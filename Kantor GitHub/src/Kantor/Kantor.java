package Kantor;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Kantor {
	
	private JFrame frame;
	private JPanel panel;
	private JTextField textfield;
	private JComboBox<String[]> combobox;
	private JRadioButton radiobutton1;
	private JRadioButton radiobutton2;
	private JRadioButton radiobutton3;
	private ButtonGroup group;
	private JButton button;
	private JLabel label;
	
	public void makeKantor() {
		
		frame = new JFrame("Kantor");
		panel = new JPanel();
		textfield = new JTextField("Podaj kwote");
			
		String[] list = new String[5];
		list[0] = "PLN";
		list[1] = "EUR";
		list[2] = "GBP";
		list[3] = "USD";
		list[4] = "CHF";
		
		combobox = new JComboBox(list);
		
		group = new ButtonGroup();
		radiobutton1 = new JRadioButton("EUR");
		radiobutton2 = new JRadioButton("USD");
		radiobutton3 = new JRadioButton("GBP");
		
		
		group.add(radiobutton1);
		group.add(radiobutton2);
		group.add(radiobutton3);
		
		button = new JButton("Przelicz");
		label = new JLabel("Wynik: xxx");
		
		frame.add(panel);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel.add(textfield);		
		panel.add(combobox);	
		
		panel.add(radiobutton1);
		panel.add(radiobutton2);
		panel.add(radiobutton3);
		
		panel.add(button);
		button.addActionListener(new ButtonListener());
		panel.add(label);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 300);
		frame.setVisible(true);
		
		
	}
	

	public static void main(String[] args) {
	
		Kantor k = new Kantor();
		k.makeKantor();
		
	}
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event1) {
			double money = Double.parseDouble(textfield.getText());
			String currency1 = combobox.getSelectedItem().toString();
			if(currency1.equals("PLN")) {
				money = money * 0.23;
			}
			else if(currency1.equals("EUR")) {				
			}
			else if(currency1.equals("GBP")) {
				money = money * 1.12;
			}
			else if(currency1.equals("USD")) {
				money = money * 0.87;
			}
			else if(currency1.equals("CHF")) {
				money = money * 0.89;
			}
			
			String currency2 = " ";
			if(radiobutton1.isSelected()) {
				currency2 = "EUR";		
			// 	
			}
			else if(radiobutton2.isSelected()) {
				currency2 = "USD";
				money = money * 1.15;	
			}
			else if(radiobutton3.isSelected()) {
				currency2 = "GPD";
				money = money * 0.89;
			}
			
			label.setText("Wynik :" + " " + String.format("%.2f", money) + " " + currency2);
			
		}
		
	}

}
