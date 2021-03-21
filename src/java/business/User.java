package business;

/**
 *
 * @author Christopher
 */
public class User 
{
    private int userID, storeID, password, passAttempt;
    private String username, adminLevel;

    public User() 
    {
        this.userID = 0; 
        this.storeID = 0;
        this.password = 0;
        this.passAttempt = -1;
        this.username="";
        this.adminLevel="";
        
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getPassAttempt() {
        return passAttempt;
    }

    public void setPassAttempt(int passAttempt) {
        this.passAttempt = passAttempt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }
    
    public boolean isAuthenticated()
    {
        return true; //temporary code
    }
}
