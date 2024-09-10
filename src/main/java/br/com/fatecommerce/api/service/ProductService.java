package br.com.fatecommerce.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.fatecommerce.api.entity.Product;
import br.com.fatecommerce.api.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    public List<Product> getInfoProducts() {
        return productRepository.findAll();
    }

    public HashMap<String, Object> deleteProduct(Long idProduct) {
        Optional<Product> product = Optional.ofNullable(productRepository.findById(idProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado!")));

        productRepository.delete(product.get());
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("result", "Produto: " + product.get().getNameProduct() + " excluído com sucesso!");
        return result;
    }

    public Product findProductById(Long idProduct) {
        return productRepository.findById(idProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado!"));
    }

    public Product updProduct(Product product) {
        if (findProductById(product.getIdProduct()) != null) {
            return productRepository.saveAndFlush(product);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Produto não encontrado!");
        }

    }

    public Optional<Product> findByEanProduct(String eanProduct) {
        return Optional.ofNullable(productRepository.findByEanProduct(eanProduct)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto com EAN " + eanProduct + " não encontrado!")));
    }

    public List<Product> findBySkuProduct(String skuProduct) {
        if (skuProduct != null || !skuProduct.equals("")) {
            List<Product> products = productRepository.findBySkuProduct(skuProduct);
            if (!products.isEmpty()) {
                return products;
            } else {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto com SKU " + skuProduct + " não encontrado!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado ");
        }

    }

    public List<Product> findByNameProduct(String nameProduct) {
        if (nameProduct != null || !nameProduct.equals("")) {
            List<Product> products = productRepository.findByNameProductIgnoreCaseContaining(nameProduct);
            if (!products.isEmpty()) {
                return products;
            } else {

                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto com SKU " + nameProduct + " não encontrado!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum produto encontrado ");
        }

    }
}
