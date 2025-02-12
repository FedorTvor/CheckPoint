import java.util.Random;

public class BookRandomizer implements ItemRandomizer<Book> {
    private static final String[] AUTHORS = {"Jane Austen", "Harper Lee", "Scott Fitzgerald", "Gabriel Garcia", "Truman Capote"};
    private static final String[] TITLES = {"Pride and Prejudice", "To Kill a Mockingbird", "The Great Gatsby", "One Hundred Years of Solitude", "In Cold Blood"};
    private static final Integer MIN_PAGES = 300;
    private static final Integer MAX_PAGES = 1500;
    private static final Random RANDOM = new Random();

    @Override
    public Book generate(){
        String author = getRandomAuthor();
        String title = getRandomTitle();
        Integer pages = getRandomPages();

        return new Book.Builder()
                .setAuthor(author)
                .setTitle(title)
                .setPages(pages)
                .build();
    }

    private static String getRandomAuthor() {
        int index = RANDOM.nextInt(AUTHORS.length);
        return AUTHORS[index];
    }

    private static String getRandomTitle() {
        int index = RANDOM.nextInt(TITLES.length);
        return TITLES[index];
    }

    private static Integer getRandomPages() {
        return MIN_PAGES + RANDOM.nextInt(MAX_PAGES - MIN_PAGES + 1);
    }
}
