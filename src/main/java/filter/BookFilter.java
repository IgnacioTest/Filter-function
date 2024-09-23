package filter;

import values.Book;
import values.BookDate;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookFilter {

    public Optional<BookDate> filter(String filter, List<Book> books) {
        Optional<BookDate> result;
        books.stream().filter(book -> book.getPublicationTimestamp() == null)
                .forEach(book -> {
                    System.out.println("libros sin fecha de publicación:");
                    System.out.println(book);
                });

        List<Book> bookListFiltered = books.stream().filter(book -> (book.getTitle() != null && book.getTitle().contains(filter))
                || (book.getSummary() != null && book.getSummary().contains(filter)) ||
                (book.getAuthor().getBio() != null && book.getAuthor().getBio().contains(filter))).collect(Collectors.toList());


        if (!bookListFiltered.isEmpty()) {
            System.out.println("libros que contienen la cadena en nombre, resumen o biografía del autor:");
            for (Book book : bookListFiltered) {
                System.out.println(book);
            }
            Optional <Book> mostRecentBook = bookListFiltered.stream().filter(b->b.getPublicationTimestamp()!=null).max(Comparator.comparingLong(Book::getPublicationTimestamp));
            if (mostRecentBook.isPresent()){
                Book book = mostRecentBook.get();
                SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
                String formatDate = format.format(book.getPublicationTimestamp());
                BookDate bookDate = new BookDate(book.getId(), book.getTitle(),book.getPublicationTimestamp(), book.getSummary(),book.getAuthor(),formatDate);
                System.out.println("libro más recientemente publicado:\n"+ bookDate.toString());
                return Optional.of(bookDate);
            }
        } else {
            System.out.println("No hay libros que contienen la cadena en nombre, resumen o biografía del autor");
        }
        return Optional.empty();
    }
    public List <Book> sortBooks (List <Book> books){
        return books.stream().sorted(Comparator.comparing(Book::getPublicationTimestamp,Comparator.nullsLast(Long::compareTo)).thenComparing(book -> book.getAuthor().getBio().length())).collect(Collectors.toList());
    }
}
