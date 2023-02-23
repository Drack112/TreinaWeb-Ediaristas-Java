package br.com.treinaweb.ediaristas.core.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ToString.Include
	private Long id;

	@Column(nullable = false, unique = true)
	private String filename;

	@Column(name = "content_length", nullable = false)
	private Long contentLength;

	@Column(name = "content_type", nullable = false)
	private String contentType;

	@Column(nullable = false)
	private String url;
}
