package views;

import java.sql.*;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import models.Korisnik;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Prijava {
	private static Text text;
	private static Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(532, 300);
		shell.setText("SWT Application");
		
		Registracija registracija = new Registracija(shell, SWT.APPLICATION_MODAL);
		registracija.open();
		
		text = new Text(shell, SWT.BORDER);
		text.setText("");
		text.setBounds(154, 67, 180, 21);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(154, 130, 180, 21);
		
		Label lblKorisnikoIme = new Label(shell, SWT.NONE);
		lblKorisnikoIme.setBounds(34, 70, 87, 15);
		lblKorisnikoIme.setText("Korisni\u010Dko ime");
		
		Label lblLozinka = new Label(shell, SWT.NONE);
		lblLozinka.setBounds(34, 133, 55, 15);
		lblLozinka.setText("Lozinka");
		
		Button btnPrijava = new Button(shell, SWT.NONE);
		btnPrijava.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Korisnik korisnik= new Korisnik();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/dvukelic","dvukelic","11");
					
					
					
					Statement stmt = con.createStatement();
				
					String sql="select * from korisnik where username='"+text.getText()+"';";
							System.out.println(sql);
					
					
					
					ResultSet rs=stmt.executeQuery("select * from korisnik");
					
					
					
					
					while (rs.next()) {
						
						korisnik.setUsername(rs.getString("username"));
						korisnik.setPassword(rs.getString("password"));
						korisnik.setName(rs.getString("name"));
						korisnik.setLastname(rs.getString("lastname"));
						korisnik.setVrsta_id(rs.getString("vrsta_id"));
					
					}
					
					
					con.close();
					
				}
						catch(Exception f){
						
						System.out.println(f);
				}
				
				if (korisnik.getPassword().equals(text_1.getText())==true) {
					
					MessageBox dialog =
						    new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
						dialog.setText("Prijava");
						dialog.setMessage("Uspjesna prijava!");
						int returnCode = dialog.open();
					
						System.out.println(returnCode);
						
						if (returnCode == 32)  {
							
							Ponuda ponuda = new Ponuda( shell, SWT.APPLICATION_MODAL);
							ponuda.open();
							
							
						}

							
				} else {
					MessageBox dialog =
						    new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
						dialog.setText("Prijava");
						dialog.setMessage("Neuspjesna prijava!");
						dialog.open();
				}
				
			}
			
			
		});
		
		
		btnPrijava.setBounds(200, 164, 75, 25);
		btnPrijava.setText("Prijava");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
