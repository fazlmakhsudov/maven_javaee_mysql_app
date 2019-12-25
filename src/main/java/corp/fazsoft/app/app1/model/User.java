package corp.fazsoft.app.app1.model;

/**
 * it holds data
 */
public class User {
    private String mName;
    private String mPassword;

    public User() {
    }

    public User(String mName, String mPassword) {
        this.mName = mName;
        this.mPassword = mPassword;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
