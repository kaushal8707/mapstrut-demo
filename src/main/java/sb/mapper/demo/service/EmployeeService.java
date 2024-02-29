package sb.mapper.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.mapper.demo.dto.EmployeeDTO;
import sb.mapper.demo.dto.EmployeeDetailsDTO;
import sb.mapper.demo.entity.Employee;
import sb.mapper.demo.mapper.EmployeeDetailsMapper;
import sb.mapper.demo.mapper.EmployeeMapper;
import sb.mapper.demo.repository.EmployeeRepository;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    EmployeeDetailsMapper employeeDetailsMapper;

    public Employee saveEmployee(EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeMapper.toEntity(employeeDTO));
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .map(employeeMapper::toDTO )
                .orElse(new EmployeeDTO());
    }

// while we are fetching data from multiple tables and want to return data as a single DTO as a responseDTO
    public EmployeeDetailsDTO getEmployeeDetailsById(Long id) {
        return employeeRepository.findById(id)
                .map(emp->{
                    return employeeDetailsMapper.toEmployeeDetailsDTO(emp, emp.getDepartment());
                }).orElse(new EmployeeDetailsDTO());
    }
}