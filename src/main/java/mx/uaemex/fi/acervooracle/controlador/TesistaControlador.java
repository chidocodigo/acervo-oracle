package mx.uaemex.fi.acervooracle.controlador;

import mx.uaemex.fi.acervooracle.exception.ResourceNotFoundException;
import mx.uaemex.fi.acervooracle.modelo.Tesista;
import mx.uaemex.fi.acervooracle.repositorio.TesisRepositorio;
import mx.uaemex.fi.acervooracle.repositorio.TesistaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TesistaControlador {
	@Autowired
    TesistaRepositorio tesistaRepositorio;
	
	@Autowired
	TesisRepositorio tesisRepositorio;

	@GetMapping("/tesista")
	public List<Tesista> getTesistas() {
	    return tesistaRepositorio.findAll();
	}

	@PostMapping("/tesista")
	public Tesista createTesista(@Valid @RequestBody Tesista tesista) {
	    return tesistaRepositorio.save(tesista);
	}

	@GetMapping("/tesista/{id}")
	public Tesista getTesistaById(@PathVariable(value = "id") Integer tesistaId) {
	    return tesistaRepositorio.findById(tesistaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Tesista", "id", tesistaId));
	}

	@PutMapping("/tesista/{id}")
	public Tesista updateTesista(@PathVariable(value = "id") Integer tesistaId,
	                                        @Valid @RequestBody Tesista nuevoTesista) {

		Tesista tesista = tesistaRepositorio.findById(tesistaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Tesista", "id", tesistaId));

		tesista.setNumeroCuenta(nuevoTesista.getNumeroCuenta());
		tesista.setNombre(nuevoTesista.getNombre());
		tesista.setApellidoPaterno(nuevoTesista.getApellidoPaterno());
		tesista.setApellidoMaterno(nuevoTesista.getApellidoMaterno());

	    Tesista tesistaActualizado = tesistaRepositorio.save(tesista);
	    return tesistaActualizado;
	}

	@DeleteMapping("/tesista/{id}")
	public ResponseEntity<?> deleteTesista(@PathVariable(value = "id") Integer tesistaId) {
		Tesista tesista = tesistaRepositorio.findById(tesistaId)
	            .orElseThrow(() -> new ResourceNotFoundException("Tesista", "id", tesistaId));

		tesistaRepositorio.delete(tesista);

	    return ResponseEntity.ok().build();
	}

}