package rashed.hasan.hone;

public class editnid {
    private String valuedata;

    public  editnid() {
        // empty constructor
        // required for Firebase.
    }
    public  editnid(String valuedata) {
        this.valuedata = valuedata;

    }
    public String getEditnid() {
        return valuedata;
    }

    public void setEditnid(String valuedata) {
        this.valuedata = valuedata;
    }
}
