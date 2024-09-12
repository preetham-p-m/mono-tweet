package com.pmp.restful_web_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmp.restful_web_service.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(long userId);
}
