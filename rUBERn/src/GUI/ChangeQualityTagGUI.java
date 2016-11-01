package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;
import GUI.Error;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ChangeQualityTagGUI {

	private final JPanel contentPanel = new JPanel();
private Matrix theMatrix;
private QualityTag tag;
private JTextField tagName;
private JTextField tagValue;
private JFrame frame;
private final Action action = new SwingAction();
	public ChangeQualityTagGUI(Matrix aMatrix, QualityTag aTag) {
		theMatrix = aMatrix;
		tag = aTag;
		frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setTitle("rUBERn - Group 3");

		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		tagName = new JTextField();
		tagName.setColumns(10);

		tagValue = new JTextField();
		tagValue.setColumns(2);
		tagValue.setDocument (new JTextFieldLimit(2));
		JLabel lblUpdateUalityTag;
		if(aTag!=null) lblUpdateUalityTag = new JLabel("Update quality tag "+aTag.getTag());
		else lblUpdateUalityTag = new JLabel("Create a quality tag");
		lblUpdateUalityTag.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateUalityTag.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblNewName = new JLabel("New name:");
		lblNewName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNewValue = new JLabel("New value:");
		lblNewValue.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		JLabel lblleaveUnchangedFields;
		if(aTag!=null) lblleaveUnchangedFields = new JLabel("(leave unchanged fields empty)");
		else lblleaveUnchangedFields = new JLabel("");
		lblleaveUnchangedFields.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblUpdateUalityTag, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblleaveUnchangedFields))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewName)
					.addGap(10)
					.addComponent(tagName, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewValue)
					.addGap(10)
					.addComponent(tagValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblUpdateUalityTag)
					.addGap(9)
					.addComponent(lblleaveUnchangedFields)
					.addGap(6)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewName))
						.addComponent(tagName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewValue))
						.addComponent(tagValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBorder(new EmptyBorder(5, 5, 10, 5));
			frame.getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setAction(action);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				frame.getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new ManageQualityTagsGUI(theMatrix);
						frame.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Update the quality tag");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				String rawName = tagName.getText().trim()+"";
				String rawValue = tagValue.getText().trim()+"";
				int value = 0;
				boolean ok = true;
				if(tag!=null) {
					if (rawValue.length() < 3 && rawValue.matches("[0-9]+")) {
						value = Integer.parseInt(rawValue);
						if(!rawName.equals("")) {
							if(!theMatrix.setTagName(tag.getTag(), rawName)) ok=false;	
						}
						if (value!=0) {
							if(!theMatrix.setTagValue(tag.getTag(), value)) ok=false;
						}
						if (ok) {
							new ManageQualityTagsGUI(theMatrix);
							frame.dispose();
						}
					}else new Error("Please enter a valid value");
					
				}else {
					if(!rawName.equals("")) {
						if(rawValue.length() < 3 && rawValue.matches("[0-9]+")) {
							value = Integer.parseInt(rawValue);
							if (value<11 && value>0) {
						theMatrix.addTag(new QualityTag(rawName, value));
						new ManageQualityTagsGUI(theMatrix);
						frame.dispose();
						}else new Error("Rating must be between 1 and 10");
					}else new Error("Please enter a valid value");
					}else new Error("Name can't be empty");
					
				}
			}
			catch(NullPointerException ouch){
				new Error("Unknown error");
			}
				
			}
		}
}
