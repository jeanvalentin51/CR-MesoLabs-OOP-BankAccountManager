package account;

public abstract class Account {



    private Long accountNumber;
    private Double balance;
    private String userName;
    private int status;
    private int overdraft;
    private AccountHistory accountHistory;

    private String accountType;

    public Account(String userName, ){
        this.accountNumber = Long.valueOf(100);
    }

//    protected void createAccount(){
//        accountNumber = Long.valueOf(100);
//    }

    protected void deposit(double amount) throws IllegalArgumentException {
        if(amount <= 0){
            throw new IllegalArgumentException("Deposit amount must be a number greater than zero.");
        }
        else if(amount > 0){
            this.setBalance(this.balance + amount);
            this.accountHistory.recordHistoryDeposit(amount);
        }
    }

    protected void withdraw(double amount) throws IllegalArgumentException{
        if((amount > this.getBalance() && this.overdraft == 1) || amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero and less than your current balance.");
        }
        else if(amount <this.getBalance() && amount > 0){
            this.setBalance(this.balance - amount);
            this.accountHistory.recordHistoryWithdraw(amount);
        }
    }

    protected void transferFromThisAccount(Account toAccount, double amount) throws IllegalArgumentException{
        if(amount > this.getBalance() || amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero and less than this account's current balance.");
        }
        else if(amount <this.getBalance() && amount > 0){
            this.setBalance(this.getBalance() - amount);
            this.accountHistory.recordHistoryOutgoingTransfer(amount, toAccount.getAccountNumber());
            toAccount.setBalance(toAccount.getBalance() + amount);
            toAccount.accountHistory.recordHistoryIncomingTransfer(amount, this.getAccountNumber());
        }
    }

    protected void transferToThisAccount(Account fromAccount, double amount) throws IllegalArgumentException{
        if(amount > fromAccount.getBalance() || amount <= 0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero and less than the source account's current balance.");
        }
        else if(amount <fromAccount.getBalance() && amount > 0){
            this.setBalance(this.getBalance() + amount);
            this.accountHistory.recordHistoryIncomingTransfer(amount, fromAccount.getAccountNumber());
            fromAccount.setBalance(this.getBalance() - amount);
            fromAccount.accountHistory.recordHistoryOutgoingTransfer(amount, this.getAccountNumber());
        }
    }


    protected void notThis(){

    }


    //getters and setters

    public Long getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
