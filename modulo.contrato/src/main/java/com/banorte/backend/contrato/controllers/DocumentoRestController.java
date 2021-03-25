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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banorte.backend.contrato.models.entity.Documento;
import com.banorte.backend.contrato.models.services.IDocumentoService;

//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DocumentoRestController {

	@Autowired
	private IDocumentoService documentoService;
	
	@GetMapping("/documento")
	public List<Documento> index(){
		return documentoService.findAll();	
	}
		
	@GetMapping("/documento/page/{page}")
	public Page<Documento> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 1);
		return documentoService.findAll(pageable);	
	}
	//CONSULTAR
	@GetMapping("/documento/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Documento documento = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			documento = documentoService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la consulta de base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (documento ==null){
			response.put("mensaje", "El documento ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Documento>(documento, HttpStatus.OK); 		
	}
	
	//ALTA
	@PostMapping("/documento")
	public ResponseEntity<?> create(@Valid @RequestBody Documento documento, BindingResult result) {
		Documento documentoNew = null;
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
			documentoNew = documentoService.save(documento);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		response.put("mensaje", "Creado con exito");
		response.put("documento", documentoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}

	
	//ACTIALIZAR
	@PutMapping("/documento/{id}")
	public ResponseEntity<?> update(@RequestBody Documento documento,  BindingResult result, @PathVariable Long id){
		Documento documentoActual = documentoService.findById(id);
		Documento documentoUpdated = null;

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = new ArrayList<String>();			
			
			for(FieldError err : result.getFieldErrors()) {
				errors.add("El campo"+err.getDefaultMessage());
			}
			
			response.put("Errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(documentoActual==null) {
			response.put("mensaje", "Error: No se  puede editar, el documento ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}

		try {
			

			documentoActual.setFecha_creacion(documento.getFecha_creacion());			
			documentoActual.setUsuario_creador(documento.getUsuario_creador());			
			documentoActual.setVersion(documento.getVersion());			
			documentoActual.setStatus(documento.getStatus());			
			documentoActual.setReca(documento.getReca());			
			documentoActual.setAprobacion(documento.getAprobacion());			
			documentoActual.setContenido_documento(documento.getContenido_documento());
			
			documentoUpdated = documentoService.save(documentoActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Actualizado con exito");
		response.put("documento", documentoUpdated);		response.put("documento", documentoUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
		
	}

	//ELIMINAR
	@DeleteMapping("documento/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			documentoService.Delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
