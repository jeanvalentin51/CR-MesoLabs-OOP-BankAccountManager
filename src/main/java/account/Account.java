package account;

import java.util.List;
import java.util.Random;

public abstract class Account {

    private Long accountNumber;
    private String userPin;
    private Double balance;
    private int status;
    private int overdraft;
    private AccountHistory accountHistory;

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

    public String getHistory(){
        return toString(accountHistory.getAllTransactions());
    }


    public String toString(List<String> list){

        return "Account: " + this.getAccountNumber() + "\n" + list.toString().replace(", ", "\n")
                .replace("[", "").replace("]", "\n");
    }
}
