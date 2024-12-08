import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

class ScoreManager {
    private static final String SCORES_FILE = "game_scores.csv";
    public static void saveScoreToCSV() {
        String playerName = JOptionPane.showInputDialog(null, "Enter your name:", "Name Input", JOptionPane.PLAIN_MESSAGE);
        if (playerName != null && !playerName.trim().isEmpty()) {
            List<Score> scores = readScoresFromCSV();
            scores.add(new Score(playerName, GameLogic.getPlayerScore()));
            scores.sort(Comparator.comparingInt(Score::getScore).reversed());
            writeScoresToCSV(scores);
        }
    }

    public static List<Score> readScoresFromCSV() {
        List<Score> scores = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(SCORES_FILE))) {
            scores = br.lines()
                    .map(line -> line.split(","))
                    .filter(values -> values.length == 2)
                    .map(values -> new Score(values[0], Integer.parseInt(values[1])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public static void writeScoresToCSV(List<Score> scores) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SCORES_FILE))) {
            for (Score score : scores) {
                writer.write(score.getPlayerName() + "," + score.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayHighScoresFromCSV() {
        List<Score> scores = readScoresFromCSV();
        StringBuilder highScores = new StringBuilder("Top 10 High Scores:\n");
        scores.stream().limit(10).forEach(score -> highScores.append(score.getPlayerName()).append(": ").append(score.getScore()).append("\n"));
        JOptionPane.showMessageDialog(null, highScores.toString(), "En İyi Skorlar", JOptionPane.INFORMATION_MESSAGE);
    }

    static class Score {
        private String playerName;
        private int score;

        public Score(String playerName, int score) {
            this.playerName = playerName;
            this.score = score;
        }

        public String getPlayerName() {
            return playerName;
        }

        public int getScore() {
            return score;
        }
    }

}