package account;

public class Checking extends Account {


    public Checking(){
        super.createAccount();
        super.setUserName("");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("");


    }


}
