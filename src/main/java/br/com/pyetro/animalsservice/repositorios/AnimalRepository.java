package br.com.pyetro.animalsservice.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pyetro.animalsservice.entidade.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	@Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
	List<Animal> findNotAdopted();
	
	@Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL ORDER BY a.dataEntrada")
	List<Animal> findAdopted();	
	
	@Query("SELECT a FROM Animal a WHERE a.especie IS NOT NULL ORDER BY a.dataEntrada")
	List<Animal> findEspecie();
	
	@Query("SELECT a FROM Animal a WHERE a.nomeRecebedor IS NOT NULL ORDER BY a.dataEntrada")
	List<Animal> findFuncionario();
	

}
