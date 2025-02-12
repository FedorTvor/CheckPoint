public class Book {
    private String author;
    private String title;
    private int pages;

    public Book() {
    }

    public Book(String author, String title, int pages) {
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

    public static Book collectorClass(String author, String title, Integer pages) {
        Book book = null;
        if(!CheckHelp.bookCheck(author, title, pages)) {
            System.out.println("Невозможно создать книги с такими параметрами");
        } else {
            book = new Book.Builder()
                    .setAuthor(author)
                    .setPages(pages)
                    .setTitle(title)
                    .build();
        }
        return  book;
    }

    public static class Builder {
        private String author;
        private String title;
        private int pages;

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setPages(int pages) {
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
    }
}
