package mx.uaemex.fi.acervooracle.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tesis implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_tesis")
	@SequenceGenerator(name="sec_id_tesis", sequenceName = "sec_id_tesis", allocationSize=1)
	private Integer id;

	private String titulo;

	private Date fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asesor_id")
	@JsonIgnore
	private Asesor asesor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tesista_id")
	@JsonIgnore
	private Tesista tesista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Asesor getAsesor() {
		return asesor;
	}

	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}

	public Tesista getTesista() {
		return tesista;
	}

	public void setTesista(Tesista tesista) {
		this.tesista = tesista;
	}

}
