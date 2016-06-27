package br.edu.ifpr.projeto.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

//identifica a classe através de um número
@SuppressWarnings("serial")
// Permite que a classe sejam utilizadas em outras classes
@MappedSuperclass

/*
 * A classe generica é para poder utilizar os atributos em outras classes sem
 * precisar utilizar as anotações novamente.
 */
public class GenericDomain implements Serializable {

	// define a variavel como chave primária
	@Id
	// define que a variável é auto incremento, caso deseje personalizar,
	// utilizar SEQUENCE.
	@SequenceGenerator(name = "pk_sequence", sequenceName = "entity_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pk_sequence")
	private long codigo;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDomain other = (GenericDomain) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}
