package rashed.hasan.hone;

import android.widget.EditText;

public class createproductclass {
    // variables for storing our data.
    private String downloadUrl,productname,price,productdiscription,downloadUr2,downloadUr3,downloadUr4,selectedItem,totalstock;

    public  createproductclass(String downloadUrl, String productname, String price, String productdiscription, String downloadUr2, String downloadUr3, String downloadUr4, String selectedItem,String totalstock) {
        // empty constructor
        // required for Firebase.

    // Constructor for all variables.
        this.downloadUrl = downloadUrl;
        this.productname = productname;
        this.price = price;
        this.productdiscription = productdiscription;
        this.downloadUr2 = downloadUr2;
        this.downloadUr3 = downloadUr3;
        this.downloadUr4 = downloadUr4;
        this.selectedItem=selectedItem;
        this.totalstock=totalstock;
    }


    // getter methods for all variables.
    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    // getter methods for all variables.
    public String getDownloadUr2() {
        return downloadUr2;
    }

    public void setDownloadUr2(String downloadUr2) {
        this.downloadUr2 = downloadUr2;
    }
    // getter methods for all variables.
    public String getDownloadUr3() {
        return downloadUr3;
    }

    public void setDownloadUr3(String downloadUr3) {
        this.downloadUr3 = downloadUr3;
    }
    // getter methods for all variables.
    public String getDownloadUr4() {
        return downloadUr4;
    }

    public void setDownloadUr4(String downloadUr4) {
        this.downloadUr4 = downloadUr4;
    }


    public String getProductname() {
        return productname;
    }

    // setter method for all variables.
    public void setProductnamee(String shopname) {
        this.productname = productname;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductdiscription() {
        return productdiscription;
    }

    public void setProductdiscription(String productdiscription) {
        this.productdiscription = productdiscription;

    }
    public String getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(String totalstock) {
        this.totalstock = totalstock;
    }
}
