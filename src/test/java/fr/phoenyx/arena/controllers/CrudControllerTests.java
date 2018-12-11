package fr.phoenyx.arena.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.services.CrudService;

public abstract class CrudControllerTests<E extends GenericEntity, I, D extends GenericEntityDTO> {

    protected abstract MockMvc getMockMvc();
    protected abstract CrudService<E, I, D> getService();
    protected abstract String getEndpointRoot();
    protected abstract Class<E> getConcernedClass();
    protected abstract I getGenericId();
    protected abstract D buildDTO();

    public abstract void setup();

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        getMockMvc().perform(get(getEndpointRoot()))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        D dto = buildDTO();
        when(getService().findById(getGenericId())).thenReturn(dto);

        //When Then
        getMockMvc().perform(get(getEndpointRoot() + "/" + getGenericId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(getGenericId().toString())));
    }

    @Test
    public void findById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        EntityNotFoundException exception = new EntityNotFoundException(getConcernedClass(), getGenericId());
        when(getService().findById(getGenericId())).thenThrow(exception);

        //When Then
        getMockMvc().perform(get(getEndpointRoot() + "/" + getGenericId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void deleteById_shouldReturnNoContent_whenExists() throws Exception {
        getMockMvc().perform(delete(getEndpointRoot() + "/" + getGenericId()))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        EntityNotFoundException exception = new EntityNotFoundException(getConcernedClass(), getGenericId());
        doThrow(exception).when(getService()).deleteById(getGenericId());

        //When Then
        getMockMvc().perform(delete(getEndpointRoot() + "/" + getGenericId()))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }
}
