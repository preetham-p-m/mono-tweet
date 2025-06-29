package com.pmp.mono_tweet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmp.mono_tweet.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(long userId);
}
