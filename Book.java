public class Book{
    private int id;
    private String title;
    private String author;
    private String publisher;
    private int numberOfPages;
    private String category;
    private boolean isAvailable;


    //constructor
    public Book(int id,String title,String author,String publisher,int numberOfPages,String category,boolean isAvailable){

        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.numberOfPages = numberOfPages;
        this.category = category;
        this.isAvailable = isAvailable;

    }


    public void printBookStats(){
        System.out.println("ID:"+id+" "+"Title:"+title+" "+"Author:"+author+" "+"Publisher:"+publisher+" "+"Number of pages:"+numberOfPages+" "+"Category:"+category+" "+"Availability"+isAvailable);
    }






    //GETTERS
    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public int getNumberOfPages(){
        return numberOfPages;
    }
    public String getCategory(){
        return category;
    }
    public boolean getAvailable(){
        return isAvailable;
    }

    //SETTERS
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}