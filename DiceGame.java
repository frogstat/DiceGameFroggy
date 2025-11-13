import java.util.*;

public class DiceGame {

    private final List<Dice> diceSet = new ArrayList<>();
    private int score;

    public DiceGame() {
        score = 0;
        for (int i = 1; i <= 5; i++) {
            diceSet.add(new Dice());
        }
    }

    public boolean isFullHouse() {
        boolean hasTwo = false;
        boolean hasThree = false;

        for (DiceNumbers number : DiceNumbers.values()) {
            int result = Collections.frequency(diceSet, new Dice(number));
            if (result == 2) {
                hasTwo = true;
            }
            if (result == 3) {
                hasThree = true;
            }
        }
        return hasTwo && hasThree;
    }

    private boolean isSmallStraight() {
        return diceSet.contains(new Dice(DiceNumbers.ONE))
                && diceSet.contains(new Dice(DiceNumbers.TWO))
                && diceSet.contains(new Dice(DiceNumbers.THREE))
                && diceSet.contains(new Dice(DiceNumbers.FOUR))
                && diceSet.contains(new Dice(DiceNumbers.FIVE));
    }

    private boolean isLargeStraight() {
        return diceSet.contains(new Dice(DiceNumbers.TWO))
                && diceSet.contains(new Dice(DiceNumbers.THREE))
                && diceSet.contains(new Dice(DiceNumbers.FOUR))
                && diceSet.contains(new Dice(DiceNumbers.FIVE))
                && diceSet.contains(new Dice(DiceNumbers.SIX));
    }

    private boolean isThreeOfAKind() {
        for (DiceNumbers number : DiceNumbers.values()) {
            int result = Collections.frequency(diceSet, new Dice(number));
            if (result == 3) {
                return true;
            }
        }
        return false;
    }

    private boolean isTwoPairs() {
        int numOfPairs = 0;
        for (DiceNumbers number : DiceNumbers.values()) {
            int result = Collections.frequency(diceSet, new Dice(number));
            if (result == 2) {
                numOfPairs++;
            }
        }
        return numOfPairs == 2;
    }

    private boolean isFourOfAKind() {
        for (DiceNumbers number : DiceNumbers.values()) {
            int result = Collections.frequency(diceSet, new Dice(number));
            if (result == 4) {
                return true;
            }
        }
        return false;
    }

    private boolean isFiveOfAKind() {
        for (DiceNumbers number : DiceNumbers.values()) {
            int result = Collections.frequency(diceSet, new Dice(number));
            if (result == 6) {
                return true;
            }
        }
        return false;
    }

    public void getResults() {
        if (isFiveOfAKind()) {
            score += 50;
            System.out.println("- 5 OF A KIND! WOOOO!");
        } else if (isLargeStraight()) {
            score += 40;
            System.out.println("- Large straight!");
        } else if (isSmallStraight()) {
            score += 30;
            System.out.println("- Small straight!");
        } else if (isFullHouse()) {
            score += 30;
            System.out.println("- Full house!");
        } else if (isFourOfAKind()) {
            score += 25;
            System.out.println("- Four of a kind!");
        } else if (isThreeOfAKind()) {
            score += 15;
            System.out.println("- Three of a kind!");
        } else if(isTwoPairs()){
            score += 10;
            System.out.println("- Two pairs!");
        }else {
            System.out.println();
        }
    }

    public void rethrowDice(Dice dice) {
        dice.throwDice();
    }

    public int getScore(){
        return score;
    }

    public List<Dice> getDiceSet() {
        return diceSet;
    }

    public void throwAllDice() {
        for (Dice dice : diceSet) {
            dice.throwDice();
        }
        diceSet.sort(Comparator.comparing(Dice::getDiceNumber));
    }

    public void printDiceSet() throws InterruptedException {
        for (Dice dice : diceSet) {
            System.out.print(dice.printDice() + " ");
            Thread.sleep(300);
        }
    }

}
