import java.util.Date;

public class BorrowBook {
    private int loanID;
    private int bookID;
    private int userID;
    private Date loanDate;
    private Date dueDate;
    private Date returnDate;
    private String status;

    //Constructor
    public BorrowBook(int loanID, int bookID,int userID, Date loanDate, Date dueDate,Date returnDate,String status){

        this.loanID = loanID;
        this.bookID = bookID;
        this.userID = userID;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;

    }

    //GETTERS
    public int getLoanID(){
        return loanID;
    }
     public int getBookID(){
        return bookID;
    }
     public int getUserID(){
        return userID;
    }
     public Date getLoanDate(){
        return loanDate;
    }
    public Date getDueDate(){
        return dueDate;
    }
    public Date getReturnDate(){
        return returnDate;
    }
    public String getStatus(){
        return status;
    }


    //SETTERS
    public void setLoanID(int loanID){
        this.loanID = loanID;
    }
    public void setBookID(int bookID){
        this.bookID = bookID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public void setLoanDate(Date loanDate){
        this.loanDate = loanDate;
    }
     public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
     public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }
    public void setStatus(String status){
        this.status = status;
    }

}
