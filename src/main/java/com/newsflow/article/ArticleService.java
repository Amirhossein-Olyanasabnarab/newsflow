package com.newsflow.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article createArticle(
            String title,
            String summary,
            String content
    ) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "Article title must not be blank"
            );
        }

        Article article = new Article(title, summary, content);

        return articleRepository.save(article);
    }
}
