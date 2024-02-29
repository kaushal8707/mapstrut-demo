package sb.mapper.demo.mapper;
import org.mapstruct.Mapper;
import sb.mapper.demo.dto.ContactDTO;
import sb.mapper.demo.entity.Contact;
import java.util.List;

/*Basic Mappings*/
@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toEntity(ContactDTO contactDTO);

    ContactDTO toDTO(Contact contact);

    List<ContactDTO> toDTOList(List<Contact> contacts);

}