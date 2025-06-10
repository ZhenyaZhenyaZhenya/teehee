package ua.opnu.practice1_template.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.opnu.practice1_template.entities.Employee;
import ua.opnu.practice1_template.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
  private final EmployeeService service;

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = service.addEmployee(employee);
    return ResponseEntity.ok(savedEmployee);
  }

  @GetMapping("/getAllEmployees")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    List<Employee> employees = service.getAllEmployees();
    return ResponseEntity.ok(employees);
  }

  @DeleteMapping("/deleteEmployee/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    service.deleteEmployee(id);
    return ResponseEntity.noContent().build();
  }
}