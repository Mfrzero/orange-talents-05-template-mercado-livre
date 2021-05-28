package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploaderFake {

	public Set<String> enviar(List<MultipartFile> imagem){
		return imagem.stream()
				.map(imagens -> "http://bucket.io/"
						+ imagens.getOriginalFilename())
				.collect(Collectors.toSet());
	}
}
