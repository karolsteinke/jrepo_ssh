package sk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sk.model.Product;
import sk.service.ProductService;

@Controller
public class ProductController {
    
    private final ProductService productService;

    //we us DI through the controller's contructor parameters to get the service bean from the Srping context
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //@GetMapping is for HTTP GET method
    //we define a Model parameter that we use to send the data to the view
    @GetMapping("/products")
    public String viewProducts(
            Model model)
    {
        //we get the list of products and send it to the view
        var products = productService.getProducts();
        model.addAttribute("products", products);

        return "products.html";
    }

    //@PostMapping is for HTTP POST method
    //we get the name and the price using request parameters
    //but we don't write this values in the URI by hand, as we did in nr14_ch8
    //instead they are auto completed by the browser based on html, it seems
    @PostMapping("/products")
    public String addProducts(
            @RequestParam String name,
            @RequestParam double price,
            Model model)
    {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProducts(p);

        //we get the list of products and send it to the view
        var products = productService.getProducts();
        model.addAttribute("products", products);

        return "products.html";
    }
}
