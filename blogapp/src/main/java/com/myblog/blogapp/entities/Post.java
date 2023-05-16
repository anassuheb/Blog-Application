package com.myblog.blogapp.entities;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name="posts",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
        ) //make a particular column as unique
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description",nullable = false)
    private String description;

    // @Lob
    // can take huge amount of data as string can take upto 255 characters
    @Column(name="content",nullable = false)
    private String content;

    //cascade is if any changes made in parent then it will be reflected to child class
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    Set<Comment> comments=new HashSet<>();
}
