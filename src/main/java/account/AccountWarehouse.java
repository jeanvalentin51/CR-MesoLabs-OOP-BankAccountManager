package account;

public class AccountWarehouse {
    private Long accountNumber;
    private Account currentAccount;

    public AccountWarehouse(){
        accountNumber= Long.valueOf(1000000);
    }

    protected void createAccount(Account account){
        accountNumber++;
        currentAccount = account;
        currentAccount.setAccountNumber(accountNumber);
    }



}
