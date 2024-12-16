package com.alugueagora.Controller;

import com.alugueagora.dtos.RentsDtos;
import com.rentNow.model.Rents;
import com.alugueagora.service.RentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rents")
public class RentsController {

    @Autowired
    private RentsService rentsService;

    @PostMapping
    public ResponseEntity<Rents>saveRents(@RequestBody @Valid RentsDtos rentsDtos) {
        var rents = new RentsService();
        BeanUtils.copyProperties(rentsDtos, rents);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentsService.save(rents));
    }

    @GetMapping
    public ResponseEntity<List<Rents>> getAllRents() {
        return ResponseEntity.status(HttpStatus.OK).body(rentsService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Rents> getRentById(@PathVariable (value = "id")UUID id) {
        Optional<Rents> rent = rentsService.findById(id);
        return rent.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRent(@PathVariable UUID id) {
        rentsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}