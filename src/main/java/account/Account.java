package account;

import java.util.List;
import java.util.Random;

public abstract class Account {

    private Long accountNumber;
    private Double balance;
    private String userName;
    private int status;    // 0 for closed, 1 for opened, 2 for frozen
    private int overdraft; // 0 for off, 1 for on, 2 for auto-transfer
    private Account overdraftTransfer;
    private String userPin;
    private AccountHistory accountHistory;

    private String accountType;


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


    //used to check if User is allowed to perform actions on this account
    protected boolean checkStatus () {
        if (this.status == 0 || this.status == 2) {
            return false;
        }
        else {
            return true;
        }
    }

    //used to check if an account can withdraw beyond its limits
    protected boolean checkOverdraft(){

        if(this.overdraft == 0 || (this.overdraft == 2 && this.overdraftTransfer.balance <=0)){
            return false;
        }
        else{
            return true;
        }
    }


//----------- constructor -------------------------------

    public Account(String userPin){

        setAccountNumber();
        this.accountHistory = new AccountHistory();
        this.userPin = userPin;
        this.balance = 0.00;
        this.status = 0;
        this.overdraft = 0;

    }

//-------- business logic ---------------------------


    public void deposit(Double amount){
        this.balance += amount;
        accountHistory.recordHistoryDeposit(amount);
    }

    public String withdraw(Double amount){
        if(checkBalance(amount)) {
            this.balance -= amount;
            accountHistory.recordHistoryWithdraw(amount);
            return null;
        } else
            return "Insufficient funds";
    }

    public String transfer(Account transferTo, Double amount){
        if(checkBalance(amount)){
            this.balance -= amount;
            transferTo.balance += amount;
            accountHistory.recordHistoryOutgoingTransfer(amount, transferTo.accountNumber);
            transferTo.accountHistory.recordHistoryIncomingTransfer(amount, this.accountNumber);
            return null;
        }else
            return "Insufficient funds";
    }

// -----------------------------------------------

    public boolean checkBalance(Double amount){
        if (amount < this.balance)
            return true;

        return false;
    }



// ---------- setters and getters -------------------------------------


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber() {
        //this.accountNumber = accountNumber;

        Random random = new Random(System.nanoTime());

        this.accountNumber = Long.valueOf(random.nextInt(1000000000));

    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getUserPin() {
        return userPin;
    }

    public void setUserPin(String pin) {
        this.userPin = pin;
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


    public String getHistoryAll(){
        return toString(accountHistory.getAllTransactions());
    }

    public String getHistoryDeposit(){
        return toString(accountHistory.getDeposits());
    }

    public String getHistoryWithdraw(){
        return toString(accountHistory.getWithdrawals());
    }

    public String getHistoryTransfer(){
        return toString(accountHistory.getAllTransactions());
    }


    public String toString(List<String> list){

        return "Account: " + this.getAccountNumber() + "\n" + list.toString().replace(", ", "\n")
                .replace("[", "").replace("]", "\n");
    }

}
