package e1;

public class BronzeBankAccount extends BankAccountDecorator {
    private static final int FEE = 1;
    public BronzeBankAccount(BankAccount baseAccount) {
        super(baseAccount);
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount < 100 ? amount : amount + FEE);
    }
}
