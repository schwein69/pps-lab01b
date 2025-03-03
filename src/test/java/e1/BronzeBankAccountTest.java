package e1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest{
    @Override
    protected BankAccount createBankAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Override
    protected void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(50);
        assertEquals(950, this.account.getBalance());
        this.account.withdraw(100);
        assertEquals(849, this.account.getBalance());
    }

    @Override
    protected void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class,()->this.account.withdraw(1200));
    }
}
