package user;

import account.AccountWarehouse;
import account.Checking;
import account.Savings;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void createAccoutn() {
        AccountWarehouse testWarehouse = new AccountWarehouse();
        Checking testAccount = new Checking(testWarehouse);
        Long expected = Long.valueOf(1000001);
        Long actual;

        testAccount.createAccount();
        actual = testAccount.getAccountNumber();
        Assert.assertEquals(expected,actual);


    }
}