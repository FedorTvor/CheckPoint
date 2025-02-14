class PagesOfBook extends ValueGetter<Book, java.lang.Integer>{
    public java.lang.Integer get(Book book){
        return book.getPages();
    }
}