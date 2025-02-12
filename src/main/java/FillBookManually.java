import java.util.Scanner;

public class FillBookManually implements Fill<Book> {

    @Override
    public Book[] fill() {
        Scanner in = new Scanner(System.in);

        System.out.println("Ведите число книг: ");
        Integer countBooks = InputHelp.InputInt(in);

        Book[] books = null;

        if(countBooks != null && countBooks > 0) {
            books = new Book[countBooks];
        } else countBooks = 0;

        for(int i = 0; i < countBooks; i++) {

            System.out.println("Введите автора книги: ");
            String author = in.nextLine();

            System.out.println("Введите название книги: ");
            String title = in.nextLine();

            System.out.println("Введите количество страниц книги: ");
            Integer pages = InputHelp.InputInt(in);

            if(!CheckHelp.bookCheck(author, title, pages)) {
                System.out.println("Невозможно создать книги с такими параметрами");
                i--;
            } else {
                books[i] = new Book.Builder()
                        .setAuthor(author)
                        .setPages(pages)
                        .setTitle(title)
                        .build();
            }
        }

        return books;
    }
}
