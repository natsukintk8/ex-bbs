package com.example.ex_bbs.domain;

/**
 * 記事情報を表すドメインクラスです.
 */
public class Articles {
    /**　ID　*/
    private Integer id;
    /**　投稿者名　*/
    private String name;
    /**　投稿内容　*/
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
