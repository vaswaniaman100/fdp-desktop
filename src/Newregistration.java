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

public class Newregistration extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	int b;
	private JComboBox year;
	private JComboBox fname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Newregistration dialog = new Newregistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Newregistration() {
		setBounds(100, 100, 1146, 1015);
		contentPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
		contentPanel.setLayout(null);
	
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBackground(new Color(0, 255, 255));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setForeground(Color.BLACK);
		lblPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblPhoneNumber.setBounds(229, 365, 225, 65);
		contentPanel.add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField.setBounds(490, 261, 383, 65);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(229, 261, 156, 65);
		contentPanel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_1.setColumns(10);
		textField_1.setBounds(490, 365, 383, 65);
		contentPanel.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblEmail.setBounds(229, 472, 225, 65);
		contentPanel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_2.setColumns(10);
		textField_2.setBounds(490, 472, 383, 65);
		contentPanel.add(textField_2);
		
		JLabel lblCollegeName = new JLabel("College Name");
		lblCollegeName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCollegeName.setForeground(Color.BLACK);
		lblCollegeName.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblCollegeName.setBounds(229, 576, 225, 65);
		contentPanel.add(lblCollegeName);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_3.setColumns(10);
		textField_3.setBounds(490, 576, 383, 65);
		contentPanel.add(textField_3);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(SystemColor.desktop);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblAddress.setBounds(229, 678, 225, 65);
		contentPanel.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_4.setColumns(10);
		textField_4.setBounds(490, 678, 383, 65);
		contentPanel.add(textField_4);
	      
	        
	        JLabel lblAreaOfInteres = new JLabel("Area of Interest");
	        lblAreaOfInteres.setHorizontalAlignment(SwingConstants.LEFT);
	        lblAreaOfInteres.setForeground(Color.BLACK);
	        lblAreaOfInteres.setFont(new Font("Tahoma", Font.BOLD, 29));
	        lblAreaOfInteres.setBounds(229, 781, 235, 65);
	        contentPanel.add(lblAreaOfInteres);
	        
	        textField_5 = new JTextField();
	        textField_5.setFont(new Font("Tahoma", Font.BOLD, 29));
	        textField_5.setColumns(10);
	        textField_5.setBounds(490, 781, 383, 65);
	        contentPanel.add(textField_5);
	        
	        JButton btnNewButton = new JButton("Register");
	      
	        btnNewButton.addActionListener(new ActionListener() {
	        	private BigInteger phonevalidation;

				public void actionPerformed(ActionEvent e) {
	        		
	        		  
	        		try {
	        			Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
		        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
		        		Statement stmt=con.createStatement();  
						
		        		int a = 0;
		        		ResultSet rs = stmt.executeQuery("select * from fdp order by id asc");
		        		while(rs.next())
		        		{
		        			a=rs.getInt(1);
		        		}
		        		System.out.println(a);
		        		a++;
		        		ResultSet rs1 = stmt.executeQuery("select * from fdpcreation where year = "+Integer.parseInt(year.getSelectedItem().toString())+" and name = '"+fname.getSelectedItem().toString()+"'");
		        		while(rs1.next())
		        		{
		        			b=rs1.getInt(1);
		        		}
		        		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		        		   LocalDateTime now = LocalDateTime.now();  
		        		   System.out.println(dtf.format(now));  
		        		   
		        		   phonevalidation = new BigInteger(textField_1.getText());
		        		   if(textField_1.getText().length()==10)
		        		   {
		               
		                stmt.executeUpdate("insert into fdp values("+a+",'"+textField.getText()+"','"+textField_1.getText()+"','"+
		                        textField_2.getText()+"','"+textField_3.getText()+"','"+textField_4.getText()+"','"+textField_5.getText()+"','"+dtf.format(now)+"',"+b+")");
		        		
		                textField.setText("");
		        		textField_1.setText("");
		        		textField_2.setText("");
		        		textField_3.setText("");
		        		textField_4.setText("");
		        		textField_5.setText("");
		        		JOptionPane.showMessageDialog(contentPanel, "User registered");
		        		   }
		        		   else
		        		   {
		        			   JOptionPane.showMessageDialog(contentPanel, "check phone number");
		        		   }
		        		
		        		
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch(NumberFormatException e1)
	        		{
						JOptionPane.showMessageDialog(contentPanel, "check phone number");
	        		}
	        		
	        	}
	        });
	        btnNewButton.setForeground(Color.BLACK);
	        btnNewButton.setBackground(new Color(248, 248, 255));
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        btnNewButton.setBounds(567, 881, 225, 65);
	        contentPanel.add(btnNewButton);
	        
	        JLabel lblYear = new JLabel("fdp name");
	        lblYear.setHorizontalAlignment(SwingConstants.LEFT);
	        lblYear.setForeground(Color.BLACK);
	        lblYear.setFont(new Font("Tahoma", Font.BOLD, 29));
	        lblYear.setBounds(229, 147, 156, 65);
	        contentPanel.add(lblYear);
	        
	        JLabel lblFdpName = new JLabel("year");
	        lblFdpName.setHorizontalAlignment(SwingConstants.LEFT);
	        lblFdpName.setForeground(Color.BLACK);
	        lblFdpName.setFont(new Font("Tahoma", Font.BOLD, 29));
	        lblFdpName.setBounds(229, 39, 156, 65);
	        contentPanel.add(lblFdpName);
	        
	        fname = new JComboBox();
	        fname.getEditor().getEditorComponent().setBackground(Color.white);
	  
	        fname.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        fname.setBounds(490, 147, 383, 65);
	        contentPanel.add(fname);
	        
	        year = new JComboBox();
	        try
	        {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
	        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
	        	Statement stmt=con.createStatement();
	        	ResultSet rs = stmt.executeQuery("select distinct year from FDPCREATION ");
	        	int i = 0;
	        	while(rs.next())
	        	{
	        		
	        		year.insertItemAt(rs.getInt(1), i);
	        		i++;
	        	}
	        	rs.close();
	        	stmt.close();
	        	con.close();
	        	
	        }
	        catch(Exception e){            }
	        year.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		 try
	     	        {
	     	        	Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
	     	        	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
	     	        	Statement stmt=con.createStatement();
	     	        	System.out.print(Integer.parseInt(year.getSelectedItem().toString()));
	     	        	ResultSet rs = stmt.executeQuery("select * from FDPCREATION where year = "+Integer.parseInt(year.getSelectedItem().toString()));
	     	        	int i = 0;
	     	        	while(rs.next())
	     	        	{	     	        		
	     	        		fname.insertItemAt(rs.getString(2), i);
	     	        		i++;
	     	        	}
	     	        	rs.close();
	    	        	stmt.close();
	    	        	con.close();
	     	        	
	     	        }
	     	        catch(Exception e){            }
	        	}
	        });
	        year.getEditor().getEditorComponent().setBackground(Color.white);
	        year.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        year.setBounds(490, 46, 383, 65);
	        contentPanel.add(year);
	       
	       
	        

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
