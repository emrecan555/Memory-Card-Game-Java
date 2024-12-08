import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gamemenubar extends JMenuBar {

    public Gamemenubar() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon duke = new ImageIcon("Java Project Assets//duke.png");
        JMenu GameMenu = new JMenu("Game");
        JMenu AboutMenu = new JMenu("About");
        JMenu ExitMenu = new JMenu("Exit");
        ExitMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        JMenuItem Restartitem = new JMenuItem("Restart");
        Restartitem.addActionListener(new RestartActionListener(this));
        JMenuItem HighScoresitem = new JMenuItem("High Scores");
        HighScoresitem.addActionListener(new HighScoresActionListener());
        JMenuItem developeritem = new JMenuItem("About The Developer");
        developeritem.addActionListener(new AboutDeveloperActionListener(duke));
        JMenuItem gameitem = new JMenuItem("About The Game");
        gameitem.addActionListener(new AboutGameActionListener(duke));

        GameMenu.add(Restartitem);
        GameMenu.add(HighScoresitem);
        AboutMenu.add(developeritem);
        AboutMenu.add(gameitem);
        add(GameMenu);
        add(AboutMenu);
        add(ExitMenu);
    }
}


