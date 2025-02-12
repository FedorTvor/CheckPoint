public class BookComporator implements CustomComparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (book1.getPages() != book2.getPages()) {
            return CustomComparator.compareINT(book1.getPages(), book2.getPages());
        } else if (!book1.getAuthor().equals(book2.getAuthor())) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        } else {
            return book1.getTitle().compareTo(book2.getTitle());
        }
    }
}