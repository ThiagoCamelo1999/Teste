package br.com.empiricus.service.impl;


//BY THIAGOSILVA
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.empiricus.model.ClientePF;
import br.com.empiricus.repository.UserPFRepository;
import br.com.empiricus.service.UserPFService.UserrPFService;
import br.com.empiricus.springboot.exception.ResourceNotFoundException;


@Service
@Transactional
public class UserPFServiceImpl implements UserrPFService {

	private UserPFRepository userPFRepository;
	
	public UserPFServiceImpl(UserPFRepository userPFRepository) {
		super();
		this.userPFRepository = userPFRepository;
	}


	@Override
	public ClientePF saveUserPF(ClientePF userLoginPF) {
		return userPFRepository.save(userLoginPF);
	}


	@Override
	public java.util.List<ClientePF> getAllUserPF() {
		return userPFRepository.findAll();
	}


	@Override
	public ClientePF getUserPFById(long id) {
		return userPFRepository.findById(id).orElseThrow(() -> 
						new ResourceNotFoundException("Cliente", "Id", id));
	}


	@Override
	public ClientePF updateUserPF(ClientePF userLoginPF, long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		ClientePF existingClientePF = userPFRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Cliente", "Id", id));
		
		existingClientePF.setNome(userLoginPF.getNome());	
		existingClientePF.setSobreNome(userLoginPF.getSobreNome());
		existingClientePF.setEmail(userLoginPF.getEmail());
		existingClientePF.setCpf(userLoginPF.getCpf());
		existingClientePF.setTelefone(userLoginPF.getTelefone());
		//SALVAR FUNCIONARIO EXISTENTE NO BD
		userPFRepository.save(existingClientePF);
		return existingClientePF;
		
		
	}
	
	

	@Override
	public void deleteUserPF(long id) {
		// VERIFICAR SE O ID EXISTE DENTRO DO BD
		userPFRepository.findById(id).orElseThrow(() -> 
							new ResourceNotFoundException("Cliente", "Id", id));
		userPFRepository.deleteById(id);
		
	}
	
	
	
}
