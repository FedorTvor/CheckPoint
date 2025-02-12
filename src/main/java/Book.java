public class Book {
    private String author;
    private String title;
    private Integer pages;

    public Book() {
    }

    public Book(String author, String title, Integer pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }

    public static class Builder {
        private String author;
        private String title;
        private Integer pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(Integer pages) {
            this.pages = pages;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.author = this.author;
            book.title = this.title;
            book.pages = this.pages;
            return book;
        }

        public static Book createInstance(String author, String title, Integer pages) {
            return new Book.Builder()
                    .setAuthor(author)
                    .setPages(pages)
                    .setTitle(title)
                    .build();
        }
    }
}
