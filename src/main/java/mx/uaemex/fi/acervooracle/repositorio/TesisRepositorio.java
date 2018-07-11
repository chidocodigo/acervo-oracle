package mx.uaemex.fi.acervooracle.repositorio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.uaemex.fi.acervooracle.modelo.Tesis;

@Repository
public interface TesisRepositorio extends JpaRepository<Tesis, Integer>{
	Page<Tesis> findByTesistaId(Integer tesistaId, Pageable pageable);
	Page<Tesis> findByAsesorId(Integer asesorId, Pageable pageable);
}
