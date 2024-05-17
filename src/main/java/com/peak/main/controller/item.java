package com.peak.main.controller;

import com.peak.main.Request.RequestName;
import com.peak.main.model.Item;
import com.peak.main.Request.Response;
import com.peak.main.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class item {

    private final ItemRepository itemRepository;

    // /item
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(itemRepository.findAll()));
    }

    @GetMapping("/search")
    public ResponseEntity<Response> getById(RequestName name) {
        return ResponseEntity.ok(new Response(itemRepository.findByName(name.getName())));
    }

    // /item
    @PostMapping
    public ResponseEntity<Response> add(@RequestBody Item item) {
        if (item.getName() == null ||
                item.getCost() == null ||
                item.getDiscount() == null ||
                item.getImage() == null || item.getImage().isEmpty() ||
                item.getOwner() == null ||
                item.getCategory() == null ||
                item.getDetail() == null ||
                item.getType() == null || item.getType().isEmpty() ||
                item.getStock() == null)
            return ResponseEntity.notFound().build();
        if (item.getSold() == null) item.setSold(0);

        return ResponseEntity.ok(new Response(itemRepository.save(item)));
    }

    // /item
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@RequestBody Long id) {
        itemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
