public class BookComporator implements CustomComparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        if (!book1.getTitle().equals(book2.getTitle())) {
            return book1.getTitle().compareTo(book2.getTitle());
        } else if (!book1.getAuthor().equals(book2.getAuthor())) {
            return book1.getAuthor().compareTo(book2.getAuthor());
        } else {
            return CustomComparator.compareINT(book1.getPages(), book2.getPages());
        }
    }
}
//		if (!car1.getPower().equals(car2.getPower())) {
//        return CustomComparator.compareINT(car1.getPower(), car2.getPower());
//        } else if (!car1.getModel().equals(car2.getModel())) {
//        return car1.getModel().compareTo(car2.getModel());
//        } else {
//        return CustomComparator.compareINT(car1.getYearOfProduction(), car2.getYearOfProduction());
//        }

//        if (book1.getPages() != book2.getPages()) {
//        return CustomComparator.compareINT(book1.getPages(), book2.getPages());
//        } else if (!book1.getAuthor().equals(book2.getAuthor())) {
//        return book1.getAuthor().compareTo(book2.getAuthor());
//        } else {
//        return book1.getTitle().compareTo(book2.getTitle());
//        }