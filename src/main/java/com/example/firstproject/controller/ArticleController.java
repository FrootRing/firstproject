package com.example.firstproject.controller;

import com.example.firstproject.DTO.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/articles/{id}")

    public String show(@PathVariable Long id, Model model){
        log.info("id =" + id);

        //1.id 로 데이터를 가져옴
        Article articlEntity = articleRepository.findById(id).orElse(null);

        //2.가져온 데이터를 모델에 등록
        model.addAttribute("article", articlEntity);

        //3.보여줄 페이지 설정
        return "articles/show";
    }
    @GetMapping("/articles")
    public String index(Model model){
        //모든 Article을 가져온다
        List<Article> articleEntityList = articleRepository.findAll();

        //가져온 article 묶음을 뷰로 전달
        model.addAttribute("articleList", articleEntityList);

        //뷰 페이지를 설정
        return "articles/index";
    }
}
