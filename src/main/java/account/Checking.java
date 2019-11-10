package account;

public class Checking extends Account {


    public Checking(AccountWarehouse accountWarehouse){
        super(accountWarehouse);
        super.setUserPin("0050");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("Checking");

    }



}
