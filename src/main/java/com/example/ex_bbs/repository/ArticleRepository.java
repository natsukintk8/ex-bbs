package com.example.ex_bbs.repository;

import com.example.ex_bbs.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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

    /**
     * 記事を投稿する.
     *
     * @param article 記事
     */
    public void insert(Article article){
        String sql = """
                 INSERT INTO
                  articles
                  (name, content)
                 VALUES
                  (:name, :content)
                """;

        SqlParameterSource param = new BeanPropertySqlParameterSource(article);
        template.query(sql,param,ARTICLES_ROW_MAPPER);
    }
}
