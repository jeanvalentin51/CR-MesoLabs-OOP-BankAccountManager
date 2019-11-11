package account;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CheckingTest {

    @Test
    public void createAccountTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(100.00);

        System.out.println(newChecking.getAccountNumber());
        System.out.println(newChecking.getBalance());

    }

    @Test
    public void withdrawInsufficientFundsTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(100.00);

        String expected = "Insufficient funds";

        Assert.assertEquals(expected, newChecking.withdraw(200.00));
    }

    @Test
    public void withdrawTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(300.00);
        newChecking.withdraw(100.00);

        Double expected = 200.00;
        Double actual = newChecking.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void depositTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(100.00);
        newChecking.deposit(340.00);

        Double expected = 440.00;
        Double actual = newChecking.getBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printDepositTransactionsTest() {

        Checking newChecking = new Checking("098");

        newChecking.setBalance(100.00);
        newChecking.deposit(340.00);
        newChecking.withdraw(100.00);

        System.out.println(newChecking.getHistoryDeposit());
    }

    @Test
    public void printWithdrawTransactionsTest() {

        Checking newChecking = new Checking("098");

        newChecking.setBalance(100.00);
        newChecking.deposit(340.00);
        newChecking.withdraw(100.00);
        newChecking.withdraw(20.00);
        newChecking.withdraw(30.00);

        System.out.println(newChecking.getHistoryWithdraw());
    }

    @Test
    public void printTransactionsTest() {

        Checking newChecking = new Checking("098");

        Checking newChecking2 = new Checking("099");

        newChecking.setBalance(100.00);
        newChecking.deposit(340.00);
        newChecking.withdraw(100.00);

        newChecking2.setBalance(120.00);
        newChecking2.deposit(10.00);
        newChecking2.withdraw(70.00);

        System.out.println(newChecking.getHistoryAll());
        System.out.println(newChecking2.getHistoryAll());
    }

    @Test
    public void getTypeTest() {

        Checking newChecking = new Checking("098");

        newChecking.setBalance(100.00);
        String expected = "Checking";

        String actual = newChecking.getAccountType();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void changeAccountStatus(){

        Checking newChecking = new Checking("098");
        newChecking.setStatus(2);

        int expected = 2;
        int actual = newChecking.getStatus();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void changeAccountOverdraft(){

        Checking newChecking = new Checking("098");
        newChecking.setOverdraft(1);

        int expected = 1;
        int actual = newChecking.getOverdraft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transferTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(5000.00);

        Savings newSavings = new Savings("098");

        newChecking.transfer(newSavings, 3000.00);

        Double expected = 3000.00;
        Double actual = newSavings.getBalance();

        Assert.assertEquals(expected, actual);

        //-------------

        Double expected2 = 2000.00;
        Double actual2 = newChecking.getBalance();

        Assert.assertEquals(expected2, actual2);

    }

    @Test
    public void transferInsufficientFundsTest(){

        Checking newChecking = new Checking("098");
        newChecking.setBalance(5000.00);

        Savings newSavings = new Savings("098");

        String expected = "Insufficient funds";
        String actual = newChecking.transfer(newSavings, 7000.00);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void transferPrintTest() {

        Checking newChecking = new Checking("098");
        newChecking.setBalance(5000.00);

        Savings newSavings = new Savings("098");

        newChecking.transfer(newSavings, 3000.00);

        System.out.println(newChecking.getHistoryTransfer());
        System.out.println(newSavings.getHistoryTransfer());

    }
}
