package dw.study240808_2.study;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 1500.00),
            new Product(2, "Phone", 800.00),
            new Product(3, "Desktop", 2000.00)
    );
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(products.get(id - 1), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Product> getProductByRequestParam(@RequestParam int id) {
        return new ResponseEntity<>(products.get(id - 1), HttpStatus.OK);
    }
}
