package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.NaiveSoln;

import java.util.UUID;

public class ATM {

    public String startTransaction(){
        String transactionId = generateTransactionId();
        System.out.println("Transaction started with id: " + transactionId);
        return transactionId;
    }

    public boolean cancelTransaction(String transactionId){
        System.out.println("Transaction with id: " + transactionId + " is cancelled.");
        return true;
    }

    public boolean readCard(String cardType, long cardNumber, int pin){
        System.out.println("Validating card: "+ cardType + " with card number: " + cardNumber + " and pin: " + pin);
        boolean isValid = validateCardDetails(cardType, cardNumber, pin);
        if(isValid){
            System.out.println("Card details are valid. Proceeding with transaction.");
        }
        else{
            System.out.println("Invalid card details. Please try again.");
        }
        return isValid;
    }

    boolean withdrawAmount(String transactionId, int amount){
        System.out.println("Validating withdraw amount: "+ amount + " with transaction id: " + transactionId);
        boolean canWithdrawAmount = checkWithdrawalLimit(transactionId, amount);
        if(canWithdrawAmount){
            System.out.println("Withdrawal amount is valid. Proceeding with transaction.");
        }
        else{
            System.out.println("Invalid withdrawal amount. Please try again.");
        }
        return canWithdrawAmount;
    }

    public void dispenseCash(double amount){
        System.out.println("Dispensing the cash amount: " + amount);
        deductCashFromATM(amount);
    }

    private void deductCashFromATM(double amount) {

    }

    public void ejectCard(){
        System.out.println("Ejecting a card.");
    }

    private boolean checkWithdrawalLimit(String transactionId, int amount) {
        return true;
    }

    private boolean validateCardDetails(String cardType, long cardNumber, int pin) {
        return true;
    }

    public String generateTransactionId(){
        return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        String transactionId = atm.startTransaction();
        boolean isCardValid = atm.readCard("VISA", 1234567890123456L, 1234);
        if(isCardValid){
            boolean canWithdrawAmount = atm.withdrawAmount(transactionId, 5000);
            if(canWithdrawAmount){
                atm.dispenseCash(5000);
            }
        }
        atm.ejectCard();
    }


}

/**
 * Problems with this solution
 * 1. Missing instance variables
 * Issue: The class only defines methods but lacks fields to hold specific properties of an ATM, such as unique identifier (atmId) or its state.
 * Solution: Add instance variables to represent the ATM's Id and state.
 * Use these fields to track the machine's identity and current status
 *
 * 2. No support for Multiple ATM instances (similar to problem 1)
 *
 * 3. Lack of state management
 * Issue: The class does not manage the state of an ATM, leading to potential issues like starting a new transaction while another is in progress.
 * Solution: Introduce an enum to define possible ATM states (IDLE, TRANSACTION_IN_PROGRESS, OUT_OF_SERVICE), Use a state variable to track and enforce state transactions.
 *
 * 4. Concurrency Issues ( similar to problem 3)
 * Issue: No mechanism to prevent concurrent transactions, leading to possible conflicts or incorrect behaviour
 * Solution: Check the ATM state before starting a transaction
 * throw an exception or error if a transaction is already in progress.
 *
 * 5. Undefined State transitions
 * Issue: The transitions between ATM states are not explicitly defined, making the flow ambigious.
 * Solution: Clearly define state transitions and ensure operations are allowed only in valid states. Update the state after each successfull operations
 *
 * 6. Violates SRP,
 */
