package com.springboot.Blog.controller;

import com.springboot.Blog.payLoad.PostDto;
import com.springboot.Blog.payLoad.PostResponse;
import com.springboot.Blog.service.PostService;
import com.springboot.Blog.utils.AppConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(
        name="CRUD REST API for POSt Resource"
)
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //create Blog Post rest APi
    @SecurityRequirement(
            name="Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(
            summary = "Create Post Rest API",
            description = "Create Post REST APi is used to save post into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Htp status 201 created"
    )
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody  PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
    //get all posts rest api
    @GetMapping
    public  PostResponse getAllPosts(
            @RequestParam(value="pageNo",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.DEFAULT_PAGE_SIZE,required = false)int pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.DEFAULT_SORT_BY,required = false)String sortBy,
            @RequestParam(value="sortDir",defaultValue = AppConstants.DEFAULT_SORT_DIRECTION,required = false)String sortDir
    ){
        return postService.getAllPosts(pageNo,pageSize,sortBy,sortDir);

    }
    //get Post by id
    @Operation(
            summary = "Get Post By Id rest APi",
            description = "get  Post By ID  REST APi is used to get single post from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Htp status 200 Sucess"
    )
    @GetMapping("/{id}")
    public  ResponseEntity<PostDto> getPostById(@PathVariable(name="id") Long id){
        return ResponseEntity.ok(postService.getPostById(id));

    }
    //update the post by RestApi
    @SecurityRequirement(
            name="Bear Authentication"
    )
    @Operation(
            summary = "Update Post Rest API",
            description = "Update  Post REST APi is used to update the particular  post into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Htp status 200 ok"
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable("id") Long id){
      PostDto postResponse = postService.updatePost(postDto,id);
      return  new ResponseEntity<>(postResponse,HttpStatus.OK);

    }
    //Delete Post rest api
    @Operation(
            summary = "Delete Post Rest API",
            description = "Delete  Post REST APi is used to update the particular  post into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Htp status 200 ok"
    )
    @SecurityRequirement(
            name="Bear Authentication"
    )
    @PreAuthorize("hasRole('ADMiN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePostById(@PathVariable(name="id") Long id){
        postService.deletePostById(id);
        return  new ResponseEntity<>("Post entity deleted successFully",HttpStatus.OK);
    }
    //Build get Posts By Category Rest Api
    @GetMapping("/category/{id}")
    public  ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("id") Long categoryId){
      List<PostDto> postDtos=  postService.getPostsByCategory(categoryId);
      return ResponseEntity.ok(postDtos);
    }
}
