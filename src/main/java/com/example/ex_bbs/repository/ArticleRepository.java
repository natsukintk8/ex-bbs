package com.example.ex_bbs.repository;

import com.example.ex_bbs.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * articlesテーブルを操作するリポジトリです.
 */
@Repository
public class ArticleRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Article> ARTICLES_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Article.class);

    /**
     * 記事全件を検索する.
     *
     * @return 記事全件
     */
    public List<Article> findAll(){
        String sql= """
                 SELECT
                  id,name,content
                 FROM
                  articles
                 ORDER BY
                  id DESC
                """;
        return template.query(sql,ARTICLES_ROW_MAPPER);
    }
}
