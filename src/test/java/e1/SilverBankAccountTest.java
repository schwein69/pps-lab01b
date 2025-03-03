package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SilverBankAccountTest extends AbstractBankAccountTest{
    @Override
    protected BankAccount createBankAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    protected void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Override
    protected void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class,()->this.account.withdraw(1200));
    }
}
