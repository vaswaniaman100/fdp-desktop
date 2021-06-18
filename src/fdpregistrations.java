import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class fdpregistrations extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	int b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			fdpregistrations dialog = new fdpregistrations();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public fdpregistrations() {
		setBounds(100, 100, 969, 534);
		contentPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPanel.setLayout(null);
	
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		
		JLabel lblPhoneNumber = new JLabel("Year");
		lblPhoneNumber.setBackground(new Color(0, 255, 255));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setForeground(Color.BLACK);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblPhoneNumber.setBounds(166, 214, 225, 65);
		contentPanel.add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField.setBounds(427, 110, 383, 65);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Fdp name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(166, 110, 156, 65);
		contentPanel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_1.setColumns(10);
		textField_1.setBounds(427, 214, 383, 65);
		contentPanel.add(textField_1);
	        
	        JButton btnNewButton = new JButton("Register");
	      
	        btnNewButton.addActionListener(new ActionListener() {
	        	

				public void actionPerformed(ActionEvent e) {
	        		
	        		  
	        		try {
	        			Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
		        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
		        		Statement stmt=con.createStatement();  
						
		        		int a = 0;
		        		ResultSet rs = stmt.executeQuery("select * from fdpcreation order by id asc");
		        		while(rs.next())
		        		{
		        			a=rs.getInt(1);
		        		}
		        		System.out.println(a);
		        		a++;
		        	
		        		  
		        		  
		               
		              stmt.executeUpdate("insert into fdpcreation values("+a+",'"+textField.getText()+"',"+Integer.parseInt(textField_1.getText())+")" );
		        		
		                textField.setText("");
		        		textField_1.setText("");
		        		
		        		JOptionPane.showMessageDialog(contentPanel, "program registered");
		        		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	        		
	        	}
	        });
	        btnNewButton.setForeground(Color.BLACK);
	        btnNewButton.setBackground(new Color(248, 248, 255));
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        btnNewButton.setBounds(444, 340, 225, 65);
	        contentPanel.add(btnNewButton);
	       
	        

	        JLabel lblNewLabel_1 = new JLabel("");
	        contentPanel.add(lblNewLabel_1);
	        lblNewLabel_1.setBounds(0, 0,this.getWidth() , this.getHeight());
	        ImageIcon icon = new ImageIcon(getClass().getResource("dbms.jpg"));
	        Image img = icon.getImage() ;
	       
	        
		        Image newimg = img.getScaledInstance( lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
		        icon = new ImageIcon( newimg );
		        lblNewLabel_1.setIcon(icon);
	      
	   
	}
}
