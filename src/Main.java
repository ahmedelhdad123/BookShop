import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void menu(){
        System.out.println("---Main Menu_____");
        System.out.println("1- Display All Book");
        System.out.println("2- Add A New Book");
        System.out.println("3- Update Book");
        System.out.println("4- Delete Book");
        System.out.println("5- Exit");
        System.out.println("Enter Your Choice");
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true)
        {
            menu();
            try {
                int x=scanner.nextInt();
                switch (x)
                {
                    case 1:
                        displayBook();
                        break;
                    case 2:
                       addBook(scanner);
                        break;
                    case 3:
                        boolean updateMenu=true;
                        while (updateMenu)
                        {
                            updateMenu();
                            int choice=scanner.nextInt();
                            switch (choice)
                            {
                                case 1:
                                    System.out.println("Enter Book Name");
                                    String nameOfBook=scanner.next();
                                    Book oldBook=Book.getBookByName(nameOfBook);
                                    Book newBook=Book.getBookByName(nameOfBook);
                                    if (oldBook==null)
                                    {
                                        System.out.println("No Book With This Name");
                                    }else
                                    {
                                        System.out.println("Enter Book NewName");
                                        String newNameOfBook=scanner.next();
                                        newBook.setName(newNameOfBook);
                                        if (Book.updateBookName(newBook,oldBook))
                                        {
                                            System.out.println("update is Done");
                                        }else
                                        {
                                            System.out.println("update Failed");
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter Book Name ");
                                    String nameOfBook1=scanner.next();
                                    Book oldBook1=Book.getBookByName(nameOfBook1);
                                    Book newBook1=Book.getBookByName(nameOfBook1);
                                    if (oldBook1==null)
                                    {
                                        System.out.println("No Book With This Name");
                                    }else
                                    {
                                        System.out.println("Enter  NewName of Author");
                                        String newNameOfAuthor=scanner.next();
                                        newBook1.setAuthor(newNameOfAuthor);
                                        if (Book.updateBookName(newBook1,oldBook1))
                                        {
                                            System.out.println("update is Done");
                                        }else
                                        {
                                            System.out.println("update Failed");
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Enter Book Name");
                                    String nameOfBook2=scanner.next();
                                    Book oldBook2=Book.getBookByName(nameOfBook2);
                                    Book newBook2=Book.getBookByName(nameOfBook2);
                                    if (oldBook2==null)
                                    {
                                        System.out.println("No Book With The Name");
                                    }else
                                    {
                                        System.out.println("Enter Book NewPrice");
                                        double newPriceOfBook=scanner.nextDouble();
                                        newBook2.setPrice(newPriceOfBook);
                                        if (Book.updateBookName(newBook2,oldBook2))
                                        {
                                            System.out.println("update is Done");
                                        }else
                                        {
                                            System.out.println("update Failed");
                                        }
                                    }
                                    break;
                                case 4:
                                    updateMenu =false;
                                    break;
                                case 5:
                                    exit();
                                    break;
                           }

                        }
                        break;
                    case 4:
                        System.out.println("Enter Name Of Book");
                        String bookNameDelete=scanner.next();
                        Book book=Book.getBookByName(bookNameDelete);
                        if(book == null)
                        {
                            System.out.println("Not Found");
                        }else
                        {
                            Book.deleteBook(book);
                            System.out.println("Delete is Done");
                        }
                        break;
                    case 5:
                        updateMenu =false;
                        break;
                }
            }catch (Exception e)
            {
                System.out.println("Please Enter Number ");
            }


        }

    }
    public static void displayBook() {
        ArrayList<Book> listbook = Book.books;
        if(listbook.isEmpty())
        {
            System.out.println("There is no Book Here");
        }else
        {
            System.out.println("Name"+ "       Price" +  "       Author"   );
            for (Book book: listbook) {
                System.out.println(book.getName() + "       " +book.getPrice() + "       "+book.getAuthor() );
            }
        }
    }
    public static void addBook(Scanner scanner)
    {
        System.out.println("Enter The count Book ");
        int countBook=scanner.nextInt();
        for (int i=0;i<countBook;i++)
        {
            System.out.println("Enter Book" + (i+1) +  "  Name");
            String bookName=scanner.next();
            System.out.println("Enter Book"+ (i+1) + "  Price");
            double bookPrice=scanner.nextDouble();
            System.out.println("Enter author of Book  " + (i+1));
            String author=scanner.next();

            Book b=new Book();
            b.setName(bookName);
            b.setAuthor(author);
            b.setPrice(bookPrice);
            Book.books.add(b);
        }
    }
    public static void updateMenu()
    {
        System.out.println("1-Update Book Name");
        System.out.println("2-Update Book Author");
        System.out.println("3-Update Book Price");
        System.out.println("4-Back To Main Menu");
        System.out.println("5-Exit");
        System.out.println("Enter Your Choice");
    }
    public static void exit()
    {
        System.exit(0);
    }
}