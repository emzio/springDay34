package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.bean.Cart2;
import pl.coderslab.bean.ProduktDao2;
import pl.coderslab.entity.CartItem2;
import pl.coderslab.entity.Product2;

import java.util.List;
import java.util.Random;

@Controller
public class CartController2 {
    private final Cart2 cart2;
    private final ProduktDao2 produktDao2;

    public CartController2(Cart2 cart2, ProduktDao2 produktDao2) {
        this.cart2 = cart2;
        this.produktDao2 = produktDao2;
    }

    @RequestMapping("/addtocart2")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart2.addToCart(new CartItem2(1, new Product2("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping(value = "/addtocart2Id/{id}/{quantity}" )
    @ResponseBody
    public String addtocartId(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity) {
        List<Product2> product2List = produktDao2.getProduct2List();
        if (id < product2List.size()+1 && id>=1){
            Product2 product2 = product2List.get(id-1);
            CartItem2 cartItem2ToUpdate = cart2.getCartItems().stream()
                    .filter(cartItem2 -> cartItem2.getProduct().equals(product2))
                    .findAny().orElse(null);
            if(cartItem2ToUpdate!=null){
                int indexOf = cart2.getCartItems().indexOf(cartItem2ToUpdate);
                CartItem2 cartItem2 = cart2.getCartItems().get(indexOf);
                cartItem2.setQuantity(cartItem2.getQuantity()+quantity);
                cart2.getCartItems().set(indexOf, cartItem2);
            } else {
                cart2.addToCart(new CartItem2(quantity, product2));
            }
        }
        return "addtocart";
    }

    @RequestMapping("/cart2/print")
    @ResponseBody
    public String printCart(){
        return cart2.getCartItems().toString();
    }
    @RequestMapping("/cart2")
    @ResponseBody
    public String printReceipt(){
        List<CartItem2> cartItems = cart2.getCartItems();

        String receipt = "W koszyku jest "+ cartItems.size() + " pozycji.\n" +
                "        W koszyku jest " + cart2.getQuantity() + "produktów.\n" +
                "        Wartość koszyka to: " + cart2.getPricesSum() + ".";
        return receipt;
    }

}
