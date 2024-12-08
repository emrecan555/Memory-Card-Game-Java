import javax.swing.*;

public class Card {
    private int id;
    private ImageIcon icon;
    public Card(int id, ImageIcon icon) {
        setId(id);
        setIcon(icon);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}