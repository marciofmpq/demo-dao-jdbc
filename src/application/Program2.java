package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===== TEST 1: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n===== TEST 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n===== TEST 3: department Insert =====");
		Department newDepartment = new Department(null, "Games");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new id = " + newDepartment.getId());

		System.out.println("\n===== TEST 4: department Update =====");
		department = departmentDao.findById(1);
		department.setName("Garden");
		departmentDao.update(department);
		System.out.println("Update completed!");

		System.out.println("\n===== TEST 5: department Delete =====");
		System.out.println("Enter id for Delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		sc.close();

	}

}
