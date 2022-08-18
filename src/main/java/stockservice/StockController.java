package stockservice;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StockController {

    private Map<String,Integer> stock = new HashMap<>();

    @GetMapping("/stocks/{productNumber}")
    public ResponseEntity<?> getStockStatus(@PathVariable String productNumber){
        if(stock.containsKey(productNumber)){
            return new ResponseEntity<>(stock.get(productNumber), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No product in stock", HttpStatus.NOT_FOUND);
        }
    }

    @PostConstruct
    public void init(){
        stock.put("A001",10);
        stock.put("B002",20);
        stock.put("C003",30);
        stock.put("C004",50);
    }
}
