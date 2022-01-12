package com.portfolio.management.springboot;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.falabella.products.model.Product;
import com.falabella.products.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductSpringBootApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private ProductRepository repository;
     
    @Test
    @Order(1)
    public void testSaveNewProduct() {
        entityManager.persist(new Product("FAL-8406270","500 Zapatilla Urbana Muje", "NEW BALANCE", "37", (float) 42999.00, "https://falabella.scene7.com/is/image/Falabella/8406270_1", "https://falabella.scene7.com/is/image/Falabella/8406270_1"));
                 
        Optional<Product> product = repository.findById("FAL-8406270");
         
        Assertions.assertThat(product.get().getName()).isEqualTo("500 Zapatilla Urbana Muje");
    }
    @Test
    @Order(2)
    public void getProductTest(){

    	Optional<Product> product = repository.findById("FAL-8406270");

    	Assertions.assertThat(product.get().getName()).isEqualTo("500 Zapatilla Urbana Muje");

    }
    @Test
    @Order(3)
    public void getListOfProductsTest(){

        List<Product> products = repository.findAll();

        Assertions.assertThat(products.size()).isGreaterThan(0);

    }
    
    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateProductTest(){

        Product product = repository.findById("FAL-8406270").get();

        product.setBrand("TEST BRAND");

        Product productUpdated =  repository.save(product);

        Assertions.assertThat(productUpdated.getBrand()).isEqualTo("TEST BRAND");

    }
    
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteEmployeeTest(){

    	Product product = repository.findById("FAL-8406270").get();

        repository.delete(product);

       
        Product product1 = null;

        Optional<Product> optionalProduct = repository.findById("FAL-8406270");

        if(optionalProduct.isPresent()){
        	product1 = optionalProduct.get();
        }

        Assertions.assertThat(product1).isNull();
    }


}
