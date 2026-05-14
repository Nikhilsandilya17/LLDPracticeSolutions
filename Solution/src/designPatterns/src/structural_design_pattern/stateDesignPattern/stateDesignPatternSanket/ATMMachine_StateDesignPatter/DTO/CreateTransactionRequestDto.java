package designPatterns.src.structural_design_pattern.stateDesignPattern.stateDesignPatternSanket.ATMMachine_StateDesignPatter.DTO;

public class CreateTransactionRequestDto {
    private final String atmId;

    public CreateTransactionRequestDto(String atmId) {
        this.atmId = atmId;
    }
}
