package utility.valuegetters;

import models.Book;

public class PagesOfBook extends ValueGetter<Book, Integer> {
    public java.lang.Integer get(Book book){
        return book.getPages();
    }
}