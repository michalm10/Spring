package ug.app.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ug.app.domain.Smartphone;
import ug.app.service.SmartphoneManager;

import java.util.List;

@RestController
public class SmartphoneController {
    private final SmartphoneManager smartphoneManager;

    public SmartphoneController(@Autowired SmartphoneManager smartphoneManager) {
        this.smartphoneManager = smartphoneManager;
    }

    @PostMapping("/api/smartphone")
    public ResponseEntity<Smartphone> add(@RequestBody Smartphone smartphone) {
        Smartphone createdSmartphone = smartphoneManager.add(smartphone);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("smartphone_added", "1");
        return new ResponseEntity<>(createdSmartphone, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping("/api/smartphone")
    List<Smartphone> getAll() {
        return smartphoneManager.getAll();
    }

    @GetMapping("/api/smartphone/{id}")
    Smartphone get(@PathVariable("id") String id) {
        System.out.println("tak");
        Smartphone foundSmartphone = smartphoneManager.getById(id);
        if (foundSmartphone == null) {
            throw new SmartphoneNotFoundException();
        }
        return foundSmartphone;
    }

    @PutMapping("/api/smartphone/{id}")
    ResponseEntity<Smartphone> modify(@RequestBody Smartphone smartphone, @PathVariable("id") String id) {
        Smartphone foundSmartphone = smartphoneManager.update(smartphone, id);
        return new ResponseEntity<>(foundSmartphone, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/smartphone/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return smartphoneManager.delete(id);
    }

}
