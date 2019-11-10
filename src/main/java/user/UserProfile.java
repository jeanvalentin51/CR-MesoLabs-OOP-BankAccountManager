package user;

import account.Account;

import java.util.ArrayList;
import java.util.List;

public class UserProfile {


    private String firstName;
    private String lastName;
    private int pinNumber;
    private List<Account> accountsList;

    public UserProfile(Integer pin, String first, String last){
        firstName = first;
        lastName = last;
        pinNumber = pin;
        accountsList = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }


    public void userMenu(String UserInput){}
}
