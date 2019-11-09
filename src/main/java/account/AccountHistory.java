package account;

import java.util.LinkedList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class AccountHistory {
    private List<String> allTransactions;
    private List<String> deposits;
    private List<String> withdrawals;
    private List<String> accountTransfers;
    private List<String> nameChanges;
    private List<String> statusChanges;
    private List<String> interestRates;

    public AccountHistory() {
        allTransactions = new LinkedList<String>();
        deposits = new LinkedList<String>();
        withdrawals = new LinkedList<String>();
        accountTransfers = new LinkedList<String>();
        nameChanges = new LinkedList<String>();
        statusChanges = new LinkedList<String>();
        interestRates = new LinkedList<String>();
    }

    public List<String> getAllTransactions() {
        return allTransactions;
    }

    public List<String> getDeposits() {
        return deposits;
    }

    public List<String> getWithdrawals() {
        return withdrawals;
    }

    public List<String> getAccountTransfers() {
        return accountTransfers;
    }

    public List<String> getNameChanges() {
        return nameChanges;
    }

    public List<String> getStatusChanges() {
        return statusChanges;
    }

    public List<String> getInterestRates() {
        return interestRates;
    }

    protected void recordHistoryDeposit (Double amount){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        String depositTransaction = "Deposited "  + amount + " at " + timestamp;
        allTransactions.add(depositTransaction);
        deposits.add(depositTransaction);

    }

    protected  void recordHistoryWithdraw (Double amount){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String withdrawalTransaction = "Withdrew " + amount + " at " + timestamp;
        allTransactions.add(withdrawalTransaction);
        withdrawals.add(withdrawalTransaction);

    }

    protected void recordHistoryIncomingTransfer (Double amount, Long accountTransfer ){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String incomingTransferTransaction = "Received incoming transfer of " + amount + " from " + accountTransfer + " at " + timestamp;
        allTransactions.add(incomingTransferTransaction);
        accountTransfers.add(incomingTransferTransaction);

    }

    protected void recordHistoryOutgoingTransfer (Double amount, Long accountTransfer){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String outgoingTransferTransaction = "Sent outgoing transfer of " + amount + " to " + accountTransfer + " at " + timestamp;
        allTransactions.add(outgoingTransferTransaction);
        accountTransfers.add(outgoingTransferTransaction);

    }

    protected void nameChange (String name){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String nameChangeTransaction = "Name changed to " + name + " at " + timestamp;
        allTransactions.add(nameChangeTransaction);
        nameChanges.add(nameChangeTransaction);

    }

    protected void statusChange(String status){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String statusChangeTransaction = "Status change to " + status + " at " + timestamp;
        allTransactions.add(statusChangeTransaction);
        statusChanges.add(statusChangeTransaction);

    }

    protected void interestChange(String newInterestRate){
        Timestamp timestamp = new Timestamp((new Date().getTime()));
        String interestRateChangeTransaction = "Interest rate changed to " + newInterestRate + " at " + timestamp;
        allTransactions.add(interestRateChangeTransaction);
        interestRates.add(interestRateChangeTransaction);


    }


}
