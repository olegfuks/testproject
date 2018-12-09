package test.server.dto;

import test.server.entity.Department;
import test.server.entity.Employee;
import test.server.repository.DepartmentRepository;

import java.util.Optional;

public class EmployeeDTO {
    private Long id;
    private String name;
    private boolean active;
    private Long departmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public static Employee convertToEmployee(EmployeeDTO employeeDTO, DepartmentRepository repository) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setActive(employeeDTO.getActive());
        Optional<Department> department = repository.findById(employeeDTO.getDepartmentId());
        department.ifPresent(employee::setDepartment);
        return employee;
    }
}
