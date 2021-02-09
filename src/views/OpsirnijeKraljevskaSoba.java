package views;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;

public class OpsirnijeKraljevskaSoba {
	private static Text txtOpis;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		txtOpis = new Text(shell, SWT.BORDER);
		txtOpis.setText("Opis");
		txtOpis.setBounds(230, 20, 157, 42);
		
		Button btnRezerviraj = new Button(shell, SWT.NONE);
		btnRezerviraj.setBounds(260, 226, 75, 25);
		btnRezerviraj.setText("Rezerviraj");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
