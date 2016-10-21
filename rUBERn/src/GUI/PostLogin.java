package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logic.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class PostLogin extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Matrix theMatrix;
	private User theUser;
	private final Action updateLocation = new UpdateLocation();
	private final Action askForCar = new AskForCar();
	private final Action logOut = new LogOut();
	/**
	 * Create the dialog.
	 */
	public PostLogin(Matrix aMatrix, User aUser) {
		setTitle("rUBERn - Group 3");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		theMatrix = aMatrix;
		theUser = aUser;
		setBounds(100, 100, 387, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Welcome to rUBERn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnUpdateLocation = new JButton("Update location");
		btnUpdateLocation.setAction(updateLocation);
		
		JButton btnAskForCar = new JButton("Ask for car");
		btnAskForCar.setAction(askForCar);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setAction(logOut);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
					.addGap(161))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(btnUpdateLocation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAskForCar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogOut)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateLocation)
						.addComponent(btnLogOut)
						.addComponent(btnAskForCar))
					.addContainerGap(170, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	private class UpdateLocation extends AbstractAction {
		public UpdateLocation() {
			putValue(NAME, "Update location");
			putValue(SHORT_DESCRIPTION, "Update your location");
		}
		public void actionPerformed(ActionEvent e) {
			new UpdateUserLocationGUI(theMatrix, theUser);
			dispose();
		}
	}
	private class AskForCar extends AbstractAction {
		public AskForCar() {
			putValue(NAME, "Ask for car");
			putValue(SHORT_DESCRIPTION, "Ask for a car");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class LogOut extends AbstractAction {
		public LogOut() {
			putValue(NAME, "Log out");
			putValue(SHORT_DESCRIPTION, "Log out of the system");
		}
		public void actionPerformed(ActionEvent e) {
			new Main(theMatrix);
			dispose();
		}
	}
}
