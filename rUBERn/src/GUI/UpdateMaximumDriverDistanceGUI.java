package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import logic.Matrix;
import GUI.Error;
import javax.swing.LayoutStyle.ComponentPlacement;
public class UpdateMaximumDriverDistanceGUI extends JFrame {
	private Matrix theMatrix;
		private JPanel contentPane;
		private JTextField distanceAmount;
		private final Action action = new SwingAction();
		private final Action action_1 = new SwingAction_1();
	public UpdateMaximumDriverDistanceGUI(Matrix aMatrix) {
			setResizable(false);

			theMatrix = aMatrix;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 270, 204);
			setVisible(true);
			
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 10, 10));
			setContentPane(contentPane);
			//pack();
			JLabel lblAddSomeMoney = new JLabel("Update maximum driver distance");
			lblAddSomeMoney.setFont(new Font("Times New Roman", Font.BOLD, 16));
			
			JLabel lblAmountToAdd = new JLabel("New maximum distance:");
			lblAmountToAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			
			distanceAmount = new JTextField();
			distanceAmount.setColumns(10);
			distanceAmount.setDocument (new JTextFieldLimit(18));
			JButton btnAdd = new JButton("Add");
			btnAdd.setAction(action);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.setAction(action_1);
			
			JLabel lblForWhenA = new JLabel("for when a user asks for a trip");
			lblForWhenA.setFont(new Font("Times New Roman", Font.BOLD, 16));
			
			JLabel lblCurrentMaximumDistance = new JLabel("Current maximum distance is: "+theMatrix.getMaximumDriverDistance());
			lblCurrentMaximumDistance.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblForWhenA, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblAddSomeMoney, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblAmountToAdd)
										.addGap(4)
										.addComponent(distanceAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(111)
										.addComponent(btnAdd)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnCancel))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblCurrentMaximumDistance, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
						.addContainerGap())
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(11)
						.addComponent(lblAddSomeMoney)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblForWhenA)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblCurrentMaximumDistance, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblAmountToAdd)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(1)
								.addComponent(distanceAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel)
							.addComponent(btnAdd))
						.addContainerGap())
			);
			contentPane.setLayout(gl_contentPane);
			setLocationRelativeTo(null);
			pack();
		}
		private class SwingAction extends AbstractAction {
			public SwingAction() {
				putValue(NAME, "Add");
				putValue(SHORT_DESCRIPTION, "Change the maximum distance when looking for drivers");
			}
			public void actionPerformed(ActionEvent e) {
				try {
				Long distance;
				String rawDistance = "00"+distanceAmount.getText().trim();
				if (rawDistance.length() < 21 && rawDistance.length() > 0 && rawDistance.matches("[0-9]+")) {
					distance =	Long.parseLong(rawDistance);
					if (distance > 0) {
						theMatrix.changeMaximumDriverDistance(distance);
							new MatrixGUI(theMatrix);
							dispose();
						}
					}
					else new Error ("Invalid distance");
				}catch(NullPointerException ouch) {
					new Error("Unknown error");
				}
				}
		}
		private class SwingAction_1 extends AbstractAction {
			public SwingAction_1() {
				putValue(NAME, "Cancel");
				putValue(SHORT_DESCRIPTION, "Quit without doing nothing");
			}
			public void actionPerformed(ActionEvent e) {
					new MatrixGUI(theMatrix);
					dispose();
				}
			}
}
