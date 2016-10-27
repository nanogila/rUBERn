package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class YesOrNoGUI {

        private boolean choice = false;

        /**
         * @wbp.parser.entryPoint
         */
        public boolean showYesNoMessage(String title, String message) {

            JLabel label = new JLabel(message);

            JButton yesButton = new JButton("Yes");
            yesButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choice = true;
                    JButton button = (JButton)e.getSource();
                    SwingUtilities.getWindowAncestor(button).dispose();
                }
            });

            JButton noButton = new JButton("No");
            noButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    choice = false;
                    JButton button = (JButton)e.getSource();
                    SwingUtilities.getWindowAncestor(button).dispose();
                }
            });

            JPanel buttons = new JPanel();
            buttons.add(yesButton);
            buttons.add(noButton);

            JPanel content = new JPanel(new BorderLayout(8, 8));
            content.add(label, BorderLayout.CENTER);
            content.add(buttons, BorderLayout.SOUTH);

            JDialog dialog = new JDialog();
            dialog.setResizable(false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setTitle(title);
            dialog.getContentPane().add(content);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            return choice;
        }
    }


//}