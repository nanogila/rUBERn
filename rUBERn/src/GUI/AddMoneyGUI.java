package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class AddMoneyGUI extends JFrame {
private User theUser;
private Matrix theMatrix;
	private JPanel contentPane;
	private JTextField moneyAmount;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	/**
	 * Create the frame.
	 */
	public AddMoneyGUI(Matrix aMatrix, User aUser) {
		setResizable(false);
		theUser = aUser;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 204);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//pack();
		JLabel lblAddSomeMoney = new JLabel("Add some money to your wallet");
		lblAddSomeMoney.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblAmountToAdd = new JLabel("Amount to add:");
		lblAmountToAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		moneyAmount = new JTextField();
		moneyAmount.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setAction(action);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddSomeMoney)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnAdd)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancel))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblAmountToAdd)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(moneyAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddSomeMoney)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmountToAdd)
						.addComponent(moneyAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnAdd))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add money");
		}
		public void actionPerformed(ActionEvent e) {
			
			Double money = 0.0;
			String rawMoney = moneyAmount.getText().trim();
			if (rawMoney.length() < 11 && rawMoney.length() > 0 && rawMoney.matches("[0-9]+")) {
				money =	Double.parseDouble(rawMoney);
				if (money > 0) {
					try {
					theMatrix.addMoney(theUser, money);
					}catch(NullPointerException ouch) {
						new Error("Unknown error");
					}
						new PostLogin(theMatrix, theUser);
						dispose();
				}
				else new Error ("Invalid money amount");
		}else new Error ("Invalid money amount");

			}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Quit without doing nothing");
		}
		public void actionPerformed(ActionEvent e) {
				new PostLogin(theMatrix, theUser);
				dispose();

		}
	}
}
