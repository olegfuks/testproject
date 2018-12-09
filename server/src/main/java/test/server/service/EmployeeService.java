package test.server.service;

import org.springframework.data.domain.Page;
import test.server.dto.EmployeeDTO;
import test.server.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void deleteById(Long id);
    void update(EmployeeDTO employee);
    Page<Employee> findEmployees(Integer page);
    List<Employee> findByNameStartsWith(String name);
}
