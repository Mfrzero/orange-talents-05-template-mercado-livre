package br.com.zupacademy.matheusfernandes.mercadolivre.produto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class ImagemForm {
	
	@NotNull
	@Size(min = 1)
	private List<MultipartFile> imagem = new ArrayList<>();
	
	public List<MultipartFile> getImagem() {
		return imagem;
	}

	public void setImagem(List<MultipartFile> imagem) {
		this.imagem = imagem;
	}
	
}
