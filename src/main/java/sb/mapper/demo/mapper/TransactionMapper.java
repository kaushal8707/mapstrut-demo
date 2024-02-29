package sb.mapper.demo.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ValueMapping;
import sb.mapper.demo.dto.TransactionDTO;
import sb.mapper.demo.dto.TransactionViewDTO;

// Mapping Enum

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @ValueMapping(source = "NETBANKING", target = "NET_BANKING")
//    @ValueMapping(source = "CREDIT_CARD", target = "CARD")
//    @ValueMapping(source = "DEBIT_CARD", target = "CARD")
    @Mapping(source = "paymentType", target ="paymentViewType" )

  //@ValueMapping(source = MappingConstants.ANY_REMAINING, target = "CARD") //ANY_REMAINING map default value first then any other values will be mapped to a general one.
    @ValueMapping(source = MappingConstants.ANY_UNMAPPED, target = "CARD")   // ANY_UNMAPPED, instead of mapping the default value first ,it will map all the unmapped value .

    TransactionViewDTO toViewDTO(TransactionDTO transactionDTO);

}