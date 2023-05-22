package com.springboot.Blog.service;

import com.springboot.Blog.payLoad.PostDto;
import com.springboot.Blog.payLoad.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize,String sortBy,String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto,Long id);
    void deletePostById(Long id);
    List<PostDto> getPostsByCategory(Long categoryId);
}
