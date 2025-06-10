package ua.opnu.practice1_template.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.opnu.practice1_template.entities.Employee;
import ua.opnu.practice1_template.repository.EmployeeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
  private final EmployeeRepository repo;

  public Employee addEmployee(Employee employee) {
    return repo.save(employee);
  }

  public List<Employee> getAllEmployees() {
    return repo.findAll();
  }

  public void deleteEmployee(Long id) {
    if (!repo.existsById(id)) {
      throw new RuntimeException("Не знайдено працівника з ID: " + id);
    }
    repo.deleteById(id);
  }
}
