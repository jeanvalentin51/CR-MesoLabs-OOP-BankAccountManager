package account;

public class Investments extends Account {
    private Double interestRate;


    public Investments(AccountWarehouse accountWarehouse){
        super(accountWarehouse);
        super.createAccount();
        super.setUserPin("0050");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("");
    }
}
