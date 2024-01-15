package onetomany.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany.dto.Company;
import onetomany.dto.Employee;

public class CompanyDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}

	public void savecompany(Company company) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(company);
		entityTransaction.commit();
	}

	public void findcompany(int id) {

		EntityManager entityManager = getEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id is present employee is present
			System.out.println(dbcompany);
		} else {
			System.out.println("Sorry id not present");
		}
	}

	public void deletecompany(int id) {
		EntityManager entityManager = getEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id is present employee is present
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(dbcompany);
			entityTransaction.commit();

		} else {
			System.out.println("Sorry id not present");
		}
	}

	public void updatecompany(int id, Company company) {
		EntityManager entityManager = getEntityManager();
		Company dbcompany = entityManager.find(Company.class, id);
		if (dbcompany != null) {
			// id is present employee is present then we can update it
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			company.setId(id);
			company.setEmployee(dbcompany.getEmployee());
			entityManager.merge(company);
			entityTransaction.commit();

		} else {
			System.out.println("Sorry id not present");
		}

	}

}
