package account;

public class Savings extends Account {

    public Savings(String userPin){

        super(userPin);
        super.setAccountType("Savings");
    }

}
