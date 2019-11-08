package account;

public abstract class Account {



    private Long accountNumber;
    private Double balance;
    private String userName;
    private int status;
    private int overdraft;
    private AccountHistory accountHistory;

    private String accountType;

    protected void createAccount(){
        accountNumber = Long.valueOf(100);
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }

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
