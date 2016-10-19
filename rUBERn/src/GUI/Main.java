package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import logic.ClientBase;
import logic.Matrix;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Main {

	private JFrame frmRubern;
	private Matrix theMatrix;
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
					Main window = new Main(theMatrix);
					window.frmRubern.setVisible(true);
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
		frmRubern.setTitle("rUBERn - Group 3");
		frmRubern.setBounds(100, 100, 231, 160);
		frmRubern.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Welcome to rUBERn");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblEnterRubernAs = new JLabel("Enter rUBERn as:");
		lblEnterRubernAs.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton btnClient = new JButton("Client");
		
		JButton btnDriver = new JButton("Driver");
		
		JButton btnAdmin = new JButton("Admin");
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
}
