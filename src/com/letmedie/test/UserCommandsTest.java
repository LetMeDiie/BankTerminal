package com.letmedie.test;
import com.letmedie.commandss.Command;
import com.letmedie.commandss.user_commands.*;
import com.letmedie.dates.TransactionManagerInterface;
import com.letmedie.dates.TransactionManagerSimple;
import com.letmedie.dates.UserManager;
import com.letmedie.dates.UserManagerSimple;
import com.letmedie.models.AccountBalance;
import com.letmedie.models.User;

public class UserCommandsTest {
    public static void main(String[] args) {
        TransactionManagerInterface transactionManager = new TransactionManagerSimple();
        User user = new User("deposit", "1", "1", new AccountBalance(1000));

        viewBalanceCommandTest(user);


        depositCommandTest(user,100,transactionManager); //valid;
        depositCommandTest(user,-100,transactionManager);//not valid amount;

        withdrawCommandTest(user,transactionManager,100);//valid
        withdrawCommandTest(user,transactionManager,-100);//not valid amount

        transferCommandTest("18062002",user,100,transactionManager);//valid
        transferCommandTest("18062002",user,-100,transactionManager);//not valid amount
        transferCommandTest("1111",user,100,transactionManager);//not valid card number

        viewBalanceCommandTest(user);

        viewTransactionCommandTest(user,transactionManager);



    }

    public static void depositCommandTest(User user , double amount ,TransactionManagerInterface transactionManager ){
        System.out.println("_______DEPOSIT TEST________");
        Command command = new DepositCommand(user,amount,transactionManager);
        command.execute();
        System.out.println();
    }

    public static void viewBalanceCommandTest(User user){
        System.out.println("________VIEW TEST__________");
        Command command = new ViewBalanceCommand(user);
        command.execute();
        System.out.println();

    }
    public static void withdrawCommandTest(User user , TransactionManagerInterface transactionManagerInterface,double amount){
        System.out.println("_________WITHDRAW TEST____________");
        Command command = new WithdrawCommand(user,amount,transactionManagerInterface);
        command.execute();
        System.out.println();
    }
    public static void transferCommandTest(String cardNumber,User user, double amount,TransactionManagerInterface transactionManagerInterface){
        System.out.println("___________TRANSFER TEST____________");
        UserManager userManager = new UserManagerSimple();
        Command command = new TransferCommand(user,cardNumber,userManager,amount,transactionManagerInterface);
        command.execute();
        System.out.println();
    }
    public static void viewTransactionCommandTest(User user,TransactionManagerInterface transactionManagerInterface){
        Command command = new ViewTransactionCommand(transactionManagerInterface.getTransactionsIterator(user));
        command.execute();


    }

}