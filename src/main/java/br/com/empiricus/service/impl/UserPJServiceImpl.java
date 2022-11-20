package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.repository.UserPJRepository;
import br.com.empiricus.service.UserPJService.UserrPJService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class UserPJServiceImpl implements UserrPJService {

	private UserPJRepository userPJRepository;
	
	public UserPJServiceImpl(UserPJRepository userPJRepository) {
		super();
		this.userPJRepository = userPJRepository;
	}


	@Override
	public ClientePJ saveUserPJ(ClientePJ userLoginPJ) {
		return userPJRepository.save(userLoginPJ);
	}


	@Override
	public java.util.List<ClientePJ> getAllUserPJ() {
		return userPJRepository.findAll();
	}


	@Override
	public ClientePJ getUserPJById(long id) {
		return userPJRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public ClientePJ updateUserPJ(ClientePJ userLoginPJ, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		ClientePJ existingUserLoginPJ = userPJRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingUserLoginPJ.setTelefone(userLoginPJ.getTelefone());	
		existingUserLoginPJ.setNome(userLoginPJ.getNome());
		existingUserLoginPJ.setEmail(userLoginPJ.getEmail());
		existingUserLoginPJ.setCnpj(userLoginPJ.getCnpj());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		userPJRepository.save(existingUserLoginPJ);
		return existingUserLoginPJ;
		
		
	}
	
	

	@Override
	public void deleteUserPJ(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		userPJRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		userPJRepository.deleteById(id);
		
	}
	
	
	
}
