class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited TZS " + amount + ". New balance: TZS " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Balance: TZS " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public double calculateInterest() {
        return 0;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : TZS " + balance);
        System.out.println("Interest       : TZS " + calculateInterest());
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MINIMUM_BALANCE = 10000;

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (balance - amount < MINIMUM_BALANCE) {
            System.out.println("Withdrawal denied. Minimum balance of TZS " + MINIMUM_BALANCE + " must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        }
    }

    public void applyInterest() {
        double interest = calculateInterest();
        balance += interest;
        System.out.println("Interest of TZS " + interest + " applied. New balance: TZS " + balance);
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Account Type   : Savings Account");
        super.displayAccountInfo();
        System.out.println("Interest Rate  : " + (interestRate * 100) + "%");
    }
}

class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance + overdraftLimit) {
            System.out.println("Withdrawal denied. Exceeds overdraft limit. Available: TZS " + (balance + overdraftLimit));
        } else {
            balance -= amount;
            System.out.println("Withdrew TZS " + amount + ". New balance: TZS " + balance);
        }
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

    public boolean isOverdrawn() {
        return balance < 0;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Account Type   : Current Account");
        super.displayAccountInfo();
        System.out.println("Overdraft Limit: TZS " + overdraftLimit);
        System.out.println("Overdrawn      : " + isOverdrawn());
    }
}

class FixedDepositAccount extends BankAccount {
    private double interestRate;
    private int maturityMonths;
    private boolean isMatured;

    public FixedDepositAccount(String accountNumber, String accountHolder, double balance, double interestRate, int maturityMonths) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
        this.maturityMonths = maturityMonths;
        this.isMatured = false;
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate * (maturityMonths / 12.0);
    }

    @Override
    public void withdraw(double amount) {
        if (!isMatured) {
            System.out.println("Withdrawal denied. Fixed deposit has not matured yet.");
        } else {
            super.withdraw(amount);
        }
    }

    public void checkMaturity(int monthsElapsed) {
        if (monthsElapsed >= maturityMonths) {
            isMatured = true;
            System.out.println("Account " + accountNumber + " has matured.");
        } else {
            System.out.println("Account " + accountNumber + " matures in " + (maturityMonths - monthsElapsed) + " month(s).");
        }
    }

    public double getMaturityAmount() {
        return balance + calculateInterest();
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("Account Type   : Fixed Deposit Account");
        super.displayAccountInfo();
        System.out.println("Interest Rate  : " + (interestRate * 100) + "%");
        System.out.println("Maturity Period: " + maturityMonths + " months");
        System.out.println("Matured        : " + isMatured);
        System.out.println("Maturity Amount: TZS " + getMaturityAmount());
    }
}

class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank(int capacity) {
        accounts = new BankAccount[capacity];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count++] = account;
            System.out.println("Account " + account.accountNumber + " added successfully.");
        } else {
            System.out.println("Bank is at full capacity.");
        }
    }

    public double getTotalDeposits() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].calculateInterest();
        }
        return total;
    }

    public void displayAllAccounts() {
        System.out.println("============================================");
        System.out.println("             ALL BANK ACCOUNTS              ");
        System.out.println("============================================");
        for (int i = 0; i < count; i++) {
            accounts[i].displayAccountInfo();
            System.out.println("--------------------------------------------");
        }
        System.out.println("Total Deposits : TZS " + getTotalDeposits());
        System.out.println("Total Interest : TZS " + getTotalInterest());
        System.out.println("============================================");
    }
}

public class Exercise13_BankingSystem {

    static void processDeposit(BankAccount account, double amount) {
        System.out.println("[Single Deposit] " + account.accountHolder);
        account.deposit(amount);
    }

    static void processDeposit(BankAccount account, double amount, String description) {
        System.out.println("[Deposit: " + description + "] " + account.accountHolder);
        account.deposit(amount);
    }

    static void processDeposit(BankAccount account, double[] amounts) {
        System.out.println("[Multiple Deposits] " + account.accountHolder);
        for (double amount : amounts) {
            account.deposit(amount);
        }
    }

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   Exercise 13: Polymorphism - Banking      ");
        System.out.println("============================================\n");

        SavingsAccount savings = new SavingsAccount("SA001", "Amina Juma", 50000, 0.05);
        CurrentAccount current = new CurrentAccount("CA001", "Juma Bakari", 30000, 20000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD001", "Fatuma Ali", 100000, 0.08, 12);

        System.out.println("--- Section 1: Method Overloading (Deposits) ---");
        processDeposit(savings, 5000);
        processDeposit(current, 10000, "Salary");
        processDeposit(fixed, new double[]{20000, 30000, 50000});

        System.out.println("\n--- Section 2: Polymorphic Withdrawals ---");
        savings.withdraw(45000);
        savings.withdraw(5000);

        current.withdraw(45000);
        current.withdraw(10000);
        System.out.println("Current account overdrawn: " + current.isOverdrawn());

        fixed.withdraw(10000);
        fixed.checkMaturity(12);
        fixed.withdraw(10000);

        System.out.println("\n--- Section 3: Interest (Polymorphism) ---");
        BankAccount[] accounts = {savings, current, fixed};
        for (BankAccount account : accounts) {
            System.out.println(account.accountHolder + " - Interest: TZS " + account.calculateInterest());
        }
        savings.applyInterest();

        System.out.println("\n--- Section 4: Fixed Deposit Maturity ---");
        System.out.println("Maturity Amount for " + fixed.accountHolder + ": TZS " + fixed.getMaturityAmount());
        fixed.checkMaturity(6);

        System.out.println("\n--- Section 5: Bank Summary ---");
        Bank bank = new Bank(10);
        bank.addAccount(savings);
        bank.addAccount(current);
        bank.addAccount(fixed);
        System.out.println();
        bank.displayAllAccounts();
    }
}
