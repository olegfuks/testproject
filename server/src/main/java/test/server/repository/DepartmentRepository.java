package test.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.server.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
