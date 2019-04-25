
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class Proj5Main extends JFrame implements ActionListener, ChangeListener
{
	private JLabel enterHammingDistLabel;
	private JTextField showDistField;
	private JSlider hammingDistSlider;
	private JButton showStationButton;
	private JTextArea stationTextArea;
	private JScrollPane stationScrollPane;
	private JLabel compareWithLabel;
	private JComboBox<String> compareWithJComboBox;
	private JButton calculateHDButton;
	private JLabel dist0Label;
	private JTextField dist0TextField;
	private JLabel dist1Label;
	private JTextField dist1TextField;
	private JLabel dist2Label;
	private JTextField dist2TextField;
	private JLabel dist3Label;
	private JTextField dist3TextField;
	private JLabel dist4Label;
	private JTextField dist4TextField;
	private JButton addStationButton;
	private JTextField addStationTextField;
	
	private String[] stations;
	
	public Proj5Main()
	{
		setLayout(new GridBagLayout());
		
		enterHammingDistLabel = new JLabel("Enter Hamming Dist:");
		GridBagConstraints enterGBC = new GridBagConstraints();
		enterGBC.insets = new Insets(10, 10, 5, 10);
		enterGBC.gridx = 0;
		enterGBC.gridy = 0;
		add(enterHammingDistLabel, enterGBC);
		
		showDistField = new JTextField(5);
		showDistField.setEditable(false);
		showDistField.setText("2");
		GridBagConstraints showDistGBC = new GridBagConstraints();
		showDistGBC.insets = new Insets(10, 10, 5, 10);
		showDistGBC.gridx = 1;
		showDistGBC.gridy = 0;
		add(showDistField, showDistGBC);
		
		hammingDistSlider = new JSlider(1, 4, 2);
		hammingDistSlider.addChangeListener(this);
		hammingDistSlider.setMajorTickSpacing(1);
		hammingDistSlider.setMinorTickSpacing(1);
		hammingDistSlider.setPaintTicks(true);
		hammingDistSlider.setPaintLabels(true);
		GridBagConstraints hammingDistSliderGBC = new GridBagConstraints();
		hammingDistSliderGBC.insets = new Insets(0, 10, 0, 10);
		hammingDistSliderGBC.gridx = 0;
		hammingDistSliderGBC.gridy = 1;
		hammingDistSliderGBC.fill = GridBagConstraints.HORIZONTAL;
		hammingDistSliderGBC.gridwidth = 2;
		add(hammingDistSlider, hammingDistSliderGBC);
		
		showStationButton = new JButton("Show Station");
		showStationButton.addActionListener(this);
		GridBagConstraints showStationButtonGBC = new GridBagConstraints();
		showStationButtonGBC.insets = new Insets(10, 10, 10, 10);
		showStationButtonGBC.gridx = 0;
		showStationButtonGBC.gridy = 2;
		showStationButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		showStationButtonGBC.gridwidth = 2;
		add(showStationButton, showStationButtonGBC);
		
		
		stationTextArea = new JTextArea(15, 20);
		stationTextArea.setEditable(false);
		stationScrollPane = new JScrollPane(this.stationTextArea);
		GridBagConstraints stationScrollPaneGBC  = new GridBagConstraints();
		stationScrollPaneGBC.insets = new Insets(10, 10, 10, 10);
		stationScrollPaneGBC.gridx = 0;
		stationScrollPaneGBC.gridy = 3;
		stationScrollPaneGBC.fill = GridBagConstraints.HORIZONTAL;
		stationScrollPaneGBC.gridwidth = 2;
		this.add(stationScrollPane, stationScrollPaneGBC);
		
		compareWithLabel = new JLabel("Compare with:");
		GridBagConstraints compareWithLabelGBC  = new GridBagConstraints();
		compareWithLabelGBC.insets = new Insets(10, 10, 10, 10);
		compareWithLabelGBC.gridx = 0;
		compareWithLabelGBC.gridy = 4;
		compareWithLabelGBC.fill = GridBagConstraints.HORIZONTAL;
		this.add(compareWithLabel, compareWithLabelGBC);
		
		stations = read();
		compareWithJComboBox = new JComboBox<String>(stations);
		compareWithJComboBox.setSelectedIndex(0);
		GridBagConstraints compareJComboBoxGBC  = new GridBagConstraints();
		compareJComboBoxGBC.insets = new Insets(10, 10, 10, 10);
		compareJComboBoxGBC.gridx = 1;
		compareJComboBoxGBC.gridy = 4;
		compareJComboBoxGBC.fill = GridBagConstraints.HORIZONTAL;
		this.add(compareWithJComboBox, compareJComboBoxGBC);
		
		calculateHDButton = new JButton("Calculate HD");
		calculateHDButton.addActionListener(this);
		GridBagConstraints calculateHDButtonGBC = new GridBagConstraints();
		calculateHDButtonGBC.insets = new Insets(10, 10, 10, 10);
		calculateHDButtonGBC.gridx = 0;
		calculateHDButtonGBC.gridy = 5;
		calculateHDButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		calculateHDButtonGBC.gridwidth = 2;
		add(calculateHDButton, calculateHDButtonGBC);
		
		
		
		dist0Label = new JLabel("Distance 0");
		GridBagConstraints dist0LabelGBC = new GridBagConstraints();
		dist0LabelGBC.insets = new Insets(10, 10, 5, 10);
		dist0LabelGBC.gridx = 0;
		dist0LabelGBC.gridy = 6;
		add(dist0Label, dist0LabelGBC);
		
		dist0TextField = new JTextField(10);
		dist0TextField.setEditable(false);
		GridBagConstraints dist0TextFieldGBC = new GridBagConstraints();
		dist0TextFieldGBC.insets = new Insets(10, 10, 5, 10);
		dist0TextFieldGBC.gridx = 1;
		dist0TextFieldGBC.gridy = 6;
		add(dist0TextField, dist0TextFieldGBC);
		
		
		
		dist1Label = new JLabel("Distance 1");
		GridBagConstraints dist1LabelGBC = new GridBagConstraints();
		dist1LabelGBC.insets = new Insets(10, 10, 5, 10);
		dist1LabelGBC.gridx = 0;
		dist1LabelGBC.gridy = 7;
		add(dist1Label, dist1LabelGBC);
		
		dist1TextField = new JTextField(10);
		dist1TextField.setEditable(false);
		GridBagConstraints dist1TextFieldGBC = new GridBagConstraints();
		dist1TextFieldGBC.insets = new Insets(10, 10, 5, 10);
		dist1TextFieldGBC.gridx = 1;
		dist1TextFieldGBC.gridy = 7;
		add(dist1TextField, dist1TextFieldGBC);
		
		
		
		dist2Label = new JLabel("Distance 2");
		GridBagConstraints dist2LabelGBC = new GridBagConstraints();
		dist2LabelGBC.insets = new Insets(10, 10, 5, 10);
		dist2LabelGBC.gridx = 0;
		dist2LabelGBC.gridy = 8;
		add(dist2Label, dist2LabelGBC);
		
		dist2TextField = new JTextField(10);
		dist2TextField.setEditable(false);
		GridBagConstraints dist2TextFieldGBC = new GridBagConstraints();
		dist2TextFieldGBC.insets = new Insets(10, 10, 5, 10);
		dist2TextFieldGBC.gridx = 1;
		dist2TextFieldGBC.gridy = 8;
		add(dist2TextField, dist2TextFieldGBC);
		
		
		
		dist3Label = new JLabel("Distance 3");
		GridBagConstraints dist3LabelGBC = new GridBagConstraints();
		dist3LabelGBC.insets = new Insets(10, 10, 5, 10);
		dist3LabelGBC.gridx = 0;
		dist3LabelGBC.gridy = 9;
		add(dist3Label, dist3LabelGBC);
		
		dist3TextField = new JTextField(10);
		dist3TextField.setEditable(false);
		GridBagConstraints dist3TextFieldGBC = new GridBagConstraints();
		dist3TextFieldGBC.insets = new Insets(10, 10, 5, 10);
		dist3TextFieldGBC.gridx = 1;
		dist3TextFieldGBC.gridy = 9;
		add(dist3TextField, dist3TextFieldGBC);
		
		
		
		dist4Label = new JLabel("Distance 4");
		GridBagConstraints dist4LabelGBC = new GridBagConstraints();
		dist4LabelGBC.insets = new Insets(10, 10, 5, 10);
		dist4LabelGBC.gridx = 0;
		dist4LabelGBC.gridy = 10;
		add(dist4Label, dist4LabelGBC);
		
		dist4TextField = new JTextField(10);
		dist4TextField.setEditable(false);
		GridBagConstraints dist4TextFieldGBC = new GridBagConstraints();
		dist4TextFieldGBC.insets = new Insets(10, 10, 5, 10);
		dist4TextFieldGBC.gridx = 1;
		dist4TextFieldGBC.gridy = 10;
		add(dist4TextField, dist4TextFieldGBC);
		
		addStationButton = new JButton("Add Station");
		addStationButton.addActionListener(this);
		GridBagConstraints addStationButtonGBC = new GridBagConstraints();
		addStationButtonGBC.insets = new Insets(10, 10, 10, 10);
		addStationButtonGBC.gridx = 0;
		addStationButtonGBC.gridy = 11;
		addStationButtonGBC.fill = GridBagConstraints.HORIZONTAL;
		addStationButtonGBC.gridwidth = 1;
		add(addStationButton, addStationButtonGBC);
		
		addStationTextField = new JTextField(10);
		addStationTextField.setText("ZERO");
		addStationTextField.setEditable(true);
		GridBagConstraints addStationTextFieldGBC = new GridBagConstraints();
		addStationTextFieldGBC.insets = new Insets(10, 10, 5, 10);
		addStationTextFieldGBC.gridx = 1;
		addStationTextFieldGBC.gridy = 11;
		add(addStationTextField, addStationTextFieldGBC);
	}


	@Override
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == showStationButton)
		{
			stationTextArea.setText("");
			
			for(String s : stations)
			{
				if(calculateInputDistance(s, (String)compareWithJComboBox.getSelectedItem()) == hammingDistSlider.getValue())
				{
					stationTextArea.append(s + "\n");
				}
			}
			
		}
		else if(event.getSource() == calculateHDButton)
		{
			System.out.println("Event recieved");
			
			int[] distArray = {0, 0, 0, 0, 0};
			
			for(String s: stations)
			{
				distArray[calculateInputDistance(s, (String)compareWithJComboBox.getSelectedItem())]++;
			}
			
			dist0TextField.setText(Integer.toString(distArray[0]));
			dist1TextField.setText(Integer.toString(distArray[1]));
			dist2TextField.setText(Integer.toString(distArray[2]));
			dist3TextField.setText(Integer.toString(distArray[3]));
			dist4TextField.setText(Integer.toString(distArray[4]));
		}
		else if(event.getSource() == addStationButton)
		{
			boolean duplicate = false;
			
			for(String s: stations)
			{
				if(addStationTextField.getText().equals(s))
				{
					System.out.println("Duplicate station encountered");
					duplicate = true;
					break;
				}
			}
			
			if(!duplicate)
			{
				String[] newStations = new String[stations.length + 1];
				
				//Copy over the existing stations
				for(int i = 0; i < stations.length; i++)
				{
					newStations[i] = stations[i];
				}
				
				//Add the new station
				newStations[stations.length] = addStationTextField.getText();
				
				stations = newStations;
				
				compareWithJComboBox.addItem(addStationTextField.getText());
			}
		}
	}
	
	//This method finds the hamming distances for the two inputs
	public int calculateInputDistance(String s1, String s2)
	{
		int inputDistance = 0;
		
		//Iterate through s1's character
		for(int i = 0; i < s1.length(); i++)
		{
			//Compare to s2's character
			if(s1.charAt(i) != s2.charAt(i))
			{
				//If different, increment the distance
				inputDistance++;
			}
		}
		
		return inputDistance;
	}
	
	@Override
	public void stateChanged(ChangeEvent event)
	{
		if(event.getSource() == hammingDistSlider)
		{
			showDistField.setText(Integer.toString(hammingDistSlider.getValue()));
		}
	}
	
	private String[] read()
	{
		try
		{
			// Use a buffered Reader on the file:
			BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
			String strg;
			String[] big = new String[200];
			int i = 0;
			
			//Reads the lines of the file until there aren't any lines left
			while((strg = br.readLine()) != null) 
			{
				big[i] = strg;
				i++;
			}
			
			
			//Trim the empty parts of the array (Java is horrible)
			String[] small = new String[i];
			for(int j = 0; j < i; j++)
			{
				small[j] = big[j];
			}
	    
			br.close();
			return small;
		}
		catch(IOException e)
		{
			System.out.println("Exception in read method");
			System.exit(1);
			return null;
		}
	}
	
	
	public static void main(String[] args) 
	{
		Proj5Main frm = new Proj5Main();
		frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frm.pack();
		frm.setVisible(true);
	}
}
