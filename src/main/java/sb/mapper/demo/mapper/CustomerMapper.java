package sb.mapper.demo.mapper;
import java.time.LocalDate;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sb.mapper.demo.dto.CustomerDTO;
import sb.mapper.demo.entity.Customer;

/*this mapper is used for
 * ignore a specific field during mapping
 *default value
 *constant
 *default expression
 *inverse mapping*/

@Mapper(componentModel = "spring",imports= {LocalDate.class})
public interface CustomerMapper {

    @Mapping(source="customerId",target="id",ignore = true)
    @Mapping(source="customerName",target="name")
    @Mapping(source="countryName",target="country",defaultValue = "India")
    @Mapping(source="registrationDate",target="registrationDate",dateFormat ="dd/MM/yyyy",defaultExpression = "java(LocalDate.now())")
    @Mapping(target="type",constant="New")
    Customer toEntity(CustomerDTO customerDTO);

	/*@Mapping(source="id",target="customerId")
	@Mapping(source="name",target="customerName")
	@Mapping(source="country",target="countryName")
	@Mapping(source="registrationDate",target="registrationDate",dateFormat ="dd/MM/yyyy")*/

    @InheritInverseConfiguration
    @Mapping(source="id",target="customerId")
    CustomerDTO toDTO(Customer customer);

}
