package com.example.demo.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.swagger.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
