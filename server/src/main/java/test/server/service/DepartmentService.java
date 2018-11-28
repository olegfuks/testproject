package test.server.service;

import test.server.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
}
