import java.util.Objects;
import java.util.Random;

public class Dice {

    private DiceNumbers diceNumber;

    public Dice() {
        diceNumber = DiceNumbers.ONE; //Default value
    }

    public Dice(DiceNumbers number) {
        diceNumber = number;
    }

    public DiceNumbers getDiceNumber() {
        return diceNumber;
    }

    public void throwDice() {
        Random random = new Random();
        int result = random.nextInt(1, 6 + 1);
        switch (result) {
            case 1 -> diceNumber = DiceNumbers.ONE;
            case 2 -> diceNumber = DiceNumbers.TWO;
            case 3 -> diceNumber = DiceNumbers.THREE;
            case 4 -> diceNumber = DiceNumbers.FOUR;
            case 5 -> diceNumber = DiceNumbers.FIVE;
            case 6 -> diceNumber = DiceNumbers.SIX;
            default -> throw new IllegalStateException("Unexpected value: " + result);
        }
    }

    public String printDice() {

        return switch (diceNumber) {
            case ONE -> "⚀";
            case TWO -> "⚁";
            case THREE -> "⚂";
            case FOUR -> "⚃";
            case FIVE -> "⚄";
            case SIX -> "⚅";
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return diceNumber == dice.diceNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(diceNumber);
    }
}

