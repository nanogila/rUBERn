package logic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.Dialog.ModalityType;

public class Error extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;
	private JLabel lblErrorMessage;
	private final Action ok = new OkButton();
	/**
	 * Create the dialog.
	 */
	public Error(String errMessage) {
		setResizable(false);
		setBounds(100, 100, 264, 204);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblErrorMessage = new JLabel(errMessage);
			lblErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
			lblErrorMessage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblErrorMessage, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setAction(ok);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addGap(56)
						.addComponent(okButton, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addGap(51))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(okButton)
						.addContainerGap())
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
	class OkButton extends AbstractAction {
		public OkButton() {
			putValue(NAME, "Ok");
			putValue(SHORT_DESCRIPTION, "Close this dialog");
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

}
