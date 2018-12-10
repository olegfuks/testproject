package test.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import test.server.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findEmployeesByNameStartsWith(String name, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Employee WHERE id = :id")
    void deleteEmployee(@Param("id") Long id);
}
