import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import filter.BookFilter;
import values.Book;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        try {
            BookFilter bookFilter = new BookFilter();
            FileReader fileReader = new FileReader("src/main/resources/list/books.json");
            Type listType = new TypeToken<List<Book>>() {
            }.getType();
            List<Book> bookList = gson.fromJson(fileReader, listType);
            System.out.println("Por favor, introduce tu cadena de busqueda:");
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) {
                throw new IllegalArgumentException("La cadena no puede estar vacía.");
            }
            bookFilter.filter(input, bookList);
            bookFilter.sortBooks(bookList);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
