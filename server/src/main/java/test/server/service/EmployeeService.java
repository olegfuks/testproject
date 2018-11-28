package test.server.service;

import test.server.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void deleteById(Long id);
    void update(Employee employee);
    List<Employee> findAll();
    List<Employee> findByNameStartsWith(String name);
}
