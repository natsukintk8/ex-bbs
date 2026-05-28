package com.example.ex_bbs.controller;

import com.example.ex_bbs.domain.Article;
import com.example.ex_bbs.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 記事関連情報の処理の制御を行うコントローラです.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 記事一覧画面に遷移する.
     *
     * @return 記事一覧画面
     */
    @GetMapping("")
    public String index(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList",articleList);
        return "article-list";
    }

    /**
     * 記事を投稿する.
     *
     * @param article 投稿内容
     * @return 記事一覧画面
     */
    @PostMapping("/insert-article")
    public String insertArticle(Article article){
        articleRepository.insert(article);
        return "article-list";
    }


}
