import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Memory Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(new Label());
        frame.pack();
        frame.setLocationRelativeTo(null);

    }
}