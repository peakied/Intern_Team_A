package com.peak.main.controller;


import com.peak.main.model.Coupon;
import com.peak.main.model.Response;
import com.peak.main.repository.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
@AllArgsConstructor
public class coupon {

    private final CouponRepository couponRepository;

    // /coupon
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(new Response(couponRepository.findAll()));
    }

    // /coupon
    @PostMapping
    public ResponseEntity<Response> add(@RequestBody Coupon coupon) {
        return ResponseEntity.ok(new Response(couponRepository.save(coupon)));
    }
}
