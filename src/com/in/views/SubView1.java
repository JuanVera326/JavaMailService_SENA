package com.in.views;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.in.controller.Controller;

public class SubView1{

	
	private JFileChooser choose;
	private Controller controller;
	
	
	public SubView1() { choose = new JFileChooser(); }
	
	public String getFile(int opc) {
		
		FileNameExtensionFilter filter = null;
		
		switch (opc) {
		case 1:
			filter = new FileNameExtensionFilter("XLS and XLSX files", "xls", "xlxs", "xlsm", "xlsb");
			break;

		case 2:
			filter = new FileNameExtensionFilter("DOCX files", "docx");
			break;
		}
		
		if (filter != null) { choose.addChoosableFileFilter(filter); }
		
		String pathFile = null;
		
		int returnValue = choose.showDialog(null,"Seleccionar");
		
		if ( returnValue == JFileChooser.APPROVE_OPTION ) {
			
			File selectedFile = choose.getSelectedFile();
			pathFile = (selectedFile.getAbsolutePath());
			
		}
		
		return pathFile;
		
	}


	public void setController(Controller controller) {
		this.controller = controller;
	}

}
