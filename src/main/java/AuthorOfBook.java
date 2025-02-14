class AuthorOfBook extends ValueGetter<Book, java.lang.String>{
    public java.lang.String get(Book book){
        return book.getAuthor();
    }
}