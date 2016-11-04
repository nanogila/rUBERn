package GUI;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.AlreadyRegisteredException;
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import logic.Matrix;
import logic.User;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;

public class ManageUserGUI extends JDialog {
	private Matrix theMatrix;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombreYApellido;
	private JTextField userName;
	private JTextField userCard;
	private JButton okButton;
	private JButton cancelButton;
	private final Action action = new Close();
	private Action action_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action_2 = new addUserRadioBtn();
	private final Action action_3 = new RemoveUserRadioBtn();
	private JRadioButton addUser;
	private JRadioButton removeUser;
	private JLabel lblPassword;
	private JPasswordField userPassword;


	/**
	 * Create the dialog.
	 */
	public ManageUserGUI(Matrix aMatrix) {
		setTitle("rUBERn - Grupo 3");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ManageUserGUI.class.getResource("/Uber-icon2.png")));
		theMatrix = aMatrix;
		action_1  = new AddAUser(theMatrix);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblNombreYApellido = new JLabel("Username: ");
			lblNombreYApellido.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		}
		JLabel lblCreditCardNumber = new JLabel("Credit card number: ");
		lblCreditCardNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userName = new JTextField();
		userName.setColumns(10);
		userCard = new JTextField();
		addUser = new JRadioButton("Add user");
		addUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				addUser.doClick();
			}
		});
		addUser.setAction(action_2);
		buttonGroup.add(addUser);
		addUser.setSelected(true);
		
		removeUser = new JRadioButton("Remove user");
		removeUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				removeUser.doClick();
			}
		});
		removeUser.setAction(action_3);
		buttonGroup.add(removeUser);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		userPassword = new JPasswordField();
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(lblNombreYApellido)
						.addComponent(lblCreditCardNumber))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(addUser)
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
							.addComponent(removeUser))
						.addComponent(userCard, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
						.addComponent(userName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
						.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(removeUser)
						.addComponent(addUser))
					.addGap(10)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombreYApellido)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditCardNumber)
						.addComponent(userCard, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(userPassword, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setAction(action_1);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setAction(action);
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addGap(5)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}setLocationRelativeTo(null);
		pack();
	}
	private class Close extends AbstractAction {
		public Close() {
			putValue(NAME, "Cancel");
			putValue(SHORT_DESCRIPTION, "exit without saving changes");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
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
				if(addUser.isSelected()) {
				Integer cardNumber=0;
				String card = userCard.getText().trim();
				String password = String.valueOf(userPassword.getPassword()).trim();
				String name = userName.getText().trim();
				if (name.equals("")) new Error("Name can't be empty");
				if (password.length()<5) new Error("Password must be 5 characters long");
				else if (card.length() < 11 && card.length() > 2 && card.matches("[0-9]+") && !(name.equals(""))) {
					cardNumber=	Integer.parseInt(card);
					User someone = new User(name, cardNumber, password);
					
					if (theMatrix.addUser(someone)) dispose();
				}else new Error("Invalid credit card number");
				}else if (removeUser.isSelected()) {
					String name = userName.getText().trim();
					theMatrix.getUser(name);
					User someone = theMatrix.getUser(name);
					if(theMatrix.removeUser(someone)) dispose(); 
					
					}
			}catch(NullPointerException a) {
				new Error("Name or credit card number are empty");

			} catch (EmptyFieldException e1) {
				new Error(e1+" is empty");
			} catch (AlreadyRegisteredException e1) {
				e1.printStackTrace();
			} catch (ItemNotFoundException e1) {
				new Error(e1+" is not registered");
			}
			}

		
	}
	private class addUserRadioBtn extends AbstractAction {
		public addUserRadioBtn() {
			putValue(NAME, "Add user");
			putValue(SHORT_DESCRIPTION, "Add user to the database");
		}
		public void actionPerformed(ActionEvent e) {
			userCard.setEnabled(true);
			userPassword.setEnabled(true);
		}
	}
	private class RemoveUserRadioBtn extends AbstractAction {
		public RemoveUserRadioBtn() {
			putValue(NAME, "Remove user");
			putValue(SHORT_DESCRIPTION, "Remove user from the database");
		}
		public void actionPerformed(ActionEvent e) {
			userCard.setEnabled(false);
			userPassword.setEnabled(false);
		}
	}
}