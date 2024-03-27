package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj); // inserir no banco esse objeto

	void update(Department obj); // atualizar objeto no banco

	void deleteById(Integer id); // deletar objeto no banco por id

	Department findById(Integer id); // encontrar objeto por id

	List<Department> findAll(); // encontrar todos os objetos

}
