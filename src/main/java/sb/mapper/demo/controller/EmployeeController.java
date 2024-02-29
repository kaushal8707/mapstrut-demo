package sb.mapper.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.mapper.demo.dto.EmployeeDTO;
import sb.mapper.demo.dto.EmployeeDetailsDTO;
import sb.mapper.demo.entity.Employee;
import sb.mapper.demo.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDTO));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // while we are fetching data from multiple tables and want to return data as a single DTO as a responseDTO
    @GetMapping("/employee-details/{id}")
    public ResponseEntity<EmployeeDetailsDTO> getEmployeeDetailsById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeDetailsById(id));
    }

}