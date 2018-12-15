package fr.phoenyx.arena.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.GenericEntity;

public abstract class CrudService<E extends GenericEntity, D extends GenericEntityDTO> {

    protected abstract JpaRepository<E, Long> getRepository();
    protected abstract Mapper<E, D> getMapper();
    protected abstract Class<E> getConcernedClass();

    public List<D> findAll() {
        return getRepository().findAll().stream()
                .map(entity -> getMapper().entityToDto(entity))
                .collect(Collectors.toList());
    }

    public D findById(Long id) throws EntityNotFoundException {
        E entity = getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(getConcernedClass(), id));
        return getMapper().entityToDto(entity);
    }

    public void deleteById(Long id) throws EntityNotFoundException {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException(getConcernedClass(), id);
        }
        getRepository().deleteById(id);
    }

    public abstract D create(D dto) throws BadRequestException, EntityNotFoundException;

    public abstract D update(D dto) throws BadRequestException, EntityNotFoundException;
}
