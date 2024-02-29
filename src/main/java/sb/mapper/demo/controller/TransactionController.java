package sb.mapper.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sb.mapper.demo.dto.TransactionDTO;
import sb.mapper.demo.dto.TransactionViewDTO;
import sb.mapper.demo.service.TransactionService;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionViewDTO> getTransactionDetails(@RequestBody TransactionDTO transactionDTO) {
        return ResponseEntity.ok(transactionService.getTransactionDetails(transactionDTO));
    }
}