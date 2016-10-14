package rUBERn;

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
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Toolkit;

public class MatrixGUI {
private Matrix theMatrix;
	private JFrame Main;
	private final Action action = new SwingAction();
	private final Action action_1 = new SeeUsers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ClientBase base=new ClientBase();
					Matrix theMatrix = new Matrix(base);
					MatrixGUI window = new MatrixGUI(theMatrix);
					window.Main.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MatrixGUI(Matrix aMatrix) {
		initialize();
		theMatrix = aMatrix;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Main = new JFrame();
		Main.setIconImage(Toolkit.getDefaultToolkit().getImage(MatrixGUI.class.getResource("/Uber-icon2.png")));
		Main.setResizable(false);
		Main.setTitle("rUBERn - Grupo 3");
		Main.setBounds(100, 100, 360, 179);
		Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBienvenidoARubern = new JLabel("Welcome to rUBERn");
		lblBienvenidoARubern.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblBienvenidoARubern.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnAddUser = new JButton("Manage Users");
		btnAddUser.setAction(action);
		
		JLabel lblChooseAnAction = new JLabel("Choose an action:");
		lblChooseAnAction.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton seeUsers = new JButton("New button");
		seeUsers.setAction(action_1);
		GroupLayout groupLayout = new GroupLayout(Main.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChooseAnAction)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddUser, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(seeUsers, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblBienvenidoARubern, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
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
					.addContainerGap(34, Short.MAX_VALUE))
		);
		Main.getContentPane().setLayout(groupLayout);
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
}
