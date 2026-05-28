package com.example.ex_bbs.repository;

import com.example.ex_bbs.domain.Comment;
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
 * commentsテーブルを操作するリポジトリです.
 */
@Repository
public class CommentRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private final static RowMapper<Comment> COMMENT_ROW_MAPPER
            = new BeanPropertyRowMapper<>(Comment.class);

    /**
     * 該当記事のコメントを全件検索する.
     *
     * @param articleId 記事ID
     * @return 該当記事のコメント全件
     */
    public List<Comment> findByArticleId(int articleId) {
        String sql = """
                 SELECT
                  id,name,content,article_id
                 FROM
                  comments
                 WHERE
                  article_id = :article_id
                 ORDER BY
                  id DESC
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("article_id", articleId);

        return template.query(sql, param, COMMENT_ROW_MAPPER);
    }

    /**
     * コメントを投稿する.
     *
     * @param comment 投稿内容
     */
    public void insert(Comment comment) {
        String sql = """
                 INSERT INTO
                  comments
                  (name, content, article_id)
                 VALUES
                  (:name, :content, :articleId)
                """;

        SqlParameterSource param = new BeanPropertySqlParameterSource(comment);

        template.update(sql,param);
    }

    /**
     * コメントを削除する.
     *
     * @param articleId 記事ID
     */
    public void deleteByArticleId(int articleId){
        String sql= """
                 DELETE FROM
                  comments
                 WHERE
                  article_id = :articleId
                """;

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("articleId",articleId);
        template.update(sql,param);
    }
}
