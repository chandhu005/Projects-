package com.springboot.Blog.service;

import com.springboot.Blog.payLoad.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(Long postId,CommentDto commentDto);
    List<CommentDto> getCommentsByPostID(Long postId);
    CommentDto getCommentById(Long postId,Long commentId);
    CommentDto updateComment(Long postId,Long commentId,CommentDto commentRequest);
    void deleteComment(Long postId,Long commentId);
}
