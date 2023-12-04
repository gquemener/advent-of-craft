package blog;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArticleTests {
    @Test
    void it_should_be_commentable() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));
        assertThat(article.getComments()).hasSize(1);
    }

    @Test
    void it_should_provide_related_comments() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );

        var text = "Amazing article !!!";
        var author = "Pablo Escobar";
        LocalDate now = LocalDate.now();
        Comment aComment = new Comment(text, author, now);
        article.comment(aComment);

        assertThat(article.getComments())
                .anyMatch(comment -> comment.equals(aComment));
    }

    @Test
    void it_should_forbid_spam() throws CommentAlreadyExistException {
        var article = new Article(
                "Lorem Ipsum",
                "consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
        );
        article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));

        assertThatThrownBy(() -> {
            article.comment(new Comment("Amazing article !!!", "Pablo Escobar", LocalDate.now()));
        }).isInstanceOf(CommentAlreadyExistException.class);
    }
}
