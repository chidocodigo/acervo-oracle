package mx.uaemex.fi.acervooracle.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "asesores")
public class Asesor extends Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_asesores")
	@SequenceGenerator(name="sec_id_asesores", sequenceName = "sec_id_asesores", allocationSize=1)
	private Integer id;

	private String claveAsesor;

	private String area;

	@OneToMany(mappedBy = "asesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tesis> tesis = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClaveAsesor() {
		return claveAsesor;
	}

	public void setClaveAsesor(String claveAsesor) {
		this.claveAsesor = claveAsesor;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Tesis> getTesis() {
		return tesis;
	}

	public void setTesis(List<Tesis> tesis) {
		this.tesis = tesis;
	}

}