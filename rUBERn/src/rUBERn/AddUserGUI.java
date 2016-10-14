package rUBERn;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.text.*;

import javax.swing.Action;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class AddUserGUI extends JDialog {
	private Matrix theMatrix;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombreYApellido;
	private JTextField userName;
	private JTextField userCard;
	private JButton okButton;
	private JButton cancelButton;
	private final Action action = new Close();
	private Action action_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action_2 = new addUserRadioBtn();
	private final Action action_3 = new RemoveUserRadioBtn();
	private JRadioButton addUser;
	private JRadioButton removeUser;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			AddUserGUI dialog = new AddUserGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public AddUserGUI(Matrix aMatrix) {
		theMatrix = aMatrix;
		action_1  = new AddAUser(theMatrix);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 328, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNombreYApellido = new JLabel("First and last name: ");
			lblNombreYApellido.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		}
		JLabel lblCreditCardNumber = new JLabel("Credit card number: ");
		lblCreditCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		userCard = new JTextField();
		
		
		addUser = new JRadioButton("Add user");
		addUser.setAction(action_2);
		buttonGroup.add(addUser);
		addUser.setSelected(true);
		
		removeUser = new JRadioButton("Remove user");
		removeUser.setAction(action_3);
		buttonGroup.add(removeUser);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNombreYApellido)
						.addComponent(lblCreditCardNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(addUser)
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addComponent(removeUser))
						.addComponent(userCard, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
						.addComponent(userName, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(removeUser)
						.addComponent(addUser))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreYApellido)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditCardNumber)
						.addComponent(userCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setAction(action_1);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setAction(action);
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addGap(5)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	private class Close extends AbstractAction {
		public Close() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "exit without saving changes");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
	private class AddAUser extends AbstractAction {
		Matrix theMatrix;
		public AddAUser(Matrix aMatrix) {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Add this user to the database");
			theMatrix = aMatrix;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				if(addUser.isSelected()) {
				Integer cardNumber=0;
				String card = userCard.getText().trim();
				String name = userName.getText().trim();
				if (name.equals("")) new NullPointerException();
				if (card.length() < 11 && card.length() > 2 && card.matches("[0-9]+")) {
					
					cardNumber=	Integer.parseInt(card);
					User someone = new User(name, cardNumber);
					//theMatrix.addUser(someone);
					if (theMatrix.addUser(someone)) dispose();
				}else new Error("Invalid credit card number");
				}else if (removeUser.isSelected()) {
					String name = userName.getText().trim();
					if (name.equals("")) new NullPointerException();
					if (theMatrix.getUser(name)!=null) {
					User someone = theMatrix.getUser(name);
					if(theMatrix.removeUser(someone)) dispose(); 
					
				}
					}
			}catch(NullPointerException a) {
				new Error("Name or credit card number are empty");

			}
			}

		
	}
	private class addUserRadioBtn extends AbstractAction {
		public addUserRadioBtn() {
			putValue(NAME, "Add user");
			putValue(SHORT_DESCRIPTION, "Add user to the database");
		}
		public void actionPerformed(ActionEvent e) {
			userCard.setEnabled(true);
		}
	}
	private class RemoveUserRadioBtn extends AbstractAction {
		public RemoveUserRadioBtn() {
			putValue(NAME, "Remove user");
			putValue(SHORT_DESCRIPTION, "Remove user from the database");
		}
		public void actionPerformed(ActionEvent e) {
			userCard.setEnabled(false);
		}
	}
}