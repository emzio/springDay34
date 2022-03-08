package pl.coderslab.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.entity.CartItem2;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.Product2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart2 {
    private List<CartItem2> cartItems;

    public Cart2() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(CartItem2 cartItem2) {
        cartItems.add(cartItem2);
    }

    public List<CartItem2> getCartItems() {
        return cartItems;
    }

    @Override
    public String toString() {
        return "Cart2{" +
                "cartItems=" + cartItems +
                '}';
    }

    public Integer getQuantity(){
        return cartItems.stream().mapToInt(cartItem2 -> cartItem2.getQuantity())
                .reduce(0, Integer::sum);
    }

    public double getPricesSum() {
        return cartItems.stream().mapToDouble(cartItem2 -> cartItem2.getProduct().getPrice())
                .reduce(0, ((a, b) -> (a + b)));
    }
}
