import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListeners {
}
class StartActionListener implements ActionListener {
    private JButton button;

    public StartActionListener(JButton button) {
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
        if (currentFrame != null) {
            currentFrame.dispose();
        }
        GameLogic.initializeDeck();
        new GameFrame();
    }
}

class SelectLevelActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Frame parentFrame = (Frame) SwingUtilities.getWindowAncestor((Component) e.getSource());
        LevelSelectionDialog dialog = new LevelSelectionDialog(parentFrame);
        dialog.setVisible(true);
        int selectedLevel = dialog.getSelectedLevel();

        if (selectedLevel != -1) {
            updateGameLevel(selectedLevel, (Component) e.getSource());
        }
    }

    private void updateGameLevel(int level, Component parent) {
        GameLogic.setCurrentLevel(level);
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(parent);
        if (currentFrame != null) {
            currentFrame.dispose();
        }
        GameLogic.initializeDeck();
        new GameFrame();
    }
}

class LevelSelectionDialog extends JDialog {
    private int selectedLevel = -1;

    public LevelSelectionDialog(Frame parent) {
        super(parent, "Select Level", true);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Select a level:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JPanel levelPanel = new JPanel();
        levelPanel.setLayout(new FlowLayout());
        for (int i = 1; i <= 3; i++) {
            JButton levelButton = new JButton("" + i);
            int level = i;
            levelButton.setPreferredSize( new Dimension(50, 50));
            levelButton.addActionListener(e -> {
                selectedLevel = level;
                dispose();
            });
            levelPanel.add(levelButton);
        }
        add(levelPanel, BorderLayout.CENTER);

        ImageIcon duke = new ImageIcon("Java Project Assets/duke.png");
        JLabel iconLabel = new JLabel(duke);
        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(iconLabel, BorderLayout.SOUTH);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public int getSelectedLevel() {
        return selectedLevel;
    }
}

class InstructionsActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon duke = new ImageIcon("Java Project Assets/duke.png");
        JOptionPane.showMessageDialog(
                ((Component) e.getSource()).getParent(),
                "Instructions:\nThere are 3 levels in game. It gets gradually harder!\nMatch all pairs of cards to win!",
                "Message",
                JOptionPane.QUESTION_MESSAGE,
                duke
        );
    }
}
class ExitActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon exit = new ImageIcon("Java Project Assets/exit.png");
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, exit);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}

class RestartActionListener implements ActionListener {
    private JMenuBar menuBar;

    public RestartActionListener(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(menuBar);
        currentFrame.dispose();
        GameLogic.setCurrentLevel(1);
        GameLogic.getCurrentDeck().clear();
        GameLogic.initializeDeck();
        new GameFrame();
        Informationbar.updateInformationLabel(GameFrame.getInformationBar());
    }
}

class HighScoresActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ScoreManager.displayHighScoresFromCSV();
    }
}

class AboutDeveloperActionListener implements ActionListener {
    private ImageIcon icon;

    public AboutDeveloperActionListener(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
                null,
                "Developer: Emrecan Bozkurt\nStudent number: 20210702007",
                "About the Developer",
                JOptionPane.QUESTION_MESSAGE,
                icon
        );
    }
}

class AboutGameActionListener implements ActionListener {
    private ImageIcon icon;

    public AboutGameActionListener(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(
                null,
                "Instructions:\nThere are 3 levels in the game. It gets gradually harder!\nMatch all pairs of cards to win!",
                "About the Game",
                JOptionPane.QUESTION_MESSAGE,
                icon
        );
    }
}
