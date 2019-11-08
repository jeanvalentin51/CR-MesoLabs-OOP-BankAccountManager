package account;

public class Savings extends Account {


    public  Savings(){
        super.createAccount();
        super.setUserName("");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("");
    }
}
