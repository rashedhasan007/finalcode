package rashed.hasan.hone;
public class createshopclass {

    // variables for storing our data.
    private String _downloadUrl,shopname,aboutus,contactnumber,address,imagelogo,url;

    public  createshopclass() {
        // empty constructor
        // required for Firebase.
    }

    // Constructor for all variables.
    public  createshopclass(String _downloadUrl, String shopname, String aboutus,String contactnumber,String address, String imagelogo,String url) {
        this._downloadUrl = _downloadUrl;
        this.shopname = shopname;
        this.aboutus = aboutus;
        this.contactnumber=contactnumber;
        this.address=address;
        this.imagelogo=imagelogo;
        this.url=url;
    }

    // getter methods for all variables.
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String get_downloadUrl() {
        return _downloadUrl;
    }

    public void set_downloadUrl(String _downloadUrl) {
        this._downloadUrl = _downloadUrl;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getImagelogo() {
        return imagelogo;
    }

    public void setImagelogo(String imagelogo) {
        this.imagelogo = imagelogo;
    }

    public String getShopname() {
        return shopname;
    }

    // setter method for all variables.
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }
}