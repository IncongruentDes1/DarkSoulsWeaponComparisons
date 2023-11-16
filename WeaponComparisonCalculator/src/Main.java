import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

    
	public static void main(String[] args) {
		ArrayList<weapons> weaponList = getWeaponList();
		String[] weaponNames = StringFormatter(weaponList);
		createInterface(weaponNames, weaponList);
		

	}
	
	
	
	
	public static ArrayList<weapons> getWeaponList(){
		     ArrayList<weapons> wl = new ArrayList<weapons>();
		     
		     try {
					File newFile = new File("weapons.txt");

				    		
					Scanner scanner = new Scanner(newFile );
					
					String firstLine = scanner.nextLine();

					while (scanner.hasNextLine()) {
						String curLine = scanner.nextLine();
						String[] split = curLine.split(":");
						weapons newWeapon = new weapons(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]),Integer.parseInt(split[5]),Integer.parseInt(split[6]),Integer.parseInt(split[7]),Integer.parseInt(split[8]),
								Integer.parseInt(split[9]),Integer.parseInt(split[10]),Integer.parseInt(split[11]),Integer.parseInt(split[12]));
						wl.add(newWeapon);

					}

					scanner.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}

		     return wl;
		
	}
	
	public static String[] StringFormatter(ArrayList<weapons> wl) {
		String[] weapons = new String[140];
		
		for (int x = 0; x < wl.size(); x++) {
			weapons[x] = wl.get(x).weaponName;
		}
		
		return weapons;

	}
	
	public static  void createInterface(String[] weaponList, ArrayList<weapons> wl) {
		     JFrame frame = new JFrame("Weaponerinos");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 500);
	        frame.setLocation(430, 100);

	        JPanel panel = new JPanel();

	        GridLayout layoutManager = new GridLayout(1, 2);
	        panel.setLayout(layoutManager);

	        frame.add(panel);

	        final JComboBox<String> cb = new JComboBox<>(weaponList);
	        final JComboBox<String> cb2 = new JComboBox<>(weaponList);
	        
	        // - work for sorting choices
	        String[] choices = {"Total Damage" , "Physical Damage" , "Magical Damage", "Fire Damage", "Lightning Damage", "Durability"};
	        
	        final JComboBox<String> cb3 = new JComboBox<>(choices);

	        cb.setMaximumSize(cb.getPreferredSize());
	        cb2.setMaximumSize(cb2.getPreferredSize());
	        cb3.setMaximumSize(cb3.getPreferredSize());
	        

	        panel.add(cb);
	        panel.add(cb2);
	        panel.add(cb3);

	        JLabel labelone = new JLabel();
	        JLabel labeltwo = new JLabel();

	        panel.add(labelone);
	        panel.add(labeltwo);

	        JButton btn = new JButton("OK");
	        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
	        panel.add(btn);

	        // Add an ActionListener to the "OK" button
	        btn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Get the selected indices from the JComboBox components
	                int selectedWeapon1Index = cb.getSelectedIndex();
	                int selectedWeapon2Index = cb2.getSelectedIndex();

	                // Get the comparison results for the selected weapons
	                String weaponOneVal = wl.get(selectedWeapon1Index).weaponComparisonStats();
	                String weaponTwoVal = wl.get(selectedWeapon2Index).weaponComparisonStats();

	                // Set the labels to display the results
	                labelone.setText(weaponOneVal);
	                labeltwo.setText(weaponTwoVal);
	                
	                frame.pack();
	                
	                // - big if statement to determine search criteria
	                Integer typeOfSearch = cb3.getSelectedIndex();
	                
	                Integer valOne = 0;
	                Integer valTwo = 0;
	                
	                if (typeOfSearch == 0) {
	                	valOne = wl.get(selectedWeapon1Index).totDamage;
	                	valTwo =  wl.get(selectedWeapon2Index).totDamage;
	                }
	                else if (typeOfSearch == 1) {
	                	valOne = wl.get(selectedWeapon1Index).physDamage;
	                	valTwo =  wl.get(selectedWeapon2Index).physDamage;
	                }
	                else if (typeOfSearch == 2) {
	                	valOne = wl.get(selectedWeapon1Index).magDamage;
	                	valTwo =  wl.get(selectedWeapon2Index).magDamage;
	                }
	                else if (typeOfSearch == 3) {
	                	valOne = wl.get(selectedWeapon1Index).fireDamage;
	                	valTwo =  wl.get(selectedWeapon2Index).fireDamage;
	                }
	                else if (typeOfSearch == 4) {
	                	valOne = wl.get(selectedWeapon1Index).lightningDamage;
	                	valTwo =  wl.get(selectedWeapon2Index).lightningDamage;
	                }
	                else if (typeOfSearch == 5) {
	                	valOne = wl.get(selectedWeapon1Index).durability;
	                	valTwo =  wl.get(selectedWeapon2Index).durability;
	                }
	                
	                if (valOne> valTwo) {
	                	labelone.setForeground(Color.RED);
	                	labeltwo.setForeground(Color.BLACK);
	                }
	                else if (valTwo > valOne) {
	                	labelone.setForeground(Color.BLACK);
	                	labeltwo.setForeground(Color.RED);              	
	                }
	                else {
	                	labelone.setForeground(Color.GRAY);
	                	labeltwo.setForeground(Color.GRAY);       
	                }
	                
	                
	            }
	        });

	        frame.pack();
	        frame.setVisible(true);
	    }
	}


