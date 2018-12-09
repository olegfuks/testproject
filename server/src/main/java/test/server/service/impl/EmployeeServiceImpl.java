package test.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.server.dto.EmployeeDTO;
import test.server.entity.Employee;
import test.server.error.EmployeeNotFoundException;
import test.server.repository.DepartmentRepository;
import test.server.repository.EmployeeRepository;
import test.server.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static int ITEMS_PER_PAGE = 10;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository  departmentRepository;

    @Transactional
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteEmployee(id);
    }

    @Transactional
    @Override
    public void update(EmployeeDTO employeeDTO) {
        if (!employeeRepository.findById(employeeDTO.getId()).isPresent()) {
            throw new EmployeeNotFoundException("Employee with id: '" + employeeDTO.getId() + "' cannot be found.");
        }
        employeeRepository.save(EmployeeDTO.convertToEmployee(employeeDTO, departmentRepository));
    }

    @Override
    public Page<Employee> findEmployees(Integer page) {
        return employeeRepository.findAll(PageRequest.of(page - 1, ITEMS_PER_PAGE));
    }

    @Override
    public List<Employee> findByNameStartsWith(String name) {
        return employeeRepository.findEmployeesByNameStartsWith(name);
    }
}
