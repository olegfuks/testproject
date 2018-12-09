package test.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.server.dto.EmployeeDTO;
import test.server.entity.Employee;
import test.server.error.EmployeeNotFoundException;
import test.server.repository.EmployeeRepository;
import test.server.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("page/{page}")
    public ResponseEntity<Page<Employee>> findEmployees(@PathVariable("page") Integer page) {
        return new ResponseEntity<>(employeeService.findEmployees(page), HttpStatus.OK);
    }

    @GetMapping("/{searchText}")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@PathVariable("searchText") String name) {
        return new ResponseEntity<>(employeeService.findByNameStartsWith(name), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity updateEmployee(@Valid @RequestBody EmployeeDTO employee){
        try {
            employeeService.update(employee);
        } catch (EmployeeNotFoundException e) {
            return new ResponseEntity(e.toString(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(employee, HttpStatus.OK);
    }
}