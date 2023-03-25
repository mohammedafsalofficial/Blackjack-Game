import java.util.ArrayList;
import java.util.Random;

public class Blackjack implements Cards {

    int[] cards = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
    int ace = 11;
    int limit = 21;

    /**
     * Returns a card from the deck of cards.
     */
    @Override
    public int dealCard() {
        Random random = new Random();
        int randomIndex = random.nextInt(cards.length);
        return cards[randomIndex];
    }

    /**
     * Returns starting cards for the user and the computer.
     */
    @Override
    public ArrayList<Integer> getStartingCards() {
        ArrayList<Integer> startingCards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            startingCards.add(dealCard());
        }
        return startingCards;
    }

    /**
     * Calculate the score for the given cards.
     */
    @Override
    public int calculateScore(ArrayList<Integer> cards) {
        int sum = 0;
        for (Integer card : cards) {
            sum += card;
        }
        if (sum == 21 && cards.size() == 2) {
            return 0;
        }
        if (cards.contains(ace) && sum > limit) {
            sum = 0;
            for (int i = 0; i < cards.size(); i++) {
                if (cards.get(i) == 11) {
                    cards.remove(i);
                    cards.add(1);
                }
                sum += cards.get(i);
            }
        }
        return sum;
    }

    /**
     * Checks if the game ends or not.
     */
    @Override
    public boolean checkGameEnds(int userScore, int computerScore) {
        return userScore == 0 || computerScore == 0 || userScore > limit;
    }

    /**
     * Compares the user score and computer score.
     */
    @Override
    public void compareScore(int userScore, int computerScore) {
        if (userScore == computerScore) {
            System.out.println("Draw");
        } else if (computerScore == 0) {
            System.out.println("Lose, Opponent has blackjack");
        } else if (userScore == 0) {
            System.out.println("Win with a blackjack");
        } else if (userScore > limit) {
            System.out.println("You went over, you lose");
        } else if (computerScore > limit) {
            System.out.println("Opponent went over, you win");
        } else if (userScore > computerScore) {
            System.out.println("You win");
        } else {
            System.out.println("You lose");
        }
    }
}
