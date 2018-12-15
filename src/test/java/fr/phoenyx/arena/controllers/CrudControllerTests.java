package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.GlobalConstants.CHARACTER_ENCODING;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.services.CrudService;

public abstract class CrudControllerTests<E extends GenericEntity, D extends GenericEntityDTO> {

    protected abstract MockMvc getMockMvc();
    protected abstract CrudService<E, D> getService();
    protected abstract String getEndpointRoot();
    protected abstract Class<E> getConcernedClass();
    protected abstract Long getGenericId();
    protected abstract D buildDTO();

    public abstract void setup();

    @Test
    public void findAll_shouldReturnOK() throws Exception {
        getMockMvc().perform(get(getEndpointRoot())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().isOk());
    }

    @Test
    public void findById_shouldReturnOK_whenExists() throws Exception {
        //Given
        D dto = buildDTO();
        when(getService().findById(getGenericId())).thenReturn(dto);

        //When Then
        getMockMvc().perform(get(getEndpointRoot() + "/" + getGenericId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
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
        getMockMvc().perform(get(getEndpointRoot() + "/" + getGenericId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void deleteById_shouldReturnNoContent_whenExists() throws Exception {
        getMockMvc().perform(delete(getEndpointRoot() + "/" + getGenericId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteById_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        EntityNotFoundException exception = new EntityNotFoundException(getConcernedClass(), getGenericId());
        doThrow(exception).when(getService()).deleteById(getGenericId());

        //When Then
        getMockMvc().perform(delete(getEndpointRoot() + "/" + getGenericId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void create_shouldReturnDto_whenOK() throws Exception {
        //Given
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().create(dto)).thenReturn(dto);

        //When Then
        getMockMvc().perform(post(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().string(containsString(getGenericId().toString())));
    }

    @Test
    public void create_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        EntityNotFoundException exception = new EntityNotFoundException(getConcernedClass(), getGenericId());
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().create(dto)).thenThrow(exception);

        //When Then
        getMockMvc().perform(post(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void create_shouldReturnBadRequest_whenKO() throws Exception {
        //Given
        BadRequestException exception = new BadRequestException("foo");
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().create(dto)).thenThrow(exception);

        //When Then
        getMockMvc().perform(post(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void update_shouldReturnDto_whenExists() throws Exception {
        //Given
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().update(dto)).thenReturn(dto);

        //When Then
        getMockMvc().perform(put(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isAccepted())
                .andExpect(content().string(containsString(getGenericId().toString())));
    }

    @Test
    public void update_shouldReturnNotFound_whenNotExists() throws Exception {
        //Given
        EntityNotFoundException exception = new EntityNotFoundException(getConcernedClass(), getGenericId());
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().update(dto)).thenThrow(exception);

        //When Then
        getMockMvc().perform(put(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(exception.getMessage())));
    }

    @Test
    public void update_shouldReturnBadRequest_whenKO() throws Exception {
        //Given
        BadRequestException exception = new BadRequestException("foo");
        D dto = buildDTO();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        String dtoJson = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(dto);
        when(getService().update(dto)).thenThrow(exception);

        //When Then
        getMockMvc().perform(put(getEndpointRoot()).content(dtoJson)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .characterEncoding(CHARACTER_ENCODING))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString(exception.getMessage())));
    }
}
