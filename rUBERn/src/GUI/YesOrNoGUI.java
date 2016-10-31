package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

public class YesOrNoGUI {

        private boolean choice = false;

        /**
         * @wbp.parser.entryPoint
         */
        public boolean showYesNoMessage(String message) {

            JLabel label = new JLabel(message);

            JPanel content = new JPanel();
            content.setBorder(new EmptyBorder(5, 5, 10, 10));
            content.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            content.add(label);

            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            dialog.setResizable(false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setModal(true);
            dialog.setTitle("rUBERn - Group 3");
            
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
                                                dialog.getContentPane().add(buttons, BorderLayout.SOUTH);
                                                buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
                                                buttons.add(yesButton);
                                                buttons.add(noButton);
                                                dialog.getRootPane().setDefaultButton(yesButton);
            dialog.getContentPane().add(content);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
            return choice;
        }
    }


//}