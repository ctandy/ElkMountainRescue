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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class NewSearcherDialog extends JDialog{

	JCheckBox dog, hiker, helicopter;
	JTextArea speed, direction, name;
	JButton submit, cancel;
	Grid grid;
	Cell cell;
	boolean finished;

	public NewSearcherDialog(Cell cell, Grid grid){
		setModal(true);
		this.cell = cell;
		this.grid = grid;

		JLabel n, s, dir;
		n = new JLabel("Name");
		s = new JLabel("Speed(0-10)");
		dir = new JLabel("Direction (Deg)");

		submit = new JButton("Submit");
		cancel = new JButton("Cancel");
		submit.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		submit.setMaximumSize(new Dimension(40,40));
		cancel.setMaximumSize(new Dimension(40,40));

		//creates searcher type options to add to the panel
		dog = new JCheckBox("Dog");
		hiker = new JCheckBox("Hiker");
		helicopter = new JCheckBox("Helicopter");

		ButtonGroup searchType = new ButtonGroup();
		searchType.add(dog);
		searchType.add(hiker);
		searchType.add(helicopter);

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		dog.addActionListener(new CheckBoxListener());
		hiker.addActionListener(new CheckBoxListener());
		helicopter.addActionListener(new CheckBoxListener());

		speed = new JTextArea();
		direction = new JTextArea();
		name = new JTextArea();


		setTitle("Add New Searcher");
		setSize(300, 200);

		JPanel sType = new JPanel();
		sType.setLayout(new GridLayout(0,1));
		sType.setBorder(new TitledBorder(new EtchedBorder(), "Searcher Type"));
		hiker.setSelected(true);
		sType.add(hiker);
		sType.add(dog);		
		sType.add(helicopter);
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		add(sType, c);

		JPanel attributes = new JPanel();
		attributes.setLayout(new GridLayout(0,1));
		attributes.setBorder(new TitledBorder(new EtchedBorder(), "Attributes"));

		attributes.add(n);
		attributes.add(name);
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
	// adds the searcher when all attributes are filled
	public void addSearcher(){

		String sName = name.getText();
		Searcher searcher;
		finished = true;
		if(dog.isSelected()){

			searcher = new Dog(sName, cell);
			grid.addSearcher(searcher);
		}else {
			String speedStr = speed.getText();
			String dirStr = direction.getText();
			double speedD, dirD;
			
			try{
				speedD = Double.parseDouble(speedStr);
				if (speedD > 10)
					speedD = 10;
				else if (speedD < 0)
					speedD = 0;
				dirD = Double.parseDouble(dirStr);
				if(hiker.isSelected()){
					searcher = new Hiker(sName, cell, speedD, dirD);
				}else{
					searcher = new Helicopter(sName, cell, speedD, dirD);
				}
				grid.addSearcher(searcher);
				finished = true;
				
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "Check format for speed and direction!",
						"Wrong Number Format", JOptionPane.ERROR_MESSAGE);
				finished = false;
			}	
			
		}
		
		if(finished)
			dispose();
	}


	class CheckBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//if searcher is a dog the user is unable to edit speed and direction
			if(e.getSource() == dog){
				speed.setEnabled(false);
				direction.setEnabled(false);
			}
			else{
				speed.setEnabled(true);
				direction.setEnabled(true);
			}

		}

	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submit){
				addSearcher();
			}
			else{
				grid.setWaitingForPlacement(false);
				dispose();
			}

		}

	}

}

