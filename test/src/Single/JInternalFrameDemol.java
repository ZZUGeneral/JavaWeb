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

public class JInternalFrameDemol extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JDesktopPane desktopPane;
	JInternalFrame internalFrame;

	public JInternalFrameDemol() {
		super("JInternalFrameDemol");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		JButton button = new JButton("Crate new Internal Frame");
		button.addActionListener(this);
		contentPane.add(button, BorderLayout.SOUTH);
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

	public void actionPerformed(ActionEvent e) {
		if (internalFrame == null) {
			internalFrame = new JInternalFrame("InternalFrame", true, true, true, true);
			internalFrame.setLocation(20, 20);
			internalFrame.setSize(new Dimension(200, 200));
			internalFrame.setVisible(true);
			Container icontentPane = internalFrame.getContentPane();
			JTextArea textArea = new JTextArea();
			JButton b = new JButton("Internal Frame Button");
			icontentPane.add(textArea, "Center");
			icontentPane.add(b, "South");
			desktopPane.add(internalFrame);
			// this.getContentPane().add(internalFrame);
			try {
				internalFrame.setSelected(true);

			} catch (java.beans.PropertyVetoException ex) {
				System.out.println("Exception while selecting");
			}
		}
	}

	public static void main(String[] args) {
		new JInternalFrameDemol();
	}
}
