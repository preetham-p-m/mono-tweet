package com.pmp.restful_web_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pmp.restful_web_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
