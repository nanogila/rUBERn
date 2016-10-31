package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Error;
import logic.*;
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
import javax.swing.SwingConstants;

public class LoginGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Matrix theMatrix;
	private JTextField userName;
	private final Action action = new Close();
	private JPasswordField userPassword;
	private final Action action_1 = new SwingAction();
	/**
	 * Create the dialog.
	 */
	public LoginGUI(Matrix aMatrix) {
		setResizable(false);
		setTitle("rUBERn - Group 3");
		theMatrix = aMatrix;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 331, 171);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblLogIn = new JLabel("Log in:");
		lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLogIn)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(userPassword)
								.addComponent(userName, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogIn))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setAction(action_1);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setAction(action);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}setLocationRelativeTo(null);
		pack();
	}
	private class Close extends AbstractAction {
		public Close() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "exit without saving changes");
		}
		public void actionPerformed(ActionEvent e) {
			new ClientGUI(theMatrix);
			dispose();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Attempt to log in");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				String name = userName.getText().trim();
				String password=String.valueOf(userPassword.getPassword()).trim();
				if (name.equals("")) new Error("Name can't be empty");
				else if(password.length()<5) {
					new Error("Password must be 5 characters long");
				}
				else if (theMatrix.checkPassword(name, password)) {
					User someone = theMatrix.getUser(name);
						new PostLogin(theMatrix, someone);
						dispose();
				}else new Error("Invalid username or password");
					
			}catch(NullPointerException a) {
				new Error("Unknown error");

			}
		}
	}
}
