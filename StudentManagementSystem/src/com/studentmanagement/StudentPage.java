package com.studentmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

public class StudentPage extends JFrame {

	private JPanel contentPane;
	private JTextField RollTxt;
	private JLabel lblEnterName;
	private JTextField NameTxt;
	private JLabel lblEnterGrades;
	private JTextField GradeTxt;
	private JLabel lblAddress;
	private JTextField PhoneTxt;
	private JTable table;
	private JScrollPane scrollPane;
	DefaultTableModel model;
	private JButton btnShowData;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public StudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DataBase db = new DataBase();
		
		contentPane = new JPanel();
		
		JLabel l1 = new JLabel("STUDENT MANAGEMENT SYSTEM");
		l1.setFont(new Font("Agency FB", Font.BOLD, 40));
		l1.setHorizontalAlignment(SwingConstants.CENTER);
	
		l1.setBounds(585, 32, 535, 69);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Roll Number");
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Times in new Roman",Font.PLAIN,15));
		l2.setBounds(33, 159, 169, 43);
		contentPane.add(l2);
		
		JTextArea AddressTxt = new JTextArea();
		AddressTxt.setFont(new Font("Monospaced", Font.PLAIN, 16));
		AddressTxt.setBounds(765, 255, 569, 83);
		contentPane.add(AddressTxt);
		
