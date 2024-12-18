package com.alugueagora.Controller;

import com.alugueagora.dtos.RentsDtos;
import com.rentNow.model.RentsModel;
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
    public ResponseEntity<RentsModel>saveRents(@RequestBody @Valid RentsDtos rentsDtos) {
        var rents = new RentsModel();
        BeanUtils.copyProperties(rentsDtos, rents);

        return ResponseEntity.status(HttpStatus.CREATED).body(rentsService.save(rents));
    }

    @GetMapping
    public ResponseEntity<List<RentsModel>> getAllRents() {
        return ResponseEntity.status(HttpStatus.OK).body(rentsService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getRentById(@PathVariable (value = "id")UUID id) {
        Optional<RentsModel> rent = rentsService.findById(id);
        if (rent.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(rent.get());

    }

    @PutMapping("rents/{id}")
    public ResponseEntity<Object> updateRents(@PathVariable (value = "id")UUID id , @RequestBody @Valid RentsDtos rentsDtos) {
        Optional<RentsModel > rent = rentsService.findById(id);
        if (rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");
        }
        var rentsModel = rent.get();
        BeanUtils.copyProperties(rentsDtos, rentsModel);
        return ResponseEntity.status(HttpStatus.OK).body(rentsService.save(rentsModel));

    }


    @DeleteMapping("rents/{id}")
    public ResponseEntity<Object> deleteRent(@PathVariable UUID id) {
        Optional<RentsModel > rent = rentsService.findById(id);
        if (rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");

        }
        rentsService.delete(rent.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Rents deleted successfully");

    }
}