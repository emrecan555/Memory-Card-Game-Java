import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Informationbar extends JLabel
{
    private static final Map<Integer, Color> levelColors = new HashMap<>();

    static {
        levelColors.put(1, new Color(85, 130, 163));
        levelColors.put(2, new Color(127, 73, 161));
        levelColors.put(3, new Color(158, 32, 20));
    }
    Informationbar()
    {
        setFont(new Font("Lucida Fax",  Font.BOLD, 30));
        setForeground(Color.WHITE);
        setBackground(getColorForLevel(GameLogic.getCurrentLevel()));
        setOpaque(true);
        setPreferredSize(new Dimension(520, 40));
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        updateInformationLabel(this);
    }

    static void updateInformationLabel(Informationbar bar) // function to update the tries left
    {
        int levelSpacing = 2;
        bar.setText(String.format("LEVEL %s %" + levelSpacing + "s Tries Left : %s", GameLogic.getCurrentLevel(), "", GameLogic.getTriesLeft()));
        bar.setBackground(bar.getColorForLevel(GameLogic.getCurrentLevel()));

    }
    private Color getColorForLevel(int level) {
        return levelColors.get(level);
    }
}
