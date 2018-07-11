package mx.uaemex.fi.acervooracle.controlador;

import mx.uaemex.fi.acervooracle.exception.ResourceNotFoundException;
import mx.uaemex.fi.acervooracle.modelo.Asesor;
import mx.uaemex.fi.acervooracle.repositorio.AsesorRepositorio;
import mx.uaemex.fi.acervooracle.repositorio.TesisRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AsesorControlador {
	@Autowired
    AsesorRepositorio asesorRepositorio;
	
	@Autowired
	TesisRepositorio tesisRepositorio;

	@GetMapping("/asesor")
	public List<Asesor> getAsesores() {
	    return asesorRepositorio.findAll();
	}

	@PostMapping("/asesor")
	public Asesor createAsesor(@Valid @RequestBody Asesor asesor) {
	    return asesorRepositorio.save(asesor);
	}

	@GetMapping("/asesor/{id}")
	public Asesor getAsesorById(@PathVariable(value = "id") Integer asesorId) {
	    return asesorRepositorio.findById(asesorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Asesor", "id", asesorId));
	}

	@PutMapping("/asesor/{id}")
	public Asesor updateAsesor(@PathVariable(value = "id") Integer asesorId,
	                                        @Valid @RequestBody Asesor nuevoAsesor) {

		Asesor asesor = asesorRepositorio.findById(asesorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Asesor", "id", asesorId));

		asesor.setClaveAsesor(nuevoAsesor.getClaveAsesor());
		asesor.setArea(nuevoAsesor.getArea());
		asesor.setNombre(nuevoAsesor.getNombre());
		asesor.setApellidoPaterno(nuevoAsesor.getApellidoPaterno());
		asesor.setApellidoMaterno(nuevoAsesor.getApellidoMaterno());

	    Asesor asesorActualizado = asesorRepositorio.save(asesor);
	    return asesorActualizado;
	}

	@DeleteMapping("/asesor/{id}")
	public ResponseEntity<?> deleteAsesor(@PathVariable(value = "id") Integer asesorId) {
		Asesor asesor = asesorRepositorio.findById(asesorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Asesor", "id", asesorId));

		asesorRepositorio.delete(asesor);

	    return ResponseEntity.ok().build();
	}

}