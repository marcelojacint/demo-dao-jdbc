package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("==== test 1, seller findById ====");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n==== test 2, seller findByDepartment ====");
		Department dep = new Department(3, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller sellers : list) {
			System.out.println(sellers);

		}

		System.out.println("\n==== test 3, seller findByDepartment ====");
		list = sellerDao.findAll();
		for (Seller sellers : list) {
			System.out.println(sellers);

		}
	}
}
