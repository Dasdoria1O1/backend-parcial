package main.java.com.ejemplo.backend.controller;

import main.java.com.ejemplo.backend.dto.EntityDTO;
import main.java.com.ejemplo.backend.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@RestController
@RequestMapping("/entities")
@RequiredArgsConstructor
public class EntityController {
    private final EntityService entityService;

    @PostMapping
    public ResponseEntity<EntityDTO> create(@RequestBody EntityDTO entityDTO) {
        return ResponseEntity.ok(entityService.create(entityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityDTO> update(@PathVariable Long id, @RequestBody EntityDTO entityDTO) {
        return ResponseEntity.ok(entityService.update(id, entityDTO));
    }

    @GetMapping
    public ResponseEntity<List<EntityDTO>> findAll() {
        return ResponseEntity.ok(entityService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(entityService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        entityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
