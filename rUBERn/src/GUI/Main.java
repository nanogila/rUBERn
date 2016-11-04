package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import logic.ClientBase;
import logic.DriverBase;
import logic.Matrix;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	private JFrame frmRubern;
	private Matrix theMatrix;
	private final Action action = new SwingAction();
	private final Action action_1 = new ShowClientGUI();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			    	DriverBase baseDeChoferes = new DriverBase();
			        ClientBase basededatos = new ClientBase();
			        Matrix theMatrix = new Matrix(basededatos, baseDeChoferes);
			        new Main(theMatrix);
			        boolean loadDefaultTags = new YesOrNoGUI().showYesNoMessage("Do you wish to load the default quality tags?");
			        if (loadDefaultTags) theMatrix.addDefaultTags();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main(Matrix aMatrix) {
		initialize();
		theMatrix = aMatrix;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRubern = new JFrame();
		frmRubern.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/Uber-icon2.png")));
		frmRubern.setResizable(false);
		frmRubern.setTitle("rUBERn - Group 3");
		frmRubern.setBounds(100, 100, 299, 160);
		frmRubern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRubern.setVisible(true);
		frmRubern.setLocationRelativeTo(null);
		JLabel label = new JLabel("Welcome to rUBERn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblEnterRubernAs = new JLabel("Enter rUBERn as:");
		lblEnterRubernAs.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton btnClient = new JButton("Client");
		btnClient.setAction(action_1);
		
		JButton btnDriver = new JButton("Driver");
		btnDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DriverGUI(theMatrix);
				frmRubern.dispose();
			}
		});
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.setAction(action);
		GroupLayout groupLayout = new GroupLayout(frmRubern.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblEnterRubernAs, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
							.addGap(0))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnClient, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnDriver, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdmin, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
							.addGap(10))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGap(1)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(lblEnterRubernAs)
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClient)
						.addComponent(btnDriver)
						.addComponent(btnAdmin))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		frmRubern.getContentPane().setLayout(groupLayout);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Admin");
			putValue(SHORT_DESCRIPTION, "Enter rUBERn as admin");
		}
		public void actionPerformed(ActionEvent e) {
			new MatrixGUI(theMatrix);
			frmRubern.dispose();
		}
	}
	private class ShowClientGUI extends AbstractAction {
		public ShowClientGUI() {
			putValue(NAME, "Client");
			putValue(SHORT_DESCRIPTION, "Enter rUBERn as a client");
		}
		public void actionPerformed(ActionEvent e) {
			new ClientGUI(theMatrix);
			frmRubern.dispose();
		}
	}
}
