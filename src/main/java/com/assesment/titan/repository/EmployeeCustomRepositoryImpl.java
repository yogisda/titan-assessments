package com.assesment.titan.repository;

import com.assesment.titan.models.Employee;
import com.assesment.titan.models.EmployeeFirstNameLastNameDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
@Component
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findByFirstNameAndDepartment(String firstName, String department) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

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
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("firstname"), firstName);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByLastName(String lastName) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("lastname"), lastName);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByDepartment(String department) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("department"), department);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findByCostcenter(String costcenter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate firstNamePredicate = cb.equal(employee.get("costcenter"), costcenter);

        cq.where(firstNamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<EmployeeFirstNameLastNameDepartment> findByDepartmentHrOrIT(String firstDepartment, String secondDepartment) {


        String queryStr =
                "SELECT NEW com.assesment.titan.models.EmployeeFirstNameLastNameDepartment(e.firstname,e.lastname,e.department) " +
                        "FROM Employee e WHERE e.department = :firstDepartment OR e.department = :secondDepartment";
        TypedQuery<EmployeeFirstNameLastNameDepartment> query =
                entityManager.createQuery(queryStr, EmployeeFirstNameLastNameDepartment.class)
                        .setParameter("firstDepartment", firstDepartment)
                        .setParameter("secondDepartment", secondDepartment);

        return query.getResultList();
    }

    @Override
    public String findByDepartmentHrOrITById(String firstDepartment, String secondDepartment, Long id) {
        String queryStr =
                "SELECT NEW com.assesment.titan.models.EmployeeFirstNameLastNameDepartment(e.firstname,e.lastname,e.department) " +
                        "FROM Employee e WHERE e.id = :id AND (e.department = :firstDepartment OR e.department = :secondDepartment)";
        TypedQuery<EmployeeFirstNameLastNameDepartment> query =
                entityManager.createQuery(queryStr, EmployeeFirstNameLastNameDepartment.class)
                        .setParameter("firstDepartment", firstDepartment)
                        .setParameter("secondDepartment", secondDepartment)
                        .setParameter("id", id);
        List<EmployeeFirstNameLastNameDepartment> results = query.getResultList();


        //$department-$firstname-$lastname
        String str = "";
        String str1 = "$";
        String str2 = "-";

        str += str1;
        str += results.get(0).department;
        str += str2;
        str += str1;
        str += results.get(0).firstName;
        str += str2;
        str += str1;
        str += results.get(0).lastName;

        return str;
    }


}
