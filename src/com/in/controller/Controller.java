package com.in.controller;

import java.io.IOException;
import java.util.List;

import com.in.model.CorreoEnvio;
import com.in.model.ReadExcelFile;
import com.in.model.ReadWordFiles;
import com.in.views.SubView1;
import com.in.views.View;

public class Controller {
	
	private CorreoEnvio mailService;
	private View view;
	private SubView1 subview1;
	private ReadExcelFile readExcelFile;
	private ReadWordFiles readWordFiles;

	public void setMailService(CorreoEnvio mailService) {
		this.mailService = mailService;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void setSubView1(SubView1 subview1) {
		this.subview1 = subview1;
	}
	
	public void setReadExcelFile(ReadExcelFile readExcelFile) {
		this.readExcelFile = readExcelFile;
	}
	public void setReadWordFile(ReadWordFiles readWordFiles) {
		this.readWordFiles = readWordFiles;
	}
	
	/*-----------------------------------------------*/

	public String getFile(int opc) {
		return subview1.getFile(opc);
	}

	public List<String> readExcelFileToEmails(String path) {
		return readExcelFile.readExcelFileToEmails(path);
	}

	public String readWordFileHTML(String path){
		return readWordFiles.convertWordToHtml(path);
	}

	public void setConfigSender(String correo_Session, String password_Session) {
		mailService.setConfigSender(correo_Session,password_Session);
	}

	public boolean testConnection() {
		return mailService.testConnection();
	}

}
