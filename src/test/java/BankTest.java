public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount acc1 = bank.createAccount("John", 1000);
        BankAccount acc2 = bank.createAccount("Alice", 500);

        try {
            acc1.deposit(-100); // Тест на виклик винятку NegativeAmountException
        } catch (NegativeAmountException e) {
            System.out.println("NegativeAmountException: " + e.getMessage());
        }

        try {
            acc1.withdraw(2000); // Тест на виклик винятку InsufficientFundsException
        } catch (InsufficientFundsException | NegativeAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            bank.transferMoney(1, 2, 1500); // Тест на виклик винятку InsufficientFundsException
        } catch (NegativeAmountException | InsufficientFundsException | AccountNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            bank.findAccount(3); // Тест на виклик винятку AccountNotFoundException
        } catch (AccountNotFoundException e) {
            System.out.println("AccountNotFoundException: " + e.getMessage());
        }
    }
}