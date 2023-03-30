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
    private final AuthService authService;

    public ArticleService(ArticleRepository articleRepository, TagRepository tagRepository, AuthService authService) {
        this.articleRepository = articleRepository;
        this.tagRepository = tagRepository;
        this.authService = authService;
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
        User currentUser = authService.getCurrentUser();
        newArticle.setUser(currentUser);
        newArticle.setTags(tags);

        return articleRepository.save(newArticle);

    }

    public Iterable<Article> findAll(String search, Integer tagId, Integer userId) {
        if (userId != null) {
            return articleRepository.findAllByUserIdOrderByCreatedAtDesc(userId);
        }
        else if (tagId != null) {
            return articleRepository.findAllByTags_IdOrderByCreatedAtDesc(tagId);
        }

        return articleRepository.findAllByTitleContainingIgnoreCaseOrderByCreatedAtDesc(search);
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

}
