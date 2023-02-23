package br.com.treinaweb.ediaristas.core.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class CidadeAtendida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ToString.Include
	private Long id;

	@Column(name = "codigo_ibge", nullable = false)
	private String codigoIbge;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	@ManyToMany(mappedBy = "cidadesAtendidas")
	private List<Usuario> usuarios;

}