import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//Program that calculates triangles from angles and sides
public class Interface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// A lot of this code is just setting up the frame.
	private JPanel contentPane;
	private JTextField[] textFields = new JTextField[6];
	private static int count = 0;
	private static double[] sides = new double[3], angles = new double[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAngle = new JLabel("Side A:");
		lblAngle.setBounds(10, 83, 46, 14);
		contentPane.add(lblAngle);
		
		textFields[0] = new JTextField();
		textFields[0].setBounds(57, 83, 86, 20);
		textFields[0].setColumns(10);
		contentPane.add(textFields[0]);
		
		JLabel lblSide = new JLabel("Side B:");
		lblSide.setBounds(10, 111, 46, 14);
		contentPane.add(lblSide);
		
		textFields[1] = new JTextField();
		textFields[1].setColumns(10);
		textFields[1].setBounds(57, 111, 86, 20);
		contentPane.add(textFields[1]);
		
		JLabel lblSide_1 = new JLabel("Side C:");
		lblSide_1.setBounds(10, 139, 46, 14);
		contentPane.add(lblSide_1);
		
		textFields[2] = new JTextField();
		textFields[2].setColumns(10);
		textFields[2].setBounds(57, 139, 86, 20);
		contentPane.add(textFields[2]);
		
		JLabel label_4 = new JLabel("Angle a:");
		label_4.setBounds(165, 83, 46, 14);
		contentPane.add(label_4);
		
		textFields[3] = new JTextField();
		textFields[3].setColumns(10);
		textFields[3].setBounds(215, 83, 86, 20);
		contentPane.add(textFields[3]);
		
		JLabel lblAngle_2 = new JLabel("Angle b:");
		lblAngle_2.setBounds(165, 111, 46, 14);
		contentPane.add(lblAngle_2);
		
		textFields[4] = new JTextField();
		textFields[4].setColumns(10);
		textFields[4].setBounds(215, 111, 86, 20);
		contentPane.add(textFields[4]);
		
		JLabel lblAngle_1 = new JLabel("Angle c:");
		lblAngle_1.setBounds(165, 139, 46, 14);
		contentPane.add(lblAngle_1);
		
		textFields[5] = new JTextField();
		textFields[5].setColumns(10);
		textFields[5].setBounds(215, 139, 86, 20);
		contentPane.add(textFields[5]);
		
		JLabel Instruction = new JLabel("<html>Enter two sides and an angle or one side and an angle of your triangle. <br>You can leave unknown data as 0 or blank. </html>\r\n");
		Instruction.setBounds(10, 11, 296, 51);
		contentPane.add(Instruction);
		
		JButton btnNewButton = new JButton("Enter your data");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			
			///////////////////////////////////PROGRAM STARTS HERE
			
			DecimalFormat d0 = new DecimalFormat( "#.00" );
			@Override
			public void mouseClicked(MouseEvent arg0) {//mouse clicked
				
				System.out.println("Got Values!"); //reading what was inputted
				for (int i = 0; i<3; i++){
					if (textFields[i].getText().equals("") || textFields[i].getText().equals(null)){
						textFields[i].setText("0");
					}
					sides[i] = Math.abs(Integer.parseInt(textFields[i].getText()));
					System.out.println("Side "+i+": "+sides[i]);
				}
				for (int i = 0; i < 3; i++){
					if (textFields[i+3].getText().equals("") || textFields[i+3].getText().equals(null)){
						textFields[i+3].setText("0");
					}
					angles[i] = Math.abs(Integer.parseInt(textFields[i+3].getText()));
					System.out.println("Angle "+(i)+": "+angles[i]);
				}
			
			int missingAngles = 0, missingSides = 0; 

			for (int i = 0; i < Jaime.findZeros(angles).length; i++){  //tallies what is missing
				if ((Jaime.findZeros(angles)[i])){
					System.out.println("Missing data for angle #"+i);
					missingAngles++;
					
				}
				if((Jaime.findZeros(sides)[i])){
					System.out.println("Missing data for side #"+i);
					missingSides++;
				}
			}
			
			boolean pass = false;
			
			if ((missingAngles <= 1 && missingSides <= 2)||(missingSides <= 1 && missingAngles <= 2)){ //Determines if the input were logical
				JOptionPane.showMessageDialog(null, "Valid input!");
				pass = true;
			}else{
				JOptionPane.showMessageDialog(null, "Invalid input!");
				pass = false;
			}
			
			//TODO implement pass

			boolean[] masterSetEmpty = new boolean[6];
			double[] masterSet = {sides[0],angles[0],sides[1],angles[1],sides[2],angles[2]};
			
			
			for (int i = 0; i < masterSet.length; i++){
				if (masterSet[i] == 0){
					masterSetEmpty[i] = false;
				}else{
					masterSetEmpty[i] = true;
				}
			}
			
			
			int count = 0;
			
			do{
				
				boolean A = masterSetEmpty[0], a = masterSetEmpty[1], B = masterSetEmpty[2], b = masterSetEmpty[3], C = masterSetEmpty[4], c = masterSetEmpty[5];		
				//just incase
				
				double totAngle = 180;
				double[] angles = {masterSet[1],masterSet[3],masterSet[5]};
				
				if (missingAngles == 1){
					for (int i = 0; i<angles.length; i++){
						totAngle=totAngle-angles[i];
						System.out.println(totAngle);
					}
					
					for (int i = 0; i<angles.length; i++){
						if ((angles[i] == 0)){ 
							angles[i] = totAngle;
							System.out.println("set angle "+(i+1)+" to "+totAngle);
						}
					}
					
				}
				missingAngles = 0;
				for (int i = 0; i < Jaime.findZeros(angles).length; i++){  //tallies what is missing
					if ((Jaime.findZeros(angles)[i])){
						missingAngles++;
					}
				}
				
				masterSet[1] = angles[0];
				masterSet[3] = angles[1];
				masterSet[5] = angles[2];
				
				if ((missingAngles <= 1) && (missingSides == 1)){ //Scenario: 1 angle, at least two sides
					if (masterSet[0] == 0)
					{
						masterSet[0] = newIsaiah.A(masterSet);
					}
					if (masterSet[2] == 0)
					{
						masterSet[2] = newIsaiah.B(masterSet);
					}
					if (masterSet[4] == 0)
					{
						masterSet[4] = newIsaiah.C(masterSet);
					}
					
				} 
				
				if ((A && a && B) || (A && a && b) || (A && B && b) || (a && B && b)){// SinA/a = Sin B/b
					masterSet = Abhishek.AaBb(masterSet);
				}
				if ((A && a && C) || (A && a && c) || (A && C && c) || (a && C && c)){// Sin A/a = Sin C/c
					masterSet = Abhishek.AaCc(masterSet);
				}
				if ((B && b && C) || (B && b && c) || (C && c && b) || (C && c && B)){ //Sine B/b = Sine C/c
					masterSet = Abhishek.BbCc(masterSet);
				}
				
				for (int i = 0; i < masterSet.length; i++){
					if (masterSet[i] == 0){
						masterSetEmpty[i] = false;
					}else{
						masterSetEmpty[i] = true;
					}
				}
				
				if (count > 25){
					System.out.println("Got stuck! Spitting out info so far!");
					break;
				}
				
			
			} while (!Jaime.areAllPresent(masterSet));
			

//			angles[0] = masterSet[1];
//			angles[1] = masterSet[3];
//			angles[2] = masterSet[5];

			if (Isaiah.k(masterSet) == 1){ //Equilateral
				masterSet[1] = 60;
				masterSet[3] = 60;
				masterSet[5] = 60;
			}

					System.out.println("Side A: "+masterSet[0]+
							"\nAngle a: "+masterSet[1]+
							"\nSide B: "+masterSet[2]+
							"\nAngle b: "+masterSet[3]+
							"\nSide C: "+masterSet[4]+
							"\nSide c: "+masterSet[5]);
					System.out.println("This triangle is "+Isaiah.TRIangle[Isaiah.k(masterSet)]+".");
					System.out.println("This triangle is "+Isaiah.TriANGLE[Isaiah.i(masterSet)]+".");
					

		}});
		
		btnNewButton.setBounds(8, 183, 298, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel((new ImageIcon(getClass().getResource("/images/triangle.png"))));
		label.setBounds(316, 36, 183, 136);
		contentPane.add(label);
	}	
}