		RollTxt = new JTextField();
		RollTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		RollTxt.setBounds(212, 159, 120, 43);
		contentPane.add(RollTxt);
		RollTxt.addKeyListener(new KeyAdapter() {
			String name,phone,grade,address;
			
                 public void keyTyped(KeyEvent e) {
		    	
		    	char c = e.getKeyChar();
		    	if(Character.isDigit(c)) {
		    		RollTxt.setEditable(true);
					
				}else {
					
					if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE || e.getKeyChar()==KeyEvent.VK_DELETE) {
						RollTxt.setEditable(true);		
						
					}
					else {
						e.consume();
					}}
				}
			public void keyReleased(KeyEvent e) {
				
				
				try {
					
					DataBase db = new DataBase();
					DataBase.Connect();
					
					 String rollnum = RollTxt.getText().trim().toString();
					String query = "Select * from register where Roll = '"+rollnum+"'";
					java.sql.PreparedStatement ps = DataBase.Con.prepareStatement(query);
					java.sql.ResultSet  rs = ps.executeQuery();				
				
					while(rs.next()) {
						 name = rs.getString("Name");
						 grade = rs.getString("Grade");
						 phone = rs.getString("Phone");
						 address = rs.getString("Address");

					}
					NameTxt.setText(name);
					PhoneTxt.setText(phone);
					GradeTxt.setText(grade);
					AddressTxt.setText(address);
					
					DataBase.Con.close();
				}catch(Exception e1) {
					e1.printStackTrace();
					
				}
				
			}
			
			
		});
		RollTxt.setColumns(10);
		
		contentPane.setBackground(Color.GRAY);
		
		lblEnterName = new JLabel("Enter Name ");
		lblEnterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterName.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEnterName.setBounds(431, 159, 169, 43);
		contentPane.add(lblEnterName);
		
		NameTxt = new JTextField();
		NameTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		NameTxt.setColumns(10);
		NameTxt.setBounds(617, 159, 393, 43);
		NameTxt.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				 int len = RollTxt.getText().length();
			        char c = e.getKeyChar();

			        
			        if (Character.isDigit(c)) {
			            if (len < 4) {
			            	RollTxt.setEditable(true);
			            } else {
			                e.consume();
			            }
			        } else {
			            
			            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE) {
			            	RollTxt.setEditable(true);
			            } else {
			                e.consume(); 
			            }
			        }}
			
			
				public void keyTyped(KeyEvent e) {
			        char c = e.getKeyChar();

			        if (Character.isLetter(c) || c == ' ') {
			            NameTxt.setEditable(true);
			        } else {
			            if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE || e.getKeyChar() == KeyEvent.VK_DELETE) {
			                NameTxt.setEditable(true);
			            } else {
			                e.consume();
			            }
			        }
			}
		});
		contentPane.add(NameTxt);
		
		lblEnterGrades = new JLabel("Enter Grades");
		lblEnterGrades.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterGrades.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEnterGrades.setBounds(1075, 159, 169, 43);
		
		contentPane.add(lblEnterGrades);
		
		GradeTxt = new JTextField();
		GradeTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GradeTxt.setColumns(10);
		GradeTxt.setBounds(1256, 159, 78, 43);
		contentPane.add(GradeTxt);
		
		lblAddress = new JLabel("Address");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblAddress.setBounds(586, 282, 169, 43);
		contentPane.add(lblAddress);
		
		
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(33, 268, 169, 43);
		contentPane.add(lblPhoneNumber);
		
		PhoneTxt = new JTextField();
		PhoneTxt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		PhoneTxt.setColumns(10);
		PhoneTxt.setBounds(193, 282, 306, 43);
		PhoneTxt.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		    	
		    	int len = PhoneTxt.getText().length();
		    	char c = e.getKeyChar();
		    	if(Character.isDigit(c)) {
					if(len<10) {
						PhoneTxt.setEditable(true);
					}
					else {
						e.consume();
					}
					
				}else {
					
					if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE || e.getKeyChar()==KeyEvent.VK_DELETE) {
						PhoneTxt.setEditable(true);		
						
					}
					else {
						e.consume();
					}
					
				}
		    }
		        
		});

		
		
		contentPane.add(PhoneTxt);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 415, 1184, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		final Object [] row = new Object[100];
		Object [] Column = {"Roll", "Name","Grade","Phone","Address"};
		model.setColumnIdentifiers(Column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdd.setBounds(364, 744, 154, 51);
		btnAdd.setBackground(Color.GREEN);
		btnAdd.setBorderPainted(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(PhoneTxt.getText().trim().isEmpty()||
						NameTxt.getText().trim().isEmpty()||
						GradeTxt.getText().trim().isEmpty()||
						RollTxt.getText().trim().isEmpty()||
						AddressTxt.getText().trim().isEmpty()||PhoneTxt.getText().length()!=10) {
				
				JOptionPane.showMessageDialog(null, "Fill All Details");
				}else {
					
				try {
				
				DataBase.Connect();
				
				String Name = NameTxt.getText();
				String Roll = RollTxt.getText();
				String Grade = GradeTxt.getText();
				String Phone = PhoneTxt.getText();
				String Address = AddressTxt.getText();
				
				String Query = "INSERT INTO register(`Roll`, `Name`, `Phone`, `Grade`, `address`) VALUES ('"+Roll+"','"+Name+"','"+Phone+"','"+Grade+"','"+Address+"')";
				
				
					Statement  stmt = DataBase.Con.createStatement();
					boolean rs = stmt.execute(Query);
					
					if(!rs) {
						JOptionPane.showMessageDialog(null, "Data Stored Successfully");
						row[0]=Roll;
						row[1]=Name;
						row[2]=Grade;
						row[3]=Phone;
						row[4]=Address;
						model.addRow(row);
						NameTxt.setText("");
						RollTxt.setText("");
						PhoneTxt.setText("");
						GradeTxt.setText("");
						AddressTxt.setText("");
						
					}else {
						JOptionPane.showMessageDialog(null, "Error Occured");
					}
					
				}
				catch(MySQLIntegrityConstraintViolationException e2) {
					JOptionPane.showMessageDialog(null, "Data Already Exist!");
					
				}
				catch(Exception e3) {
					e3.printStackTrace();
				}
				}
				
			}
		});
		contentPane.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBounds(655, 744, 154, 51);
		btnUpdate.setBorderPainted(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Update = "UPDATE register SET `Name`='"+NameTxt.getText()+"',`Phone`='"+PhoneTxt.getText()+"',`Grade`='"+GradeTxt.getText()+"',`address`='"+AddressTxt.getText()+"' WHERE roll = '"+RollTxt.getText()+"'";
				
				int i =table.getSelectedRow();
				if(i==-1 && RollTxt.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Select Row Or Enter Roll number");

				}else {
				
					try {
					    DataBase.Connect();
					    java.sql.PreparedStatement ps = DataBase.Con.prepareStatement(Update);

					    int res = ps.executeUpdate();

					    if(res > 0) {
					        model.setValueAt(NameTxt.getText(), i, 1);
					        model.setValueAt(GradeTxt.getText(), i, 2);
					        model.setValueAt(PhoneTxt.getText(), i, 3);
					        model.setValueAt(AddressTxt.getText(), i, 4);
					        JOptionPane.showMessageDialog(null, "Data Updated");
					    } else {
					        JOptionPane.showMessageDialog(null, "Error While Updating or Record Is not Exist");
					    }
					} catch(Exception e12) {
					    e12.printStackTrace();
					}}
}
		});
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDelete.setBounds(938, 744, 154, 51);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int i = table.getSelectedRow();	
				
				if(i== -1 && RollTxt.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Select row or Type Roll Number ");
				}
				else {
					
					String rollnum = (String)table.getValueAt(i,0);
					String ROll = RollTxt.getText();
					String Query = "DELETE FROM `register` WHERE roll='"+ROll+"'OR roll='"+rollnum+"'";
					
					try {
						DataBase.Connect();
						
						Statement st = DataBase.Con.createStatement();
						Boolean res = st.execute(Query);
						
						if(!res) {
							JOptionPane.showMessageDialog(null,"Data Deleted");
							model.removeRow(i);
						}
						else {
							JOptionPane.showMessageDialog(null,"Error Occures");

						}
						
						
					}catch(Exception e10) {
						e10.printStackTrace();
					}
					
				
			}}

			
		});
		contentPane.add(btnDelete);
		
		
		JButton btnShow = new JButton("SHOW DATA");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					DataBase.Connect();
					Statement ps = DataBase.Con.createStatement();
					String Query = "Select * from register";
					ResultSet rs = ps.executeQuery(Query);
//					ResultSetMetaData rsmd = rs.getMetaData();
					String name,roll,phone,grade,address;
					while(rs.next()) {
						roll = rs.getString(1);
						name = rs.getString(2);
						grade = rs.getString(4);
						phone = rs.getString(3);
						address = rs.getString(5);
						String[] rows = {roll,name,grade,phone,address};
						model.addRow(rows);
					}
			}catch(Exception e12) {
				e12.printStackTrace();
			}}
		});
		btnShow.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnShow.setBounds(1371, 474, 120, 43);
		contentPane.add(btnShow);
		
		setLocationRelativeTo(null);
		Dimension s = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(s.width, s.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnShowData = new JButton("CLEAR");
		btnShowData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NameTxt.setText("");
				PhoneTxt.setText("");
				AddressTxt.setText("");
				GradeTxt.setText("");
				RollTxt.setText("");
			}
		});
		btnShowData.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnShowData.setBounds(1371, 217, 120, 43);
		contentPane.add(btnShowData);
	}
}
