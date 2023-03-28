package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.models.Article;
import com.example.writingplatformapi.models.Comment;
import com.example.writingplatformapi.models.CreateArticleDto;
import com.example.writingplatformapi.services.ArticleService;
import com.example.writingplatformapi.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/Articles")
public class ArticleController {

    private final ArticleService articleService;
    private final CommentService commentService;

    public ArticleController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @RequestMapping(value = "")
    public Iterable<Article> findArticle(@RequestParam String search,@RequestParam(required = false) Integer tag,@RequestParam(required = false) Integer user) {
        return articleService.findAll(search,tag,user);
    }

    @RequestMapping(value = "/{id}")
    public Optional<Article> findArticleById(@PathVariable int id) {
       return articleService.getArticleById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Article createArticle(@RequestBody CreateArticleDto createArticleDto) {
        return articleService.create(createArticleDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Article updateArticleById() {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Article deleteArticleById() {
        return null;
    }

    @RequestMapping(value = "/{id}/comment")
    public Iterable<Comment> findArticleCommentById(@PathVariable int id) {
        return commentService.getArticleComment(id);
    }



}
