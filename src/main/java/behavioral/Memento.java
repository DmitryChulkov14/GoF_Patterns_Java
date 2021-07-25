package behavioral;

/**
 * Memento pattern is used to restore state of an object to a previous state.
 * <br/>
 * <br/>
 * Шаблон Memento используется для восстановления состояния объекта до предыдущего состояния.
 */
public class Memento {
    public static void main(String[] args) {
        Article article = new Article(1, "First article");
        article.setContent("ABC");
        System.out.println(article);

        ArticleMemento articleMemento = article.createMemento();

        article.setContent("123");
        System.out.println(article);

        article.restore(articleMemento);
        System.out.println(article);
    }
}

class Article {
    private long id;
    private String title;
    private String content;

    public Article(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleMemento createMemento() {
        return new ArticleMemento(id, title, content);
    }

    public void restore(ArticleMemento articleMemento) {
        this.id = articleMemento.getId();
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
}

class ArticleMemento {

    private final long id;
    private final String title;
    private final String content;

    public ArticleMemento(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
