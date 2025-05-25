import java.util.ArrayList;
import java.util.Scanner;

public class Account 
{
    private static int newAccNum = 1000;
    private int option; 
    private int accNum; 
    private String accName; 
    private double funds; 

    public Account(String accName, double funds, int option)
    {
        this.accName = accName;
        this.accNum = newAccNum;
        newAccNum++; 
        this.funds = funds; 
        this.option = option;
    }

    public int getAccNum()
    {
        return accNum; 
    }

    public double depositing (double inputCash)
    {
        funds = funds + inputCash; 
        return funds;
    }

    public double withdraw(double outCash)
    {
        if (outCash > funds)
        {
            return funds;
        }
        else 
        {
            funds = funds - outCash; 
            return funds;
        }
    }
        public void setOption(int option)
        {
            this.option = option; 
        }

        public String getAccName()
        {
            return accName; 
        }

        public double getFunds()
        {
            return funds;
        }

        public int getOption()
        {
            return option; 
        }
}

class theBank 
{
    static ArrayList<Account> accounts = new ArrayList<>();
    static Account thisAccount = null; 
    static Scanner scanner = new Scanner(System.in);
    static Account currentAcc = null; 
    public static void optionMenu()
    {
    System.out.println("\nWhat can we do for you? Please choose from 1-6.");

    System.out.println("1. Create Account");
    System.out.println("2. Deposit Money");
    System.out.println("3. Withdraw Money");
    System.out.println("4. Check Balance");
    System.out.println("5. Switch Accounts");
    System.out.println("6. Exit\n");
    System.out.println("Enter your choice here: ");
    }

    public static void showOptions()
    {
        System.out.println();
        System.out.println("1. Create Another Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Switch Accounts");
        System.out.println("6. Exit\n");
        
    }
    public static void deposit(Account userAccount)
    {
    double cash = -1; 
    System.out.println("Enter desired amount to deposit: ");
    while(cash < 0)
    {
        try {
            cash = scanner.nextDouble();
            if (cash < 0)
            {
                System.out.println("Please make sure to enter a number larger than zero: ");
            }
            else 
            {
                userAccount.depositing(cash);
                System.out.println("New Balance after deposit: $" + userAccount.getFunds());
            }
        } 
        catch (Exception e) 
        {
            System.out.print("Deposit error: Please try entering a number: ");
            scanner.next();
        }
    }
    }

    public static void withdrawing(Account userAccount)
    {
    double cash = -1;
    System.out.println("Enter desired amount to withdraw:  ");
    while(cash < 0)
        {
        try
            {
            cash = scanner.nextDouble();
            if (cash > userAccount.getFunds())
                {
                System.out.println("You can not withdraw more than the funds in your account.");
                break;
                }
            else if (cash < 0)
            {
                System.out.println("Please enter a number larger than zero: ");
            }
            else 
            {
                userAccount.withdraw(cash);
                break;
            }
            }

        catch (Exception e)
        {
            System.out.println("ERROR: Please enter a number: ");
            scanner.next();
        }

        }
    }

    public static void showFunds(Account userAccount)
    {
        System.out.println("You have $" + userAccount.getFunds() + " in your bank account");
    }

    public static int menuChoice (Account userAccount)
    {
        int option = userAccount.getOption();
        switch(option)
        {
            case 2: 
                deposit(userAccount);
                break;
            case 3: 
                withdrawing(userAccount);
                break; 
            case 4: 
                showFunds(userAccount);
                break;
            case 5: 
                switchAcc();
                break;
            //case 6: 
              //  System.out.println("Thanks for using Leen's banking system!");
              //  break;

        }
        return 1;
    }

    public static int checkMenuOp (int lowestNumIn, int highestNumIn)
    {
        int option = -1; 
        while(option < lowestNumIn || option > highestNumIn)
        {
            try 
            {
                option = scanner.nextInt();
                scanner.nextLine();
                if (option < lowestNumIn || option > highestNumIn)
                {
                    System.out.print("Please be sure to choose from " + lowestNumIn + " to " + highestNumIn); 
                }
            } 
            catch (Exception e) 
            {
                System.out.print("Please be sure to enter a #, try again: ");
                scanner.next();
            }
        }
        return option;
    }

    public static void newAcc()
    {
        String accName = "AUTO NAME"; 
        double funds = 0; 

        System.out.print("Please input new account owner name: "); 
    
        accName = scanner.nextLine(); 

        if(accName.trim().equals(""))
        {
            accName = "AUTO NAME";
        }

        System.out.print("How much would you like to deposit to open the account?");
        while (true) 
        { 
            try 
            {
                funds = scanner.nextDouble();
                if (funds >= 0)
                {
                    break;
                }
                else 
                {
                    System.out.print("Please enter a number larger than 0: ");
                }
            } 
            catch (Exception e) 
            {
                System.out.print("Please be sure to enter a #, try again: ");
                scanner.next();
            }
        }

        Account newAcc = new Account(accName, funds, 3);
        accounts.add(newAcc);
        currentAcc = newAcc; 

        System.out.print("\nNew account successfully made. Account #: " + newAcc.getAccNum());
    }

    public static void switchAcc()
    {
        if (accounts.size() == 0)
        {
            System.out.println("Please make an account, there is no record of previous accounts.");
            return;
        }

        System.out.println("The accounts we have on file are: ");
        for (int i = 0; i < accounts.size(); i++)
        {
            Account one = accounts.get(i);
            System.out.println((i + 1) + "." + one.getAccName() + ", Account #: " + one.getAccNum());
        }

        System.out.println("Please choose the number from the list (1 to " + accounts.size() + "): ");
        int choiceNum = checkMenuOp(1, accounts.size());
        currentAcc = accounts.get(choiceNum - 1);
        System.out.println("You picked the " + currentAcc.getAccName() + " account.");

    }

    public static void main(String[] args) 
    {
        System.out.println("Welcome to Leen's Simple Banking System! ");

        int option = 0; 
        while(currentAcc == null)   
        {
            optionMenu();
            option = checkMenuOp(1, 6);
            
            if (option == 1)
            {
                newAcc();
            }
            else if (option == 5)
            {
                switchAcc();                
            }
            else if (option == 6)
            {
                System.out.println("Thanks for using Leen's banking system!");
                return;
            }
            else 
            {
            System.out.println("Please create or switch to an account first.");
            }
            

        }

        while(true)
        {
            showOptions();
            option = checkMenuOp(1, 6);
            if(option == 1)
            {
                newAcc();
            }
            else if(option == 6)
            {
                break;
            }
            else 
            {
                currentAcc.setOption(option);
                menuChoice(currentAcc);
            }
        }
     System.out.println("Thank you for choosing Leen's Banking System! Have a nice day.");

    }
}


