import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameButtons extends JButton implements ActionListener
    {private ImageIcon frontside;
    private Card backside;
    private static Card firstselectCard;
    private static Card secondselectCard;
    private static int timesClicked = 0;
    private static List<GameButtons> clickedButtons = new ArrayList<>();
    private ImageIcon duke = new ImageIcon("Java Project Assets//duke.png");

    GameButtons(){
        setOpaque(true);
        setFocusable(false);
        setPreferredSize(new Dimension(130,130));
        setBackground(Color.WHITE);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (timesClicked < 2) {
            setIcon(backside.getIcon());
            setDisabledIcon(backside.getIcon());
            setEnabled(false);
            setBackground(Color.WHITE);
            clickedButtons.add(this);
            timesClicked++;

            if (timesClicked == 1) {
                firstselectCard = backside;
            } else if (timesClicked == 2) {
                secondselectCard = backside;
                boolean isMatch = firstselectCard.getId()==secondselectCard.getId();
                if (isMatch) {
                    GameLogic.setPlayerScore(GameLogic.getPlayerScore() + GameLogic.getPluspoint());
                    Informationbar.updateInformationLabel(GameFrame.getInformationBar());
                    for (GameButtons button : clickedButtons) {
                        GameLogic.getCurrentDeck().remove(button);
                    }
                    clickedButtons.clear();
                    checkGameStatus(false);
                } else {
                    GameLogic.setTriesLeft(GameLogic.getTriesLeft() - 1);
                    GameLogic.setPlayerScore(GameLogic.getPlayerScore() + GameLogic.getNegpoint());
                    Informationbar.updateInformationLabel(GameFrame.getInformationBar());
                    if (GameLogic.getCurrentLevel() == 3) { // shuffle cards if its level 3
                        new Thread(new ShuffleDeckTask(GameLogic.getCurrentDeck())).start();
                    }
                    if (GameLogic.getTriesLeft() == 0) {
                        checkGameStatus(true);
                    } else {
                        Timer timer = new Timer(300, evt -> resetButtons());
                        timer.setRepeats(false);
                        timer.start();
                    }
                }
                timesClicked = 0;
            }
        }
    }

    private void resetButtons() {
        for (GameButtons button : clickedButtons) {
            button.setIcon(button.getFrontside());
            button.setEnabled(true);
        }
        clickedButtons.clear();
    }

    private void checkGameStatus(boolean isGameLost) {
        if (isGameLost) {
            showEndGameMessage("You lost, try again!", "You Lost!");
            ScoreManager.saveScoreToCSV();
            closeGame();
            resetGame();
        } else if (GameLogic.getCurrentDeck().isEmpty()) {
            handleLevelCompletion();
        }
    }

    private void showEndGameMessage(String message, String title) {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        JOptionPane.showMessageDialog(this.getParent(), message, title, JOptionPane.INFORMATION_MESSAGE, duke);
    }
    private void handleLevelCompletion() {
        showEndGameMessage("Congrats you won!!", null);
        if (GameLogic.getCurrentLevel() == 3) {
            showScoreMessage();
            ScoreManager.saveScoreToCSV();
            closeGame();
        }
        else {
            advanceToNextLevel();
        }
    }

    private void showScoreMessage() {
        JOptionPane.showMessageDialog(this.getParent(), GameLogic.getPlayerScore(), null, JOptionPane.INFORMATION_MESSAGE, duke);
    }

        private void closeGame() {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (currentFrame != null) {
            currentFrame.dispose();
        }
    }
    private void advanceToNextLevel() {
        GameLogic.advanceLevel();
        closeGame();
        resetLevel();
    }


    private void resetGame() {
        GameLogic.setCurrentLevel(1);
        GameLogic.setPlayerScore(0);
        resetLevel();
    }

    private void resetLevel() {
        GameLogic.getCurrentDeck().clear();
        GameLogic.initializeDeck();
        new GameFrame();
        Informationbar.updateInformationLabel(GameFrame.getInformationBar());
    }

    public ImageIcon getFrontside() {
        return frontside;
    }

    public void setFrontside(ImageIcon frontside) {
        this.frontside = frontside;
    }

    public Card getBackside() {
        return backside;
    }

    public void setBackside(Card backside) {
        this.backside = backside;
    }
    }
