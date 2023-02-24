package br.com.treinaweb.ediaristas.api.dto.responses;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ServicoResponse {
	private Long id;


	private String nome;


	private BigDecimal valorMinimo;


	private Integer qtdHoras;


	private BigDecimal procentagemComissao;


	private Integer horasQuarto;


	private BigDecimal valorQuarto;


	private Integer horasSala;


	private BigDecimal valorSala;


	private Integer horasBanheiro;


	private BigDecimal valorBanheiro;


	private Integer horasCozinha;


	private BigDecimal valorCozinha;


	private Integer horasQuintal;


	private BigDecimal valorQuintal;


	private Integer horasOutros;


	private BigDecimal valorOutros;


	private String icone;

	private Integer posicao;
}
