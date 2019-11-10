package account;

import sun.tools.tree.DoubleExpression;

public abstract class Account {



    private Long accountNumber;
    private Double balance;
    private String userPin;
    private int status;
    private int overdraft;
    private AccountHistory accountHistory;
    private AccountWarehouse warehouse;
    private String accountType;


//----------- constructor -------------------------------
    public Account(AccountWarehouse warehouse){
        this.warehouse = warehouse;
        this.accountHistory = new AccountHistory();
        // TODO vv
        this.accountType = "";
        this.status = 0;
        this.overdraft = 0;
    }

//-------- business logic ---------------------------

    public void createAccount(){
        warehouse.createAccount(this);
    }

    public void depositWithdraw(Double amount){
        this.balance += amount;
    }


// ---------- setters and getters -------------------------------------

    public Long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
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

}
