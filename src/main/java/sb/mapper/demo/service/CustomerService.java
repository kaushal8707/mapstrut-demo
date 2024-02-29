package sb.mapper.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.mapper.demo.dto.CustomerDTO;
import sb.mapper.demo.entity.Customer;
import sb.mapper.demo.mapper.CustomerMapper;
import sb.mapper.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    public Customer saveCustomer(CustomerDTO customerDTO) {
        return customerRepository.save(customerMapper.toEntity(customerDTO));
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDTO)
                .orElse(new CustomerDTO());
    }

}