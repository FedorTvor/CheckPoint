package utility.valuegetters;

import models.Book;

public class AuthorOfBook extends ValueGetter<Book, String> {
    public java.lang.String get(Book book){
        return book.getAuthor();
    }
}