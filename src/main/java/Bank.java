import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = accounts.size() + 1; // Простий спосіб генерації номера рахунку
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        BankAccount account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws NegativeAmountException, InsufficientFundsException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}