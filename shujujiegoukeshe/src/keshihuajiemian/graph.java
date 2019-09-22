package keshihuajiemian;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

public class graph {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graph window = new graph();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graph() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 726, 571);
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JButton btnF = new JButton("F");
		sl_panel.putConstraint(SpringLayout.NORTH, btnF, 146, SpringLayout.NORTH, panel);
		btnF.setVerticalAlignment(SwingConstants.TOP);
		panel.add(btnF);
		
		JButton btnA = new JButton("A");
		sl_panel.putConstraint(SpringLayout.NORTH, btnA, 243, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnA, 117, SpringLayout.WEST, panel);
		panel.add(btnA);
		
		JButton btnG = new JButton("G");
		sl_panel.putConstraint(SpringLayout.WEST, btnF, 0, SpringLayout.WEST, btnG);
		sl_panel.putConstraint(SpringLayout.WEST, btnG, 314, SpringLayout.WEST, panel);
		panel.add(btnG);
		
		JButton btnE = new JButton("E");
		sl_panel.putConstraint(SpringLayout.EAST, btnE, -215, SpringLayout.EAST, panel);
		panel.add(btnE);
		
		JButton btnB = new JButton("B");
		sl_panel.putConstraint(SpringLayout.WEST, btnB, 159, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnB, -155, SpringLayout.SOUTH, panel);
		panel.add(btnB);
		
		JButton btnC = new JButton("C");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnG, -130, SpringLayout.NORTH, btnC);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnC, -89, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnC, -391, SpringLayout.EAST, panel);
		panel.add(btnC);
		
		JButton btnD = new JButton("D");
		sl_panel.putConstraint(SpringLayout.SOUTH, btnE, -132, SpringLayout.NORTH, btnD);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnD, -126, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnD, -204, SpringLayout.EAST, panel);
		panel.add(btnD);
	}
}
