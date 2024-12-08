import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exit extends JButton {
    public Exit() {
        super("Exit");
        addActionListener(new ExitActionListener());
    }
}

