package br.com.empiricus.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Value("${spring.mail.username}")
	private String remetente;
	
	public String enviarEmail (String destinatario, String titulo, String mensagem) {

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(remetente);
            message.setTo(destinatario);
            message.setSubject(titulo);
            message.setText(mensagem);
            emailSender.send(message);
            return "Email Enviado";
        } catch (MailException e){
            return "Erro ao enviar o email";
        } 
	}
}

  