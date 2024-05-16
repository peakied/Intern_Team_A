package com.peak.main.controller;

import com.peak.main.Request.Response;
import com.peak.main.model.Store;
import com.peak.main.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
@AllArgsConstructor
public class store {

    private final StoreRepository storeRepository;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(storeRepository.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@RequestParam ObjectId id) {
        return ResponseEntity.ok(new Response(storeRepository.findById(id)));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'SELLER')")
    public ResponseEntity<Response> add(@RequestBody Store store) {
        if (store.getName() == null ||
                store.getOwner() == null ||
                store.getDetail() == null ||
                store.getImage() == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Response(storeRepository.save(store)));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response> delete(@PathVariable String id) {
        storeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
