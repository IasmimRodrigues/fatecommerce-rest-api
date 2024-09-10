package br.com.fatecommerce.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecommerce.api.entity.Product;
import br.com.fatecommerce.api.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product")
@CrossOrigin(value = "*")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/list")
    public ResponseEntity<Object> getInfoProducts() {
        List<Product> result = productService.getInfoProducts();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> saveProduct(@RequestBody Product product) {
        Product result = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long idProduct) {
        HashMap<String, Object> result = productService.deleteProduct(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/findProduct/{idProduct}")

    public ResponseEntity<Object> getProductById(@PathVariable Long idProduct) {
        Product result = productService.findProductById(idProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        Product result = productService.updProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping(value = "/findProductByEan/{eanProduct}")
    public ResponseEntity<Object> getProductByEan(@PathVariable String eanProduct) {
        Optional<Product> result = productService.findByEanProduct(eanProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/findBySku/{skuProduct}")
    public ResponseEntity<Object> getProductBySku(@PathVariable String skuProduct) {
        List<Product> result = productService.findBySku(skuProduct);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
    

