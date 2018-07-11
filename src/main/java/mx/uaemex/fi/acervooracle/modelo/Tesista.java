package mx.uaemex.fi.acervooracle.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "tesistas")
public class Tesista extends Persona implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="sec_id_tesistas")
	@SequenceGenerator(name="sec_id_tesistas", sequenceName = "sec_id_tesistas", allocationSize=1)
	private Integer id;

	private String numeroCuenta;

	@OneToMany(mappedBy = "tesista", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tesis> tesis = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public List<Tesis> getTesis() {
		return tesis;
	}

	public void setTesis(List<Tesis> tesis) {
		this.tesis = tesis;
	}
}
