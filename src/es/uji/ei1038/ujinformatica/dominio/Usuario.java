package es.uji.ei1038.ujinformatica.dominio;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import es.uji.ei1038.ujinformatica.decorator.ComponenteDecorador;
import es.uji.ei1039.ujinformatica.observer.UsuarioObservador;

public class Usuario implements UsuarioObservador{

	private int id;
	private String nickname;
	private String contrasenya;
	private String contrasenyaRepetida;
	private String nombre;
	private String apellidos;
	private String email;
	private String tipo;
	private String suscritoNovedades; 


	public Usuario() {
		this.id = 0;
		this.nickname = "";
		this.contrasenya = "";
		this.nombre = "";
		this.apellidos = "";
		this.email = "";
		this.tipo = "U";
		this.contrasenyaRepetida = "";
		this.suscritoNovedades = "";
	}

	public Usuario(String nickname, String contrasenya,
			String nombre, String apellidos, String email, String contrasenyaRepetida, String suscritoNovedades) {
		super();
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.tipo = "U";
		this.contrasenyaRepetida = contrasenyaRepetida;
		this.suscritoNovedades = suscritoNovedades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContrasenyaRepetida() {
		return contrasenyaRepetida;
	}

	public void setContrasenyaRepetida(String contrasenyaRepetida) {
		this.contrasenyaRepetida = contrasenyaRepetida;
	}

	public String getSuscritoNovedades() {
		return suscritoNovedades;
	}

	public void setSuscritoNovedades(String suscritoNovedades) {
		this.suscritoNovedades = suscritoNovedades;
	}

	@Override
	public void update(UsuarioObservador usuarioObservador, ComponenteDecorador componente) {
		EmailSenderService2 ess = new EmailSenderService2();
		Usuario usuario = (Usuario) usuarioObservador;
		try {
			ess.generateAndSendEmail(usuario, componente);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}



	static class EmailSenderService2{

		static Properties mailServerProperties;
		static Session getMailSession;
		static MimeMessage generateMailMessage;
	 
	 
		public void generateAndSendEmail(Usuario usuario, ComponenteDecorador componente) throws AddressException, MessagingException {
	 
	//Step1		
			System.out.println("\n 1st ===> setup Mail Server Properties..");
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port", "587");
			mailServerProperties.put("mail.smtp.auth", "true");
			mailServerProperties.put("mail.smtp.starttls.enable", "true");
			System.out.println("Mail Server Properties have been setup successfully..");
	 
	//Step2		
			System.out.println("\n\n 2nd ===> get Mail Session..");
			getMailSession = Session.getDefaultInstance(mailServerProperties, null);
			generateMailMessage = new MimeMessage(getMailSession);
			generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario.getEmail()));
			generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("appujimatica@gmail.com"));
			generateMailMessage.setSubject("Appujimática ha ampliado su catálogo");
			String emailBody = "El equipo de Appujimática le notifica que ha ampliado su catálogo disponible en su página web. " + "<br><br>" + componente.getDescripcionPieza() + "<br><br> Atentamente, la dirección de Appujimática.";
			generateMailMessage.setContent(emailBody, "text/html");
			System.out.println("Mail Session has been created successfully..");
	 
	//Step3		
			System.out.println("\n\n 3rd ===> Get Session and Send mail");
			Transport transport = getMailSession.getTransport("smtp");
			
			// Enter your correct gmail UserID and Password (XXXarpitshah@gmail.com)
			transport.connect("smtp.gmail.com", "appujimatica@gmail.com", "practicas123()");
			transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
			transport.close();
		}

	}



}
