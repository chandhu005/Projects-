package com.springboot.Blog.service.impl;

import com.springboot.Blog.entity.Category;
import com.springboot.Blog.entity.Post;
import com.springboot.Blog.exception.ResourceNotFoundException;
import com.springboot.Blog.payLoad.PostDto;
import com.springboot.Blog.payLoad.PostResponse;
import com.springboot.Blog.repository.CategoryRepository;
import com.springboot.Blog.repository.PostRepository;
import com.springboot.Blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
private ModelMapper mapper;
private CategoryRepository categoryRepository;
    public PostServiceImpl(PostRepository postRepository,ModelMapper mapper,CategoryRepository categoryRepository) {

        this.postRepository = postRepository;
        this.mapper=mapper;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
     Category category= categoryRepository.findById(postDto.getCategoryId()).orElseThrow(()->new ResourceNotFoundException("Category","id",postDto.getCategoryId()));
        /*convert DTO to entity
        //created an post object
        //set all DTO details into Post object
        //save the post entity in Database
       ///save method returns saved Post
        //save method returns new post
        //need to send the saved posts in restApi using post DTO

         */
        //convert DTO to entity
           Post post=mapToEntity(postDto);
           post.setCategory(category);
           Post newPost=postRepository.save(post);
       //convert entity to DTO
        PostDto postResponse= mapToDTO(newPost);

        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDir) {
        Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        //crete pageble instance
        Pageable pageable= PageRequest.of(pageNo,pageSize, sort);

      Page<Post> posts=postRepository.findAll(pageable);
      //get content for page object
        List<Post> listOfPosts=posts.getContent();
     List<PostDto> content= listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
        PostResponse postResponse=new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        return postResponse;

        //return null;
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        return mapToDTO(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        //get post by id from the database
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
     Category category=   categoryRepository.findById(postDto.getCategoryId()).orElseThrow(()-> new ResourceNotFoundException("Category","id",postDto.getCategoryId()));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        post.setCategory(category);
        Post updatedPost=postRepository.save(post);
        return mapToDTO(updatedPost);

       // return null;
    }

    @Override
    public void  deletePostById(Long id) {
        Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id));
        postRepository.delete(post);
        //return null;
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
      Category category=  categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
        List<Post> posts=postRepository.findByCategoryId(categoryId);
      return posts.stream().map((post)->mapToDTO(post)).collect(Collectors.toList());
    }

    //convert entity to DTO
 private PostDto mapToDTO(Post post){
        PostDto postDto=mapper.map(post,PostDto.class);
//     PostDto postDto=new PostDto();
//     postDto.setTitle(post.getTitle());
//     postDto.setDescription(post.getDescription());
//     postDto.setContent(post.getContent());
     return postDto;

 }
 //convert Dto to entity
 private Post mapToEntity(PostDto postDto){
 Post post=mapper.map(postDto,Post.class);
//     Post();
//     post.setTitle(postDto.getTitle());
//     post.setDescription(postDto.getDescription());
//     post.setContent(postDto.getContent());
     return post;
    }
}
