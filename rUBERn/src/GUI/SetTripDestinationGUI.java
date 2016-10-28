package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import logic.*;
import GUI.Error;

public class SetTripDestinationGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField locationX;
	private JTextField locationY;
	private final Action action = new Ok();
	private Matrix theMatrix;
	private User theUser;
	private JTextField userName;
	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public SetTripDestinationGUI(Matrix aMatrix, User aUser) {
		theUser=aUser;
		theMatrix = aMatrix;
		setTitle("rUBERn - Grupo 3");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
		setBounds(100, 100, 285, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblUpdateUserLocation = new JLabel("Set destination location:");
		lblUpdateUserLocation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel newLocationX = new JLabel("Location X:");
		newLocationX.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel newLocationY = new JLabel("Location Y:");
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
					.addContainerGap(59, Short.MAX_VALUE))
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
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
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
			name = theUser.getName();
			if (name.equals("")) new Error("Name can't be empty");
			if (rawLocationX.equals("")) new Error("Location X field can't be empty");
			if (rawLocationY.equals("")) new Error("Location Y field can't be empty");
			if (rawLocationX.length() >0 && rawLocationY.length() > 0 && rawLocationX.length() < 11 && rawLocationX.matches("[0-9]+") && rawLocationY.length() < 11 && rawLocationY.matches("[0-9]+")) {
				rawLocationX="00"+rawLocationX;
				rawLocationY="00"+rawLocationY;
				aLocationX=	Long.parseLong(rawLocationX);
				aLocationY=	Long.parseLong(rawLocationY);
				long[] destination = {aLocationX, aLocationY};
				if (theMatrix.askForCar(theUser, destination)) {
					new PostLogin(theMatrix, theUser);
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