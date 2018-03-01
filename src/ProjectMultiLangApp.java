import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProjectMultiLangApp extends JFrame implements ActionListener {

	JButton apply, login;
	JTextField userName ;JPasswordField password;
	JLabel usern , userp, titl;
	JComboBox<String> box;
	
	
	
	public ProjectMultiLangApp() {
		super.getContentPane().setBackground(Color.PINK);
		super.setTitle("Universal Language Application");
		super.setBounds(100, 100, 500, 500);
		super.setResizable(false);
		//--
		titl = new JLabel("Multi Language Application");
		titl.setBounds(105, 10, 300, 35);
		super.add(titl);
		titl.setFont(new Font("Times New Roman", Font.BOLD,20 ));
		
		
		usern = new JLabel("Username ");
		usern.setBounds(30, 100, 100, 40);
		super.add(usern);
		usern.setFont(new Font("Comic sans", Font.BOLD,17));
		
		
		userName = new JTextField();
		userName.setBounds(150, 100, 200, 35);
		super.add(userName);
		userName.setFont(new Font("Comic sans", Font.BOLD,17));
		
		
		userp = new JLabel("Password ");
		userp.setBounds(30, 170, 100, 40);
		super.add(userp);
		userp.setFont(new Font("Comic sans", Font.BOLD,17));
		
		
		password = new JPasswordField();
		password.setBounds(150, 170, 200, 35);
		super.add(password);
		password.setFont(new Font("Comic sans", Font.BOLD,17));
		
		login = new JButton("Login");
		login.setBounds(150, 250, 150, 35);
		super.add(login);
		login.setFont(new Font("Comic sans", Font.BOLD,17));
		
		
		String [] array = {"Select Language","Hindi","Urdu","German","french"};
		box = new JComboBox<String>(array);
		box.setBounds(150, 310, 200, 30);
		super.add(box);
		box.setFont(new Font("Comic sans", Font.BOLD,15));
		box.addActionListener(this);
		
		//--
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		ProjectMultiLangApp ref = new ProjectMultiLangApp();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==box) {
			String selItem = (String)box.getSelectedItem();
			
			if(selItem.startsWith("Sel")) {
				JOptionPane.showMessageDialog(null, "Please select a language");
			}
			else {
				
				String lang = selItem.toLowerCase();
				String country = "";
				if(lang.equals("hindi")) {
					country = "IN";
					lang = "hi";
					titl.setFont(new Font("", Font.BOLD,25 ));
				}
				if(lang.equals("urdu")) {
					country = "IN";
					lang = "ur";
				}
				
				if(lang.equals("german")) {
					country = "DE";
					lang = "de";
					titl.setFont(new Font("", Font.BOLD,20 ));
				}
				
				if(lang.equals("french")) {
					country="FR";
					lang = "fr";
					usern.setBounds(30, 100, 150, 40);
					userp.setBounds(30, 170, 150, 40);
					
					userName.setBounds(200, 100, 200, 35);
					password.setBounds(200, 170, 200, 35);
					
					login.setBounds(200, 250, 150, 35);
					
					box.setBounds(200, 310, 200, 30);
				}
				
				
				Locale locale = new Locale(lang, country);
				
				ResourceBundle res = ResourceBundle.getBundle("info",locale);
				
				String str1 = res.getString("lbl1.txt");
				String str2 = res.getString("lbl2.txt");
				String str3 = res.getString("lbl3.txt");
				String str4 = res.getString("btn.txt");
				
				
				titl.setText(str1);
				usern.setText(str2);
				userp.setText(str3);
				login.setText(str4);
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
		}
		
	}
}
