package com.example.writingplatformapi.controllers;

import com.example.writingplatformapi.models.Comment;
import com.example.writingplatformapi.models.CreateCommentDto;
import com.example.writingplatformapi.services.CommentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Comments" )
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Comment createArticleComment(@RequestBody CreateCommentDto commentDto) {
        return commentService.create(commentDto);
    }
}
