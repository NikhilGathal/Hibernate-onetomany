package onetomany.controller;

import onetomany.dao.CompanyDao;
import onetomany.dao.EmployeeDao;
import onetomany.dto.Company;
import onetomany.dto.Employee;

public class CompanyEmployeeController {

	public static void main(String[] args) {

		// to save data or insert

//		Company company = new Company();
//		company.setId(1);
//		company.setName("TYSS");
//		company.setGst("Tyss@123");
//
//		CompanyDao companyDao = new CompanyDao();
//		companyDao.savecompany(company);

//		Employee employee = new Employee();
//		employee.setId(2);
//		employee.setName("Anib");
//		employee.setAddress("Pune");
//
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.saveemployee(1, employee);

		// to find company

//		CompanyDao companyDao = new CompanyDao();
//		companyDao.findcompany(1);

		// to find employee

		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.findemployee(2);

		// delete employee

//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.deleteemployee(2);

		// delete company

//		CompanyDao companyDao = new CompanyDao();
//		companyDao.deletecompany(1);

		// update Employee

//		Employee employee = new Employee();
//		employee.setName("Ashok");
//		employee.setAddress("Latur");
//
//		EmployeeDao employeeDao = new EmployeeDao();
//		employeeDao.updateemployee(2, employee);

		// update company

//		Company company = new Company();
//		company.setName("TCS");
//		company.setGst("TCS@123");
//
//		CompanyDao companyDao = new CompanyDao();
//		companyDao.updatecompany(1, company);

	}

}
