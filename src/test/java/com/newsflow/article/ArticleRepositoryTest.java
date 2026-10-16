package com.newsflow.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;


    @Test
    void shouldSaveAndFindArticle(){
        Article article = new Article
                (
                        "Java for beginners",
                        "A beginner-friendly Java guide",
                        "This article explains Java fundamentals."
                );

        Article saveArticle = articleRepository.save(article);

        UUID articleId = saveArticle.getId();

        Article foundArticle = articleRepository.findById(articleId).orElseThrow();

        assertThat(foundArticle.getTitle())
                .isEqualTo("Java for beginners");

        assertThat(foundArticle.getStatus())
                .isEqualTo(ArticleStatus.DRAFT);

        assertThat(foundArticle.getCreatedAt())
                .isNotNull();
    }
}
