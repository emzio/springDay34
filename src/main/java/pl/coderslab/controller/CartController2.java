package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.bean.Cart2;
import pl.coderslab.bean.ProduktDao2;
import pl.coderslab.entity.CartItem2;
import pl.coderslab.entity.Product2;
import pl.coderslab.entity.ProductRepository;

import java.util.List;
import java.util.Random;

@Controller
public class CartController2 {
    private final Cart2 cart2;
//    private final ProduktDao2 produktDao2;
    private final ProductRepository produktDao2;

    public CartController2(Cart2 cart2, ProductRepository produktDao2) {
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

//        rozwiązanie Piotra nie sprawdzające czy produkt już jest na liscie CartItem2 (trzeba zminić tu i tam int i long:
//        if (id > 0) {
//            produktDao2.getProduct2List().stream()
//                    .filter(n -> n.getId() == id)
//                    .findFirst()
//                    .ifPresent(n -> cart2.addToCart(new CartItem2((int) quantity, n)));
//        }
        return "addtocart";
    }

    @GetMapping(value = "/addtocart2Jsp" )
    public String addtocartIdJspGet() {
        return "addtocart";
    }

    @PostMapping(value = "/addtocart2Jsp" )
//    @ResponseBody
    public String addtocartIdJspPost(@RequestParam String product, @RequestParam Integer quantity) {

        List<Product2> product2List = produktDao2.getProduct2List();
        Long id = produktDao2.getByName(product);
        if (id < product2List.size()+1 && id>=1){
            Product2 product2 = product2List.get((int) (id-1));
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
        return "redirect:/cart2/printJsp";
    }

    @RequestMapping("/cart2/print")
    @ResponseBody
    public String printCart(){
        return cart2.getCartItems().toString();
    }

    @RequestMapping("/cart2/printJsp")
    public String printCartJsp(Model model){
        model.addAttribute("cartItems" , cart2.getCartItems());

        return "cart2Print";
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
