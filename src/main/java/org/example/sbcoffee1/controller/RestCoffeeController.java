package org.example.sbcoffee1.controller;

import org.example.sbcoffee1.model.Coffee;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coffees")
public class RestCoffeeController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestCoffeeController() {
        // Initialisation avec quelques cafés
        coffees.add(new Coffee("1", "Café Cereza"));
        coffees.add(new Coffee("2", "Café Ganador"));
        coffees.add(new Coffee("3", "Café Lareño"));
        coffees.add(new Coffee("4", "Café Tres Pontas"));
    }

    // 1) RECHERCHER tous les cafés
    @GetMapping
    public List<Coffee> getAllCoffees() {
        return coffees;
    }

    // 2) RECHERCHER un café par son ID
    @GetMapping("/{id}")
    public Optional<Coffee> getCoffeeById(@PathVariable String id) {
        return coffees.stream()
                .filter(coffee -> coffee.getId().equals(id))
                .findFirst();
    }

    // 3) CRÉER un nouveau café
    @PostMapping
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        coffees.add(coffee);
        return coffee;
    }

    // 4) MODIFIER un café existant
    @PutMapping("/{id}")
    public Coffee updateCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        // Supprimer l'ancien café s'il existe
        coffees.removeIf(c -> c.getId().equals(id));
        // Ajouter le nouveau café
        coffees.add(coffee);
        return coffee;
    }

    // 5) SUPPRIMER un café
    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable String id) {
        coffees.removeIf(c -> c.getId().equals(id));
    }
}