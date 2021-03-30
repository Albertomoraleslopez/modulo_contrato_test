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

import com.banorte.backend.contrato.models.entity.Plantilla;
import com.banorte.backend.contrato.services.IPlantillaService;


//@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlantillaRestController {
	
	@Autowired
	private IPlantillaService plantillaService;
	
	@GetMapping("/plantilla")
	public List<Plantilla> index(){
		return plantillaService.findAll();	
	}
		
	@GetMapping("/plantilla/page/{page}")
	public Page<Plantilla> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 1);
		return plantillaService.findAll(pageable);	
	}
	//CONSULTAR
	@GetMapping("/plantilla/{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		Plantilla plantilla = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			plantilla = plantillaService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error en la consulta de base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (plantilla ==null){
			response.put("mensaje", "El plantilla ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}
		return new ResponseEntity<Plantilla>(plantilla, HttpStatus.OK); 		
	}
	
	//ALTA
	@PostMapping("/plantilla")
	public ResponseEntity<?> create(@Valid @RequestBody Plantilla plantilla, BindingResult result) {
		Plantilla plantillaNew = null;
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
			plantillaNew = plantillaService.save(plantilla);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		response.put("mensaje", "Creado con exito");
		response.put("plantilla", plantillaNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	
	}

	
	//ACTIALIZAR
	@PutMapping("/plantilla/{id}")
	public ResponseEntity<?> update(@RequestBody Plantilla plantilla,  BindingResult result, @PathVariable Long id){
		Plantilla plantillaActual = plantillaService.findById(id);
		Plantilla plantillaUpdated = null;

		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			
			List<String> errors = new ArrayList<String>();			
			
			for(FieldError err : result.getFieldErrors()) {
				errors.add("El campo"+err.getDefaultMessage());
			}
			
			response.put("Errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(plantillaActual==null) {
			response.put("mensaje", "Error: No se  puede editar, la plantilla ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);			
		}

		try {
			plantillaActual.setNombre(plantilla.getNombre());
			plantillaActual.setId_tipo_doc(plantilla.getId_tipo_doc());
			plantillaActual.setId_subtipo_doc(plantilla.getId_subtipo_doc());
			plantillaActual.setId_producto(plantilla.getId_producto());			
			plantillaActual.setFecha_creacion(plantilla.getFecha_creacion());			
			plantillaActual.setUsuario_creador(plantilla.getUsuario_creador());			
			plantillaActual.setVersion(plantilla.getVersion());			
			plantillaActual.setStatus(plantilla.getStatus());			
			plantillaActual.setReca(plantilla.getReca());			
			plantillaActual.setAprobacion(plantilla.getAprobacion());			
			plantillaActual.setContenido_plantilla(plantilla.getContenido_plantilla());


			plantillaUpdated = plantillaService.save(plantillaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Actualizado con exito");
		response.put("plantilla", plantillaUpdated);		response.put("plantilla", plantillaUpdated);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
		
	}

	//ELIMINAR
	@DeleteMapping("plantilla/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		try {
			plantillaService.Delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("Error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Eliminado con exito");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

}
