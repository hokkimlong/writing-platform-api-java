
package com.example.writingplatformapi.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

    Iterable<Article> findAllByTitleContainingIgnoreCase(String title);
    Iterable<Article> findAllByTags_Id(int tagId);
    Iterable<Article> findAllByUserId(int userId);
}
