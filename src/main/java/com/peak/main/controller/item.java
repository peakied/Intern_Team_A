package com.peak.main.controller;

import com.peak.Util.Status;
import com.peak.main.model.Item;
import com.peak.main.model.Response;
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

    // /item
    @PostMapping
    public ResponseEntity<Response> add(@RequestBody Item item) {
        item.setStatus(Status.ORDER);
        return ResponseEntity.ok(new Response(itemRepository.save(item)));
    }
}
