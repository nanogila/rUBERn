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

public class DriverGUI extends JFrame {
	private final JPanel contentPanel = new JPanel();
	private JLabel lblChooseAnOption;
	private final Action action = new CancelAction();
	Matrix theMatrix;
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new Login();
	/**
	 * Create the dialog.
	 */
	public DriverGUI(Matrix aMatrix) {
		theMatrix = aMatrix;
		setVisible(true);
		setTitle("rUBERn - Group 3");
		setResizable(false);
		setBounds(100, 100, 230, 160);
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
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnRegister)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(257))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblChooseAnOption, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(273))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseAnOption)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnRegister))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setAction(action);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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
			new DriverRegisterGUI(theMatrix);
			dispose();
		}
	}
	private class Login extends AbstractAction {
		public Login() {
			putValue(NAME, "Log in");
			putValue(SHORT_DESCRIPTION, "Log in as user");
		}
		public void actionPerformed(ActionEvent e) {
			new DriverLoginGUI(theMatrix);
			dispose();
		}
	}
}
