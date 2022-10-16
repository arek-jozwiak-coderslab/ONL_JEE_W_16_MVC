package pl.coderslab.sesex2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        Product p = new Product("prod" + rand.nextInt(10), rand.nextDouble());
        CartItem cartItem = new CartItem(1, p);
        cart.addToCart(cartItem);
        return "addtocart";
    }


    @RequestMapping("/cart")
    @ResponseBody
    public String cart() {
        List<CartItem> items = cart.getCartItems();

        for (CartItem item : items) {
            System.err.print(item.getProduct().getName());
            System.err.println(" -"  + item.getQuantity());
        }

        return "cart";
    }

}
