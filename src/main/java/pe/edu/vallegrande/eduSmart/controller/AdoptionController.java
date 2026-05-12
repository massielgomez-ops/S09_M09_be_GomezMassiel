package pe.edu.vallegrande.eduSmart.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.eduSmart.model.Adoption;
import pe.edu.vallegrande.eduSmart.service.AdoptionService;

import java.util.List;

@RestController
@RequestMapping("/adoptions")
@CrossOrigin(origins = "*")
public class AdoptionController {

    private final AdoptionService service;

    public AdoptionController(AdoptionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Adoption> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Adoption create(@RequestBody Adoption adoption) {
        return service.save(adoption);
    }

    @PutMapping("/{id}")
    public Adoption update(@PathVariable Integer id, @RequestBody Adoption adoption) {
        adoption.setId(id);
        return service.save(adoption);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
