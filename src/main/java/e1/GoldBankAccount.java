package e1;

public class GoldBankAccount extends BankAccountDecorator{
    private static final int OVERDRAFT = -500;
    public GoldBankAccount(BankAccount baseAccount) {
        super(baseAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() - amount  < OVERDRAFT){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
