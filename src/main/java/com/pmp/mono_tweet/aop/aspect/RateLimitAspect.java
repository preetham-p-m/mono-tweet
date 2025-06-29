package com.pmp.mono_tweet.aop.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pmp.mono_tweet.aop.annotation.RateLimit;
import com.pmp.mono_tweet.exception.errors.TooManyRequestsException;

@Configuration
@Aspect
public class RateLimitAspect {
    private final ConcurrentHashMap<String, List<Long>> requestCounts = new ConcurrentHashMap<>();

    @Before("@annotation(com.pmp.mono_tweet.aop.annotation.RateLimit)")
    public void beforeRequest(JoinPoint joinPoint) throws NoSuchMethodException {
        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();

        final String key = requestAttributes.getRequest().getRemoteAddr() + requestAttributes.getRequest()
                .getRequestURI();

        final long currentTime = System.currentTimeMillis();

        this.requestCounts.putIfAbsent(key, new ArrayList<>());

        Method method = getMethodFromJoinPoint(joinPoint);
        RateLimit rateLimitAnnotation = method.getAnnotation(RateLimit.class);
        int rateLimit = rateLimitAnnotation.limit();
        long rateDuration = rateLimitAnnotation.duration();

        cleanUpRequestCounts(currentTime, rateDuration);

        if (this.requestCounts.get(key).size() > rateLimit) {
            throw new TooManyRequestsException(
                    ("Too many requests to " + requestAttributes.getRequest().getRequestURI()).formatted());
        }

        this.requestCounts.get(key).add(currentTime);
    }

    private void cleanUpRequestCounts(final long currentTime, final long rateDuration) {
        this.requestCounts.values().forEach(l -> {
            l.removeIf(t -> timeIsTooOld(currentTime, t, rateDuration));
        });
    }

    private boolean timeIsTooOld(final long currentTime, final long timeToCheck, final long rateDuration) {
        return currentTime - timeToCheck > rateDuration;
    }

    private Method getMethodFromJoinPoint(JoinPoint joinPoint) throws NoSuchMethodException {
        String methodName = joinPoint.getSignature().getName();
        Class<?>[] parameterTypes = ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature())
                .getParameterTypes();
        return joinPoint.getTarget().getClass().getMethod(methodName, parameterTypes);
    }

}
