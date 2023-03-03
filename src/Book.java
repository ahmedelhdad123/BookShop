import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    static ArrayList<Book> books=new ArrayList<>();
    private String name;
    private double price;
    private String author;

    public static Book getBookByName(String name) {
        for (Book book: Book.books) {
            if(book.getName().equals(name))
            {
                return book;
            }
        }
        return null;
    }
    public static boolean updateBookName(Book newBook,Book oldBook)
    {
        int index=-1;
         if(books.size()>0)
         {
             for (int i=0;i<books.size();i++)
             {
                 if(books.get(i).getName().equals(oldBook.getName()))
                 {
                     index =i;
                     break;
                 }
             }
             if (index!=-1)
             {
                 books.get(index).setName(newBook.getName());
                 books.get(index).setAuthor(newBook.getAuthor());
                 books.get(index).setPrice(newBook.getPrice());

                 return true;
             }
         }
         return false;
    }

    public static boolean deleteBook(Book book) {
        books.remove(book);
        return true;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
