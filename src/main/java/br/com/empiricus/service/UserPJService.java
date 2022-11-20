package br.com.empiricus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.repository.UserPJRepository;


@Service
public class UserPJService {

	@Autowired
	private UserPJRepository repository;
	
	@Autowired
    EmailService emailService;
	
	
	public interface UserrPJService {
		ClientePJ saveUserPJ(ClientePJ clientePJ);//METODO  POST
		List<ClientePJ> getAllUserPJ(); //METODO GET ALL (PESQUISA TODA TABELO)
		ClientePJ getUserPJById(long id); //METODO GET POR ID
		ClientePJ updateUserPJ(ClientePJ clientePJ, long id); //METODO PUT 
		void deleteUserPJ(long id); //METODO DELETE
	}


	public ClientePJ CadastrarUserPJ(ClientePJ clientePJ) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(clientePJ.getSenha());
		clientePJ.setSenha(senhaEncoder);
		emailService.enviarEmail(clientePJ.getEmail(), "Confirmação de cadastro", "O seu cadastro no IndicAtivos Foi realizado com sucesso!");
		return repository.save(clientePJ);
	}

}