package TP2;
import java.io.*;
import java.util.*;

class Book implements Serializable {
    String title, author;
    int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    
    public String toString() {
        return title + " by " + author + " (" + year + ")";
    }
}

public class BookManager {
    public static void saveBooks(ArrayList<Book> books, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Book> loadBooks(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", 2000));
        books.add(new Book("Book2", "Author2", 2010));

        File file = new File("books.dat");
        saveBooks(books, file);

        ArrayList<Book> loadedBooks = loadBooks(file);
        for (Book b : loadedBooks) {
            System.out.println(b);
        }
    }
}