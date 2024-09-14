package com.pmp.restful_web_service.exception.model;

import java.util.List;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ValidationError {

    private final LocalDateTime timeStamp;

    private final long errorCount;

    private final List<ValidationField> validationErrors;

    public ValidationError(LocalDateTime timeStamp, List<ValidationField> validationErrors) {
        this.timeStamp = timeStamp;
        this.validationErrors = validationErrors;
        this.errorCount = validationErrors.size();
    }

}
