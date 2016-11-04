package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
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
		theMatrix = aMatrix;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 270, 204);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 20, 20));
		setContentPane(contentPane);
		JLabel lblAddSomeMoney = new JLabel("Add some money to your wallet");
		lblAddSomeMoney.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblAmountToAdd = new JLabel("Amount to add:");
		lblAmountToAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		moneyAmount = new JTextField();
		moneyAmount.setColumns(10);
		moneyAmount.setDocument (new JTextFieldLimit(7));
		JButton btnAdd = new JButton("Add");
		btnAdd.setAction(action);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setAction(action_1);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblAddSomeMoney)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblAmountToAdd)
					.addGap(4)
					.addComponent(moneyAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addComponent(btnAdd)
					.addGap(6)
					.addComponent(btnCancel))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAddSomeMoney)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAmountToAdd)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(moneyAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd)
						.addComponent(btnCancel)))
		);
		contentPane.setLayout(gl_contentPane);
		setLocationRelativeTo(null);
		pack();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add");
			putValue(SHORT_DESCRIPTION, "Add money");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			Double money = 0.0;
			String rawMoney = moneyAmount.getText().trim();
			if (rawMoney.length() < 11 && rawMoney.length() > 0 && rawMoney.matches("[0-9]+")) {
				money =	Double.parseDouble(rawMoney);
				if (money > 0) {
					
					theMatrix.addMoney(theUser, money);
					
						new PostLogin(theMatrix, theUser);
						new Error (theUser.getName()+" now has $"+theUser.getBalance()+" in his bank account");
						dispose();
				}
				else new Error ("Invalid money amount");
		}else new Error ("Invalid money amount");
			}catch (EmptyFieldException e1) {
				new Error(e1+" can't be empty");
				e1.printStackTrace();
			} catch (ItemNotFoundException e1) {
				new Error(e1+" is not registered");
			}
			catch(Exception ouch) {
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
				new PostLogin(theMatrix, theUser);
				dispose();

		}
	}
}
