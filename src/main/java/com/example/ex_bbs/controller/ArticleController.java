package com.example.ex_bbs.controller;

import com.example.ex_bbs.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(){
        return "article-list";
    }


}
