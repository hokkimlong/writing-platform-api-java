package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.models.Article;
import com.example.writingplatformapi.models.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/article")
public class ArticleController {

    @RequestMapping(value="/")
    public List<Article> findArticle() {
        return null;
    }

    @RequestMapping(value="/{id}")
    public Article findArticleById(@RequestParam int id) {
        return null;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.POST)
    public Article createArticleById() {
        return null;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public Article updateArticleById() {
        return null;
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public Article deleteArticleById() {
        return null;
    }

    @RequestMapping(value="/{id}/comment")
    public Article findArticleCommentById(@RequestParam int id, @RequestBody Comment comment){
        return null;
    }

    @RequestMapping(value="/{id}/comment", method= RequestMethod.POST)
    public Article createArticleComment(@RequestParam int id, @RequestBody Comment comment) {
        return null;
    }

}
