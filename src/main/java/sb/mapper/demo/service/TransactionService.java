package sb.mapper.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sb.mapper.demo.dto.*;
import sb.mapper.demo.mapper.TransactionMapper;

@Service
public class TransactionService {
    @Autowired
    TransactionMapper transactionMapper;

    public TransactionViewDTO getTransactionDetails(TransactionDTO transactionDTO) {

        return transactionMapper.toViewDTO(transactionDTO);
    }
}