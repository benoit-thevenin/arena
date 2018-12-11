package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ID;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.services.CrudService;

public abstract class CrudController<E extends GenericEntity, I, D extends GenericEntityDTO> {

    protected abstract CrudService<E, I, D> getService();

    @GetMapping
    public ResponseEntity<List<D>> findAll() {
        return new ResponseEntity<>(getService().findAll(), HttpStatus.OK);
    }

    @GetMapping(ID)
    public ResponseEntity<D> findById(@PathVariable I id) throws EntityNotFoundException {
        return new ResponseEntity<>(getService().findById(id), HttpStatus.OK);
    }

    @DeleteMapping(ID)
    public ResponseEntity<Void> deleteById(@PathVariable I id) throws EntityNotFoundException {
        getService().deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
