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
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class DriverPostLogin extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Matrix theMatrix;
	private Driver theDriver;
	private final Action updateLocation = new UpdateLocation();
	private final Action goOnline;
	private final Action logOut = new LogOut();
	private final Action action = new SwingAction();
	/**
	 * Create the dialog.
	 */
	public DriverPostLogin(Matrix aMatrix, Driver aDriver) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(DriverPostLogin.class.getResource("/Uber-icon2.png")));
		setTitle("rUBERn - Group 3");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		theMatrix = aMatrix;
		theDriver = aDriver;
		goOnline = new GoOnline(aDriver);
		setBounds(100, 100, 404, 177);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("Welcome to rUBERn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnUpdateLocation = new JButton("Update location");
		btnUpdateLocation.setAction(updateLocation);
		
		JButton btnGoOnline = new JButton("Go online");
		btnGoOnline.setAction(goOnline);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setAction(logOut);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(btnUpdateLocation)
					.addGap(18)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGoOnline, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(label)
					.addGap(35)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnUpdateLocation)
						.addComponent(btnNewButton))
					.addGap(9)
					.addComponent(btnGoOnline, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogOut))
		);
		contentPanel.setLayout(gl_contentPanel);
		setLocationRelativeTo(null);
		pack();
	}
	private class UpdateLocation extends AbstractAction {
		public UpdateLocation() {
			putValue(NAME, "Update location");
			putValue(SHORT_DESCRIPTION, "Update your location");
		}
		public void actionPerformed(ActionEvent e) {
			new UpdateDriverLocationGUI(theMatrix, theDriver);
			dispose();
		}
	}
	private class GoOnline extends AbstractAction {
		private Driver someDriver;
		public GoOnline(Driver aDriver) {
			someDriver = aDriver;
			switch(someDriver.getStatus()) {
			case "ONLINE": putValue(NAME, "End shift");
			putValue(SHORT_DESCRIPTION, "End shift");
			break;
			case "OFFLINE": putValue(NAME, "Start shift");
			putValue(SHORT_DESCRIPTION, "Start shift");
			break;
			default: putValue(NAME, "Unavailabe");
			putValue(SHORT_DESCRIPTION, "can't do nothing because you are unavailable");
			break;
			}			
		}
		public void actionPerformed(ActionEvent e) {
			switch(someDriver.getStatus()) {
			case "ONLINE": if (someDriver.goOffline()) {
				putValue(NAME, "Start shift");
				putValue(SHORT_DESCRIPTION, "Start shift");
				new Error("You are no longer working, have a nice day");
			}
			break;
			case "OFFLINE": if (someDriver.goOnline()) {
				putValue(NAME, "End shift");
				putValue(SHORT_DESCRIPTION, "End shift");
				new Error("You are now working");
			}
			break;
			default:
			break;
			}	
			}
	}
	private class LogOut extends AbstractAction {
		public LogOut() {
			putValue(NAME, "Return to main screen");
			putValue(SHORT_DESCRIPTION, "return to main screen without logging out");
		}
		public void actionPerformed(ActionEvent e) {
			new Main(theMatrix);
			dispose();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Add money");
			putValue(SHORT_DESCRIPTION, "Adds money to your wallet");
		}
		public void actionPerformed(ActionEvent e) {
			new AddMoneyDriverGUI(theMatrix, theDriver);
			dispose();
		}
	}
}
