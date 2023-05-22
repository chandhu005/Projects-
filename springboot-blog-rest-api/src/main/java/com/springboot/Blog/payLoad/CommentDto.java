package com.springboot.Blog.payLoad;


import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


@Data
public class CommentDto {
    private Long id;
    @NotEmpty(message="name should not be null or empty ")
    private String name;
    @Email
    @NotEmpty(message = "Email should not be null or Empty")
    private String Email;
    @NotEmpty
    @Size(min=10,message="comment body be minimum 10 characters")
    private String Body;
}
