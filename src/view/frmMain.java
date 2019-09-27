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
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class frmMain extends JFrame {

	Connection connect;
	PreparedStatement pst;
	ResultSet rs;
	
	
	private JPanel contentPane;
	private JPanel scenariosPanel;
	private JPanel employeesPanel;
	private JPanel risksPanel;
	private JPanel activitiesPanel;
	private JPanel projectsPanel;
	private JLayeredPane layeredPane;
	private JTextField txtProjectName;
	private JTextField txtActivityLabel;
	private JTextField txtRiskName;
	private JTextField txtRiskCostProbability;
	private JTextField txtRiskTimeProbability;
	private JTextField txtRiskCostImpact;
	private JTextField txtRiskTotalRiskExposure;
	private JTextField txtRiskTimeImpact;
	private JTextField txtRiskRelatedProject;
	private JTextField txtActivityEstimatedTime;
	private JTextField txtActivityEstimatedCost;
	private JTextField txtActivityRelatedProject;
	private JTextField txtEmployeeName;
	private JTextField txtEmployeeSpeciality;
	private JTextField txtEmployeeRelatedProject;
	private JTextField txtScenarioName;
	private JTextField txtScenarioRelatedProject;
	private JTextField txtProjectDuration;
	private JTextField txtProjectBudget;
	private JTextField txtProjectTimeBudget;
	private JTextField txtProjectCostBudget;

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
				switchPanels(projectsPanel);
				pressedBtn(btn_1);
				ind_1.setOpaque(true);
				unpressedBtn(new JPanel[]{btn_2,btn_3,btn_4,btn_5}, new JPanel[]{ind_2,ind_3,ind_4,ind_5});
			}
		});
		btn_1.setBackground(new Color(146, 115, 195));
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
				switchPanels(activitiesPanel);
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
				switchPanels(risksPanel);
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
				switchPanels(employeesPanel);
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
				switchPanels(scenariosPanel);
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
		
		JLabel btn_exit = new JLabel("");
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btn_exit.setIcon(new ImageIcon(frmMain.class.getResource("/icons/icons8_exit_32px_2.png")));
		btn_exit.setBounds(5, 560, 32, 32);
		sideMenu.add(btn_exit);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(150, 0, 850, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		projectsPanel = new JPanel();
		layeredPane.add(projectsPanel, "name_3191288904014");
		projectsPanel.setLayout(null);
		
		JPanel projectsTop = new JPanel();
		projectsTop.setBackground(new Color(47, 39, 76));
		projectsTop.setBounds(0, 0, 850, 50);
		projectsPanel.add(projectsTop);
		
		JPanel projectsLeft = new JPanel();
		projectsLeft.setForeground(Color.WHITE);
		projectsLeft.setBackground(new Color(146, 115, 195));
		projectsLeft.setBounds(0, 50, 350, 550);
		projectsPanel.add(projectsLeft);
		projectsLeft.setLayout(null);
		
		JLabel lblNewProject = new JLabel("New Project");
		lblNewProject.setForeground(Color.WHITE);
		lblNewProject.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblNewProject.setBounds(30, 11, 140, 50);
		projectsLeft.add(lblNewProject);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setBounds(30, 59, 140, 2);
		projectsLeft.add(separator);
		
		JLabel lblProjectName = new JLabel("Name");
		lblProjectName.setForeground(Color.WHITE);
		lblProjectName.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProjectName.setBounds(30, 75, 150, 20);
		projectsLeft.add(lblProjectName);
		
		txtProjectName = new JTextField();
		txtProjectName.setForeground(new Color(47, 39, 76));
		txtProjectName.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtProjectName.setBounds(30, 100, 290, 25);
		projectsLeft.add(txtProjectName);
		txtProjectName.setColumns(10);
		
		JLabel lblProjectDuration = new JLabel("Duration");
		lblProjectDuration.setForeground(Color.WHITE);
		lblProjectDuration.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProjectDuration.setBounds(30, 136, 150, 20);
		projectsLeft.add(lblProjectDuration);
		
		txtProjectDuration = new JTextField();
		txtProjectDuration.setForeground(new Color(47, 39, 76));
		txtProjectDuration.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtProjectDuration.setColumns(10);
		txtProjectDuration.setBounds(30, 161, 290, 25);
		projectsLeft.add(txtProjectDuration);
		
		JLabel lblProjectBudget = new JLabel("Budget");
		lblProjectBudget.setForeground(Color.WHITE);
		lblProjectBudget.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProjectBudget.setBounds(30, 197, 150, 20);
		projectsLeft.add(lblProjectBudget);
		
		txtProjectBudget = new JTextField();
		txtProjectBudget.setForeground(new Color(47, 39, 76));
		txtProjectBudget.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtProjectBudget.setColumns(10);
		txtProjectBudget.setBounds(30, 222, 290, 25);
		projectsLeft.add(txtProjectBudget);
		
		JLabel lblProjectTime = new JLabel("Time Contingency Budget");
		lblProjectTime.setForeground(Color.WHITE);
		lblProjectTime.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProjectTime.setBounds(30, 258, 185, 20);
		projectsLeft.add(lblProjectTime);
		
		txtProjectTimeBudget = new JTextField();
		txtProjectTimeBudget.setForeground(new Color(47, 39, 76));
		txtProjectTimeBudget.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtProjectTimeBudget.setColumns(10);
		txtProjectTimeBudget.setBounds(30, 283, 290, 25);
		projectsLeft.add(txtProjectTimeBudget);
		
		JLabel lblProjectCostContingencyBudget = new JLabel("Cost Contingency Budget");
		lblProjectCostContingencyBudget.setForeground(Color.WHITE);
		lblProjectCostContingencyBudget.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblProjectCostContingencyBudget.setBounds(30, 319, 185, 20);
		projectsLeft.add(lblProjectCostContingencyBudget);
		
		txtProjectCostBudget = new JTextField();
		txtProjectCostBudget.setForeground(new Color(47, 39, 76));
		txtProjectCostBudget.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtProjectCostBudget.setColumns(10);
		txtProjectCostBudget.setBounds(30, 344, 290, 25);
		projectsLeft.add(txtProjectCostBudget);
		
		JPanel btnProjectCreate = new JPanel();
		btnProjectCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnProjectCreate.setBackground(new Color(33, 27, 56));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnProjectCreate.setBackground(new Color(47, 39, 76));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				createProject();
			}
		});
		
		btnProjectCreate.setLayout(null);
		btnProjectCreate.setBackground(new Color(47, 39, 76));
		btnProjectCreate.setBounds(104, 470, 140, 50);
		projectsLeft.add(btnProjectCreate);
		
		JLabel lblProjectCreate = new JLabel("Create");
		lblProjectCreate.setForeground(Color.WHITE);
		lblProjectCreate.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblProjectCreate.setBounds(43, 18, 54, 15);
		btnProjectCreate.add(lblProjectCreate);
		
		JPanel projectsRight = new JPanel();
		projectsRight.setBackground(new Color(255, 255, 255));
		projectsRight.setBounds(350, 50, 500, 550);
		projectsPanel.add(projectsRight);
		
		activitiesPanel = new JPanel();
		layeredPane.add(activitiesPanel, "name_3216371395926");
		activitiesPanel.setLayout(null);
		
		JPanel activitiesTop = new JPanel();
		activitiesTop.setBackground(new Color(47, 39, 76));
		activitiesTop.setBounds(0, 0, 850, 50);
		activitiesPanel.add(activitiesTop);
		
		JPanel activitiesLeft = new JPanel();
		activitiesLeft.setForeground(Color.WHITE);
		activitiesLeft.setBackground(new Color(146, 115, 195));
		activitiesLeft.setBounds(0, 50, 350, 550);
		activitiesPanel.add(activitiesLeft);
		activitiesLeft.setLayout(null);
		
		JLabel lblNewActivity = new JLabel("New Activity");
		lblNewActivity.setForeground(Color.WHITE);
		lblNewActivity.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblNewActivity.setBounds(30, 11, 140, 50);
		activitiesLeft.add(lblNewActivity);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(30, 59, 140, 2);
		activitiesLeft.add(separator_1);
		
		JLabel lblActivityLabel = new JLabel("Label");
		lblActivityLabel.setForeground(Color.WHITE);
		lblActivityLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblActivityLabel.setBounds(30, 75, 150, 20);
		activitiesLeft.add(lblActivityLabel);
		
		txtActivityLabel = new JTextField();
		txtActivityLabel.setForeground(new Color(47, 39, 76));
		txtActivityLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtActivityLabel.setColumns(10);
		txtActivityLabel.setBounds(30, 100, 290, 25);
		activitiesLeft.add(txtActivityLabel);
		
		JLabel lblActivityEstimatedTime = new JLabel("Estimated Time");
		lblActivityEstimatedTime.setForeground(Color.WHITE);
		lblActivityEstimatedTime.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblActivityEstimatedTime.setBounds(30, 136, 150, 20);
		activitiesLeft.add(lblActivityEstimatedTime);
		
		txtActivityEstimatedTime = new JTextField();
		txtActivityEstimatedTime.setForeground(new Color(47, 39, 76));
		txtActivityEstimatedTime.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtActivityEstimatedTime.setColumns(10);
		txtActivityEstimatedTime.setBounds(30, 161, 290, 25);
		activitiesLeft.add(txtActivityEstimatedTime);
		
		JLabel lblActivityEstimatedCost = new JLabel("Estimated Cost");
		lblActivityEstimatedCost.setForeground(Color.WHITE);
		lblActivityEstimatedCost.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblActivityEstimatedCost.setBounds(30, 197, 150, 20);
		activitiesLeft.add(lblActivityEstimatedCost);
		
		txtActivityEstimatedCost = new JTextField();
		txtActivityEstimatedCost.setForeground(new Color(47, 39, 76));
		txtActivityEstimatedCost.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtActivityEstimatedCost.setColumns(10);
		txtActivityEstimatedCost.setBounds(30, 222, 290, 25);
		activitiesLeft.add(txtActivityEstimatedCost);
		
		JLabel lblActivityRelatedProject = new JLabel("Related Project");
		lblActivityRelatedProject.setForeground(Color.WHITE);
		lblActivityRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblActivityRelatedProject.setBounds(30, 258, 150, 20);
		activitiesLeft.add(lblActivityRelatedProject);
		
		txtActivityRelatedProject = new JTextField();
		txtActivityRelatedProject.setForeground(new Color(47, 39, 76));
		txtActivityRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtActivityRelatedProject.setColumns(10);
		txtActivityRelatedProject.setBounds(30, 283, 290, 25);
		activitiesLeft.add(txtActivityRelatedProject);
		
		JPanel btnActivityCreate = new JPanel();
		btnActivityCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnActivityCreate.setBackground(new Color(33, 27, 56));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnActivityCreate.setBackground(new Color(47, 39, 76));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createActivity();
			}		
			
		});
		btnActivityCreate.setLayout(null);
		btnActivityCreate.setBackground(new Color(47, 39, 76));
		btnActivityCreate.setBounds(104, 470, 140, 50);
		activitiesLeft.add(btnActivityCreate);
		
		JLabel lblActivityCreate = new JLabel("Create");
		lblActivityCreate.setForeground(Color.WHITE);
		lblActivityCreate.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblActivityCreate.setBounds(43, 18, 54, 15);
		btnActivityCreate.add(lblActivityCreate);
		
		JPanel activitiesRight = new JPanel();
		activitiesRight.setBackground(Color.WHITE);
		activitiesRight.setBounds(350, 50, 500, 550);
		activitiesPanel.add(activitiesRight);
		
		risksPanel = new JPanel();
		risksPanel.setForeground(Color.ORANGE);
		layeredPane.add(risksPanel, "name_3219603263281");
		risksPanel.setLayout(null);
		
		JPanel risksTop = new JPanel();
		risksTop.setBackground(new Color(47, 39, 76));
		risksTop.setBounds(0, 0, 850, 50);
		risksPanel.add(risksTop);
		
		JPanel risksLeft = new JPanel();
		risksLeft.setForeground(Color.WHITE);
		risksLeft.setBackground(new Color(146, 115, 195));
		risksLeft.setBounds(0, 50, 350, 550);
		risksPanel.add(risksLeft);
		risksLeft.setLayout(null);
		
		JLabel lblNewRisk = new JLabel("New Risk");
		lblNewRisk.setForeground(Color.WHITE);
		lblNewRisk.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblNewRisk.setBounds(30, 11, 115, 50);
		risksLeft.add(lblNewRisk);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.WHITE);
		separator_2.setBounds(30, 59, 115, 2);
		risksLeft.add(separator_2);
		
		JLabel lblRiskName = new JLabel("Name");
		lblRiskName.setForeground(Color.WHITE);
		lblRiskName.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskName.setBounds(30, 75, 150, 20);
		risksLeft.add(lblRiskName);
		
		txtRiskName = new JTextField();
		txtRiskName.setForeground(new Color(47, 39, 76));
		txtRiskName.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskName.setColumns(10);
		txtRiskName.setBounds(30, 100, 290, 25);
		risksLeft.add(txtRiskName);
		
		JLabel lblRiskCostProbability = new JLabel("Cost Probability");
		lblRiskCostProbability.setForeground(Color.WHITE);
		lblRiskCostProbability.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskCostProbability.setBounds(30, 136, 150, 20);
		risksLeft.add(lblRiskCostProbability);
		
		txtRiskCostProbability = new JTextField();
		txtRiskCostProbability.setForeground(new Color(47, 39, 76));
		txtRiskCostProbability.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskCostProbability.setColumns(10);
		txtRiskCostProbability.setBounds(30, 161, 290, 25);
		risksLeft.add(txtRiskCostProbability);
		
		JLabel lblRiskTimeProbability = new JLabel("Time Probability");
		lblRiskTimeProbability.setForeground(Color.WHITE);
		lblRiskTimeProbability.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskTimeProbability.setBounds(30, 197, 150, 20);
		risksLeft.add(lblRiskTimeProbability);
		
		txtRiskTimeProbability = new JTextField();
		txtRiskTimeProbability.setForeground(new Color(47, 39, 76));
		txtRiskTimeProbability.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskTimeProbability.setColumns(10);
		txtRiskTimeProbability.setBounds(30, 222, 290, 25);
		risksLeft.add(txtRiskTimeProbability);
		
		JLabel lblRiskCostImpact = new JLabel("Cost Impact");
		lblRiskCostImpact.setForeground(Color.WHITE);
		lblRiskCostImpact.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskCostImpact.setBounds(30, 258, 117, 20);
		risksLeft.add(lblRiskCostImpact);
		
		txtRiskCostImpact = new JTextField();
		txtRiskCostImpact.setForeground(new Color(47, 39, 76));
		txtRiskCostImpact.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskCostImpact.setColumns(10);
		txtRiskCostImpact.setBounds(30, 283, 135, 25);
		risksLeft.add(txtRiskCostImpact);
		
		JLabel lblRiskTimeImpact = new JLabel("Time Impact");
		lblRiskTimeImpact.setForeground(Color.WHITE);
		lblRiskTimeImpact.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskTimeImpact.setBounds(185, 258, 109, 20);
		risksLeft.add(lblRiskTimeImpact);
		
		txtRiskTimeImpact = new JTextField();
		txtRiskTimeImpact.setForeground(new Color(47, 39, 76));
		txtRiskTimeImpact.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskTimeImpact.setColumns(10);
		txtRiskTimeImpact.setBounds(185, 283, 135, 25);
		risksLeft.add(txtRiskTimeImpact);
		
		JLabel lblRiskTotalRiskExposure = new JLabel("Total Risk Exposure");
		lblRiskTotalRiskExposure.setForeground(Color.WHITE);
		lblRiskTotalRiskExposure.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskTotalRiskExposure.setBounds(30, 319, 140, 20);
		risksLeft.add(lblRiskTotalRiskExposure);
		
		txtRiskTotalRiskExposure = new JTextField();
		txtRiskTotalRiskExposure.setForeground(new Color(47, 39, 76));
		txtRiskTotalRiskExposure.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskTotalRiskExposure.setColumns(10);
		txtRiskTotalRiskExposure.setBounds(30, 344, 290, 25);
		risksLeft.add(txtRiskTotalRiskExposure);
		
		JLabel lblRiskRelatedProject = new JLabel("Related Project");
		lblRiskRelatedProject.setForeground(Color.WHITE);
		lblRiskRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblRiskRelatedProject.setBounds(30, 380, 150, 20);
		risksLeft.add(lblRiskRelatedProject);
		
		txtRiskRelatedProject = new JTextField();
		txtRiskRelatedProject.setForeground(new Color(47, 39, 76));
		txtRiskRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRiskRelatedProject.setColumns(10);
		txtRiskRelatedProject.setBounds(30, 405, 290, 25);
		risksLeft.add(txtRiskRelatedProject);
		
		JPanel btnRiskCreate = new JPanel();
		btnRiskCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRiskCreate.setBackground(new Color(33, 27, 56));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRiskCreate.setBackground(new Color(47, 39, 76));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				createRisk();
			}
		});
		btnRiskCreate.setBackground(new Color(47, 39, 76));
		btnRiskCreate.setBounds(104, 470, 140, 50);
		risksLeft.add(btnRiskCreate);
		btnRiskCreate.setLayout(null);
		
		JLabel lblRiskCreate = new JLabel("Create");
		lblRiskCreate.setForeground(Color.WHITE);
		lblRiskCreate.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRiskCreate.setBounds(43, 18, 54, 15);
		btnRiskCreate.add(lblRiskCreate);
		
		JPanel risksRight = new JPanel();
		risksRight.setBackground(Color.WHITE);
		risksRight.setBounds(350, 50, 500, 550);
		risksPanel.add(risksRight);
		
		employeesPanel = new JPanel();
		layeredPane.add(employeesPanel, "name_3221706195412");
		employeesPanel.setLayout(null);
		
		JPanel employeesTop = new JPanel();
		employeesTop.setBackground(new Color(47, 39, 76));
		employeesTop.setBounds(0, 0, 850, 50);
		employeesPanel.add(employeesTop);
		
		JPanel employeesLeft = new JPanel();
		employeesLeft.setForeground(Color.WHITE);
		employeesLeft.setBackground(new Color(146, 115, 195));
		employeesLeft.setBounds(0, 50, 350, 550);
		employeesPanel.add(employeesLeft);
		employeesLeft.setLayout(null);
		
		JLabel lblNewEmployee = new JLabel("New Employee");
		lblNewEmployee.setForeground(Color.WHITE);
		lblNewEmployee.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblNewEmployee.setBounds(30, 11, 170, 50);
		employeesLeft.add(lblNewEmployee);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.WHITE);
		separator_3.setBounds(30, 59, 170, 2);
		employeesLeft.add(separator_3);
		
		JLabel lblEmployeeName = new JLabel("Name");
		lblEmployeeName.setForeground(Color.WHITE);
		lblEmployeeName.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEmployeeName.setBounds(30, 75, 150, 20);
		employeesLeft.add(lblEmployeeName);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setForeground(new Color(47, 39, 76));
		txtEmployeeName.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtEmployeeName.setColumns(10);
		txtEmployeeName.setBounds(30, 100, 290, 25);
		employeesLeft.add(txtEmployeeName);
		
		JLabel lblEmployeeSpeciality = new JLabel("Speciality");
		lblEmployeeSpeciality.setForeground(Color.WHITE);
		lblEmployeeSpeciality.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEmployeeSpeciality.setBounds(30, 136, 150, 20);
		employeesLeft.add(lblEmployeeSpeciality);
		
		txtEmployeeSpeciality = new JTextField();
		txtEmployeeSpeciality.setForeground(new Color(47, 39, 76));
		txtEmployeeSpeciality.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtEmployeeSpeciality.setColumns(10);
		txtEmployeeSpeciality.setBounds(30, 161, 290, 25);
		employeesLeft.add(txtEmployeeSpeciality);
		
		JLabel lblEmployeeQualified = new JLabel("Qualified");
		lblEmployeeQualified.setForeground(Color.WHITE);
		lblEmployeeQualified.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEmployeeQualified.setBounds(30, 197, 150, 20);
		employeesLeft.add(lblEmployeeQualified);
		
		JLabel lblEmployeeRelatedProject = new JLabel("Related Project");
		lblEmployeeRelatedProject.setForeground(Color.WHITE);
		lblEmployeeRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEmployeeRelatedProject.setBounds(30, 258, 150, 20);
		employeesLeft.add(lblEmployeeRelatedProject);
		
		txtEmployeeRelatedProject = new JTextField();
		txtEmployeeRelatedProject.setForeground(new Color(47, 39, 76));
		txtEmployeeRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtEmployeeRelatedProject.setColumns(10);
		txtEmployeeRelatedProject.setBounds(30, 283, 290, 25);
		employeesLeft.add(txtEmployeeRelatedProject);
		
		JComboBox dropEmployeeQualified = new JComboBox();
		dropEmployeeQualified.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		dropEmployeeQualified.setBackground(new Color(255, 255, 255));
		dropEmployeeQualified.setBounds(30, 222, 290, 25);
		employeesLeft.add(dropEmployeeQualified);
		
		JPanel btnEmployeeCreate = new JPanel();
		btnEmployeeCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnEmployeeCreate.setBackground(new Color(33, 27, 56));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEmployeeCreate.setBackground(new Color(47, 39, 76));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				createEmployee();
			}
		});
		btnEmployeeCreate.setLayout(null);
		btnEmployeeCreate.setBackground(new Color(47, 39, 76));
		btnEmployeeCreate.setBounds(104, 470, 140, 50);
		employeesLeft.add(btnEmployeeCreate);
		
		JLabel lblEmployeeCreate = new JLabel("Create");
		lblEmployeeCreate.setForeground(Color.WHITE);
		lblEmployeeCreate.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEmployeeCreate.setBounds(43, 18, 54, 15);
		btnEmployeeCreate.add(lblEmployeeCreate);
		
		JPanel employeesRight = new JPanel();
		employeesRight.setBackground(Color.WHITE);
		employeesRight.setBounds(350, 50, 500, 550);
		employeesPanel.add(employeesRight);
		
		scenariosPanel = new JPanel();
		layeredPane.add(scenariosPanel, "name_3224266333301");
		scenariosPanel.setLayout(null);
		
		JPanel scenariosTop = new JPanel();
		scenariosTop.setBackground(new Color(47, 39, 76));
		scenariosTop.setBounds(0, 0, 850, 50);
		scenariosPanel.add(scenariosTop);
		
		JPanel scenariosLeft = new JPanel();
		scenariosLeft.setForeground(Color.WHITE);
		scenariosLeft.setBackground(new Color(146, 115, 195));
		scenariosLeft.setBounds(0, 50, 350, 550);
		scenariosPanel.add(scenariosLeft);
		scenariosLeft.setLayout(null);
		
		JLabel lblNewScenario = new JLabel("New Scenario");
		lblNewScenario.setForeground(Color.WHITE);
		lblNewScenario.setFont(new Font("Roboto", Font.PLAIN, 24));
		lblNewScenario.setBounds(30, 11, 165, 50);
		scenariosLeft.add(lblNewScenario);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.WHITE);
		separator_4.setBounds(30, 59, 165, 2);
		scenariosLeft.add(separator_4);
		
		JLabel lblScenarioName = new JLabel("Name");
		lblScenarioName.setForeground(Color.WHITE);
		lblScenarioName.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblScenarioName.setBounds(30, 75, 150, 20);
		scenariosLeft.add(lblScenarioName);
		
		txtScenarioName = new JTextField();
		txtScenarioName.setForeground(new Color(47, 39, 76));
		txtScenarioName.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtScenarioName.setColumns(10);
		txtScenarioName.setBounds(30, 100, 290, 25);
		scenariosLeft.add(txtScenarioName);
		
		JLabel lblScenarioRelatedProject = new JLabel("Related Project");
		lblScenarioRelatedProject.setForeground(Color.WHITE);
		lblScenarioRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblScenarioRelatedProject.setBounds(30, 136, 150, 20);
		scenariosLeft.add(lblScenarioRelatedProject);
		
		txtScenarioRelatedProject = new JTextField();
		txtScenarioRelatedProject.setForeground(new Color(47, 39, 76));
		txtScenarioRelatedProject.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtScenarioRelatedProject.setColumns(10);
		txtScenarioRelatedProject.setBounds(30, 161, 290, 25);
		scenariosLeft.add(txtScenarioRelatedProject);
		
		JPanel btnScenarioCreate = new JPanel();
		btnScenarioCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnScenarioCreate.setBackground(new Color(33, 27, 56));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnScenarioCreate.setBackground(new Color(47, 39, 76));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				createScenario();
			}
		});
		btnScenarioCreate.setLayout(null);
		btnScenarioCreate.setBackground(new Color(47, 39, 76));
		btnScenarioCreate.setBounds(104, 470, 140, 50);
		scenariosLeft.add(btnScenarioCreate);
		
		JLabel lblScenarioCreate = new JLabel("Create");
		lblScenarioCreate.setForeground(Color.WHITE);
		lblScenarioCreate.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblScenarioCreate.setBounds(43, 18, 54, 15);
		btnScenarioCreate.add(lblScenarioCreate);
		
		JPanel scenariosRight = new JPanel();
		scenariosRight.setBackground(Color.WHITE);
		scenariosRight.setBounds(350, 50, 500, 550);
		scenariosPanel.add(scenariosRight);
		
		
		setLocationRelativeTo(null);
		connect = DbConnect.dbconnect();
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
	
	private void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	//new project
	public void createProject() {
		
		String sql = "Insert into projects(name,duration,budget,timecontingencybudget,costcontingencybudget) values(?,?,?,?,?)";
		
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, txtProjectName.getText());
			pst.setDouble(2, Double.parseDouble(txtProjectDuration.getText()));
			pst.setDouble(3, Double.parseDouble(txtProjectBudget.getText()));
			pst.setDouble(4, Double.parseDouble(txtProjectTimeBudget.getText()));
			pst.setDouble(5, Double.parseDouble(txtProjectCostBudget.getText()));
			
			pst.execute();
		}
		catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}
	
	
	//new activity
	public void createActivity() {
		
		String sql = "Insert into activities(label,estimatedtime,estimatedcost,projectid) values(?,?,?,?)";
		
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, txtActivityLabel.getText());
			pst.setInt(2, Integer.parseInt(txtActivityEstimatedTime.getText()));
			pst.setDouble(3, Double.parseDouble(txtActivityEstimatedCost.getText()));
			pst.setInt(4, Integer.parseInt(txtActivityRelatedProject.getText()));
			
			pst.execute();
		}
		catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}
	
	
	//new risk
	public void createRisk() {
			
		String sql = "Insert into risks(name,costprobability,timeprobability,costimpact,timeimpact,totalriskexposure,projectid) values(?,?,?,?,?,?,?)";
			
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, txtRiskName.getText());
			pst.setDouble(2, Double.parseDouble(txtRiskCostProbability.getText()));
			pst.setDouble(3, Double.parseDouble(txtRiskTimeProbability.getText()));
			pst.setInt(4, Integer.parseInt(txtRiskCostImpact.getText()));
			pst.setInt(5, Integer.parseInt(txtRiskTimeImpact.getText()));
			pst.setDouble(6, Double.parseDouble(txtRiskTotalRiskExposure.getText()));
			pst.setInt(7, Integer.parseInt(txtRiskRelatedProject.getText()));
			
			pst.execute();
		}
		catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}
		
		
	//new employee
	public void createEmployee() {
		
		String sql = "Insert into employees(name,speciality,qualified,projectid) values(?,?,?,?)";
		
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, txtEmployeeName.getText());
			pst.setString(2, txtEmployeeSpeciality.getText());
			pst.setBoolean(3, Boolean.parseBoolean(dropEmployeeQualified.getText()));
			pst.setInt(4, Integer.parseInt(txtEmployeeRelatedProject.getText()));
			
			pst.execute();
		}
		catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}
	
	//new scenario
		public void createScenario() {
			
			String sql = "Insert into scenarios(name,projectid) values(?,?)";
			
			try {
				pst = connect.prepareStatement(sql);
				pst.setString(1, txtScenarioName.getText());
				pst.setInt(2, Integer.parseInt(txtScenarioRelatedProject.getText()));
				
				pst.execute();
			}
			catch (SQLException error) {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	
}
