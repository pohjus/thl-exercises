import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Main {    
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(createBook("1984", "George Orwell", 328));
        books.add(createBook("To Kill a Mockingbird", "Harper Lee", 281));
        books.add(createBook("The Great Gatsby", "F. Scott Fitzgerald", 180));
        books.add(createBook("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 417));
        books.add(createBook("Moby Dick", "Herman Melville", 585));

        books.stream()
            .filter(book -> book.pages() > 200)
            .sorted(Comparator.comparing(Book::title))
            .forEach(Main::print);
    }

    public static Book createBook(String title, String author, int pages) {
        return new Book(title, author, pages);
    }



    public static void print(Book book) {
        System.out.println(book.shortDescription());   
    }
}