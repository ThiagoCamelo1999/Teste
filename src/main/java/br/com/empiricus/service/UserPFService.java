package br.com.empiricus.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.repository.UserPFRepository;


@Service
public class UserPFService {

	@Autowired
	private UserPFRepository repository;
	
	
	@Autowired
    EmailService emailService;
	
	public interface UserrPFService {
	ClientePF saveUserPF(ClientePF clientePF);//METODO  POST
	List<ClientePF> getAllUserPF(); //METODO GET ALL (PESQUISA TODA TABELO)
	ClientePF getUserPFById(long id); //METODO GET POR ID
	ClientePF updateUserPF(ClientePF clientePF, long id); //METODO PUT 
	void deleteUserPF(long id); //METODO DELETE
	}

	public ClientePF CadastrarUserPF(ClientePF clientePF) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(clientePF.getSenha());
		clientePF.setSenha(senhaEncoder);
		emailService.enviarEmail(clientePF.getEmail(), "Confirmação de cadastro", "O seu cadastro no IndicAtivos Foi realizado com sucesso!");
		return repository.save(clientePF);
	}

}