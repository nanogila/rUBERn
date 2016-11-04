package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logic.*;
import GUI.Error;
import exceptions.ItemNotFoundException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class ManageQualityTagsGUI extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Matrix theMatrix;
	private boolean newTag;
	private final Action action = new SwingAction();
	private JCheckBox boxNewTag;
	private JComboBox<String> qualityTag;
	public ManageQualityTagsGUI(Matrix aMatrix) {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(ManageQualityTagsGUI.class.getResource("/Uber-icon2.png")));
		theMatrix = aMatrix;
		newTag = false;
		setBounds(100, 100, 450, 300);
		setVisible(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 10, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		if(theMatrix.getTagNames().length==0) {
			new ChangeQualityTagGUI(theMatrix, null);
			dispose();
		}else {
		qualityTag = new JComboBox<String>();
		qualityTag.setModel(new DefaultComboBoxModel<String>(theMatrix.getTagNames()));
		qualityTag.setSelectedIndex(0);
		
		JLabel lblSelectAQuality = new JLabel("Select a quality tag:");
		lblSelectAQuality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectAQuality.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		boxNewTag = new JCheckBox("Create a new one");
		boxNewTag.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(boxNewTag.isSelected()) {
					qualityTag.setEnabled(false);
				newTag = true;
				}
				else {
					newTag = false;
					qualityTag.setEnabled(true);
				}
			}
		});
		
		JLabel lblModifyQualityTags = new JLabel("Modify quality tags:");
		lblModifyQualityTags.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblModifyQualityTags))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSelectAQuality)
					.addGap(4)
					.addComponent(qualityTag, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(123)
					.addComponent(boxNewTag))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblModifyQualityTags)
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblSelectAQuality))
						.addComponent(qualityTag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(7)
					.addComponent(boxNewTag))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnDisplayExistingOnes = new JButton("Display existing ones");
			btnDisplayExistingOnes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theMatrix.seeTags();
				}
			});
			buttonPane.add(btnDisplayExistingOnes);
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
					public void actionPerformed(ActionEvent arg0) {
						new MatrixGUI(theMatrix);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setLocationRelativeTo(null);
		pack();
	}}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(boxNewTag.isSelected()) {
				new ChangeQualityTagGUI(theMatrix, null);
			}else {
				try {
					new ChangeQualityTagGUI(theMatrix, theMatrix.getTag(theMatrix.getTagNames()[qualityTag.getSelectedIndex()]));
				} catch (ItemNotFoundException e1) {
					new Error(e1+" is not registered");
				}
			}dispose();
		}
	}
}
