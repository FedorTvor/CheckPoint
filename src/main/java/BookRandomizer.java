import java.util.Random;

public class BookRandomizer implements ItemRandomizer<Book> {
    private final String[] authors = {"Jane Austen", "Harper Lee", "Scott Fitzgerald", "Gabriel Garcia", "Truman Capote"};
    private final String[] titles = {"Pride and Prejudice", "To Kill a Mockingbird", "The Great Gatsby", "One Hundred Years of Solitude", "In Cold Blood"};
    private final Integer minPages = 300;
    private final Integer maxPages = 1500;
    private final Random random = new Random();

    @Override
    public Book generate(){
        String author = getRandomAuthor();
        String title = getRandomTitle();
        Integer pages = getRandomPages();

        return Book.createInstance(author,title,pages);
    }

    private String getRandomAuthor() {
        int index = random.nextInt(authors.length);
        return authors[index];
    }

    private String getRandomTitle() {
        int index = random.nextInt(titles.length);
        return titles[index];
    }

    private Integer getRandomPages() {
        return minPages + random.nextInt(maxPages - minPages + 1);
    }
}
