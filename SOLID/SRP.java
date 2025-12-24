public class SRP {
    public static void main(String[] args) {
        
        BankAccount account = new BankAccount();
        account.deposit(34500.60);
        account.withdraw(10000.4);
        //account.getBalance();

        AccountStatementPrinter printer = new AccountStatementPrinter();
        printer.statementPrinter(account);

        AccountRepository repository = new AccountRepository();
        repository.save(account);
    }
}

// Business logic
class BankAccount{
    private double balance;

    void deposit(double amount){
        balance += amount;
    }

    void withdraw(double amount){
        balance -= amount;
    }

    double getBalance(){
        return balance;
    }
}

// statement resposibility
class AccountStatementPrinter{
    public void statementPrinter(BankAccount account){
        System.out.println("Current Balance : "+ account.getBalance());
    }
}

//persistence responsibility
class AccountRepository{
    void save(BankAccount account){
        System.out.println("Account save to database.");
    }
}

/*🏦 Example System: Bank Account System (SRP)
        ❌ SRP Violated (Bad Design)
        class BankAccount {

            void deposit(double amount) {
                // business logic
                System.out.println("Deposited: " + amount);
            }

            void withdraw(double amount) {
                // business logic
                System.out.println("Withdrawn: " + amount);
            }

            void generateStatement() {
                // printing responsibility
                System.out.println("Generating bank statement");
            }

            void saveToDatabase() {
                // persistence responsibility
                System.out.println("Saving account to DB");
            }
        }

        ❌ Why this violates SRP

        Business logic (deposit/withdraw)

        Presentation logic (statement)

        Persistence logic (DB)
        ➡️ 3 different reasons to change

        🧠 How to Explain This in Interview (Perfect Answer)

        “Earlier, the BankAccount class had multiple responsibilities like business logic, 
        printing statements, and database operations, violating SRP.
        By separating these into different classes, each class now has only one reason to change, 
        which follows the Single Responsibility Principle.”

        ⭐ Key Takeaway (Write This in Notes)

        SRP = separation of concerns

        One class → one responsibility

        Leads to clean & testable LLD


*/
