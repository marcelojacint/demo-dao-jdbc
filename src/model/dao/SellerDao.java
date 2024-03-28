package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj); // inserir no banco esse objeto

	void update(Seller obj); // atualizar objeto no banco

	void deleteById(Integer id); // deletar objeto no banco por id

	Seller findById(Integer id); // encontrar objeto por id

	List<Seller> findAll(); // encontrar todos os objetos
	
	List<Seller> findByDepartment(Department department);

}
