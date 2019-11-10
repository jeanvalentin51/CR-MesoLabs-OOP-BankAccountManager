package account;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    public void createAccount() {
            AccountWarehouse testWarehouse = new AccountWarehouse();
            Checking testAccount = new Checking(testWarehouse);
            Long expected = Long.valueOf(1000001);
            Long actual;

            testAccount.createAccount();
            actual = testAccount.getAccountNumber();
            Assert.assertEquals(expected,actual);
    }

    @Test
    void depositWithdraw() {
        AccountWarehouse testWarehouse = new AccountWarehouse();
        Checking testAccount = new Checking(testWarehouse);

        Double expected = Double.valueOf(500);
        testAccount.setBalance(Double.valueOf(575));
        testAccount.depositWithdraw(Double.valueOf(-75));

        Double actual = testAccount.getBalance();
        Assert.assertEquals(expected,actual);

        expected = Double.valueOf(525);
        testAccount.depositWithdraw(Double.valueOf(25));
        actual = testAccount.getBalance();
        Assert.assertEquals(expected,actual);

    }
}