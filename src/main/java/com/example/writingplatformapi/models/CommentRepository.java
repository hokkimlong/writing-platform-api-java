package com.example.writingplatformapi.models;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    Iterable<Comment> findAllByArticleId(int id);
}
