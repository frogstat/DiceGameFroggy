import java.util.*;

public class FroggyGame {
    public static void main(String[] args) throws InterruptedException{

        DiceGame diceGame = new DiceGame();

        System.out.println("""
                **********************
                Welcome to the dice game!
                Possible outcomes by score:
                    Five in a row: 50 pts
                    Large straight: 40 pts
                    Small straight: 30 pts
                    Full house: 30 pts
                    Four in a row: 25 pts
                    Three in a row: 15 pts
                    Two pairs: 10 pts
                **********************""");

        Thread.sleep(2000);
        System.out.print("3... ");
        Thread.sleep(1000);
        System.out.print("2... ");
        Thread.sleep(1000);
        System.out.print("1... ");
        Thread.sleep(1000);
        System.out.println("Roll!");
        Thread.sleep(1000);

        for (int i = 1; i <= 10; i++) {
            diceGame.throwAllDice();
            System.out.printf("%2d: ", i);
            Thread.sleep(750);
            diceGame.printDiceSet();
            diceGame.getResults();
        }
        System.out.println("***************");
        System.out.println("Score: " + diceGame.getScore());
        System.out.println("***************");
    }
}
