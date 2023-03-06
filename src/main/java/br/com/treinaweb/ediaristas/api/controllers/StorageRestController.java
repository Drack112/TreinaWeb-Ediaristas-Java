package br.com.treinaweb.ediaristas.api.controllers;

import br.com.treinaweb.ediaristas.core.repositories.FotoRepository;
import br.com.treinaweb.ediaristas.core.services.storage.adapters.StorageService;
import br.com.treinaweb.ediaristas.core.services.storage.providers.LocalStorageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/uploads")
public class StorageRestController {
	@Autowired
	private FotoRepository fotoRepository;

	@Autowired
	private StorageService storageService;

	@GetMapping
	public ResponseEntity<Object> buscarFoto(
		@RequestParam
		String filename
	) throws IOException {
		var foto = fotoRepository.findByFilename(filename).get();
		var file = storageService.buscarFoto(filename);

		return ResponseEntity.ok()
			.header("Content-Type", foto.getContentType())
			.header("Content-Length", foto.getContentLength().toString())
			.body(file.getInputStream().readAllBytes());
	}
}
