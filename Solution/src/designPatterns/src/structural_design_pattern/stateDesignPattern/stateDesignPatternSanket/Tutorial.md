Q. Design a ATM

What are the requirements of the system?

1. Single transaction support
2. The system should allow only one transaction at a time for a particular user. No concurrent transactions should be allowed for the same user.
3. The ATM should have a start button to initiate the transaction.
4. once the transaction starts, the machine should prompt the user to insert their card
5. The system should validate the card details upon insertion
6. If the card is invalid, the system should reject it and return it to the user
7. After validating the card, the system should ask the user to enter the withdrawl amount, The system should validate if the withdrawl amount can be dispensed based on the available cash in the machine and the user's account balance
8. Allowed scenarios (cancellation scenarios):
   - Before inserting the card
   - After being prompted to

Let's clarify the flow of an ATM

1. Transaction start
Action: User presses the start transaction button
API call:
 An API is triggered to start the transaction
 THe API returns a unique transaction ID which will be used for all subsequent operations in this transaction
Next step:
   User proceeds or cancels

2. Card insertion
Action: User inserts their card into the machine
API call:
    An API is triggered to validate the card details (card number, expiry date, CVV)
Validation flow:
   If valid: Proceed to the next step(enter amount)
   if invalid: 
     Stop the transaction
     Eject the card and return to the initial state 

3. Enter withdrawal amount
Action: User enters the withdrawal amount on the machine
API call:
   The system validates if the withdrawal amount can be dispensed based on the available cash in the machine and the user's account balance
Validation flow:
    If valid: Proceed to dispense cash
    If invalid: 
      Allow the user to re-enter the amount or cancel the transaction

4. Dispense cash
Action: The machine dispenses the cash to the user
API call:
   close the transaction and record it for tracking purpose
User feedback:
   Display a confirmation message indicating successful transaction completion

5. Cancellation options
Cancellation points:
   Before card insertion (API call to stop the transaction)
    After card insertion but before entering the amount(API call to stop the transaction)
    After entering the amount but before cash dispensing (API call to stop the transaction)
Restricted cancellation scenarios:
    Once cash dispensing is started, the transaction cannot be canceled

6. Transaction closure
Action: After cash dispensing or cancellation, the transaction is finalized
API call:
   Mark the transaction as completed or canceled in the system, record the transaction details for auditing and tracking purposes


API overview

1. Start transaction API - Initiated when the user presses the start button, returns a unique transaction ID
2. Cancel transaction API - Stops the transaction at any valid point and resets the state
3. Validate card: Checks if the card is valid or not
4. Validate amount: Ensures the entered amount can be dispensed
5. Close transaction: Finalizes the transaction and records the details