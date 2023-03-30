package com.example.writingplatformapi.services;

import com.example.writingplatformapi.models.*;
import org.springframework.stereotype.Repository;

@Repository
public class CommentService {
   private final CommentRepository commentRepository;
   private final AuthService authService;

    public CommentService(CommentRepository commentRepository, AuthService authService) {
        this.commentRepository = commentRepository;
        this.authService = authService;
    }

    public Iterable<Comment> getArticleComment(int id){
       return commentRepository.findAllByArticleId(id);
    }

    public Comment create(CreateCommentDto createCommentDto){
        Comment comment = new Comment();
        comment.setMessage(createCommentDto.message);
        Article article = new Article();
        article.setId(createCommentDto.articleId);
        comment.setArticle(article);
        User currentUser = authService.getCurrentUser();
        comment.setUser(currentUser);
        return commentRepository.save(comment);

    }
}
