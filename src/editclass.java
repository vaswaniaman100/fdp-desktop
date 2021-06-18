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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;
import java.sql.*;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;

public class editclass extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField search;
	private JTextField textField_6;
	private JTextField id;
	static editclass dialog;
	private JComboBox fname;
	JComboBox year;
	int b;
	 Connection con;
     Statement stmt;
     ResultSet rs = null;
     private JTextField fdpid;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			 dialog = new editclass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void exportTable(JTable table, File file) throws IOException {
	            TableModel model = table.getModel();
	            FileWriter out = new FileWriter(file);
	            for(int i=0; i < model.getColumnCount(); i++) {
	        out.write(model.getColumnName(i) + "\t");
	            }
	            out.write("\n");

	            for(int i=0; i< model.getRowCount()-1; i++) {
	        for(int j=0; j < model.getColumnCount(); j++) {
	        	System.out.println(i+" " +j);
	            out.write(model.getValueAt(i,j).toString()+"\t");
	            }
	            out.write("\n");
	        }

	        out.close();
	        System.out.println("write out to: " + file);
	}
	/**
	 * Create the dialog.
	 */
	public editclass() {
		setBounds(100, 100, 1522, 1027);
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
		lblPhoneNumber.setBounds(32, 366, 225, 65);
		contentPanel.add(lblPhoneNumber);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField.setBounds(349, 262, 383, 65);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(40, 262, 156, 65);
		contentPanel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_1.setColumns(10);
		textField_1.setBounds(349, 366, 383, 65);
		contentPanel.add(textField_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblEmail.setBounds(32, 473, 225, 65);
		contentPanel.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_2.setColumns(10);
		textField_2.setBounds(349, 473, 383, 65);
		contentPanel.add(textField_2);
		
		JLabel lblCollegeName = new JLabel("College Name");
		lblCollegeName.setHorizontalAlignment(SwingConstants.LEFT);
		lblCollegeName.setForeground(Color.BLACK);
		lblCollegeName.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblCollegeName.setBounds(32, 577, 225, 65);
		contentPanel.add(lblCollegeName);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_3.setColumns(10);
		textField_3.setBounds(349, 577, 383, 65);
		contentPanel.add(textField_3);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblAddress.setBounds(32, 679, 225, 65);
		contentPanel.add(lblAddress);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.BOLD, 29));
		textField_4.setColumns(10);
		textField_4.setBounds(349, 679, 383, 65);
		contentPanel.add(textField_4);
	      
	        
	        JLabel lblAreaOfInteres = new JLabel("Area of Interest");
	        lblAreaOfInteres.setHorizontalAlignment(SwingConstants.LEFT);
	        lblAreaOfInteres.setForeground(Color.BLACK);
	        lblAreaOfInteres.setFont(new Font("Tahoma", Font.BOLD, 29));
	        lblAreaOfInteres.setBounds(32, 782, 235, 65);
	        contentPanel.add(lblAreaOfInteres);
	        
	        textField_5 = new JTextField();
	        textField_5.setFont(new Font("Tahoma", Font.BOLD, 29));
	        textField_5.setColumns(10);
	        textField_5.setBounds(349, 782, 383, 65);
	        contentPanel.add(textField_5);
	        
	        JButton btnNewButton = new JButton("Update");
	      
	        btnNewButton.addActionListener(new ActionListener() {
	        	private BigInteger phonevalidation;

				public void actionPerformed(ActionEvent e) {
	        		
	        		  
	        		try {
	        			Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
		        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
		        		Statement stmt=con.createStatement();  
		        		phonevalidation = new BigInteger(textField_1.getText());
		        		   if(textField_1.getText().length()==10)
		        		   {
		        			   if(!id.getText().equals(""))
		        			   {
		        				   String query;
		        			   query="update fdp set name = '"+textField.getText()+"',"
		        			   		+ " PHONE= '"+textField_1.getText()+"' , EMAIL = '"+textField_2.getText()+"', CNAME = "
		        			   				+ "'"+textField_3.getText()+"', ADDRESS = '"+textField_4.getText()+"',"
		        			   						+ " AOI = '"+textField_5.getText()+"',fdpid = "+Integer.parseInt(fdpid.getText())+" where id = "+Integer.parseInt(id.getText());
		        			   
		        			
		        			 stmt.executeUpdate(query);
		        			 JOptionPane.showMessageDialog(contentPanel, "User updated");
		        			 dialog.dispose();
		        			   }
		        			   else
			        		   {
			        			   System.out.println("notnot");
			        		
			        		   }
		        			   
		        		   }
		        		   else
		        		   {
		        			   System.out.println("notnot");
		        		
		        		   }
		        		
		               
		                
		        		   
	        		
	        	}catch(Exception ex)
	        		{}
				}
	        });
	        btnNewButton.setForeground(Color.BLACK);
	        btnNewButton.setBackground(new Color(248, 248, 255));
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        btnNewButton.setBounds(767, 672, 193, 52);
	        contentPanel.add(btnNewButton);
	        
	        
	       
	       
	        
	      
	        
	        table = new JTable()
	        {
	        	 public boolean editCellAt(int row, int column, java.util.EventObject e) {
	                 return false;
	              }
	        };
	       
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) 
	        	{
	        		int row = table.getSelectedRow(); int col = 0;
	        		String str =String.valueOf(table.getValueAt(row,col));
	        	    id.setText(str);
	        	    col = 1;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField.setText(str);
		        	col = 2;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_1.setText(str);
		        	col = 3;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_2.setText(str);
		        	col = 4;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_3.setText(str);
		        	col = 5;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_4.setText(str);
		        	col = 6;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_5.setText(str);
		        	col = 7;
		        	str =String.valueOf(table.getValueAt(row,col));
		        	textField_6.setText(str);
		        	col = 8;
		        	str = String.valueOf(table.getValueAt(row,col));
		        	fdpid.setText(str);
		        	
	        	}
	        });
	        
	       
	        
	        search = new JTextField();
	        search.setBounds(1166, 36, 116, 22);
	        contentPanel.add(search);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(744, 67, 647, 585);
	        
	        contentPanel.add(scrollPane);
	        
	        JLabel lblDateOfRegistration = new JLabel("Date of Registration");
	        lblDateOfRegistration.setHorizontalAlignment(SwingConstants.LEFT);
	        lblDateOfRegistration.setForeground(Color.BLACK);
	        lblDateOfRegistration.setFont(new Font("Tahoma", Font.BOLD, 29));
	        lblDateOfRegistration.setBounds(33, 892, 300, 65);
	        contentPanel.add(lblDateOfRegistration);
	        
	        textField_6 = new JTextField();
	        textField_6.setEditable(false);
	        textField_6.setFont(new Font("Tahoma", Font.BOLD, 29));
	        textField_6.setColumns(10);
	        textField_6.setBounds(349, 892, 383, 65);
	        contentPanel.add(textField_6);
	        
	        JLabel lblNewLabel_2 = new JLabel("search name");
	        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        lblNewLabel_2.setForeground(Color.BLACK);
	        lblNewLabel_2.setBounds(1015, 39, 116, 16);
	        contentPanel.add(lblNewLabel_2);
	        
	        id = new JTextField();
	        id.setVisible(false);
	        id.setBounds(279, 1, 116, 22);
	        contentPanel.add(id);
	        id.setColumns(10);
	        
	        JButton btnDelete = new JButton("Delete");
	        btnDelete.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
	        		try {
	        			Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
		        		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
		        		Statement stmt=con.createStatement();  
		        	
		        				   String query;
		        			   query="delete from fdp where id = "+Integer.parseInt(id.getText());
		        			   
		        			
		        			 stmt.executeUpdate(query);
		        			 JOptionPane.showMessageDialog(contentPanel, "User deleted");
		        			 dialog.dispose();
		        			  
		        		
		               
		                
		        		   
	        		
	        	}catch(Exception ex)
	        		{}
	        	}
	        });
	        btnDelete.setForeground(Color.BLACK);
	        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        btnDelete.setBackground(new Color(248, 248, 255));
	        btnDelete.setBounds(972, 677, 186, 43);
	        contentPanel.add(btnDelete);
	        
	        JButton printbutton = new JButton("Print");
	        printbutton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		
	        		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
	        		   LocalDateTime now = LocalDateTime.now();  
	        		   System.out.println(dtf.format(now));  
	        		 MessageFormat f = new MessageFormat("Available Books in Library");
	                    Printable printable = table.getPrintable(
	                            JTable.PrintMode.NORMAL,
	                            new MessageFormat("F.D.P Registrations "),
	                            new MessageFormat("page no{0}                                       date "+dtf.format(now)));
	                    PrinterJob job = PrinterJob.getPrinterJob();
	                    PageFormat u = new PageFormat();
	                    
	                    u.setOrientation(PageFormat.LANDSCAPE);
	                    job.setPrintable(printable, u);
	                    if (job.printDialog()) {
	                    	try {
	                    		job.print();
	                    	} 
	                    	catch (PrinterException e) {
	        						// TODO Auto-generated catch block
	        						e.printStackTrace();
	        					}
	                            }
	        	}
	                   
						
						
					
	        	
	        });
	        printbutton.setForeground(Color.BLACK);
	        printbutton.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        printbutton.setBackground(new Color(248, 248, 255));
	        printbutton.setBounds(1166, 677, 186, 43);
	        contentPanel.add(printbutton);
	        
	        fname = new JComboBox();
	        fname.addItemListener(new ItemListener() {
	        	public void itemStateChanged(ItemEvent arg0) {
	        		
	        		try{ 
	     	    	   Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
	     	    		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
	     	    		 stmt=con.createStatement();
	     	    		 ResultSet rs1 = stmt.executeQuery("select * from fdpcreation where year = "+Integer.parseInt(year.getSelectedItem().toString())+" and name = '"+fname.getSelectedItem().toString()+"'");	        	
	     	    		 while(rs1.next())
	     	        		{
	     	        			b=rs1.getInt(1);
	     	        		}
	     	    		 System.out.println(b);
	     	    		rs = stmt.executeQuery("select * from fdp where fdpid = "+b+" order by id asc");
	     	    		
	     	    		
	     	    		
	     	    				table.setModel(DbUtils.resultSetToTableModel(rs));
	     	    				 table.getColumnModel().getColumn(0).setMinWidth(0);
	     		     	        table.getColumnModel().getColumn(0).setMaxWidth(0);
	     		     	        table.getColumnModel().getColumn(0).setWidth(0);
	     		     	         table.getColumnModel().getColumn(8).setMinWidth(0);
	     		     	        table.getColumnModel().getColumn(8).setMaxWidth(0);
	     		     	        table.getColumnModel().getColumn(8).setWidth(0);
	     		     	        table.getColumnModel().getColumn(5).setMinWidth(0);
	     		     	        table.getColumnModel().getColumn(5).setMaxWidth(0);
	     		     	        table.getColumnModel().getColumn(5).setWidth(0);
	     		     	        table.getColumnModel().getColumn(4).setMinWidth(0);
	     		     	        table.getColumnModel().getColumn(4).setMaxWidth(0);
	     		     	        table.getColumnModel().getColumn(4).setWidth(0);
	     		     	       
	     		     	       /*
	     		     	        table.getColumnModel().getColumn(6).setMinWidth(0);
	     		     	        table.getColumnModel().getColumn(6).setMaxWidth(0);
	     		     	        table.getColumnModel().getColumn(6).setWidth(0);*/
	     		     	        table.setAutoResizeMode(WIDTH);
	     		     	        table.setCellSelectionEnabled(false);
	     		     	        table.setRowSelectionAllowed(true);
	     		     	        table.setColumnSelectionAllowed(false);
	     		     	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	     		     	        DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
	     		     	        cell.setHorizontalAlignment(SwingConstants.CENTER);
	     		     	        table.getColumnModel().getColumn(7).setHeaderValue("DATE");
	     		     	        
	     		     	        table.getColumn("NAME").setCellRenderer(cell);
	     		     	        table.getColumn("PHONE").setCellRenderer(cell);
	     		     	        table.getColumn("EMAIL").setCellRenderer(cell);
	     		     	        table.getColumn("AOI").setCellRenderer(cell);
	     		     	        table.getColumn("DATE").setCellRenderer(cell);

	     		   	        TableRowSorter sorter = new TableRowSorter(table.getModel());
	     		    	        table.setRowSorter(sorter);
	     		   	         
	     		   	        search.setColumns(10);
	     		   	        try{
	     		   		        search.getDocument().addDocumentListener(new DocumentListener(){

	     		   		            @Override
	     		   		            public void insertUpdate(DocumentEvent e) {
	     		   		                String text = search.getText();

	     		   		                if (text.trim().length() == 0) {
	     		   		                    sorter.setRowFilter(null);
	     		   		                } else {
	     		   		                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,1));
	     		   		                    
	     		   		                }
	     		   		            }

	     		   		            @Override
	     		   		            public void removeUpdate(DocumentEvent e) {
	     		   		                String text = search.getText();

	     		   		                if (text.trim().length() == 0) {
	     		   		                    sorter.setRowFilter(null);
	     		   		                } else {
	     		   		                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,1));
	     		   		                }
	     		   		            }

	     		   		            @Override
	     		   		            public void changedUpdate(DocumentEvent e) {
	     		   		                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	     		   		            }
	     		   		            


	     		   		        });
	     		   		        }catch(Exception e){}
	     		   		           
	     		   	        table.setFont(new Font("Serif", Font.PLAIN, 12));
	     		   	        table.getTableHeader().setFont(new Font("Serif", Font.PLAIN, 12));
	     		   	        
	     		   	        
	     	    			
	     	    		
	     	    		
	     	       }
	     	       catch(Exception e)
	     	       {
	     	    	   e.printStackTrace();
	     	       }
	        		 
	        		  
	     	       
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        	}
	        });
	        fname.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        fname.setBounds(349, 146, 383, 65);
	        contentPanel.add(fname);
	        
	     year = new JComboBox();
	        year.setFont(new Font("Tahoma", Font.PLAIN, 29));
	        year.setBounds(349, 36, 383, 65);
	        contentPanel.add(year);
	     
	        try
	        {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");  	        		 
	         con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","project","1234");   
	        stmt=con.createStatement();
	        	rs = stmt.executeQuery("select distinct year from FDPCREATION");
	        	int i = 0;
	        	while(rs.next())
	        	{
	        		System.out.println(rs.getInt(1));
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
	        			 fname.removeAllItems();;
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
	        
	        JLabel label = new JLabel("year");
	        label.setHorizontalAlignment(SwingConstants.LEFT);
	        label.setForeground(Color.BLACK);
	        label.setFont(new Font("Tahoma", Font.BOLD, 29));
	        label.setBounds(40, 38, 156, 65);
	        contentPanel.add(label);
	        
	        JLabel label_1 = new JLabel("fdp name");
	        label_1.setHorizontalAlignment(SwingConstants.LEFT);
	        label_1.setForeground(Color.BLACK);
	        label_1.setFont(new Font("Tahoma", Font.BOLD, 29));
	        label_1.setBounds(40, 146, 156, 65);
	        contentPanel.add(label_1);
	        
	        fdpid = new JTextField();
	        fdpid.setVisible(false);
	        fdpid.setBounds(458, 1, 76, 22);
	        contentPanel.add(fdpid);
	        fdpid.setColumns(10);
	        

	        JLabel lblNewLabel_1 = new JLabel("");
	        contentPanel.add(lblNewLabel_1);
	        lblNewLabel_1.setBounds(0, 0,this.getWidth() , this.getHeight());
	        ImageIcon icon = new ImageIcon(getClass().getResource("dbms.jpg"));
	        Image img = icon.getImage() ;
	       
	        
		        Image newimg = img.getScaledInstance( lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;
		        icon = new ImageIcon( newimg );
		        lblNewLabel_1.setIcon(icon);
		        new Thread()
        		{
        			public void run()
        			{
        				TableColumnModel columnmodel = table.getColumnModel();
    	        		TableModel tm = table.getModel();
    	        		int total =columnmodel.getColumnCount();
    	        		for(int i =0;i<total;i++)
    	        		{
    	        			int taille=0;
    	        			int total2 = tm.getRowCount();
    	        			for(int j =0;j<total2;j++)
    	        			{
    	        				if(tm.getValueAt(j, i)!=null)
    	        				{
    	        					int taille2 = tm.getValueAt(j, i).toString().length()*10;
    	        					if(taille2>taille)
    	        					{
    	        						taille=taille2;
    	        					}
    	        				}columnmodel.getColumn(i).setPreferredWidth(taille);
    	        			}
    	        		}
    	        		
        			}
        		}.start();
	      
	   
	}
}
