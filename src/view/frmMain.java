package view;

import java.sql.*;
import dal.DbConnect;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmMain extends JFrame {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public frmMain() throws ClassNotFoundException {
		setResizable(false);
		setTitle("Project Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(47, 39, 76));
		sideMenu.setBounds(0, 0, 150, 600);
		contentPane.add(sideMenu);
		sideMenu.setLayout(null);
		
				
		//Sidemenu Buttons
		JPanel btn_1 = new JPanel();
		JPanel btn_2 = new JPanel();
		JPanel btn_3 = new JPanel();
		JPanel btn_4 = new JPanel();
		JPanel btn_5 = new JPanel();
		
		//Indicators
		JPanel ind_1 = new JPanel();
		ind_1.setOpaque(false);
		JPanel ind_2 = new JPanel();
		ind_2.setOpaque(false);
		JPanel ind_3 = new JPanel();
		ind_3.setOpaque(false);
		JPanel ind_4 = new JPanel();
		ind_4.setOpaque(false);
		JPanel ind_5 = new JPanel();
		ind_5.setOpaque(false);
		
		
		//Button 1
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressedBtn(btn_1);
				ind_1.setOpaque(true);
				unpressedBtn(new JPanel[]{btn_2,btn_3,btn_4,btn_5}, new JPanel[]{ind_2,ind_3,ind_4,ind_5});
			}
		});
		btn_1.setBackground(new Color(47, 39, 76));
		btn_1.setBounds(0, 150, 150, 50);
		sideMenu.add(btn_1);
		btn_1.setLayout(null);
				
		ind_1.setBackground(new Color(255, 255, 255));
		ind_1.setBounds(0, 0, 5, 50);
		btn_1.add(ind_1);
		
		JLabel lblbtn_1 = new JLabel("Projects");
		lblbtn_1.setForeground(Color.WHITE);
		lblbtn_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblbtn_1.setBounds(49, 20, 60, 15);
		btn_1.add(lblbtn_1);
		
		
		//Button 2
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressedBtn(btn_2);
				ind_2.setOpaque(true);
				unpressedBtn(new JPanel[]{btn_1,btn_3,btn_4,btn_5}, new JPanel[]{ind_1,ind_3,ind_4,ind_5});
			}
		});
		btn_2.setLayout(null);
		btn_2.setBackground(new Color(47, 39, 76));
		btn_2.setBounds(0, 200, 150, 50);
		sideMenu.add(btn_2);
				
		ind_2.setBackground(new Color(255, 255, 255));
		ind_2.setBounds(0, 0, 5, 50);
		btn_2.add(ind_2);
		
		JLabel lblbtn_2 = new JLabel("Activities");
		lblbtn_2.setForeground(Color.WHITE);
		lblbtn_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblbtn_2.setBounds(46, 20, 70, 15);
		btn_2.add(lblbtn_2);
		
		
		//Button 3
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressedBtn(btn_3);
				ind_3.setOpaque(true);
				unpressedBtn(new JPanel[]{btn_1,btn_2,btn_4,btn_5}, new JPanel[]{ind_1,ind_2,ind_4,ind_5});
			}
		});
		btn_3.setLayout(null);
		btn_3.setBackground(new Color(47, 39, 76));
		btn_3.setBounds(0, 250, 150, 50);
		sideMenu.add(btn_3);
				
		ind_3.setBackground(new Color(255, 255, 255));
		ind_3.setBounds(0, 0, 5, 50);
		btn_3.add(ind_3);
		
		JLabel lblbtn_3 = new JLabel("Risks");
		lblbtn_3.setForeground(Color.WHITE);
		lblbtn_3.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblbtn_3.setBounds(57, 20, 55, 15);
		btn_3.add(lblbtn_3);
				
		
		//Button 4
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressedBtn(btn_4);
				ind_4.setOpaque(true);
				unpressedBtn(new JPanel[] {btn_1,btn_2,btn_3,btn_5}, new JPanel[]{ind_1,ind_2,ind_3,ind_5});
			}
		});
		btn_4.setLayout(null);
		btn_4.setBackground(new Color(47, 39, 76));
		btn_4.setBounds(0, 300, 150, 50);
		sideMenu.add(btn_4);
				
		ind_4.setBackground(new Color(255, 255, 255));
		ind_4.setBounds(0, 0, 5, 50);
		btn_4.add(ind_4);
		
		JLabel lblbtn_4 = new JLabel("Employees");
		lblbtn_4.setForeground(Color.WHITE);
		lblbtn_4.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblbtn_4.setBounds(42, 20, 76, 15);
		btn_4.add(lblbtn_4);
		
		
		//Button 5
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pressedBtn(btn_5);
				ind_5.setOpaque(true);
				unpressedBtn(new JPanel[] {btn_1,btn_2,btn_3,btn_4}, new JPanel[]{ind_1,ind_2,ind_3,ind_4});
			}
		});
		btn_5.setLayout(null);
		btn_5.setBackground(new Color(47, 39, 76));
		btn_5.setBounds(0, 350, 150, 50);
		sideMenu.add(btn_5);
				
		ind_5.setBackground(new Color(255, 255, 255));
		ind_5.setBounds(0, 0, 5, 50);
		btn_5.add(ind_5);
		
		JLabel lblbtn_5 = new JLabel("Scenarios");
		lblbtn_5.setForeground(Color.WHITE);
		lblbtn_5.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblbtn_5.setBounds(44, 20, 85, 15);
		btn_5.add(lblbtn_5);
		setLocationRelativeTo(null);
		con = DbConnect.dbconnect();
	}
	
	private void pressedBtn(JPanel pane) {
		pane.setBackground(new Color(146, 115, 195));
	}
	
	
	private void unpressedBtn(JPanel [] pane, JPanel [] indicator) {
		
		for(int i=0;i<pane.length;i++) {
			pane[i].setBackground(new Color(47, 39, 76));
		}
		
		for(int i=0;i<pane.length;i++) {
			indicator[i].setOpaque(false);
		}
		
	}
	
	

}
