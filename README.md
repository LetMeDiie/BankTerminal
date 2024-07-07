Project description: Bank terminal in Java

The project is a console application in Java that simulates the operation of an ATM. The app allows users to perform basic banking operations such as checking balances, viewing recent transactions, deposits and withdrawals. Users are identified by card number and PIN to ensure security.

Objective of the project

Create a simple and functional ATM model to improve your Object Oriented Programming (OOP) skills in Java. The project will help you master the concepts of working with classes and objects, data processing and implementation of basic algorithms.

Functional requirement

1. User identification:

2. Each user has his own bank account

3. The user must be able to manage their accounts.

4. Every transaction performed by the user must be stored.


1. Each user must have an account.
   1. The user must be able to login by providing the correct username and password.

2. User identification:
   1. Enter the card number and PIN code to access your account.

3. The user must be able to manage their accounts. 
   1. The user must be able to view the current balance of their account.
   2. The user must be able to deposit funds into his account by specifying the deposit amount.
   3. The user must be able to withdraw funds from his account by specifying the withdrawal amount.
      1. The system must check if there are enough funds in the account to complete the transaction. If there are insufficient funds, the transaction must be declined with appropriate notice.
   4. The user must be able to transfer funds from his account to the account of another registered user.
      1. *The user must indicate the card number of another recipient user and the transfer amount.
      2. Before making a transfer, the system must check whether there are sufficient funds in the sender's account. If there are insufficient funds, the transaction must be declined with appropriate notice.
   5. The user should be able to view the history of all their transactions, including deposits, withdrawals and transfers.
   6. The user must be able to log out of their account.

Use case:  
1. User
   * Login
   * Log out of your account
   * View transaction history
   * Account management
     * View current balance
     * depositing funds
     * withdrawals
     * money transaction
2. Terminal
   * System startup
   * menu and interface presentation
   * transaction execution
3. Bank System
   * Banking system for storing transaction history
      (the system processes requests from the terminal and interacts with the database to save transaction history. But since the program works without a database, the data will be stored in a separate class)
   * user storage 


Architecture application
Application modules: (in my case these are all just packages)
1. Dates (date module)
* Main functions: Storing existing users and completed transactions in the system
2. Commands (command module):
* Basic functions: All available commands when working with the terminal
3. Models (module for objects):
* Main functions: Necessary objects for system operation
4. Input_Output:
* Main functions: Working with the terminal, receiving data from the user and also output.
5. Main:
  * Main functions: Managing terminals and changing its state. (for example, moving from the login menu to the account management menu)

Use Case: Login
Subject: User
1. The user launches the application.
2. The system will display the login menu.
3. The user enters the card number.
4. The user enters a PIN code.
5. The system checks the entered data:
   * If the data is correct, the System provides access to the user account.
     * If the data is incorrect, the System displays an error message and returns to step 2.
6. The user gains access to the account management menu.(After successful login, the terminal menu changes to the account management menu)

Classes: User, UserManager (storing/retrieving registered users), LoginCommand]


Each operation will be implemented using a template command. There will also be something similar in the menu or state, storing objects of available commands depending on the type of state.  Most likely, a state template will be used. The state stores command objects, and depending on the command selected, the terminal changes the state to the desired one.  For example, if the terminal is in the login menu state, the user selects the login item. After a successful login, the LoginCommand class will change the terminal state to a state that stores user account management operations. (I ended up calling these classes the terminal manager)


Account management Depositing funds
1. The system asks the user for the amount he wants to deposit.
2. The user enters the amount.
3. The system confirms the entered amount and requests confirmation of the transaction.
4. The user confirms the transaction.
5. The system deposits the specified amount into the user's account.
6. The system updates the user's account balance.
7. The system records the transaction in the transaction history.
8. The system displays a successful deposit message to the user and an updated account balance.
9. Save the transaction


Withdrawals
* The system asks the user for the amount he wants to withdraw from the account.
* The user enters the amount he wants to withdraw.
* The system debits the specified amount from the user's account balance.
* The system updates the user's account balance after withdrawal.
* The system adds information about the completed transaction to the transaction history.
* The system displays a message to the user about successful withdrawal and current account balance.
* Save the transaction 


And other actions. I think it's clear how the system works.