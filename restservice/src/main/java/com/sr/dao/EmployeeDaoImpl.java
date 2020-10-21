package com.sr.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sr.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	
	   @Autowired
	   private SessionFactory sessionFactory;


	public List<Employee> getEmployees() {
		  Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	      Root<Employee> root = cq.from(Employee.class);
	      cq.select(root);
	      Query<Employee> query = session.createQuery(cq);
	      return query.getResultList();
	}

	public Employee getEmployee(Long id) {
		return sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	public void deleteEmployee(Long id) {
		 Session session = sessionFactory.getCurrentSession();
	      Employee employee = session.byId(Employee.class).load(id);
	      session.delete(employee);
	}

	public void updateEmployee(Long id, Employee employee) {
		  Session session = sessionFactory.getCurrentSession();
	      Employee employee2 = session.byId(Employee.class).load(id);
	      employee2.setEname(employee.getEname());
	      employee2.setAge(employee.getAge());
	      session.flush();
	}

	public long createEmployee(Employee employee) {
		 sessionFactory.getCurrentSession().save(employee);
	     return employee.getId();
	}

}
