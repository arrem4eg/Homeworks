package homework8;

public class BankTest {
    public static void main(String[] args) {

        Bank bank = new Bank(4);

        // test1. create account. limit 4 accounts

        System.out.println("###################  TEST 1 ########################");
        bank.createAccount(1001, 100);
        bank.createAccount(1002, 200);
        bank.createAccount(1003, 300);
        bank.createAccount(1004, 400.40);
        bank.createAccount(1005, 500.50);

        System.out.println("###################  TEST 2 ########################");

        // test2. deposit
        bank.deposit(1001, 300);
        bank.deposit(1002, 50);
        bank.deposit(1001, 0);
        bank.deposit(1004, -100);

        System.out.println("#####################  TEST3 ############################");

        // test3.  withdrawal Of Funds
        bank.withdrawalOfFunds(1001, 44.69);
        bank.withdrawalOfFunds(1002, 0);
        bank.withdrawalOfFunds(1003, 1000);
        bank.withdrawalOfFunds(1004, -999);

        System.out.println("###################### TEST4  ###########################");

        //test4. non-existent account
        bank.deposit(1021, 290);
        bank.withdrawalOfFunds(1042, 600);

    }
}
