import java.util.Scanner;

public class FillBookManually implements Fill<Book> {
    final String MES_COUNT = "Ведите число книг: ";
    final String MES_AUTHOR = "Введите автора книги: ";
    final String MES_TITLE = "Введите название книги: ";
    final String MES_PAGES = "Введите количество страниц книги: ";
    final String MES_ERROR_BUILD = "Невозможно создать книги с такими параметрами";


    @Override
    public Book[] fill() {
        Scanner in = new Scanner(System.in);

        Integer countBooks = InputHelp.getIntField(MES_COUNT, in);

        Book[] books = null;

        if(countBooks != null && countBooks > 0) {
            books = new Book[countBooks];
        } else countBooks = 0;

        int j = 0;

        for(int i = 0; i < countBooks; i++) {
            String author = InputHelp.getStringField(MES_AUTHOR, in);

            String title = InputHelp.getStringField(MES_TITLE, in);

            Integer pages = InputHelp.getIntField(MES_PAGES, in);

            if(CheckHelp.bookCheck(author, title, pages)) {
                books[j] = Book.createInstance(author, title, pages);
                j++;
            } else {
                System.out.println(MES_ERROR_BUILD);
            }
        }

        Book[] books_result = null;
        if(j > 0) {
            books_result = new Book[j];
            System.arraycopy(books, 0, books_result, 0, j);
        }

        return books_result;
    }
}
