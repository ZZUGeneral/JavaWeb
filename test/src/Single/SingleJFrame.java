package Single;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
public class SingleJFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JDesktopPane desktopPane;
	JInternalFrame internalFrame1, internalFrame2;
	public SingleJFrame() {
		super("JInternalFrameDemol");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		JButton button1 = new JButton("Crate new First Service");
		JButton button2 = new JButton("Crate new Second Service");
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (internalFrame1 == null) {
					internalFrame1 = new JInternalFrame("InternalFrame1", true, true, true, true);
					internalFrame1.setLocation(20, 20);
					internalFrame1.setSize(new Dimension(200, 200));
					internalFrame1.setVisible(true);
					Container icontentPane = internalFrame1.getContentPane();
					JTextArea textArea = new JTextArea();
					JButton b = new JButton("Internal Frame Button");
					icontentPane.add(textArea, "Center");
					icontentPane.add(b, "South");
					desktopPane.add(internalFrame1);
					try {
						internalFrame1.setSelected(true);
					} catch (java.beans.PropertyVetoException ex) {
						System.out.println("Exception while selecting");
					}
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (internalFrame2 == null) {
					internalFrame2 = new JInternalFrame("InternalFrame2", true, true, true, true);
					internalFrame2.setLocation(20, 20);
					internalFrame2.setSize(new Dimension(200, 200));
					internalFrame2.setVisible(true);
					Container icontentPane = internalFrame2.getContentPane();
					JTextArea textArea = new JTextArea();
					JButton b = new JButton("Internal Frame Button");
					icontentPane.add(textArea, "Center");
					icontentPane.add(b, "South");
					desktopPane.add(internalFrame2);
					try {
						internalFrame2.setSelected(true);
					} catch (java.beans.PropertyVetoException ex) {
						System.out.println("Exception while selecting");
					}
				}
			}
		});
		contentPane.add(button1, BorderLayout.SOUTH);
		contentPane.add(button2, BorderLayout.NORTH);
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane);
		this.setSize(300, 300);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
	}
	public static void main(String[] args) {
		new SingleJFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
