package com.example.firstproject.controller;

import com.example.firstproject.DTO.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {return "articles/view";}

    @PostMapping("/articles/create")
    public String createArticles(ArticleForm form){
        log.info(form.toString());
        //System.out.println(form.toString());

        //1. Dto를 변환한다 Entity!
        Article article = form.toEntity();
        log.info(article.toString());
        //System.out.println(article.toString());

        //2. Repository에게  Entity를 DB에 저장하게 함!
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }
}
