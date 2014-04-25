package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class manualUpdater implements MouseListener {
	private JDialog cancelOption;
	private JButton cancelButton;
	private boolean waitforUpdate;
	
	manualUpdater(Rescue r){
		cancelOption = new JDialog(r,
				"Would you like to cancel the manual update?");
		cancelButton = new JButton("Cancel");
		cancelOption.add(cancelButton);
		cancelOption.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	class buttonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent b) {
			if(b.getSource() == cancelButton){
				
			}
			
		}
		
	}

}
