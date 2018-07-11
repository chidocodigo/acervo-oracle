package mx.uaemex.fi.acervooracle.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uaemex.fi.acervooracle.modelo.Asesor;

@Repository
public interface AsesorRepositorio extends JpaRepository<Asesor, Integer> {
}
