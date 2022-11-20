package br.com.empiricus.controller;


import java.util.List;

import br.com.empiricus.model.Ativos;
import br.com.empiricus.model.Indicadores;
import br.com.empiricus.service.IndicadoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/Indicadores")
@Tag(name = "Indicadores", description = "Controller para requisições Indicadores -> variáveis para verificações indicadores")
@SecurityRequirement(name = "Bearer Authentication")
public class IndicadoresController {

    @Autowired
    private IndicadoresService indicadoresService;


    @GetMapping
    @Operation(
    		summary = ("Apresentação de Indicadores"),
    		description = ("Apresenta todos indicadores"),
    		tags = {"Indicadores"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
    public List<Indicadores> getAllIndicIndicadores(){
        return indicadoresService.getAllIndicadores();
    }


    @GetMapping("{id}")
    @Operation(
    		summary = ("Apresentação de Indicadores através do id"),
    		description = ("Apresenta os indicadores cadastrados através do id"),
    		tags = {"Indicadores"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
    public ResponseEntity<Indicadores> getIndicadoresById(@PathVariable long indicadoresId){
        return new ResponseEntity<Indicadores>(indicadoresService.getIndicadoresById(indicadoresId), HttpStatus.OK);
    }


    @GetMapping("/nomes/{nome}")
    @Operation(
    		summary = ("Apresentação de Indicadores através do nome"),
    		description = ("Apresenta os indicadores cadastrados através do nome"),
    		tags = {"Indicadores"}, 
    		responses = {
    				@ApiResponse(description = "Online", responseCode = "200", 
    						content = @Content(mediaType = "application/json",
    						array = @ArraySchema(schema = @Schema(implementation = Ativos.class))
    						)) }
    		)
    public ResponseEntity<List<Indicadores>> getIndicadoresByNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(indicadoresService.getIndicadoresByNome(nome));
    }

 /*   @PostMapping()
    public ResponseEntity<Indicadores> saveIndicadores(@RequestBody Indicadores indicadores){
        return new ResponseEntity<Indicadores>(indicadoresService.saveIndicadores(indicadores), HttpStatus.CREATED);

    }

    @PutMapping("{id}")
    public ResponseEntity<Indicadores> updateIndicadores(@PathVariable("id") long id
            , @RequestBody Indicadores Indicadores){
        return new ResponseEntity<Indicadores>(indicadoresService.updateIndicadores(Indicadores, id), HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteIndicadores(@PathVariable("id") long id){

        indicadoresService.deleteIndicadores(id);
        return new ResponseEntity<String>("Indicadores Deletados!.", HttpStatus.OK);
    }
*/

}
