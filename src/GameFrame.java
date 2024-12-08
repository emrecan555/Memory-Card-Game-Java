import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private static Gamemenubar GameMenuBar = new Gamemenubar();
    private static Informationbar InformationBar = new Informationbar();
    public GameFrame() {
        super("Flash Card Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(560, 655);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());
        setJMenuBar(GameMenuBar);
        add(InformationBar, BorderLayout.NORTH);
        addbuttons();
        setLocationRelativeTo(null);
    }

    public static Informationbar getInformationBar() {
        return InformationBar;
    }

    public static void setInformationBar(Informationbar informationBar) {
        GameFrame.InformationBar = informationBar;
    }
    public void addbuttons(){
        JPanel panelForButtons = new JPanel();
        panelForButtons.setLayout(new FlowLayout());
        for (GameButtons button : GameLogic.getCurrentDeck())
        {

            panelForButtons.add(button);
        }
        add(panelForButtons);
    }

}