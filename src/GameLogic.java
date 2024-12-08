import javax.swing.*;
import java.util.*;

public class GameLogic {
    private static int currentLevel = 1;
    private static int triesLeft = 18;
    private static int playerScore = 0;
    private static int pluspoint;
    private static int negpoint;
    private static List<GameButtons> currentDeck = new ArrayList<>();
    private static final Map<Integer, LevelSettings> levelSettingsMap = new HashMap<>();
    private static final Map<Integer, ImageIcon> levelFrontsides = new HashMap<>();

    static {
        levelFrontsides.put(1, new ImageIcon("Java Project Assets/Level1-InternetAssets/no_image.png"));
        levelFrontsides.put(2, new ImageIcon("Java Project Assets/Level2-CyberSecurityAssets/no_image.png"));
        levelFrontsides.put(3, new ImageIcon("Java Project Assets/Level3-GamingComputerAssets/no_image.png"));
    }
    static void setLevelSettings() {
        levelSettingsMap.put(1, new LevelSettings(new GameCards(1), 18, 5, -1));
        levelSettingsMap.put(2, new LevelSettings(new GameCards(1.0), 15, 4, -2));
        levelSettingsMap.put(3, new LevelSettings(new GameCards('1'), 12, 3, -3));
    }
    static void initializeDeck(){
        setLevelSettings();
        LevelSettings settings = levelSettingsMap.getOrDefault(currentLevel, levelSettingsMap.get(1));
        GameCards currentCards = settings.cards;

        setTriesLeft(settings.triesLeft);
        setPluspoint(settings.pluspoint);
        setNegpoint(settings.negpoint);

        for (int i = 0; i < 8; i++) {
            GameButtons buttonOne = new GameButtons();
            GameButtons buttonTwo = new GameButtons();
            buttonOne.setFrontside(levelFrontsides.get(getCurrentLevel()));
            buttonTwo.setFrontside(levelFrontsides.get(getCurrentLevel()));
            buttonOne.setIcon(levelFrontsides.get(getCurrentLevel()));
            buttonTwo.setIcon(levelFrontsides.get(getCurrentLevel()));
            buttonOne.setBackside(currentCards.getCards().getFirst());
            buttonTwo.setBackside(currentCards.getCards().getFirst());
            currentCards.getCards().removeFirst();
            currentDeck.add(buttonOne);
            currentDeck.add(buttonTwo);
        }
        new Thread(new ShuffleDeckTask(currentDeck)).start();
    }

    private static class LevelSettings {
        GameCards cards;
        int triesLeft;
        int pluspoint;
        int negpoint;

        LevelSettings(GameCards cards, int triesLeft, int pluspoint, int negpoint) {
            this.cards = cards;
            this.triesLeft = triesLeft;
            this.pluspoint = pluspoint;
            this.negpoint = negpoint;
        }
    }
    public static void advanceLevel() {
        currentLevel++;
    }
    public static List<GameButtons> getCurrentDeck() {
        return currentDeck;
    }

    public static void setCurrentDeck(List<GameButtons> currentDeck) {
        GameLogic.currentDeck = currentDeck;
    }

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        GameLogic.currentLevel = currentLevel;
    }

    public static int getTriesLeft() {
        return triesLeft;
    }

    public static void setTriesLeft(int triesLeft) {
        GameLogic.triesLeft = triesLeft;
    }

    public static int getPlayerScore() {
        return playerScore;
    }

    public static void setPlayerScore(int playerScore) {
        GameLogic.playerScore = playerScore;
    }

    public static int getPluspoint() {
        return pluspoint;
    }

    public static void setPluspoint(int pluspoint) {
        GameLogic.pluspoint = pluspoint;
    }

    public static int getNegpoint() {
        return negpoint;
    }

    public static void setNegpoint(int negpoint) {
        GameLogic.negpoint = negpoint;
    }

}
