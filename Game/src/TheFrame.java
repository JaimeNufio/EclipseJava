import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import java.awt.Label;

public class TheFrame extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	
	public final JLabel score = new JLabel("0");
	public final JLabel streak = new JLabel("0");
	public final JLabel congrats = new JLabel("");
	public final JLabel level = new JLabel("0");
	public static final JProgressBar progressBar = new JProgressBar();
	public static int time = 360;
	public static final TheFrame frame = new TheFrame();
	public static boolean pass = true;

//	public Game game;

	/**
	 * Launch the application.
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		while (time > 0){
			System.out.println(time);
			progressBar.setValue(time);
			Thread.sleep(1000);
			time--;
		}
		pass = false;
		
		
	}

	/**
	 * Create the frame.
	 */
	public TheFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(UIManager.getColor("menu"));
		panel.setBounds(0, 0, 434, 213);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSolveFor = new JLabel("Solve For:");
		lblSolveFor.setBounds(10, 11, 94, 33);
		panel.add(lblSolveFor);
		lblSolveFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 51, 176, 73);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		Game.updateRange();
		Game.updateVal();
		lblNewLabel.setText(Game.updateText());
		
		text = new JTextField();
		
		text.setFont(new Font("Tahoma", Font.PLAIN, 25));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(10, 144, 254, 47);
		panel.add(text);
		text.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(275, 11, 149, 191);
		panel.add(panel_1);
		panel_1.setBackground(UIManager.getColor("info"));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setOpaque(true);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblScore.setBounds(10, 11, 65, 41);
		panel_1.add(lblScore);
		
		score.setFont(new Font("Tahoma", Font.PLAIN, 20));
		score.setHorizontalAlignment(SwingConstants.RIGHT);
		score.setBounds(85, 17, 54, 28);
		panel_1.add(score);
		
		JLabel lblLevel = new JLabel("Level:");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevel.setBounds(10, 50, 65, 41);
		panel_1.add(lblLevel);
		

		level.setHorizontalAlignment(SwingConstants.RIGHT);
		level.setFont(new Font("Tahoma", Font.PLAIN, 20));
		level.setBounds(85, 56, 54, 28);
		panel_1.add(level);
		
		JLabel lblStreak = new JLabel("Streak:");
		lblStreak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStreak.setBounds(10, 89, 65, 41);
		panel_1.add(lblStreak);
		
		streak.setHorizontalAlignment(SwingConstants.RIGHT);
		streak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		streak.setBounds(85, 95, 54, 28);
		panel_1.add(streak);
		

		congrats.setHorizontalAlignment(SwingConstants.CENTER);
		congrats.setFont(new Font("Tahoma", Font.PLAIN, 18));
		congrats.setBounds(10, 141, 129, 39);
		panel_1.add(congrats);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 219, 414, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
//		Label label = new Label("test");
//		label.setAlignment(Label.CENTER);
//		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		label.setBounds(10, 11, 394, 41);
//		panel_2.add(label);
		
		progressBar.setMaximum(time);
		progressBar.setBounds(10, 11, 394, 40);
		panel_2.add(progressBar);
		panel_1.setVisible(true);
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER && pass){
					if (Game.answerState(text.getText())){
						congrats.setForeground(Game.colors());
						congrats.setText(Game.strings());
						Game.checkAnswer(text.getText());
						text.setText("");
					}
					Game.updateVal();
					lblNewLabel.setText(Game.updateText());
				}else{
					congrats.setText("");
				}

				Game.generalUpdate(score, Game.score+"");
				Game.generalUpdate(streak, Game.streak+"");
				Game.generalUpdate(level,Game.level+"");

			}
		});

	}
}
