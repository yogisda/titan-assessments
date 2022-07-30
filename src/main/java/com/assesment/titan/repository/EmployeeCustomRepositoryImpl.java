package com.assesment.titan.repository;

import com.assesment.titan.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findByFirstNameAndDepartment(String firstName, String department) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("firstname"), firstName);
        Predicate departmentPredicate = cb.equal(employee.get("department"), department);

        cq.where(firstNamePredicate, departmentPredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("firstname"), firstName);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("lastname"), lastName);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByDepartment(String department) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("department"), department);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByCostcenter(String costcenter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("costcenter"), costcenter);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

}
