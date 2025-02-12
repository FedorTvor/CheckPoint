import java.util.Scanner;

public class FillBookManually implements Fill<Book> {

    @Override
    public Book[] fill() {
        Scanner in = new Scanner(System.in);

        Integer countBooks = InputHelp.getInt("Ведите число книг: ", in);

        Book[] books = null;

        if(countBooks != null && countBooks > 0) {
            books = new Book[countBooks];
        } else countBooks = 0;

        for(int i = 0; i < countBooks; i++) {
            String author = InputHelp.getString("Введите автора книги: ", in);

            String title = InputHelp.getString("Введите название книги: ", in);

            Integer pages = InputHelp.getInt("Введите количество страниц книги: ", in);

            books[i] = Book.collectorClass(author,title, pages);

            if(books[i] == null) i--;
        }

        return books;
    }
}
