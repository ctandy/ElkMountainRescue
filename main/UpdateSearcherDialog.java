package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;








import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class UpdateSearcherDialog extends JDialog{

	JTextArea speed, direction;
	JButton submit, cancel;
	Grid grid;
	Searcher searcher;

	public UpdateSearcherDialog(Searcher searcher, Grid grid){
		setModal(true);
		this.searcher = searcher;
		this.grid = grid;

		JLabel s, dir;
		s = new JLabel("Speed");
		dir = new JLabel("Direction (Deg)");

		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		submit.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		submit.setMaximumSize(new Dimension(40,40));
		cancel.setMaximumSize(new Dimension(40,40));

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		speed = new JTextArea();
		direction = new JTextArea();

		setTitle("Update Searcher");
		setSize(300, 200);


		JPanel attributes = new JPanel();
		attributes.setLayout(new GridLayout(0,1));
		attributes.setBorder(new TitledBorder(new EtchedBorder(), "Attributes"));

		attributes.add(s);
		attributes.add(speed);
		attributes.add(dir);
		attributes.add(direction);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		add(attributes, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 1;
		add(submit, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 1;
		add(cancel , c );


	}

	public void updateSearcher(){
		String speedStr = speed.getText();
		double speed = Double.parseDouble(speedStr);
		String dirStr = direction.getText();
		double dir = Double.parseDouble(dirStr);
		searcher.setSpeed(speed);
		searcher.setDirection(dir);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submit){
				updateSearcher();
				dispose();
			}
			else{
				grid.setWaitingForUpdate(false);
				dispose();
			}

		}

	}

}