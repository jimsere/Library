import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Library {
    
    private List<Book> books;
    private List<BorrowBook> borrowBooks;
    public Library(){
        books = new ArrayList<>();
        borrowBooks = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }
    public void deleteBook(int bookId){
        books.removeIf(book -> book.getId() == bookId);
    }
    
    public void printAllBooks(){
        for(Book book : books){
            book.printBookStats();
        }
    }
    public Book getBookById(int id){
        for(Book book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

   public BorrowBook getLoanById(int loanID){
        for(BorrowBook borrowBook : borrowBooks){
            if(borrowBook.getLoanID() == loanID ){
                return borrowBook;
            }
        }
        return null;
   }

    public boolean BookIsAvailable(int bookID, Date requestedLoanDate, Date requestedDueDate){
        for(BorrowBook borrowBook : borrowBooks){
            if(borrowBook.getBookID() == bookID){
                Date existingLoanDate = borrowBook.getLoanDate();
                Date existingDueDate = borrowBook.getDueDate();
    
                // Ελέγχουμε αν οι ημερομηνίες επικαλύπτονται
                if((requestedLoanDate.before(existingDueDate) && requestedLoanDate.after(existingLoanDate)) ||
                   (requestedDueDate.before(existingDueDate) && requestedDueDate.after(existingLoanDate)) ||
                   (existingLoanDate.before(requestedDueDate) && existingLoanDate.after(requestedLoanDate)) ||
                   (existingDueDate.before(requestedDueDate) && existingDueDate.after(requestedLoanDate))){
                    return false; // το βιβλίο δεν είναι διαθέσιμο
                }
            }
        }
        return true; // το βιβλίο είναι διαθέσιμο
    }
    

    //des afto kai anevase to
    public boolean BookLoan(int loanID, int userID, int bookID, Date startDate, Date endDate, Date returnDate, String status) {
        // Εύρεση του βιβλίου με βάση το bookID
        Book bookToLoan = getBookById(bookID);
        if (bookToLoan == null) {
            System.out.println("No book found with the given bookID: " + bookID);
            return false;
        }
    
        // Έλεγχος αν το βιβλίο είναι ήδη δανεισμένο σε αυτό το χρονικό διάστημα
        for (BorrowBook borrowBook : borrowBooks) {
            if (borrowBook.getBookID() == bookID) {
                if ((borrowBook.getLoanDate().compareTo(endDate) < 0 && borrowBook.getDueDate().compareTo(startDate) > 0)
                        || (borrowBook.getLoanDate().compareTo(startDate) > 0 && borrowBook.getLoanDate().compareTo(endDate) < 0)
                        || (borrowBook.getDueDate().compareTo(startDate) > 0 && borrowBook.getDueDate().compareTo(endDate) < 0)) {
                    System.out.println("Book is already loaned during this period.");
                    return false;
                }
            }
        }
    
        // Αν το βιβλίο είναι διαθέσιμο, δημιουργία ενός νέου δανείου
        BorrowBook newLoan = new BorrowBook(loanID, userID, bookID, startDate, endDate, returnDate, status);
        borrowBooks.add(newLoan);
        System.out.println("Loan created successfully.");
        return true;
    }
    

    public void DeleteLoan(int loanID){
        BorrowBook borrowBook = getLoanById(loanID);
        if(borrowBook!=null){
            borrowBooks.remove(borrowBook);
            System.out.println("Delete for loan with id:"+loanID+" "+"was made successfully!");

        }

    }

    public List<Book> getAvailableBooks(Date desiredDate){

        List<Book> availableBooks = new ArrayList<>();

        for(Book book:books){
            boolean isAvailable = true;

        for(BorrowBook borrowBook:borrowBooks){
            if(borrowBook.getBookID() == book.getId()){
                Date loanDate = borrowBook.getLoanDate();
                Date DueDate = borrowBook.getDueDate();

                if (loanDate != null && DueDate != null) {
                    if((desiredDate.compareTo(loanDate) >= 0) && (desiredDate.compareTo(DueDate) <= 0)){
                            isAvailable = false;
                            break;                    }
                } 
                
            }
        }
        if(isAvailable){
            availableBooks.add(book);
        }
        }
        return availableBooks;
    }

    public void printLoansByBook(int bookID){
        for(BorrowBook borrowBook:borrowBooks){
            if(borrowBook.getBookID()==bookID){
                System.out.println("Loan ID:"+" "+borrowBook.getLoanID()+" "+"User ID:"+" "+borrowBook.getUserID()+" "+"Loan Date:"+" "+borrowBook.getLoanDate()+" "+"Due Date:"+" "+borrowBook.getDueDate());
            }
        }

    }

     public void printLoansByUserId(int userID){
        for(BorrowBook borrowBook:borrowBooks){
            if(borrowBook.getUserID()==userID){
                System.out.println("Loan ID:"+" "+borrowBook.getLoanID()+" "+"Book ID:"+" "+borrowBook.getBookID()+" "+"Loan Date:"+" "+borrowBook.getLoanDate()+" "+"Due Date:"+" "+borrowBook.getDueDate());
            }
        }

    }
}
