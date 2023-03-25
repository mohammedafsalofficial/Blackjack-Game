import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    static void game() {
        Blackjack blackjack = new Blackjack();

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> userCards;
        ArrayList<Integer> computerCards;

        userCards = blackjack.getStartingCards();
        computerCards = blackjack.getStartingCards();
        int userScore = 0;
        int computerScore = 0;

        boolean isGameOver = false;
        while (!isGameOver) {
            userScore = blackjack.calculateScore(userCards);
            computerScore = blackjack.calculateScore(computerCards);

            System.out.println("    Your cards: " + userCards + ", Current score: " + userScore);
            System.out.println("    Computer's first card: " + computerCards.get(0));

            isGameOver = blackjack.checkGameEnds(userScore, computerScore);

            if (isGameOver) {
                break;
            } else {
                System.out.print("Type 'y' to get another card, type 'n' to pass: ");
                String userShouldDeal = input.next();
                if (Objects.equals(userShouldDeal, "y")) {
                    userCards.add(blackjack.dealCard());
                } else {
                    isGameOver = true;
                }
            }
        }

        while (computerScore != 0 && computerScore < 17) {
            computerCards.add(blackjack.dealCard());
            computerScore = blackjack.calculateScore(computerCards);
        }

        System.out.println("    Your final hand: " + userCards + ", Final score: " + userScore);
        System.out.println("    Computer's final hand: " + computerCards + ", Final score: " + computerScore);
        blackjack.compareScore(userScore, computerScore);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Do you want to play a game of Blackjack? Type 'y' or 'n': ");
        String choice = input.next();

        if (Objects.equals(choice, "y")) {
            game();
        }
    }
}
