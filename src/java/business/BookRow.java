package business;

/**
 *
 * @author Christopher
 */
public class BookRow //I probably should have named BookRow
{
    private String bookID;
    private String title;
    private String author;
    private String pubCode;
    private String booktype;
    private long price;
    private int onHand,
            storeID;

    public BookRow() 
    {
        this.bookID = "";
        this.title = "";
        this.author = "";
        this.pubCode = "";
        this.booktype = "";
        this.price = -1;
        this.onHand = -1;
        this.storeID = -1;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubCode() {
        return pubCode;
    }

    public void setPubCode(String pubCode) {
        this.pubCode = pubCode;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getOnHand() {
        return onHand;
    }

    public void setOnHand(int onHand) {
        this.onHand = onHand;
    }
    
    public int getStoreID() {
        return this.storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
    
}
