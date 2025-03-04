package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    protected static final int INITIAL_DEPOSIT = 1000;
    protected BankAccount account;

    protected abstract BankAccount createBankAccount();

    @BeforeEach
    protected void init() {
        this.account = createBankAccount();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }

    protected abstract void testCanWithdraw();

    protected abstract void testCannotWithdrawMoreThanAvailable();
}
