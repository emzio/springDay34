package pl.coderslab.bean;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Product2;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProduktDao2 {
    private List<Product2> product2List;


    public ProduktDao2() {
         product2List = List.of(
                new Product2(1L,"salceson", 23.24),
                new Product2(2L,"kiełbasa", 45.34),
                new Product2(3L,"chleb", 5.20),
                new Product2(4L,"jabłka", 4.80),
                new Product2(5L,"jajka", 15.10),
                new Product2(6L,"mleko", 3.99),
                new Product2(7L,"szynka", 42.99)
        );
    }

    public List<Product2> getProduct2List() {
        return product2List;
    }

    public Product2 getById(Long id){
        return product2List.stream()
                .filter(p -> p.getId() == id)
                .findAny().orElse(null);
    }
}
