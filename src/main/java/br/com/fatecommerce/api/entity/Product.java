package br.com.fatecommerce.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name_product", unique = true, nullable = false, length = 300)
    @NotBlank(message = "O campo nome é obrigatório!")
    @Length(min =2, max = 300, message = "O nome deve ter entre 2 e 308 caracteres!")
    private String nameProduct;

    @Column(name = "description_product", nullable = false, length = 3000)
    @NotBlank(message = "O campo descrição é obrigatório!")
    @Length(min =2, max = 3000, message = "A descrição deve ter entre 2 e 3000 caracteres!")
    private String descriptionProduct;

    @Column(name = "sku_product", nullable = false, length = 10)
    @NotBlank(message = "O campo SKU é obrigatório!")
    @Length(min =2, max = 10, message = "O SKU deve ter entre 2 e 10 caracteres!")
    private String skuProduct;

    @Column(name = "ean_product", unique = true, length = 15)
    @NotBlank(message = "O campo EAN é obrigatório!")
    @Length(min =2, max = 15, message = "O EAN deve ter entre 2 e 15 caracteres!")
    private String eanProduct;

    @Column(name = "cost_price_product", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "O preço de custo é obrigatório!")
    private BigDecimal costPriceProduct;

    @Column(name = "amount_product", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "O preço de venda é obrigatório!")
    private BigDecimal amountProduct;

    @Column(name = "published_product", nullable = false)
    private Boolean publishedProduct;

  
    @Column (name = "sotck_product", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "O estoque é obrigatório!")
    private Long stockProduct;

    @Column(name = "date_created_product", nullable = false)
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate dateCreatedProduct;

    @Column(name = "date_updated_product", nullable = false)
    @JsonFormat (pattern = "dd/MM/yyyy")
    private LocalDate dateUpdatedProduct;

    @PrePersist
    private void prePersist(){
        this.setPublishedProduct(false);
        this.setDateCreatedProduct(LocalDate.now());
    }

    @PreUpdate
    private void preUpdate() {
        this.setDateUpdatedProduct(LocalDate.now());
    }


   
}
