This program is the CIS-18B Lesson 1 Assignment. 

This program is a simple banking system. The whole progam is written in the Java file 'Account.java'.
It runs entirely through the console with user selected input using Scanner. 

FUNCTIONALITY- The user will be able to: 
Create accounts with names with their choice of deposit
Make deposists and withdraws
Check the balance of the accounts
Switch between different accounts 
And Exit the program at any time with a goodbye message

Assignment Requirements: 
1. Uses variables, data types, and operators correctly- Variables store account names, balances, and options using appropriate types like `String`, `double`, and `int`. Arithmetic operators update balances.
2. Implements control flow statements (if/else, loops, switch)- if-else statements validate user input, while loops ensure correct user entries, and a switch statement handles menu navigation.
3. Defines and calls methods with parameters and return values- Methods such as deposit, withdraw, and menuChoice accept arguments and return values based on account changes.
4. Uses object-oriented programming (OOP) principles- A class named Account is used to define account data and behavior. Account objects are created and stored in an ArrayList.
5. Implements basic exception handling- try-catch blocks are used to handle errors such as non-numeric user input when numbers are expected.
6. Unique account number generator for each new account- A static variable in the Account class ensures each new account has a unique number starting from 1000.
7. Allows users to create multiple accounts and switch between them- Accounts are stored in a list, and users can select an account from the list to make it the current active account.
8. Includes basic user input handling using the Scanner class- Scanner is used to collect input for names, amounts, and menu selections.
9. Outputs meaningful results using System.out.println()- The program gives users clear messages about actions such as deposits, withdrawals, errors, and balances.
  
Sample Console Interaction: 

Welcome to Leen's Simple Banking System! 

What can we do for you? Please choose from 1-6.
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

Enter your choice here: 
1
Please input new account owner name: Jack
How much would you like to deposit to open the account?300

New account successfully made. Account #: 1000
1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

4
You have $300.0 in your bank account

1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

1
Please input new account owner name: Nelson
How much would you like to deposit to open the account?400

New account successfully made. Account #: 1001
1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

5
The accounts we have on file are: 
1.Jack, Account #: 1000
2.Nelson, Account #: 1001
Please choose the number from the list (1 to 2):
2
You picked the Nelson account.

1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

3
Enter desired amount to withdraw:  
400

1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

4
You have $0.0 in your bank account

1. Create Another Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Switch Accounts
6. Exit

6
Thank you for choosing Leen's Banking System! Have a nice day.
PS C:\Users\leenz\Documents\GitHub\CIS18B-S25-33479-Assignment3> 
