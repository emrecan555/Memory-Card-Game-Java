import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ShuffleDeckTask implements Runnable {
    private List<GameButtons> deck;

    public ShuffleDeckTask(List<GameButtons> deck) {
        this.deck = deck;
    }

    @Override
    public void run() {
        List<Card> temp = new ArrayList<>();
        for (Iterator<GameButtons> it = deck.iterator(); it.hasNext(); ) {
            temp.add(it.next().getBackside());
        }
        Collections.shuffle(temp);
        Iterator<Card> tempIt = temp.iterator();
        for (GameButtons button : GameLogic.getCurrentDeck()) {
            if (tempIt.hasNext()) {
                button.setBackside(tempIt.next());
            }
        }
    }
}
