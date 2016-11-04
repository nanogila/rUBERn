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
import exceptions.EmptyFieldException;
import exceptions.ItemNotFoundException;
import exceptions.NotEnoughMoneyException;

import javax.swing.SwingConstants;

public class SetTripDestinationGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField locationX;
	private JTextField locationY;
	private final Action action = new Ok();
	private Matrix theMatrix;
	private User theUser;
	private JTextField userName;
	private JTextField people;
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
		setBounds(100, 100, 285, 239);
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
		
		JLabel lblPeople = new JLabel("People:");
		lblPeople.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeople.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		people = new JTextField();
		people.setColumns(10);
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
							.addComponent(locationX, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPeople, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(people, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeople, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(people, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
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
						new PostLogin(theMatrix, theUser);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}setLocationRelativeTo(null);
		pack();
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
			int somePeople=0;
			String rawLocationX = locationX.getText().trim();
			String rawLocationY = locationY.getText().trim();
			String rawPeople = people.getText().trim();
			String name;
			name = theUser.getName();
			if (rawLocationX.equals("")) new Error("Location X field can't be empty");
			if (rawLocationY.equals("")) new Error("Location Y field can't be empty");
			if (rawPeople.equals("")) new Error("Location Y field can't be empty");
			if (rawPeople.length() >0 && rawLocationX.length() >0 && rawLocationY.length() > 0 && rawLocationX.length() < 11 && rawPeople.length() < 11 && rawPeople.matches("[0-9]+") && rawLocationX.matches("[0-9]+") && rawLocationY.length() < 11 && rawLocationY.matches("[0-9]+")) {
				rawLocationX="00"+rawLocationX;
				rawLocationY="00"+rawLocationY;
				somePeople=Integer.parseInt(rawPeople);
				aLocationX=	Long.parseLong(rawLocationX);
				aLocationY=	Long.parseLong(rawLocationY);
				long[] destination = {aLocationX, aLocationY};
				if (theMatrix.askForCar(theUser, destination, somePeople)) {
					new PostLogin(theMatrix, theUser);
					dispose();
				}
			}else {if(!rawLocationX.matches("[0-9]+")&&!rawLocationX.equals("")) new Error("Location X field can't contain letters");
			 if(!rawLocationY.matches("[0-9]+")&&!rawLocationY.equals("")) new Error("Location Y field can't contain letters");}
		}catch (NotEnoughMoneyException e1) {
new Error ("Not enough money");
		} catch (ItemNotFoundException e1) {
			new Error(e1+" is not registered");
			e1.printStackTrace();
		} catch (EmptyFieldException e1) {
			new Error(e1+" can't be empty");
		}catch(Exception a) {
			new Error("Unknown error");
		} 
		}
		}
}