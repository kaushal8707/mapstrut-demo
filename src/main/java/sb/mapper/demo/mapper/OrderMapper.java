package sb.mapper.demo.mapper;
import org.mapstruct.BeforeMapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sb.mapper.demo.dto.OrderDTO;
import sb.mapper.demo.entity.Order;

//@AfterMapping & @BeforeMapping
// Mapping with custom method

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @BeforeMapping
    default void validate(OrderDTO orderDTO) {
        if(orderDTO.getQuantity()==0) {
            orderDTO.setQuantity(1);
        }
    }
    @Mapping(source = "orderAmount", target = "amount")
    @Mapping(source = "orderDate", target = "date", dateFormat = "yyyy-MMM-dd")
    @Mapping(source="orderStatus",target="status",qualifiedByName = "checkOrderStatus")    // checkOrderStatus is method name using to map from string to boolean
    Order toEntity(OrderDTO orderDTO);

    @Mapping(source = "amount", target = "orderAmount")
    @Mapping(source = "date", target = "orderDate", dateFormat = "yyyy-MMM-dd")
    @Mapping(source="status",target="orderStatus",qualifiedByName="checkOrderStatusInString")
    OrderDTO toDTO(Order order);

    @AfterMapping
    default void calculateSum(Order order,@MappingTarget OrderDTO orderDto) {
        float sum = 0;
        if(order.getQuantity()!=0 && order.getAmount() !=0) {
            sum = sum + (order.getQuantity()*order.getAmount());
            orderDto.setSum(sum);
        }

    }

    @Named("checkOrderStatus")
    default boolean checkOrderStatus(String orderStatus) {    //input as string and output be a boolean
        boolean flag;                                           //default method in an interface
        if(orderStatus.equals("Delivered")) {
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

    @Named("checkOrderStatusInString")
    default String checkOrderStatusInString(boolean status) {
        String orderStatus;
        if(status) {
            orderStatus = "Delivered";
        }else {
            orderStatus = "Pending";
        }
        return orderStatus;
    }
}
