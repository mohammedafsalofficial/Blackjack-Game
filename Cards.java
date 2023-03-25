import java.util.ArrayList;

public interface Cards {

    int dealCard();
    ArrayList<Integer> getStartingCards();
    int calculateScore(ArrayList<Integer> cards);
    boolean checkGameEnds(int userScore, int computerScore);
    void compareScore(int userScore, int computerScore);
}
