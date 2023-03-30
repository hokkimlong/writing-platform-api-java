
package com.example.writingplatformapi.models;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Iterable<Article> findAllByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String title);
    Iterable<Article> findAllByTags_IdOrderByCreatedAtDesc(int tagId);
    Iterable<Article> findAllByUserIdOrderByCreatedAtDesc(int userId);
}
