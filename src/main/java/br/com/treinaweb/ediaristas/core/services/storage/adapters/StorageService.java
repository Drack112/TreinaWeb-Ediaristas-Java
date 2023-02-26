package br.com.treinaweb.ediaristas.core.services.storage.adapters;

import br.com.treinaweb.ediaristas.core.models.Foto;
import br.com.treinaweb.ediaristas.core.services.storage.exceptions.StorageServiceException;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	Foto salvar(MultipartFile file) throws StorageServiceException;
}
