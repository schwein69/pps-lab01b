package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractBankAccountTest {
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
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    protected abstract void testCanWithdraw();

    @Test
    protected abstract void testCannotWithdrawMoreThanAvailable();
}
