package account;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountHistoryTest {



    @Test
    void recordHistoryDeposit() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.recordHistoryDeposit(25.00);
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualDepositTransactions = accountHistory.getDeposits().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualDepositTransactions);
    }

    @Test
    void recordHistoryWithdraw() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.recordHistoryWithdraw(25.00);
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualWithdrawalTransactions = accountHistory.getWithdrawals().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualWithdrawalTransactions);
    }

    @Test
    void recordHistoryIncomingTransfer() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.recordHistoryIncomingTransfer(25.00, 7L);
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualIncomingTransferTransactions = accountHistory.getAccountTransfers().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualIncomingTransferTransactions);
    }

    @Test
    void recordHistoryOutgoingTransfer() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.recordHistoryOutgoingTransfer(25.00, 7L);

        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualOutgoingTransferTransactions = accountHistory.getAccountTransfers().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualOutgoingTransferTransactions);
    }

    @Test
    void nameChange() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.nameChange("Bob Smith");
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualNameChangeTransactions = accountHistory.getNameChanges().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualNameChangeTransactions);
    }

    @Test
    void statusChange() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.statusChange("Closed");
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualStatusChangeTransactions = accountHistory.getStatusChanges().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualStatusChangeTransactions);
    }

    @Test
    void interestChange() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.interestChange("5.5");
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();
        Integer actualInterestRateChangeTransactions = accountHistory.getInterestRates().size();

        Assert.assertEquals(expected, actualAllTransactions);
        Assert.assertEquals(expected, actualInterestRateChangeTransactions);
    }

    @Test
    void getAllTransactions() {
        AccountHistory accountHistory = new AccountHistory();
        Integer expected = 1;   //testing size b/c timestamp is fluid bc we are assigning the time in our method.
        accountHistory.recordHistoryDeposit(25.00);
        Integer actualAllTransactions = accountHistory.getAllTransactions().size();


        Assert.assertEquals(expected, actualAllTransactions);
    }




}