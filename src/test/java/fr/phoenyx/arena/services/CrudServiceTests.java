package fr.phoenyx.arena.services;

import static fr.phoenyx.arena.constants.MessagesConstants.NOT_FOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.GenericEntity;

public abstract class CrudServiceTests<E extends GenericEntity, I, D extends GenericEntityDTO> {

    protected abstract JpaRepository<E, I> getRepository();
    protected abstract CrudService<E, I, D> getService();
    protected abstract Mapper<E, D> getMapper();
    protected abstract Class<E> getConcernedClass();
    protected abstract I getGenericId();
    protected abstract E buildEntity();
    protected abstract List<E> buildEntities();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void findAll_shouldReturnList() {
        //Given
        List<E> entities = buildEntities();
        when(getRepository().findAll()).thenReturn(entities);
        List<D> expectedDtos = entities.stream()
                .map(entity -> getMapper().entityToDto(entity))
                .collect(Collectors.toList());

        //When
        List<D> dtos = getService().findAll();

        //Then
        assertThat(dtos).hasSize(expectedDtos.size());
        assertThat(dtos).containsExactlyElementsOf(expectedDtos);
    }

    @Test
    public void findById_shouldReturnEntity_whenExists() throws EntityNotFoundException {
        //Given
        E entity = buildEntity();
        when(getRepository().findById(getGenericId())).thenReturn(Optional.of(entity));
        D expectedDto = getMapper().entityToDto(entity);

        //When
        D dto = getService().findById(getGenericId());

        //Then
        assertThat(dto).isNotNull();
        assertThat(dto).isEqualTo(expectedDto);
    }

    @Test
    public void findById_shouldThrowException_whenNotExists() throws EntityNotFoundException {
        //Given
        exceptionRule.expect(EntityNotFoundException.class);
        String message = String.join(" ", getConcernedClass().getSimpleName(), NOT_FOUND, getGenericId().toString());
        exceptionRule.expectMessage(message);
        when(getRepository().findById(getGenericId())).thenReturn(Optional.empty());

        //When Then
        getService().findById(getGenericId());
    }

    @Test
    public void deleteById_shouldDeleteEntity_whenExists() throws EntityNotFoundException {
        //Given
        when(getRepository().existsById(getGenericId())).thenReturn(true);

        //When
        getService().deleteById(getGenericId());

        //Then
        verify(getRepository()).existsById(getGenericId());
        verify(getRepository()).deleteById(getGenericId());
    }

    @Test
    public void deleteById_shouldThrowException_whenNotExists() throws EntityNotFoundException {
        //Given
        exceptionRule.expect(EntityNotFoundException.class);
        String message = String.join(" ", getConcernedClass().getSimpleName(), NOT_FOUND, getGenericId().toString());
        exceptionRule.expectMessage(message);
        when(getRepository().existsById(getGenericId())).thenReturn(false);

        //When Then
        getService().deleteById(getGenericId());
    }
}
