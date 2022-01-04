package rashed.hasan.hone;

public class DataModalreseller {

    // variables for storing our image and name.
    private String productname;
    private String downloadUr2;
    private String price;
    private String totalstock;

    public DataModalreseller() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public DataModalreseller(String productname, String downloadUr2,String price,String totalstock) {
        this.productname = productname;
        this.downloadUr2 =downloadUr2;
        this.price=price;
        this.totalstock=totalstock;
    }

    // getter and setter methods
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDownloadUr2() {
        return downloadUr2;
    }

    public void setImgUrl(String imgUrl) {
        this.downloadUr2 = downloadUr2;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(String totalstock) {
        this.totalstock = totalstock;
    }


}