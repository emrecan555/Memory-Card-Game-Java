import javax.swing.*;
import java.util.*;

public class GameCards
{
    protected List<Card> cards;

    GameCards(int x)
    {
        cards = new ArrayList<>();
        for (Internet card : Internet.values()) {
            cards.add(new Card(card.id, new ImageIcon(card.iconfilepath)));
        }
    }
    GameCards(double x)
    {
        cards = new ArrayList<>();
        for (CyberSecurity card : CyberSecurity.values()) {
            cards.add(new Card(card.id, new ImageIcon(card.iconfilepath)));
        }
    }
    GameCards(char x)
    {
        cards = new ArrayList<>();
        for (GamingComputer card : GamingComputer.values()) {
            cards.add(new Card(card.id, new ImageIcon(card.iconfilepath)));
        }
    }


    public List<Card> getCards() {
        return cards;
    }
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
