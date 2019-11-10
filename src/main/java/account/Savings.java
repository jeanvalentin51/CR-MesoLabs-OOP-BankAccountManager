package account;

public class Savings extends Account {


    public  Savings(AccountWarehouse accountWarehouse){
        super(accountWarehouse);
        super.setUserPin("0050");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("");
    }
}
