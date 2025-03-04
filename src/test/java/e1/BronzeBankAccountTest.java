package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest {
    @Override
    protected BankAccount createBankAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Override
    @Test
    protected void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
        this.account.withdraw(100);
        assertEquals(849, this.account.getBalance());
    }

    @Override
    @Test
    protected void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }
}
