package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.AlreadyRegisteredException;
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import logic.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class DriverRegisterGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField userName;
	private JTextField userCard;
	private Action action;
private Matrix theMatrix;
private JPasswordField userPassword;
private JPasswordField userPassword2;
private final Action action_1 = new Cancel();
private int carModel;
private JComboBox<String> carQuality;
private JTextField carModelName;
private JTextField carCapacity;
	/**
	 * Create the dialog.
	 */
	public DriverRegisterGUI(Matrix aMatrix) {
		setVisible(true);
		theMatrix = aMatrix;
		carModel = 0;
		setTitle("rUBERn - Group 3");
		setResizable(false);
		action = new AddAUser(theMatrix);
		setBounds(100, 100, 395, 660);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblRegister = new JLabel("Register:");
		lblRegister.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		
		JLabel label_1 = new JLabel("Credit card number: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userCard = new JTextField();
		userCard.setColumns(10);
		userCard.setDocument (new JTextFieldLimit(10));
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword = new JPasswordField();
		
		JLabel lblConfirmPassword = new JLabel("Confirm password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword2 = new JPasswordField();
		
		JLabel lblCarModel = new JLabel("Car category:");
		lblCarModel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarModel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		carQuality = new JComboBox<String>();
		carQuality.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carModel=carQuality.getSelectedIndex();
			}
		});
		if(theMatrix.getTagNames().length==0) {
			new Error("Please add some quality tags in order to register drivers");
			new DriverGUI(theMatrix);
			dispose();
		}
		carQuality.setModel(new DefaultComboBoxModel<String>(theMatrix.getTagNames()));
		
		carModelName = new JTextField();
		
		JLabel lblCarModel_1 = new JLabel("Car model:");
		lblCarModel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarModel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblCarCapacity = new JLabel("Car capacity:");
		lblCarCapacity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarCapacity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		carCapacity = new JTextField();
		carCapacity.setColumns(2);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(42)
					.addComponent(lblRegister))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(62)
					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(userName, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(label_1)
					.addGap(6)
					.addComponent(userCard, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(66)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblConfirmPassword)
					.addGap(4)
					.addComponent(userPassword2, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCarModel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(carModelName, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblCarCapacity, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(carCapacity, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(18)
					.addComponent(lblCarModel, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(carQuality, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(lblRegister)
					.addGap(19)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblUsername))
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(label_1))
						.addComponent(userCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConfirmPassword)
						.addComponent(userPassword2, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCarModel_1))
						.addComponent(carModelName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(15)
							.addComponent(lblCarCapacity))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(carCapacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblCarModel))
						.addComponent(carQuality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setAction(action);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setAction(action_1);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		pack();
	}
	private class AddAUser extends AbstractAction {
		Matrix theMatrix;
		public AddAUser(Matrix aMatrix) {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Add this user to the database");
			theMatrix = aMatrix;
		}
		public void actionPerformed(ActionEvent e) {
			try {
				String model = carModelName.getText().trim();
				String rawCapacity = carCapacity.getText().trim();
				if (rawCapacity.length() < 3 && rawCapacity.matches("[0-9]+")) {
					int capacity = Integer.parseInt(rawCapacity); 
				QualityTag qualitytag = theMatrix.getTag(theMatrix.getTagNames()[carModel]);
				Car aCar = new Car(model, capacity, qualitytag);
									
				Integer cardNumber=0;
				String card = userCard.getText().trim();
				String name = userName.getText().trim();
				String rawUserPassword=String.valueOf(userPassword.getPassword()).trim();
				String rawConfirmPassword=String.valueOf(userPassword2.getPassword()).trim();
				if (!(rawUserPassword.equals(rawConfirmPassword))){
					new Error("Passwords don't match");
				}else {
					String password = rawUserPassword;
				if (name.equals("")) {
					new Error("Name can't be empty");
				}else if (!name.matches("[a-zA-Z0-9_-]+")) {
					new Error("Please enter only valid characters");
				} else if(password.length()<5) {
					new Error("Password must be 5 characters long");
				} else if (card.length() < 11 && card.length() > 2 && card.matches("[0-9]+")) {
					cardNumber=	Integer.parseInt(card);
					Driver someone = new Driver(name, cardNumber, password, aCar);
					if (theMatrix.addDriver(someone)) {
						new DriverPostLogin(theMatrix, someone);
						dispose();
				}
				}else new Error("Invalid credit card number");
				}
			}else new Error("Please enter a valid capacity");
			}catch (ItemNotFoundException e1) {
				new Error(e1+" is not registered");
			} catch (AlreadyRegisteredException e1) {
				new Error(e1+" is already registered");
			} catch (EmptyFieldException e1) {
				new Error(e1+" can't be empty");
			}catch(Exception a) {
				new Error("Unknown error");

			} 
			}

		
	}
	private class Cancel extends AbstractAction {
		public Cancel() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "Return to previous screen");
		}
		public void actionPerformed(ActionEvent e) {
			new DriverGUI(theMatrix);
			dispose();
		}
	}
}
