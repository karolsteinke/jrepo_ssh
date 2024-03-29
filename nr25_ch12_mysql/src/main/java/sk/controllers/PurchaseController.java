package sk.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.model.Purchase;
import sk.repositories.PurchaseRepository;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(
        PurchaseRepository purchaseRepository
    ) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);

        //***TEST*** curl -X POST http://localhost:8080/purchase -H "Content-Type: application/json" -d "{\"product\":\"ABCDEF\", \"price\": 199.0}"
    }

    @GetMapping
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();

        //***TEST*** curl http://localhost:8080/purchase
    }
}
