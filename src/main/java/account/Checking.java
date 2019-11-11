package account;

public class Checking extends Account {

    public Checking(String userPin){

        super(userPin);
        super.setAccountType("Checking");
    }




}
