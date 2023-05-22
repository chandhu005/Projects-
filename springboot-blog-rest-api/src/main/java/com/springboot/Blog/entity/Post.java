package com.springboot.Blog.entity;

//import jdk.jfr.Category;
import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//getters setters and all we use @Data lombook
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name="posts",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        }
)
public class Post {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(name="title",nullable = false)
    private String title;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name="content",nullable = false)
    private String content;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Comment> comments=new HashSet<>();
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")// for foriegn key
    private Category category;


}
