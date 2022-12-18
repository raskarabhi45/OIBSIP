// Task 3 ATM Interface in Java
import java.util.*;
class BankAccount
{
    String Name;
    String Username;
    String Password;
    String AccountNo;
    float Balance=100000f;
    int Transactions=0;
    String TransactionHistory="";
   /* 
    BankAccount(String name,String username,String password,String accountno)
    {
        this.Name=name;
        this.Username=username;
        this.Password=password;
        this.AccountNo=accountno;
    }
    */

    public void Register()
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter your name : ");
        this.Name=obj.nextLine();
        System.out.println("Enter your username : ");
        this.Username=obj.nextLine();
        System.out.println("Enter your password : ");
        this.Password=obj.nextLine();
        System.out.println("Enter your acoountNo : ");
        this.AccountNo=obj.nextLine();

        System.out.println("Registration Completed ... Kindly Login");

    }

    public boolean Login()
    {
        boolean isLogin=false;
        Scanner obj=new Scanner(System.in);
        while( !isLogin )
        {
            System.out.println("Enter your username : ");
            String username=obj.nextLine();
            if(username.equals(Username))
            {
                while(!isLogin)
                {
                    System.out.println("Enter your passsword : ");
                    String password=obj.nextLine();
                    if(password.equals(Password))
                    {
                        System.out.println("Login Successful...");
                        isLogin=true;
                    }
                    else
                    {
                        System.out.println("Incorrect Password");
                    }
                }
            }
            else
            {
                System.out.println("Username not found");
            }
        }
        return isLogin;
    }

    public void Withdraw()
    {
        System.out.println("Enter amount to withdraw");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextFloat();

        try{
            if(Balance>=amount)
            {
                Transactions++;
                Balance=Balance-amount;
                System.out.println("Withdraw Successful...");
                String str=amount+" Rs Withdrawed";
                TransactionHistory=TransactionHistory.concat(str);
            }
            else
            {
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception obj1)
        {

        }
    }


    public void Deposit()
    {
        System.out.println("Enter amount to deposit : ");
        Scanner obj=new Scanner(System.in);
        float amount=obj.nextFloat();

        try{
            if(amount<=100000f)
            {
                Transactions++;
                Balance=Balance+amount;
                System.out.println("Amount Successfully Deposited");
                String str=amount+" RS deposited";
                TransactionHistory=TransactionHistory.concat(str);
            }
            else
            {
                System.out.println("Sorry...Limit is 100000.00");
            }
        }
        catch(Exception obj2)
        {

        }
    }

    public void Transfer()
    {
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter Receipents Name : ");
        String recerpent=obj.nextLine();
        System.out.println("Enter amount to transfer");
        float amount=obj.nextFloat();

        try
        {
            if(Balance>=amount)
            {
                if(amount<=50000f)
                {
                    Transactions++;
                    Balance=Balance-amount;
                    System.out.println("Successfully transfered to "+recerpent);
                    String str=amount+"Rs Transferred to "+recerpent+"\n";
                    TransactionHistory=TransactionHistory.concat(str);
                }
                else
                {
                    System.out.println("\nSorry Limit is 50000.00 ");
                }
            }
            else
            {
                System.out.println("Insufficient balance");
            }
        }
        catch(Exception obj3)
        {

        }
    }

    public void CheckBalance()
    {
        System.out.println("'\n"+"Account balance is "+Balance+" Rs");
    }

    public void TransactionHistory()
    {
        if(Transactions==0)
        {
            System.out.println("Empty");
        }
        else
        {
            System.out.println("\n"+TransactionHistory +"\n");
        }
    }

}

public class AtmInterface {

    public static int TakeIntegerInput(int limit)
    {
        int input=0;
        boolean flag=false;

        while(!flag)
        {
            try
            {
                Scanner obj=new Scanner(System.in);
                input=obj.nextInt();
                flag=true;

                if(flag && input >limit ||input < 1)
                {
                    System.out.println("Choose the number between 1 to "+limit);
                    flag=false;
                }
            }
            catch(Exception obj4)
            {
                System.out.println("Enter only integer value");
                flag=false;
            }
        }
        return input;
    }

    public static void main(String arg[])
    {
        System.out.println("\n--------------WELCOME TO IDBI ATM SYSTEM--------------\n");
        System.out.println(" 1.Register \n 2.Exit");
        System.out.println("Enter your choice : ");
        
        int choice=TakeIntegerInput(2);

        if(choice==1)
        {
            BankAccount obj=new BankAccount();
            obj.Register();
            while(true)
            {
                System.out.println("\n 1.Login \n 2.Exit");
                System.out.println("Enter your choice : ");
                int ch=TakeIntegerInput(2);
                if(ch==1)
                {
                    if(obj.Login())
                    {
                        System.out.println("\n\n---------WELCOME BACK "+obj.Name+"-----------\n");
                        boolean isFinished=false;
                        while(!isFinished)
                        {
                            System.out.println("\n1.Withdraw\n 2.Deposit\n 3.Transfer\n 4.CheckBalance\n 5.TransactionHostory\n 6.Exit\n");
                            System.out.println("\nEnter your choice");

                            int i=TakeIntegerInput(6);
                            switch(i)
                            {
                                case 1:
                                obj.Withdraw();
                                break;
                                case 2:
                                obj.Deposit();
                                break;
                                case 3:
                                obj.Transfer();
                                break;
                                case 4:
                                obj.CheckBalance();
                                break;
                                case 5:
                                obj.TransactionHistory();
                                break;
                                case 6:
                                isFinished=true;
                                break;

                            }
                        }
                    }
                }
                else
                {
                    System.exit(0);
                }
            }
        }
        else
        {
            System.exit(0);
        }

    }
    
}
