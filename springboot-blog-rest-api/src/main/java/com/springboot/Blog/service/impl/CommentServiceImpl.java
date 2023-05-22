package com.springboot.Blog.service.impl;
import com.springboot.Blog.entity.Comment;
import com.springboot.Blog.entity.Post;
import com.springboot.Blog.exception.BlogApiException;
import com.springboot.Blog.exception.ResourceNotFoundException;
import com.springboot.Blog.payLoad.CommentDto;
import com.springboot.Blog.repository.CommentRepository;
import com.springboot.Blog.repository.PostRepository;
import com.springboot.Blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import com.springboot.Blog.service.impl.CommentServiceImpl;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper mapper;



    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository,ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.mapper=mapper;
    }

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Comment comment=mapToEntity(commentDto);
        //Reterive post entity by id
        Post  post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        //set post to comment entity
        comment.setPost(post);
        //save Comment
        Comment newcomment=commentRepository.save(comment);
        return mapToDTO(newcomment);
    }

    @Override
    public List<CommentDto> getCommentsByPostID(Long postId) {
        //retive comments by postid
        List<Comment> comments=commentRepository.findByPostId(postId);
        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
        //return null;
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        //retrive Post By id
        Post  post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        //retrive Comment By Id
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","id",commentId));

        //check Weaher
        if (!comment.getPost().getId().equals(post.getId())) {

            throw new BlogApiException(HttpStatus.BAD_REQUEST,"comments are not belongs to post");
        }

        return mapToDTO(comment);
    }

    @Override
    public CommentDto updateComment(Long postId, Long commentId , CommentDto commentRequest) {
        Post  post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","id",commentId));
        if (!comment.getPost().getId().equals(post.getId())) {

            throw new BlogApiException(HttpStatus.BAD_REQUEST,"comments are not belongs to post");
        }
        comment.setName(commentRequest.getName());
        comment.setEmail(commentRequest.getEmail());
        comment.setBody(commentRequest.getBody());
        Comment updatedComment= commentRepository.save(comment);
        return mapToDTO(updatedComment);

       // return null;
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        //retrieve Post By id
        Post  post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        //retrive Comment By Id
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","id",commentId));

        //check Weaher
        if (!comment.getPost().getId().equals(post.getId())) {

            throw new BlogApiException(HttpStatus.BAD_REQUEST,"comments are not belongs to post");
        }
        commentRepository.delete(comment);
    }

    /*@Override
    public void deleteComment(Long postId, Long commentId) {
        Post  post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","id",postId));
        Comment comment=commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("comment","id",commentId));
        if (!comment.getPost().getId().equals(post.getId())) {

            throw new BlogApiException(HttpStatus.BAD_REQUEST,"comments are not belongs to post");
        }
        commentRepository.delete(comment);
    }

     */

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto=mapper.map(comment,CommentDto.class);
//        commentDto.setId(comment.getId());
//        commentDto.setName(comment.getName());
//        commentDto.setEmail(comment.getEmail());
//        commentDto.setBody(comment.getBody());
        return commentDto;
    }
    private Comment mapToEntity(CommentDto commentDto){

        Comment comment=mapper.map(commentDto,Comment.class);
       // CommentDto commentDto=new CommentDto();
        comment.setId(commentDto.getId());
//        comment.setName(commentDto.getName());
//        comment.setEmail(commentDto.getEmail());
//        comment.setBody(commentDto.getBody());
        return comment;
    }
}
