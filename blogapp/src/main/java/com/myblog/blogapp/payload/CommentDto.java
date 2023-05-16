package com.myblog.blogapp.payload;

import com.myblog.blogapp.entities.Post;
import lombok.Data;

import javax.persistence.*;

@Data
public class CommentDto {

    private long id;

    private String body;

    private String email;

    private String name;

}
