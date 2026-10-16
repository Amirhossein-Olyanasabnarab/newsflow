
package com.newsflow.article;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    @Test
    void shouldCreateAndSaveArticle() {
        when(articleRepository.save(any(Article.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Article createdArticle = articleService.createArticle(
                "Java for Beginners",
                "A beginner-friendly Java guide",
                "This article explains Java fundamentals."
        );

        assertThat(createdArticle.getTitle())
                .isEqualTo("Java for Beginners");

        assertThat(createdArticle.getSummary())
                .isEqualTo("A beginner-friendly Java guide");

        assertThat(createdArticle.getContent())
                .isEqualTo("This article explains Java fundamentals.");

        assertThat(createdArticle.getStatus())
                .isEqualTo(ArticleStatus.DRAFT);

        verify(articleRepository).save(any(Article.class));
    }
}
