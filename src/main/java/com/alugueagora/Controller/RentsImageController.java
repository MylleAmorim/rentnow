package com.alugueagora.Controller;

import com.alugueagora.dtos.RentsDtos;
import com.alugueagora.dtos.RentsImageDtos;
import com.alugueagora.service.RentsImageService;
import com.rentNow.model.RentsImageModel;
import com.rentNow.model.RentsModel;
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
public class RentsImageController {

    @Autowired
    private RentsImageService rentsImageService;

    @PostMapping("/rentsImage")
    public ResponseEntity<RentsImageModel> saveRentsImage(@RequestBody @Valid RentsImageDtos rentsImageDtos) {
        var rents = new RentsImageModel();
        BeanUtils.copyProperties(rentsImageDtos, rents);
        return ResponseEntity.status(HttpStatus.CREATED).body(rentsImageService.save(rents));
    }

    @GetMapping
    public ResponseEntity<List<RentsImageModel>> getAllRents() {
        return ResponseEntity.status(HttpStatus.OK).body(rentsImageService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getRentById(@PathVariable(value = "id") UUID id) {
        Optional<RentsImageModel> rent = rentsImageService.findById(id);
        if (rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(rent.get());

    }

    @PutMapping("rentsImage/{id}")
    public ResponseEntity<Object> updateRents(@PathVariable (value = "id")UUID id , @RequestBody @Valid RentsImageDtos rentsImageDtos) {
        Optional<RentsImageModel > rent = rentsImageService.findById(id);
        if (rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");
        }
        var rentsImageModel = rent.get();
        BeanUtils.copyProperties(rentsImageDtos, rentsImageModel);
        return ResponseEntity.status(HttpStatus.OK).body(rentsImageService.save(rentsImageModel));
    }

    @DeleteMapping("rentsImage/{id}")
    public ResponseEntity<Object> deleteRentImage(@PathVariable UUID id) {
        Optional<RentsImageModel > rent = rentsImageService.findById(id);
        if (rent.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rents not found");

        }
        rentsImageService.delete(rent.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Rents deleted successfully");

    }




}
