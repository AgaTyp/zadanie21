package pl.agntyp.zadanie21;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private List<Product> products;
    private List<Category> categories = List.of(Category.values());

    public MainController() {
        products = new ArrayList<>();
        products.add(new Product("Mleko", Category.SPOŻYWCZE, 3.50));
        products.add(new Product("Masło", Category.SPOŻYWCZE, 5.50));
        products.add(new Product("Sok", Category.SPOŻYWCZE, 4.00));
        products.add(new Product("Płyn do mycia naczyń", Category.DOMOWE, 5.00));
        products.add(new Product("Zmywaki", Category.DOMOWE, 4.50));
        products.add(new Product("Krem do rąk", Category.INNE, 8.00));
    }

    @GetMapping("/")
    public String home(Model model) {

        List<Category> validCategories = new ArrayList<>();
        for (Category category : Category.values()) {
            if (category != Category.WSZYSTKO) {
                validCategories.add(category);
            }
        }
        model.addAttribute("validCategories", validCategories);
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);

        return "home";
    }

    @PostMapping("/dodaj")
    public String add(Product product) {

        products.add(product);
//        return "redirect:/";
        return "redirect:/lista?kategoria=" + Category.WSZYSTKO;

    }

    @GetMapping("/lista")
    public String list(@RequestParam Category kategoria, Model model) {
        List<Product> list = new ArrayList<>();
        double sum = 0.00;
        model.addAttribute("category", kategoria.getDescription());
        if (kategoria.equals(Category.WSZYSTKO)) {
            for (Product product : products) {
                list.add(product);
                sum += product.getPrice();
            }
        } else {
            for (Product product : products) {
                if (product.getCategory().equals(kategoria)) {
                    list.add(product);
                    sum += product.getPrice();
                }
            }

        }
        model.addAttribute("productList", list);
        model.addAttribute("sum", sum);
        return "lista";
    }

}
