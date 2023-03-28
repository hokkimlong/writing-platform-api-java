package com.example.writingplatformapi.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TagRepository extends CrudRepository<Tag, Integer> {
    Iterable<Tag> findAllByNameContainingIgnoreCase(String name);

    @Query(nativeQuery = true , value = "SELECT t.id as id,t.name as name,count(a_t.tag_id) as availableArticle from article_tag a_t join tag t on a_t.tag_id = t.id group by t.id")
    Iterable<PopularTag> findPopular();

}
