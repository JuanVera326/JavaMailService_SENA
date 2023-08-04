package com.in.model;
import javax.swing.JOptionPane;

import com.in.controller.Controller;

import javax.mail.*;
import javax.activation.*;
import javax.mail.internet.*;
import java.util.Properties;

public class CorreoEnvio{
	
	private Controller controller;
	private String mailSend;
	private String pass;
	private Transport transport;
	private Properties obj;
	private Session session;
	String msg;
	

	public boolean testConnection() {
		
		try {
			obj = new Properties();
			
			obj.put("mail.smtp.host", "smtp.gmail.com");
			obj.setProperty("mail.smtp.starttls.enable", "true");
			obj.put("mail.smtp.port", "587");
			obj.setProperty("mail.smtp.port", "587");
			obj.put("mail.smtp.user", mailSend);
			obj.setProperty("mail.smtp.auth", "true");
			
			session = Session.getDefaultInstance(obj);
			
			transport = session.getTransport("smtp");
			transport.connect(mailSend, pass);
			
		} catch (MessagingException e) {
			
			return false;
			
		}
		return transport.isConnected();
	}
	
	public void transfer_to_email(String mail) {
		
		msg = JOptionPane.showInputDialog("Ingrese el mensaje!!");
		
		MimeMessage myMail = new MimeMessage(session);
		
	/*	try {
			
			myMail.setFrom(new InternetAddress(mailSend));
			myMail.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			myMail.setSubject("");
			myMail.setText(msg);
			
			transport.connect(mailSend, pass);
			transport.sendMessage(myMail, myMail.getRecipients(Message.RecipientType.TO));
			transport.close();
			
			JOptionPane.showMessageDialog(null,"Correo Enviado!.","Succesfully",JOptionPane.OK_OPTION);
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null,"Correo no Enviado.\nCodigo de Error: " + e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			
		}*/
	}
	
	public void setConfigSender(String mailSend, String pass) {
		this.mailSend = mailSend;
		this.pass = pass;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

}