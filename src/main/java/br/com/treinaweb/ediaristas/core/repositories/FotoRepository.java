package br.com.treinaweb.ediaristas.core.repositories;

import br.com.treinaweb.ediaristas.core.models.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto, Long> {
	Optional<Foto> findByFileName(String filename);
}
