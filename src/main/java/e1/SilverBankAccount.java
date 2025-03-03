package e1;

public class SilverBankAccount extends BankAccountDecorator{
    private static final int FEE = 1;
    public SilverBankAccount(BankAccount baseAccount) {
        super(baseAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (getBalance() < amount){
           throw new IllegalStateException();
        }
        super.withdraw(amount + FEE);
    }
}
