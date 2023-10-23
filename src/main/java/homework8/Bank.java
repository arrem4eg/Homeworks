package homework8;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<Integer, Double> bankAccount = new HashMap<>();
    private int count;
    Account account = new Account();
    Transactions transactions = new Transactions();

    Bank(int count) {
        this.count = count;
    }

    public boolean counterUsers() {
        if (count == 0) {
            System.out.println("Limit 4 accounts");
            return false;
        } else {
            count--;
            return true;
        }
    }

    public void createAccount(int accountNumber, double accountBalance) {
        if (counterUsers()) {
            account.setAccountBalance(accountNumber, accountBalance);
            System.out.println("Account " + accountNumber + " created");
        }
    }

    public void deposit(int accountNumber, double depositSum) {
        if (transactions.checkAccountNumber(accountNumber) && transactions.checkDepositSum(depositSum)) {
            double temp = account.getBalance(accountNumber);
            account.setAccountBalance(accountNumber, temp + depositSum);
            transactions.printInfo(accountNumber, depositSum, "депозит");
        }
    }

    public void withdrawalOfFunds(int accountNumber, double sum) {
        if (transactions.checkAccountNumber(accountNumber) && transactions.checkBalanceSum(accountNumber, sum)) {
            double temp = account.getBalance(accountNumber);
            account.setAccountBalance(accountNumber, temp - sum);
            transactions.printInfo(accountNumber, sum, "зняття коштів");
        }
    }

    class Account {

        public void setAccountBalance(int accountNumber, double accountBalance) {
            bankAccount.put(accountNumber, accountBalance);
        }

        public double getBalance(int accountNumber) {
            return bankAccount.get(accountNumber);
        }
    }

    class Transactions {

        public boolean checkAccountNumber(int accountNumber) {
            if (bankAccount.containsKey(accountNumber)) {
                return true;
            } else {
                System.out.println("рахунок з таким номером не існує");
                return false;
            }
        }

        public boolean checkDepositSum(double depositSum) {
            if (depositSum > 0) {
                return true;
            } else {
                System.out.println("Сума має бути більше 0");
                return false;
            }
        }

        public boolean checkBalanceSum(int accountNumber, double sum) {
            if ((sum > 0) && bankAccount.get(accountNumber) >= sum) {
                return true;
            } else {
                System.out.println("Сума має бути більше 0 та не перевищувати баланс рахунку "
                        + bankAccount.get(accountNumber)
                        + " для аккаунта " + accountNumber);
                return false;
            }
        }

        public void printInfo(int accountNumber, double sum, String type) {
            System.out.println("-----");
            System.out.println("тип операції: " + type);
            System.out.println("сумa: " + sum);
            System.out.println("номер рахунку: " + accountNumber);
            System.out.println("-----");
        }

    }
}




