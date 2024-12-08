import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JButton  {

    public Instructions() {
        super("Instructions");
        addActionListener(new InstructionsActionListener());
    }

    private void initializeButton() {
        setFocusable(false);
        addActionListener(new InstructionsActionListener());
    }

}
