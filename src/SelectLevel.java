import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectLevel extends JButton {
    public SelectLevel() {
        super("Select Level");
        addActionListener(new SelectLevelActionListener());
    }
}

