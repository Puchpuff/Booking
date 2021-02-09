package views;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class Ponuda extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Ponuda(Shell parent, int style) {
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
		shell.setSize(601, 564);
		shell.setText(getText());
		
		Label lblWowSoba = new Label(shell, SWT.NONE);
		lblWowSoba.setFont(SWTResourceManager.getFont("Verdana", 9, SWT.NORMAL));
		lblWowSoba.setBounds(317, 10, 106, 15);
		lblWowSoba.setText("WOW soba");
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 118, 575, 2);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(10, 243, 575, -13);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setBounds(0, 399, 585, 2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(-27, 249, 612, 2);
		
		Label lblExtraWowSoba = new Label(shell, SWT.NONE);
		lblExtraWowSoba.setFont(SWTResourceManager.getFont("Verdana", 9, SWT.NORMAL));
		lblExtraWowSoba.setBounds(289, 145, 176, 15);
		lblExtraWowSoba.setText("Extreme WOW soba");
		
		Label lblKraljevskaSoba = new Label(shell, SWT.NONE);
		lblKraljevskaSoba.setFont(SWTResourceManager.getFont("Verdana", 9, SWT.NORMAL));
		lblKraljevskaSoba.setBounds(289, 272, 148, 15);
		lblKraljevskaSoba.setText("Kraljevska soba");
		
		Label lblPresjednikaSoba = new Label(shell, SWT.NONE);
		lblPresjednikaSoba.setFont(SWTResourceManager.getFont("Verdana", 9, SWT.NORMAL));
		lblPresjednikaSoba.setBounds(289, 422, 176, 15);
		lblPresjednikaSoba.setText("Presjedni\u010Dka soba");
		
		Button btnOpirnije = new Button(shell, SWT.NONE);
		btnOpirnije.setBounds(317, 212, 75, 25);
		btnOpirnije.setText("Op\u0161irnije");
		
		Button btnOpirnije_1 = new Button(shell, SWT.NONE);
		btnOpirnije_1.setBounds(316, 343, 75, 25);
		btnOpirnije_1.setText("Op\u0161irnije");
		
		Button btnOpirnije_2 = new Button(shell, SWT.NONE);
		btnOpirnije_2.setBounds(317, 481, 75, 25);
		btnOpirnije_2.setText("Op\u0161irnije");
		
		Button btnOpirnije_3 = new Button(shell, SWT.NONE);
		btnOpirnije_3.setBounds(316, 72, 75, 25);
		btnOpirnije_3.setText("Op\u0161irnije");

	}
}
