package com.in.controller;

import com.in.model.CorreoEnvio;
import com.in.model.ReadExcelFile;
import com.in.model.ReadWordFiles;
import com.in.views.SubView1;
import com.in.views.View;

public class Relations {
	
	public void start() {
		
		CorreoEnvio mailService = new CorreoEnvio();
		ReadExcelFile readExcelFile = new ReadExcelFile();
		ReadWordFiles readWordFiles = new ReadWordFiles();
		View view = new View();
		SubView1 subview1 = new SubView1();
		Controller controller = new Controller();
		
		mailService.setController(controller);
		view.setController(controller);
		subview1.setController(controller);
		readExcelFile.setController(controller);
		readWordFiles.setController(controller);
		
		controller.setMailService(mailService);
		controller.setView(view);
		controller.setSubView1(subview1);
		controller.setReadExcelFile(readExcelFile);
		controller.setReadWordFile(readWordFiles);
		
		view.setVisible(true);
	}
	
}
