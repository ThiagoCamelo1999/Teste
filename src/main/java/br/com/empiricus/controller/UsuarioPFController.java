package br.com.empiricus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empiricus.model.Ativos;
import br.com.empiricus.model.ClientePF;
import br.com.empiricus.service.UserPFService.UserrPFService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios/PF")
@Tag(name = "Usuarios PF", description = "Controller para requisições Usuarios -> variáveis para verificações usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioPFController {
	
	
	@Autowired
	private UserrPFService userrPFService;

		
		@GetMapping
		@Operation(
	    		summary = ("Apresentação de todos usuarios"),
	    		description = ("Apresenta os usuarios cadastrados"),
	    		tags = {"Usuarios PF"}, 
	    		responses = {
	    				@ApiResponse(description = "Online", responseCode = "200", 
	    						content = @Content(mediaType = "application/json",
	    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
	    						)) }
	    		)
		public List<ClientePF> getAllUser(){
			return userrPFService.getAllUserPF();
		}
		
		
		@GetMapping("{id}")
		@Operation(
	    		summary = ("Apresentação dos usuarios atavéz do id"),
	    		description = ("Apresenta os usuarios cadastrados atravéz do id"),
	    		tags = {"Usuarios PF"}, 
	    		responses = {
	    				@ApiResponse(description = "Online", responseCode = "200", 
	    						content = @Content(mediaType = "application/json",
	    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
	    						)) }
	    		)
		public ResponseEntity<ClientePF> getUserById(@PathVariable("id") long clientePFid){
			return new ResponseEntity<ClientePF>(userrPFService.getUserPFById(clientePFid), HttpStatus.OK);
		}
		
		
		@PutMapping("{id}")
		@Operation(
	    		summary = ("Atualização dos usuarios atavéz do id"),
	    		description = ("Atualização dos usuarios cadastrados atravéz do id"),
	    		tags = {"Usuarios PF"}, 
	    		responses = {
	    				@ApiResponse(description = "Online", responseCode = "200", 
	    						content = @Content(mediaType = "application/json",
	    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
	    						)) }
	    		)
		public ResponseEntity<ClientePF> updateUserPF(@PathVariable("id") long id
													,@RequestBody ClientePF userLoginPF){
			return new ResponseEntity<ClientePF>(userrPFService.updateUserPF(userLoginPF, id), HttpStatus.OK);
		}
		
		
		@DeleteMapping("{id}")
		@Operation(
	    		summary = ("Exclusão dos usuarios atavéz do id"),
	    		description = ("Exclusão dos usuarios cadastrados atravéz do id"),
	    		tags = {"Usuarios PF"}, 
	    		responses = {
	    				@ApiResponse(description = "Online", responseCode = "200", 
	    						content = @Content(mediaType = "application/json",
	    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
	    						)) }
	    		)
		public ResponseEntity<String> deleteUserPF(@PathVariable("id") long id){
			//DELETANDO DO BD
			userrPFService.deleteUserPF(id);
			return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
		}

}
