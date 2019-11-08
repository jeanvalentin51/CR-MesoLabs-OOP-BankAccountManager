package account;

public class Investments extends Account {
    private Double interestRate;


    public Investments(){
        super.createAccount();
        super.setUserName("");
        super.setOverdraft(1);
        super.setStatus(1);
        super.setAccountType("");
    }
}
