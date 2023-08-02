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
	String msg;
	
	public void transfer_to_email(String mail) {
		
		mailSend = "josejuanchov@gmail.com";
		pass = "rmgxowikmsundomb";
		msg = JOptionPane.showInputDialog("Ingrese el mensaje!!");
		
		Properties obj = new Properties();
		
		obj.put("mail.smtp.host", "smtp.gmail.com");
		obj.setProperty("mail.smtp.starttls.enable", "true");
		obj.put("mail.smtp.port", "587");
		obj.setProperty("mail.smtp.port", "587");
		obj.put("mail.smtp.user", mailSend);
		obj.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(obj);
		MimeMessage myMail = new MimeMessage(session);
		
		try {
			
			myMail.setFrom(new InternetAddress(mailSend));
			myMail.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
			myMail.setSubject("Correo Urgente juas juas");
			myMail.setText(msg);
			
			Transport transport = session.getTransport("smtp");
			transport.connect(mailSend, pass);
			transport.sendMessage(myMail, myMail.getRecipients(Message.RecipientType.TO));
			transport.close();
			
			JOptionPane.showMessageDialog(null, "Correo Enviado Correctamente!");
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "Error al enviar el correo.. \n" + e);
			
		}
	}
	
	public void setConfigSender(String mailSend, String pass) {
		this.mailSend = mailSend;
		this.pass = pass;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

}