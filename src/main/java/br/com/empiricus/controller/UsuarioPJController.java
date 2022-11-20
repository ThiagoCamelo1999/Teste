package br.com.empiricus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.empiricus.model.Ativos;
import br.com.empiricus.model.ClientePJ;
import br.com.empiricus.service.UserPJService;
import br.com.empiricus.service.UserPJService.UserrPJService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/usuarios/PJ")
@Tag(name = "Usuarios pj", description = "Controller para requisições Usuarios -> variáveis para verificações usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioPJController {
	
	@Autowired
	private UserrPJService userrPJService;

	@GetMapping
	@Operation(
    		summary = ("Apresentação todos usuarios "),
    		description = ("Apresenta os todos usuarios cadastrados"),
    		tags = {"Usuarios pj"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public List<ClientePJ> getAllUserPJ(){
		return userrPJService.getAllUserPJ();
	}
	

	@GetMapping("{id}")
	@Operation(
    		summary = ("Apresentação os usuarios atavéz do id"),
    		description = ("Apresenta os usuarios cadastrados atravéz do id"),
    		tags = {"Usuarios pj"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public ResponseEntity<ClientePJ> getUserPJById(@PathVariable("id") long clientePJid){
		return new ResponseEntity<ClientePJ>(userrPJService.getUserPJById(clientePJid), HttpStatus.OK);
	}

	@PutMapping("{id}")
	@Operation(
    		summary = ("Atualização dos usuarios atavéz do id"),
    		description = ("Atualização dos usuarios cadastrados atravéz do id"),
    		tags = {"Usuarios pj"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public ResponseEntity<ClientePJ> updateUserPJ(@PathVariable("id") long id
												,@RequestBody ClientePJ userLoginPJ){
		return new ResponseEntity<ClientePJ>(userrPJService.updateUserPJ(userLoginPJ, id), HttpStatus.OK);
	}
	

	@DeleteMapping("/{id}")
	@Operation(
    		summary = ("Exclusão dos usuarios atavéz do id"),
    		description = ("Exclusão dos usuarios cadastrados atravéz do id"),
    		tags = {"Usuarios pj"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
	public ResponseEntity<String> deleteUserPJ(@PathVariable("id") long id){
		//DELETANDO DO BD
		userrPJService.deleteUserPJ(id);
		return new ResponseEntity<String>("Cliente Deletado com sucesso!.", HttpStatus.OK);
	}

}
