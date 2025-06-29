package com.pmp.mono_tweet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmp.mono_tweet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
