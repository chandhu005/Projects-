package com.springboot.Blog.payLoad;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Data
@Schema(
        description = "Post DTO Model information"
)
public class PostDto {
    private Long id;
     //title should not be null or empty
    //title should have at least 2 characters
    @Size(min=2,message="Post Title should have at least 2 characters")
    @NotEmpty
    @Schema(
            description = "Blog post Description"
    )
    private String title;
    //post should not be null or empty
    //post should have at least 10 characters
    @Size(min=10,message = "Post Title should have at least 10 characters")
    @NotEmpty
    private String description;
  //post content should not be null or empty
    @NotEmpty
    private String content;
    private Set<CommentDto> comment;
    private  Long categoryId;
}
