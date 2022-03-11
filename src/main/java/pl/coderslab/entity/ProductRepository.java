package pl.coderslab.entity;

import java.util.List;

public interface ProductRepository {
    public List<Product2> getProduct2List();
    public Product2 getById(Long id);
    public Long getByName(String name);
}
