package e1;

import static org.junit.jupiter.api.Assertions.*;

public class GoldBankAccountTest extends AbstractBankAccountTest{
    @Override
    protected BankAccount createBankAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Override
    public void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(800, this.account.getBalance());
    }

    @Override
    public void testCannotWithdrawMoreThanAvailable() {
        this.account.deposit(1000);
        assertDoesNotThrow(()->this.account.withdraw(1200));
    }
}
