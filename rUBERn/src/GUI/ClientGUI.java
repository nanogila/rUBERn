package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class ClientGUI extends JFrame {
	private final JPanel contentPanel = new JPanel();
	private JLabel lblChooseAnOption;
	private final Action action = new CancelAction();
	Matrix theMatrix;
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new Login();
	private JButton cancelButton;
	/**
	 * Create the dialog.
	 */
	public ClientGUI(Matrix aMatrix) {
		theMatrix = aMatrix;
		setVisible(true);
		setTitle("rUBERn - Group 3");
		setResizable(false);
		setBounds(100, 100, 202, 148);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblChooseAnOption = new JLabel("Choose an option:");
			lblChooseAnOption.setHorizontalAlignment(SwingConstants.CENTER);
			lblChooseAnOption.setFont(new Font("Times New Roman", Font.BOLD, 16));
		}
		JButton btnRegister = new JButton("Register");
		btnRegister.setAction(action_1);
		JButton btnLogin = new JButton("Login");
		btnLogin.setAction(action_2);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseAnOption, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnRegister)
							.addGap(10)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblChooseAnOption)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister)
						.addComponent(btnLogin)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setAction(action);
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addGap(51)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(48))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addComponent(cancelButton)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}setLocationRelativeTo(null);
		pack();
	}

	private class CancelAction extends AbstractAction {
		public CancelAction() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Return to home");
		}
		public void actionPerformed(ActionEvent e) {
			new Main(theMatrix);
			dispose();
			
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Register");
			putValue(SHORT_DESCRIPTION, "Register as new user");
		}
		public void actionPerformed(ActionEvent e) {
			new RegisterGUI(theMatrix);
			dispose();
		}
	}
	private class Login extends AbstractAction {
		public Login() {
			putValue(NAME, "Log in");
			putValue(SHORT_DESCRIPTION, "Log in as user");
		}
		public void actionPerformed(ActionEvent e) {
			new LoginGUI(theMatrix);
			dispose();
		}
	}
}
