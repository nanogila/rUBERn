package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Error;
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import logic.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class DriverLoginGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Matrix theMatrix;
	private JTextField driverName;
	private final Action action = new Close();
	private JPasswordField driverPassword;
	private final Action action_1 = new SwingAction();
	/**
	 * Create the dialog.
	 */
	public DriverLoginGUI(Matrix aMatrix) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(DriverLoginGUI.class.getResource("/Uber-icon2.png")));
		setResizable(false);
		setTitle("rUBERn - Group 3");
		theMatrix = aMatrix;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 337, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblLogIn = new JLabel("Log in:");
		lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblDrivername = new JLabel("Drivername:");
		lblDrivername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDrivername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		driverName = new JTextField();
		driverName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		driverPassword = new JPasswordField();
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblLogIn))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(45)
					.addComponent(lblDrivername, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(driverName, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(driverPassword, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblLogIn)
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDrivername, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(driverName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(driverPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
			new DriverGUI(theMatrix);
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
				String name = driverName.getText().trim();
				String password=String.valueOf(driverPassword.getPassword()).trim();
				if (name.equals("")) new Error("Name can't be empty");
				else if(password.length()<5) {
					new Error("Password must be 5 characters long");
				}
				else if (theMatrix.checkDriverPassword(name, password)) {
					Driver someone = theMatrix.getDriver(name);
						new DriverPostLogin(theMatrix, someone);
						dispose();
				}else new Error("Invalid driver name or password");
					
			}catch (EmptyFieldException e1) {
				new Error(e1+" can't be empty");
				e1.printStackTrace();
			} catch (ItemNotFoundException e1) {
				new Error(e1+"is not registered");
				e1.printStackTrace();
			}catch(Exception a) {
				new Error("Unknown error");

			} 
		}
	}
}
