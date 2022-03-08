package pl.coderslab.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.entity.CartIem;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<CartIem> cartIems;

    public Cart() {
        cartIems = new ArrayList<>();
    }

    public void add(CartIem cartItem){
        cartIems.add(cartItem);
    }

    public List<CartIem> findAll(){
        return cartIems;
    }
}
