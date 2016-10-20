package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import logic.ClientBase;
import logic.Matrix;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

public class MatrixGUI {
private Matrix theMatrix;
	private JFrame frame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SeeUsers();
	private final Action action_2 = new ChangeUserLocation();
	private final Action action_3 = new SwingAction_1();
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
		frame.setBounds(100, 100, 423, 206);
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblChooseAnAction)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnAddUser, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(seeUsers, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblBienvenidoARubern, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
							.addGap(20))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnUpdateUserLocation)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(22, Short.MAX_VALUE))))
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
					.addContainerGap(24, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
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
}
