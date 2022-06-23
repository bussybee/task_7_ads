package ru.vsu.cs.maslovei.demo;

import ru.vsu.cs.util.SwingUtils;
import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class Program {

    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        SwingUtils.setDefaultFont("Arial", 20);

        EventQueue.invokeLater(() -> {
            try {
                JFrame mainFrame = new GraphDemoFrame();
                mainFrame.setVisible(true);
                mainFrame.setExtendedState(MAXIMIZED_BOTH);
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });
    }
}
