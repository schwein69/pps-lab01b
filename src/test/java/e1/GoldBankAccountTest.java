package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends AbstractBankAccountTest {
    @Override
    protected BankAccount createBankAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Override
    @Test
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Override
    @Test
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        assertDoesNotThrow(() -> this.account.withdraw(1500));
        assertEquals(-500, this.account.getBalance());
    }
}
