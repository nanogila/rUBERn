package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class UpdateUserLocationGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField locationX;
	private JTextField locationY;
	private final Action action = new Ok();
	private Matrix theMatrix;
	private User theUser;
	private JLabel lblUsername;
	private JTextField userName;
	boolean askingForTrip;
	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public UpdateUserLocationGUI(Matrix aMatrix, User aUser, Boolean trip) {
		askingForTrip = trip;
		theUser=aUser;
		theMatrix = aMatrix;
		setTitle("rUBERn - Grupo 3");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 368, 272);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		JLabel lblUpdateUserLocation = new JLabel("Update user location:");
		lblUpdateUserLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel newLocationX = new JLabel("New location X:");
		newLocationX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel newLocationY = new JLabel("New location Y:");
		newLocationY.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		locationX = new JTextField();
		locationX.setColumns(10);
		
		locationY = new JTextField();
		locationY.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblUpdateUserLocation))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(newLocationY)
							.addGap(18)
							.addComponent(locationY, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(newLocationX)
							.addGap(18)
							.addComponent(locationX, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblUpdateUserLocation)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(newLocationX)
						.addComponent(locationX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLocationY))
					.addGap(24))
		);
		
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (theUser!=null) new PostLogin(theMatrix, theUser);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}pack();
	}

	public UpdateUserLocationGUI(Matrix aMatrix) {
		theUser = null;
		theMatrix = aMatrix;
		setTitle("rUBERn - Grupo 3");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 321, 229);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		{
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		}
		{
			userName = new JTextField();
			userName.setColumns(10);
		}
		
		JLabel lblUpdateUserLocation = new JLabel("Update user location:");
		lblUpdateUserLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel newLocationX = new JLabel("New location X:");
		newLocationX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel newLocationY = new JLabel("New location Y:");
		newLocationY.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		locationX = new JTextField();
		locationX.setColumns(10);
		
		locationY = new JTextField();
		locationY.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblUpdateUserLocation))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(newLocationY)
							.addGap(18)
							.addComponent(locationY, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblUsername)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(newLocationX)
								.addGap(18)
								.addComponent(locationX, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))))
					.addGap(17))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblUpdateUserLocation)
					.addGap(7)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsername))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLocationX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(locationY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(newLocationY))
					.addGap(24))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (theUser!=null) new PostLogin(theMatrix, theUser);
						dispose();
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}pack();
		}		
	}
	private class Ok extends AbstractAction {
		public Ok() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Update location");
		}
		public void actionPerformed(ActionEvent e) {
			try {
			long aLocationX=0;
			long aLocationY=0;
			String rawLocationX = locationX.getText().trim();
			String rawLocationY = locationY.getText().trim();
			String name;
			if (theUser==null) { name = userName.getText().trim();}
			else {name = theUser.getName();}
			if (name.equals("")) new Error("Name can't be empty");
			if (rawLocationX.equals("")) new Error("Location X field can't be empty");
			if (rawLocationY.equals("")) new Error("Location Y field can't be empty");
			if (rawLocationX.length() >0 && rawLocationY.length() > 0 && rawLocationX.length() < 11 && rawLocationX.matches("[0-9]+") && rawLocationY.length() < 11 && rawLocationY.matches("[0-9]+")) {
				rawLocationX="00"+rawLocationX;
				rawLocationY="00"+rawLocationY;
				aLocationX=	Long.parseLong(rawLocationX);
				aLocationY=	Long.parseLong(rawLocationY);
				if (theMatrix.updateUserLocation(aLocationX, aLocationY, name)) {
					if (theUser!=null) {
						if (!askingForTrip)new PostLogin(theMatrix, theUser);
					}
					dispose();
				}
			}else {if(!rawLocationX.matches("[0-9]+")&&!rawLocationX.equals("")) new Error("Location X field can't contain letters");
			 if(!rawLocationY.matches("[0-9]+")&&!rawLocationY.equals("")) new Error("Location Y field can't contain letters");}
		}catch(NullPointerException a) {
			new Error("Unknown error");
		}
		}
		}
}
