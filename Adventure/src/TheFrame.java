import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class TheFrame extends JFrame {

	private JPanel contentPane;
	public JButton btnAtk, btnDef, btnPar, btnEsc;
	public JLabel labelSpeech = new JLabel("Speech:");
	private JLabel ItemImage;
	private JProgressBar PlayerMana;
	private JLabel EnemyImage;
	private JProgressBar EnemyHealth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheFrame frame = new TheFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TheFrame() {
		String folder = "src//Sprites//";
		setBackground(new Color(51, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 405);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 51, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 134, 11));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAtk = new JButton("Attack");
		btnAtk.setToolTipText("Test\r\n");
		btnAtk.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		btnDef = new JButton("Defend");
		btnDef.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		btnPar = new JButton("Parry");
		btnPar.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		btnEsc = new JButton("Escape");
		btnEsc.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		
		
		panel.add(btnAtk);
		panel.add(btnDef);
		panel.add(btnPar);
		panel.add(btnEsc);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(184, 134, 11));
		contentPane.add(panel_1, BorderLayout.NORTH);
		labelSpeech.setFont(new Font("AR JULIAN", Font.PLAIN, 20));
		
		panel_1.add(labelSpeech);
		
		JPanel FightMode = new JPanel();
		FightMode.setBackground(SystemColor.desktop);
		FightMode.setSize(new Dimension(1, 1));
		contentPane.add(FightMode, BorderLayout.CENTER);
		FightMode.setLayout(null);
		
		String name = "Wizard";
		JLabel PlayerImage = new JLabel("");
		PlayerImage.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new LineBorder(new Color(0, 0, 0))));
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(folder+name+".png").getImage().getScaledInstance(60, 60, Image.SCALE_REPLICATE));
		
		ItemImage = new JLabel("");
		ItemImage.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new LineBorder(new Color(0, 0, 0))));
		ItemImage.setOpaque(true);
		ItemImage.setForeground(Color.BLACK);
		ItemImage.setBackground(new Color(255, 255, 255));
		ItemImage.setBounds(84, 11, 50, 46);
		FightMode.add(ItemImage);
		PlayerImage.setIcon(imageIcon);
		PlayerImage.setOpaque(true);
		PlayerImage.setBackground(new Color(255, 204, 102));
		PlayerImage.setForeground(new Color(0, 0, 0));
		PlayerImage.setBounds(10, 11, 64, 64);
		FightMode.add(PlayerImage);
		
		JProgressBar PlayerHealth = new JProgressBar();
		PlayerHealth.setForeground(new Color(0, 153, 0));
		PlayerHealth.setString("");
		PlayerHealth.setStringPainted(true);
		PlayerHealth.setValue(70);
		PlayerHealth.setBounds(144, 11, 178, 25);
		FightMode.add(PlayerHealth);
		
		PlayerMana = new JProgressBar();
		PlayerMana.setForeground(new Color(0, 0, 255));
		PlayerMana.setStringPainted(true);
		PlayerMana.setString("");
		PlayerMana.setValue(40);
		PlayerMana.setBounds(144, 47, 178, 14);
		FightMode.add(PlayerMana);
		
		EnemyImage = new JLabel("");
		EnemyImage.setOpaque(true);
		EnemyImage.setForeground(Color.BLACK);
		EnemyImage.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new LineBorder(new Color(0, 0, 0))));
		EnemyImage.setBackground(new Color(255, 204, 102));
		EnemyImage.setBounds(499, 207, 64, 64);
		FightMode.add(EnemyImage);
		
		EnemyHealth = new JProgressBar();
		EnemyHealth.setValue(70);
		EnemyHealth.setStringPainted(true);
		EnemyHealth.setString("");
		EnemyHealth.setForeground(new Color(0, 153, 0));
		EnemyHealth.setBounds(308, 246, 178, 25);
		FightMode.add(EnemyHealth);
		setVisible(true);
	}
}
