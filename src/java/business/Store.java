package business;

/**
 *
 * @author Christopher
 */
public class Store {
    private int storeID, storeEmp;
    private String storeName, storeAddr;
    
    public Store(){
        this.storeID = 0;
        this.storeEmp = 0;
        this.storeName = "";
        this.storeAddr = "";
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public int getStoreEmp() {
        return storeEmp;
    }

    public void setStoreEmp(int storeEmp) {
        this.storeEmp = storeEmp;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddr() {
        return storeAddr;
    }

    public void setStoreAddr(String storeAddr) {
        this.storeAddr = storeAddr;
    }
    
}
