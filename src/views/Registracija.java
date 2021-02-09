package views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import models.Korisnik;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Registracija extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Registracija(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.SHELL_TRIM);
		shell.setSize(450, 390);
		shell.setText(getText());
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(33, 31, 159, 20);
		lblNewLabel.setText("Korisnicko ime");
		
		Label lblLozinka = new Label(shell, SWT.NONE);
		lblLozinka.setBounds(33, 78, 70, 20);
		lblLozinka.setText("Lozinka");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(262, 38, 149, 26);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(262, 78, 149, 26);
		
		Label lblIme = new Label(shell, SWT.NONE);
		lblIme.setBounds(33, 114, 70, 20);
		lblIme.setText("Ime");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(262, 114, 149, 26);
		
		Label lblPrezime = new Label(shell, SWT.NONE);
		lblPrezime.setBounds(33, 169, 70, 20);
		lblPrezime.setText("Prezime");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(267, 163, 144, 26);
		
		Label lblVrstaKorisnika = new Label(shell, SWT.NONE);
		lblVrstaKorisnika.setBounds(33, 218, 124, 20);
		lblVrstaKorisnika.setText("Vrsta korisnika");
		
		CCombo combo = new CCombo(shell, SWT.BORDER);
		combo.setBounds(267, 218, 144, 25);
		
		
		
		combo.add("Admin");
		combo.add("Registrirani korisnik");
		
		Button btnRegistrirajKorisnika = new Button(shell, SWT.NONE);
		btnRegistrirajKorisnika.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				Korisnik korisnik= new Korisnik();
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/dvukelic","dvukelic","11");
					
					
					
					Statement stmt = con.createStatement();
					String sql = "";
				
					if (combo.getText().equals("Admin")== true)
					{  
						sql="insert into korisnik (username, password, name, lastname, vrsta_id) values ('"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"','"+text_3.getText()+"',1);";
						
					}
					
					else if (combo.getText().equals("Registrirani korisnik")== true)
					{  
						sql="insert into korisnik (username, password, name, lastname, vrsta_id) values ('"+text.getText()+"','"+text_1.getText()+"','"+text_2.getText()+"','"+text_3.getText()+"',2);";
						
					}
					MessageBox dialog =
						    new MessageBox(shell, SWT.ICON_QUESTION | SWT.OK);
						dialog.setText("Registracija");
						dialog.setMessage("Uspjesna registracija!");
						dialog.open();
			
				stmt.executeUpdate(sql);
					
					
					con.close();
					
				}
						catch(Exception f){
						
						System.out.println(f);
				}
			}
		});
		btnRegistrirajKorisnika.setBounds(33, 287, 159, 30);
		btnRegistrirajKorisnika.setText("Registriraj korisnika");
		
		Button btnOdustani = new Button(shell, SWT.NONE);
		btnOdustani.setBounds(271, 287, 90, 30);
		btnOdustani.setText("Odustani");
		
		
		

	}
}
