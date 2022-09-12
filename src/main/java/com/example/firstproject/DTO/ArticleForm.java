package com.example.firstproject.DTO;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {

    private String title;
    private String contents;


    public Article toEntity() {
        return new Article(null, title, contents);
    }
}
