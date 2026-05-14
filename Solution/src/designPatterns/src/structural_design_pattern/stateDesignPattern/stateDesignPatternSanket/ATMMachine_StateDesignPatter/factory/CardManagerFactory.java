package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.factory;

import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.enums.CardType;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CardManagerService;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.CreditCardManagerService;
import designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.service.DebitCardManagerService;

public class CardManagerFactory {
    public static CardManagerService getCardManager(CardType cardType) {
        CardManagerService cardManagerService = null;
        if (cardType.equals(CardType.CREDIT_CARD)) {
            return new DebitCardManagerService();
        } else if (cardType.equals(CardType.DEBIT_CARD)) {
            return new CreditCardManagerService();
        } else {
            throw new IllegalArgumentException("Invalid card type: " + cardType);
        }
    }
}
