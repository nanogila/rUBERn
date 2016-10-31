package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import logic.Matrix;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class MatrixGUI {
private Matrix theMatrix;
	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SeeUsers();
	private final Action action_2 = new ChangeUserLocation();
	private final Action action_3 = new SwingAction_1();
	private final Action action_4 = new SwingAction_2();
	/**
	 * Create the application.
	 */
	public MatrixGUI(Matrix aMatrix) {
		initialize();
		theMatrix = aMatrix;
	}

	/*
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		//Main.setIconImage(Toolkit.getDefaultToolkit().getImage(MatrixGUI.class.getResource("/Uber-icon2.png")));
		frame.setResizable(false);
		frame.setTitle("rUBERn - Group 3");
		frame.setBounds(100, 100, 423, 242);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBienvenidoARubern = new JLabel("Welcome to rUBERn");
		lblBienvenidoARubern.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBienvenidoARubern.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAddUser = new JButton("Manage Users");
		btnAddUser.setAction(action);
		
		JLabel lblChooseAnAction = new JLabel("Choose an action:");
		lblChooseAnAction.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JButton seeUsers = new JButton("New button");
		seeUsers.setAction(action_1);
		
		JButton btnUpdateUserLocation = new JButton("Update user location");
		btnUpdateUserLocation.setAction(action_2);
		btnUpdateUserLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton button = new JButton("Return to main window");
		button.setAction(action_3);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setActionCommand("Cancel");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action_4);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblChooseAnAction)
								.addComponent(lblBienvenidoARubern, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnUpdateUserLocation, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addComponent(btnAddUser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
											.addGap(1))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(seeUsers, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))))
							.addGap(20))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton)
							.addContainerGap(318, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBienvenidoARubern)
					.addGap(28)
					.addComponent(lblChooseAnAction)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddUser)
						.addComponent(seeUsers, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdateUserLocation)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setLocationRelativeTo(null);
		frame.pack();
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Manage Users");
			putValue(SHORT_DESCRIPTION, "Add a user to the database");
		}
		public void actionPerformed(ActionEvent e) {
			new ManageUserGUI(theMatrix);
		}
	}
	private class SeeUsers extends AbstractAction {
		public SeeUsers() {
			putValue(NAME, "See registered users");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			theMatrix.seeUsers();
			theMatrix.seeDrivers();
		}
	}
	private class ChangeUserLocation extends AbstractAction {
		public ChangeUserLocation() {
			putValue(NAME, "Update user location");
			putValue(SHORT_DESCRIPTION, "The button is pretty explicit");
		}
		public void actionPerformed(ActionEvent e) {
			new UpdateUserLocationGUI(theMatrix);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Return to main window");
			putValue(SHORT_DESCRIPTION, "etc");
		}
		public void actionPerformed(ActionEvent e) {
			new Main(theMatrix);
			frame.dispose();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "See log file location");
			putValue(SHORT_DESCRIPTION, "See rUBERn's log file location");
		}
		public void actionPerformed(ActionEvent e) {
			new Error(theMatrix.getLogFileLocation());
		}
	}
}
