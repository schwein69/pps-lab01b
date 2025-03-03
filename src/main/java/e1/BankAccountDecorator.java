package e1;

public abstract class BankAccountDecorator implements BankAccount{
    protected BankAccount baseAccount;

    public BankAccountDecorator(BankAccount baseAccount) {
        this.baseAccount = baseAccount;
    }

    @Override
    public int getBalance() {
        return baseAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        baseAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        baseAccount.withdraw(amount);
    }
}
