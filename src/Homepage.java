import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Dialog.ModalityType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.Font;

public class Homepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		setBounds(0, 0,(int) this.getToolkit().getScreenSize().getWidth(), (int)this.getToolkit().getScreenSize().getHeight());
	//	setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null); 
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBackground(new Color(245, 255, 250));
		menuBar.setBorder(null);
		setJMenuBar(menuBar);
		
		JMenu mnRegistration = new JMenu("Registration");
		mnRegistration.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnRegistration.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnRegistration.setIconTextGap(1);
		mnRegistration.setBackground(Color.WHITE);
		menuBar.add(mnRegistration);
		mnRegistration.setIcon(new ImageIcon(getClass().getResource("registration.jpg")));
		
		JMenuItem newregistration = new JMenuItem("New registration");
		
		newregistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
			        Newregistration dialog = new Newregistration();
			        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        dialog.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
			}
		);
		
		mnRegistration.add(newregistration);
		newregistration.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
		
		JMenuItem mntmFdpRegistration = new JMenuItem("Fdp registration");
		mntmFdpRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
			        fdpregistrations dialog = new fdpregistrations();
			        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        dialog.setVisible(true);
			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
		});
		mnRegistration.add(mntmFdpRegistration);
		
		JMenu mnUser = new JMenu("User");
		mnUser.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		menuBar.add(mnUser);
		mnUser.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		mnUser.setIcon(new ImageIcon(getClass().getResource("viewicon.jpg")));
		
		
		JMenuItem mntmViewEdit = new JMenuItem("View / Edit /delete");
		mntmViewEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 editclass dialog = new editclass();
			        dialog.setModalityType(ModalityType.APPLICATION_MODAL);
			        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        dialog.setVisible(true);
			}
		});
		mntmViewEdit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
		mnUser.add(mntmViewEdit);
		
		
		JMenu mnNewMenu = new JMenu("exit");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		mnNewMenu.setActionCommand("exit");
		mnNewMenu.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
		mnNewMenu.setIcon(new ImageIcon(getClass().getResource("exit.png")));
		mnNewMenu.add(mntmExit);
	
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(23, 90, 547, 341);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(0, 0,this.getWidth() , this.getHeight());
	        ImageIcon icon = new ImageIcon(getClass().getResource("db.png"));
	        Image img = icon.getImage() ;
	        Image newimg = img.getScaledInstance( lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
	        icon = new ImageIcon( newimg );
	        lblNewLabel_1.setIcon(icon);
	
		
	}
}
