package application;

import java.util.Date;
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
		
		System.out.println("\n==== test 4, seller insert ====");
		Seller newSeller = new Seller(null, "isaias jacinto", "isaiasjacinto@gmail.com", new Date(), 3000.0, dep);
		sellerDao.insert(newSeller);
		System.err.println(newSeller);
		System.out.println("new id: "  + newSeller.getId());
		
		System.out.println("\n==== test 5, seller update ====");
		seller = sellerDao.findById(1);
		seller.setName("taise");
		sellerDao.update(seller);
		
		System.out.println("\n==== test 6, seller delete ====");
		sellerDao.deleteById(9);
		
		
	}
}
