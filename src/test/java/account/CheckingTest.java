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


}
