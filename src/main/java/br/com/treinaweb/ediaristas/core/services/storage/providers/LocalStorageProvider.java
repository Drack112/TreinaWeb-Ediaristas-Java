package br.com.treinaweb.ediaristas.core.services.storage.providers;

import br.com.treinaweb.ediaristas.api.controllers.StorageRestController;
import br.com.treinaweb.ediaristas.core.models.Foto;
import br.com.treinaweb.ediaristas.core.repositories.FotoRepository;
import br.com.treinaweb.ediaristas.core.services.storage.adapters.StorageService;
import br.com.treinaweb.ediaristas.core.services.storage.exceptions.StorageServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class LocalStorageProvider implements StorageService {
	private final Path pastaUpload = Paths.get("uploads");

	@Autowired
	private FotoRepository fotoRepository;

	@Override
	public Foto salvar(MultipartFile file) throws StorageServiceException {
		try {
			return trySalvar(file);
		} catch (IOException exception) {
			throw new StorageServiceException(exception.getLocalizedMessage());
		}
	}

	@Override
	public UrlResource buscarFoto(String filename){
		var arquivo = pastaUpload.resolve(filename);

		try {
			return new UrlResource(arquivo.toUri());
		}catch (MalformedURLException e){
			throw new StorageServiceException();
		}
	}

	private Foto trySalvar(MultipartFile file) throws IOException {
		if (!Files.exists(pastaUpload)) {
			Files.createDirectories(pastaUpload);
		}

		var foto = gerarModelFoto(file);
		Files.copy(file.getInputStream(), pastaUpload.resolve(foto.getFilename()));
		return fotoRepository.save(foto);
	}

	private Foto gerarModelFoto(MultipartFile file) throws IOException {
		var foto = new Foto();
		var filename = gerarNovoFilename(file.getOriginalFilename());
		var url = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StorageRestController.class).buscarFoto(filename)).toString();
		foto.setFilename(filename);
		foto.setContentLength(file.getSize());
		foto.setContentType(file.getContentType());
		foto.setUrl(url);
		return foto;
	}

	private String gerarNovoFilename(String filenameOriginal) {
		var ext = filenameOriginal.split("\\.")[1];
		return UUID.randomUUID().toString() + "." + ext;
	}
}
