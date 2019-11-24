package zoo;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class User implements Serializable {
    
    protected String name;
    protected String address;
    protected String phone;
    protected LocalDate entryDate;
    protected String user;
    protected String password;
    
    protected User(String name, String address, String phone,
            LocalDate entryDate, String user, String password){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.entryDate = entryDate;
        this.user = user;
        this.password = password;
    }
    
    public abstract void proceed(Zoo zoo);
 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
