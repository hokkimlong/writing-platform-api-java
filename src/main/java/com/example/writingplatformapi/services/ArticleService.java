package com.example.writingplatformapi.services;

import com.example.writingplatformapi.models.*;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final TagRepository tagRepository;

    public ArticleService(ArticleRepository articleRepository, TagRepository tagRepository) {
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
    }

    public Article create(CreateArticleDto article) {

        Set<Tag> tags = new HashSet<>();
        tags.addAll(article.tags);

        article.newTags.forEach(newTag -> {
            Tag tag = new Tag();
            tag.setName(newTag);
            Tag createdTag = tagRepository.save(tag);
            tags.add(createdTag);
        });

        Article newArticle = new Article();
        newArticle.setTitle(article.title);
        newArticle.setContent(article.content);
        User currentUser = new User();
        currentUser.setId(2);
        newArticle.setUser(currentUser);
        newArticle.setTags(tags);

        return articleRepository.save(newArticle);

    }

    public Iterable<Article> findAll(String search, Integer tagId, Integer userId) {
        if (userId != null) {
            return articleRepository.findAllByUserId(userId);
        } else if (tagId != null) {
            return articleRepository.findAllByTags_Id(tagId);
        }

        return articleRepository.findAllByTitleContainingIgnoreCase(search);
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

}
