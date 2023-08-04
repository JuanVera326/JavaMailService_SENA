package com.in.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.in.controller.Controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class View extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	
	private Controller controller;
	private JPanel contentPane;
	private JPanel panel;
	private JTextField correo_personal;
	private JPasswordField clave_dinamica;
	private JTextField correo_destinatario;
	private JTextField asunto_correos;
	private JPanel panel_1;
	private JLabel lblIngresaCorreoDestinatario;
	private JLabel lblAsunto;
	private JButton sendMailBtn;
	private JButton importExcelDestinatariosBtn;
	private JButton cleanUpBtn;
	private JLabel lblTotalDests;
	private JLabel lblTotalDestinatarios;
	private JLabel lblTuSession;
	private JEditorPane editorPane;
	private JButton importWordPlantillaBtn;
	private JScrollPane scrollPane;
	private JButton configEmisorBtn;
	private List<String> emails;
	private String docPlantilla;
	private String correo_Session;
	private String password_Session;

	
	public View() {
		
		setTitle("Correos Sena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(57, 169, 0)));
		panel.setBounds(30, 95, 500, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setEnabled(false);
		panel_1.setBorder(new LineBorder(new Color(57, 169, 0)));
		panel_1.setBounds(30, 291, 500, 359);
		contentPane.add(panel_1);
		
		JLabel senalogo = new JLabel(new ImageIcon(View.class.getResource("/com/in/resources/img//sena.png")));
		senalogo.setBounds(225, 0, 110, 110);
		contentPane.add(senalogo);
		
		JLabel lblIngresaTuClave = new JLabel("Ingresa tu clave dinamica: ");
		lblIngresaTuClave.setBounds(10, 81, 149, 24);
		lblIngresaTuClave.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel.add(lblIngresaTuClave);
		
		JLabel lblNewLabel = new JLabel("Ingresa tu correo: ");
		lblNewLabel.setBounds(10, 46, 149, 24);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		configEmisorBtn = new JButton("Aceptar");
		configEmisorBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		configEmisorBtn.setBounds(390, 67, 89, 23);
		panel.add(configEmisorBtn);
		configEmisorBtn.addActionListener(this);
		
		JLabel lblTuSessionA = new JLabel("Tu session a como: ");
		lblTuSessionA.setForeground(new Color(57, 169, 0));
		lblTuSessionA.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTuSessionA.setBounds(49, 150, 149, 24);
		panel.add(lblTuSessionA);
		
		lblTuSession = new JLabel("");
		lblTuSession.setForeground(new Color(57, 169, 0));
		lblTuSession.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTuSession.setBounds(197, 150, 282, 24);
		panel.add(lblTuSession);
		
		JLabel lblNewLabel_1 = new JLabel("Configuración Remisión");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(170, 11, 188, 24);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("----------------------------------------------------------------------------");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 125, 459, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Configuración Envio Correo");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(155, 11, 202, 24);
		panel_1.add(lblNewLabel_1_1);
		
		lblIngresaCorreoDestinatario = new JLabel("Ingresa correo Destinatario:");
		lblIngresaCorreoDestinatario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblIngresaCorreoDestinatario.setBounds(10, 46, 159, 24);
		panel_1.add(lblIngresaCorreoDestinatario);
		
		correo_destinatario = new JTextField();
		correo_destinatario.setColumns(10);
		correo_destinatario.setBounds(165, 50, 325, 20);
		panel_1.add(correo_destinatario);
		
		correo_personal = new JTextField();
		correo_personal.setBounds(197, 49, 183, 20);
		panel.add(correo_personal);
		correo_personal.setColumns(10);
		
		clave_dinamica = new JPasswordField();
		clave_dinamica.setBounds(197, 85, 183, 20);
		panel.add(clave_dinamica);
		clave_dinamica.setText("");
		panel.setEnabled(false);
		
		importExcelDestinatariosBtn = new JButton("Importar Destinatarios");
		importExcelDestinatariosBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		importExcelDestinatariosBtn.setBounds(324, 117, 166, 23);
		panel_1.add(importExcelDestinatariosBtn);
		importExcelDestinatariosBtn.addActionListener(this);
		
		lblAsunto = new JLabel("Ingresa asunto:");
		lblAsunto.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblAsunto.setBounds(10, 83, 96, 24);
		panel_1.add(lblAsunto);
		
		asunto_correos = new JTextField();
		asunto_correos.setColumns(10);
		asunto_correos.setBounds(116, 86, 374, 20);
		panel_1.add(asunto_correos);
		
		lblTotalDests = new JLabel("Total Dests: ");
		lblTotalDests.setForeground(new Color(57, 169, 0));
		lblTotalDests.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTotalDests.setBounds(10, 120, 96, 24);
		panel_1.add(lblTotalDests);
		
		lblTotalDestinatarios = new JLabel("");
		lblTotalDestinatarios.setBackground(new Color(255, 255, 255));
		lblTotalDestinatarios.setForeground(new Color(0, 0, 0));
		lblTotalDestinatarios.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblTotalDestinatarios.setBounds(99, 120, 70, 24);
		panel_1.add(lblTotalDestinatarios);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(10, 153, 480, 161);
		scrollPane = new JScrollPane(editorPane);
		scrollPane.setLocation(10, 155);
		scrollPane.setSize(480, 159);
        panel_1.add(scrollPane, BorderLayout.CENTER);
		
		importWordPlantillaBtn = new JButton("Cargar Plantilla");
		importWordPlantillaBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		importWordPlantillaBtn.setBounds(165, 325, 176, 23);
		panel_1.add(importWordPlantillaBtn);
		importWordPlantillaBtn.addActionListener(this);
		
		cleanUpBtn = new JButton("Limpiar");
		cleanUpBtn.setBounds(30, 64, 89, 23);
		contentPane.add(cleanUpBtn);
		cleanUpBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		sendMailBtn = new JButton("Enviar");
		sendMailBtn.setBounds(441, 64, 89, 23);
		contentPane.add(sendMailBtn);
		sendMailBtn.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sendMailBtn.addActionListener(this);
		cleanUpBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		
		if ( e.getSource() == sendMailBtn ) {
			System.out.println("Enviando Correo ->");
			String bar = "";
			for (int i = 0; i < 20; i++) {
				bar += "->";
				System.out.println(bar);
			}
			System.out.println(bar + " Enviado B)");
		}
		
		if ( e.getSource() == configEmisorBtn ) {
			
			boolean val = (correo_personal.getText() != "") ? isValidEmail(correo_personal.getText()) : false;
			
			if (val) {
				
				correo_Session = correo_personal.getText();
				char[] arr_key = clave_dinamica.getPassword();
				
				if (arr_key.length != 0) {
					password_Session = new String(arr_key);
				}else {
					JOptionPane.showMessageDialog(null,"El campo de 'Clave Dinamica' No es Valido.","ERROR",JOptionPane.ERROR_MESSAGE);
					correo_personal.setText("");
					clave_dinamica.setText("");
				}
				
				controller.setConfigSender(correo_Session,password_Session);
				boolean connect = controller.testConnection();
				
				if (connect) {
					JOptionPane.showMessageDialog(null,"Conexion Establecida!.","Succesfully",JOptionPane.INFORMATION_MESSAGE);
					lblTuSession.setText(correo_Session);
					correo_personal.setText("");
					clave_dinamica.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"Conexion no Establecida!.","ERROR",JOptionPane.ERROR_MESSAGE);
					correo_personal.setText("");
					clave_dinamica.setText("");
					correo_Session = "";
					password_Session = "";
					lblTuSession.setText("");
				}
				
			}else {
				
				JOptionPane.showMessageDialog(null,"El campo de 'Tu correo' No es Valido.","ERROR",JOptionPane.ERROR_MESSAGE);
				correo_personal.setText("");
				clave_dinamica.setText("");
				
			}
		}
		
		if( e.getSource() == importExcelDestinatariosBtn ) {
			
			String path = controller.getFile(1);
			emails = controller.readExcelFileToEmails(path);
			
			if (!!emails.isEmpty()) {
				lblTotalDestinatarios.setText("Vacio");
			}else {
				if (emails.get(0).equals("Err")) {
					JOptionPane.showMessageDialog(null,"Error al Importar los Destinatarios.","ERROR",JOptionPane.ERROR_MESSAGE);
					emails.clear();
				}
				lblTotalDestinatarios.setText(emails.size() + "");
			}
		}
		
		if ( e.getSource() == importWordPlantillaBtn ) {
			
			String path = controller.getFile(2);
			
			try {
				
				docPlantilla = controller.readWordFileHTML(path);
				if (docPlantilla == null) {
					editorPane.setText("Vacio!");
					JOptionPane.showMessageDialog(null,"Error al Importar la Plantilla.","ERROR",JOptionPane.ERROR_MESSAGE);
				}else {
					editorPane.setText(docPlantilla);
				}
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error al Importar la Plantilla.","ERROR",JOptionPane.ERROR_MESSAGE);
			}
		}

		if ( e.getSource() == cleanUpBtn ) {
			
			clave_dinamica.setText("");
			correo_personal.setText("");
			correo_destinatario.setText("");
			asunto_correos.setText("");
			editorPane.setText("");
			lblTuSession.setText("");
			lblTotalDestinatarios.setText("");
			
		}
		
	}
	
	public boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

	public void setController(Controller controller) {
		this.controller = controller;
	}
}