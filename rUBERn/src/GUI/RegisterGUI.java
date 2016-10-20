package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.Matrix;
import logic.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;

public class RegisterGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField userName;
	private JTextField userCard;
	private Action action;
private Matrix theMatrix;
private JPasswordField userPassword;
private JPasswordField passwordField_1;
private JPasswordField userPassword2;

	/**
	 * Create the dialog.
	 */
	public RegisterGUI(Matrix aMatrix) {
		setVisible(true);
		theMatrix = aMatrix;
		setTitle("rUBERn - Group 3");
		setResizable(false);
		action = new AddAUser(theMatrix);
		setBounds(100, 100, 403, 227);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		JLabel label_1 = new JLabel("Credit card number: ");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userCard = new JTextField();
		
		JLabel label_2 = new JLabel("Password: ");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword = new JPasswordField();
		
		JLabel label_3 = new JLabel("Password: ");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		passwordField_1 = new JPasswordField();
		
		JLabel lblConfirmPassword = new JLabel("Confirm password: ");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword2 = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(userName, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblConfirmPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(label_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(userCard, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
									.addComponent(userPassword))
								.addComponent(userPassword2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblRegister))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblRegister)
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(userCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPassword2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(112)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(82)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(81)
							.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setAction(action);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
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
				Integer cardNumber=0;
				String card = userCard.getText().trim();
				String name = userName.getText().trim();
				String rawUserPassword=String.valueOf(userPassword.getPassword()).trim();
				String rawConfirmPassword=String.valueOf(userPassword2.getPassword()).trim();
				if (!(rawUserPassword.equals(rawConfirmPassword))){
					new Error("Passwords don't match");
				}else {
					String password = rawUserPassword;
				if (name.equals("")) new Error("Name can't be empty");
				else if(password.length()<5) {
					new Error("Password must be 5 characters long");
				}
				else if (card.length() < 11 && card.length() > 2 && card.matches("[0-9]+")) {
					cardNumber=	Integer.parseInt(card);
					User someone = new User(name, cardNumber, password);
					//theMatrix.addUser(someone);
					if (theMatrix.addUser(someone)) {
						new PostLogin(theMatrix, someone);
						dispose();
					}
				}else new Error("Invalid credit card number");
				}	
			}catch(NullPointerException a) {
				new Error("Name or credit card number are empty");

			}
			}

		
	}
}
