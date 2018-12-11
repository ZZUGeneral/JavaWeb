package test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JTest extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3285290853986547026L;
	public JTest() {
		JButton button = new JButton("°´Å¥");
		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("This is mouseClicked!");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("This is mouseEntered!");
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("This is mouseExited!");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("This is mousePressed!");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("This is mouseReleased!");
			}

			});
		add(button);
		show();
	}
	public static void main(String[] arg) {
		new JTest();
	}

}
