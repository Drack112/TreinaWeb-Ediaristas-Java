package br.com.treinaweb.ediaristas.core.models;

import br.com.treinaweb.ediaristas.core.enums.TipoUsuario;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Usuario {

	@EqualsAndHashCode.Include
	@ToString.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(name = "tipo_usuario", length = 8, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;

	@Column(nullable = true, length = 11, unique = true)
	private String cpf;

	@Column(nullable = true)
	private LocalDate nascimento;

	@Column(nullable = true, length = 11)
	private String telefone;

	@Column(nullable = true)
	private Double reputacao;

	@Column(name = "chave_pix", nullable = true, unique = true)
	private String chavePix;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "foto_documento", nullable = true)
	private Foto fotoDocumento;

	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "foto_usuario", nullable = true)
	private Foto fotoUsuario;

	@ManyToMany
	@JoinTable(
		name = "cidades_atendidas_usuarios",
		joinColumns = @JoinColumn(name = "usuario_id"),
		inverseJoinColumns = @JoinColumn(name = "cidade_atendida_id")
	)
	private List<CidadeAtendida> cidadesAtendidas;

	public Boolean isDiarista() {
		return tipoUsuario.equals(TipoUsuario.DIARISTA);
	}

	public Boolean isCliente() {
		return tipoUsuario.equals(TipoUsuario.CLIENTE);
	}

}
