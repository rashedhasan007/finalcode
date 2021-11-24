package rashed.hasan.hone;


import android.widget.TextView;

public class editname{
    private String valuedata;

    public  editname(TextView valuedata) {
        // empty constructor
        // required for Firebase.
    }
    public  editname(String valuedata) {
        this.valuedata = valuedata;

    }
    public String getEditnameid() {
        return valuedata;
    }

    public void setEditnameid(String valuedata) {
        this.valuedata = valuedata;
    }
}
