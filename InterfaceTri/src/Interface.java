import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Interface {

	protected Shell shell;
//	private Text text1,text2,text3,text4,text5,text6;
	private Label label2;
	private Label label3;
	private Label label4;
	private Label label5;
	private Label label6;
	private Label lblEnterTheKnown;
	private Label lblNewLabel;

	private Text[] texts = new Text[6];
	
	public static void main(String[] args) {
		try {
			Interface window = new Interface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 429);
		shell.setText("SWT Application");
		
		texts[0] = new Text(shell, SWT.BORDER);
		texts[0].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[0].setBounds(100, 65, 106, 33);
		
		texts[1] = new Text(shell, SWT.BORDER);
		texts[1].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[1].setBounds(100, 101, 106, 33);
		
		texts[2] = new Text(shell, SWT.BORDER);
		texts[2].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[2].setBounds(100, 139, 106, 33);
		
		texts[3] = new Text(shell, SWT.BORDER);
		texts[3].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[3].setBounds(304, 68, 106, 33);
		
		texts[4] = new Text(shell, SWT.BORDER);
		texts[4].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[4].setBounds(304, 104, 106, 33);
		
		texts[5] = new Text(shell, SWT.BORDER);
		texts[5].setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		texts[5].setBounds(304, 143, 106, 33);
		
		lblEnterTheKnown = new Label(shell, SWT.NONE);
		lblEnterTheKnown.setAlignment(SWT.CENTER);
		lblEnterTheKnown.setVisible(true);
		lblEnterTheKnown.setText("Enter the known information:");
		lblEnterTheKnown.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		lblEnterTheKnown.setBounds(10, 10, 414, 38);
		
		Label label1 = new Label(shell, SWT.NONE);
		label1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label1.setVisible(true);
		label1.setBounds(10, 68, 84, 27);
		label1.setText("Angle 1:");
		
		label2 = new Label(shell, SWT.NONE);
		label2.setVisible(true);
		label2.setText("Angle 2:");
		label2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label2.setBounds(10, 107, 84, 27);
		
		label3 = new Label(shell, SWT.NONE);
		label3.setVisible(true);
		label3.setText("Angle 3:");
		label3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label3.setBounds(10, 144, 84, 27);
		
		label4 = new Label(shell, SWT.NONE);
		label4.setVisible(true);
		label4.setText("Side 1:");
		label4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label4.setBounds(226, 71, 72, 27);
		
		label5 = new Label(shell, SWT.NONE);
		label5.setVisible(true);
		label5.setText("Side 2:");
		label5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label5.setBounds(226, 107, 72, 27);
		
		label6 = new Label(shell, SWT.NONE);
		label6.setVisible(true);
		label6.setText("Side 3:");
		label6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label6.setBounds(226, 145, 72, 27);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				for (int i = 0; i < texts.length;i++){
					System.out.println(texts[i].getText());
				}
			}
		});
		
		btnNewButton.setBounds(126, 189, 172, 27);
		btnNewButton.setText("Enter");
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 233, 414, 139);
		lblNewLabel.setText("Answer:");

	}




}
