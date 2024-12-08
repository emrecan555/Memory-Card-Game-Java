import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JButton {
    public Start() {
        super("Start Game");
        addActionListener(new StartActionListener(this));
    }
}
