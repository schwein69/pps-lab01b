package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SilverBankAccountTest extends AbstractBankAccountTest {
    @Override
    protected BankAccount createBankAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    @Test
    protected void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Override
    @Test
    protected void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
