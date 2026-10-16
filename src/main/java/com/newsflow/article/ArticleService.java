package com.newsflow.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article createArticle(String title, String summary, String content){
        Article article = new Article(title, summary, content);
        return articleRepository.save(article);
    }
}
