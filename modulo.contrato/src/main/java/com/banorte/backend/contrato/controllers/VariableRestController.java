package com.banorte.backend.contrato.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banorte.backend.contrato.models.entity.Variables;
import com.banorte.backend.contrato.services.IVariablesService;

@RestController
@RequestMapping("/api")
public class VariableRestController {

	
	@Autowired
	private IVariablesService variableService;
	
	@GetMapping("/variables")
	public List<Variables> index(){
		return variableService.findAll();	
	}
		
	@GetMapping("/variables/page/{page}")
	public Page<Variables> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 1);
		return variableService.findAll(pageable);	
	}
	//CONSULTAR
	@GetMapping("/variables/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Variables variables = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			variables = variableService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la consulta de base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (variables ==null){
			response.put("mensaje", "El variable ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Variables>(variables, HttpStatus.OK); 		
	}
	
	//ALTA
	@PostMapping("/variables")
	public ResponseEntity<?> create(@Valid @RequestBody Variables variables, BindingResult result) {
		Variables variablesNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = new ArrayList<String>();			
			
			for(FieldError err : result.getFieldErrors()) {
				errors.add("El campo: '"+err.getField()+"' "+err.getDefaultMessage());
			}
			
			response.put("Errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
			
		try {
			variablesNew = variableService.save(variables);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		response.put("mensaje", "Creado con exito");
		response.put("variable", variablesNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}

	
	//ACTIALIZAR
	@PutMapping("/variable/{id}")
	public ResponseEntity<?> update(@RequestBody Variables variables,  BindingResult result, @PathVariable Long id){
		Variables variablesActual = variableService.findById(id);
		Variables variablesUpdated = null;

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = new ArrayList<String>();			
			
			for(FieldError err : result.getFieldErrors()) {
				errors.add("El campo"+err.getDefaultMessage());
			}
			
			response.put("Errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(variablesActual==null) {
			response.put("mensaje", "Error: No se  puede editar, la variables ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}

		try {
			variablesActual.setNombre(variables.getNombre());
			variablesActual.setIdVariable(variables.getIdVariable());

			variablesUpdated = variableService.save(variablesActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Actualizado con exito");
		response.put("variables", variablesUpdated);		response.put("variables", variablesUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
		
	}

	//ELIMINAR
	@DeleteMapping("variable/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			variableService.Delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	

}
