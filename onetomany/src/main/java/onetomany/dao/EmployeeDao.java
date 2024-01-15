package onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany.dto.Company;
import onetomany.dto.Employee;

public class EmployeeDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void saveemployee(int companyid, Employee employee) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Company dbcompany = entityManager.find(Company.class, companyid);
		if (dbcompany != null) {

			// it present means company present

			entityTransaction.begin();
			entityManager.persist(employee);
			// taking old employee details in list and store it in list
			List<Employee> employees = dbcompany.getEmployee();
			employees.add(employee);
			// we add employee in it inside this list both new and old employee present
			dbcompany.setEmployee(employees);
			// resaved it
			entityTransaction.commit();
		} else {
			System.out.println("Comp not present");
		}
	}

	public void findemployee(int id) {

		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id is present employee is present
			System.out.println(dbemployee);
		} else {
			System.out.println("Sorry id not present");
		}
	}

	public void deleteemployee(int id) {
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id is present employee is present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbemployee);
			entityTransaction.commit();
			System.out.println(dbemployee);
		} else {
			System.out.println("Sorry id not present");
		}
	}
	
	public void updateemployee(int id,Employee employee)
	{
		EntityManager entityManager = getEntityManager();
		Employee dbemployee = entityManager.find(Employee.class, id);
		if (dbemployee != null) {
			// id is present employee is present then we can update data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			employee.setId(id);
			entityManager.merge(employee);
			entityTransaction.commit();
			
		} else {
			System.out.println("Sorry id not present");
		}
	}

}
