package test.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.server.entity.Employee;
import test.server.repository.EmployeeRepository;
import test.server.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Transactional
    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByNameStartsWith(String name) {
        return employeeRepository.findEmployeesByNameStartsWith(name);
    }
}
