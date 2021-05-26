package br.com.zupacademy.matheusfernandes.mercadolivre.categoria;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{


	Optional<Categoria> findByNome(String nome);

	Categoria findById(Categoria categoriaMae);

}
