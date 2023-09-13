import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;


public class Library_Managment {
    
    public static void  main(String[] args) {
        Library library = new Library();
         SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        //Books
        Book book1 = new Book(1, "To spiti sto livadi", "Papadopoulos", "Psixogios", 100, "Peripetia", true);
        Book book2 = new Book(2, "Stroumfakia", "Konstantinidou", "Metexmio", 50, "Peripetia", true);
        Book book3 = new Book(3, "To aloito mystirio", "Lamprianidhs", "Psixogios", 250, "Drama", true);
        Book book4 = new Book(4, "O fonos", "Petridi", "Pataki", 300, "Drama", true);
        Book book5 = new Book(5, "Love story", "Papadopoulos", "Psixogios", 100, "Romantiko", true);
        Book book6 = new Book(6, "The two of us", "Samaras", "Psixogios", 300, "Romantiko", true);
        Book book7 = new Book(7, "H katara", "Geiorgioy", "Metexmio", 150, "Thriler", true);
        Book book8 = new Book(8, "The ring", "Papathanasiou", "Pataki", 250, "Thriler", true);

        //Adding the books into the library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);
        library.addBook(book8);

        System.out.println("---------------------------------------");   
        System.out.println("Loans");   
        System.out.println("---------------------------------------");   
        try {
            //Loans ftiakse to BookLoan 
            library.BookLoan(1, 1, 1, sdf.parse("23-12-2023"), sdf.parse("30-12-2023"), sdf.parse("29-12-2023"), "Active");
            library.BookLoan(2, 2, 2, sdf.parse("25-12-2023"), sdf.parse("01-01-2024"), sdf.parse("31-12-2023"), "Active");
            library.BookLoan(3, 3, 3, sdf.parse("28-12-2023"), sdf.parse("04-01-2024"), null, "Active");
            library.BookLoan(4, 4, 4, sdf.parse("01-01-2024"), sdf.parse("08-01-2024"), null, "Active");
            library.BookLoan(5, 2, 5, sdf.parse("05-01-2024"), sdf.parse("12-01-2024"), null, "Active");
            library.BookLoan(6, 1, 1, sdf.parse("09-01-2024"), sdf.parse("16-01-2024"), null, "Active");

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------");   

        // Available Books
        System.out.println("Available books");   
        System.out.println("---------------------------------------");   

        try {
        Date desiredDate = sdf.parse("28-12-2023");
        List<Book> availableBooks = library.getAvailableBooks(desiredDate);
        for(Book book : availableBooks){
            System.out.println("Book with ID:" + book.getId()+ " " + "is available");
        }
        System.out.println("---------------------------------------");   
    }   catch (ParseException e) {
        e.printStackTrace();
    }
    
        System.out.println("Loans by user");   
        System.out.println("---------------------------------------");   

        //Loans by user
        library.printLoansByUserId(1);
        System.out.println("---------------------------------------");   


        System.out.println("Loan for one specific book");   
        System.out.println("---------------------------------------");   

        //View the Loans for one specific book
        library.printLoansByBook(2);
        System.out.println("---------------------------------------");   

        System.out.println("Delete a loan");   
        System.out.println("---------------------------------------");   

        //Delete a loan
        library.DeleteLoan(4);

    }
}
