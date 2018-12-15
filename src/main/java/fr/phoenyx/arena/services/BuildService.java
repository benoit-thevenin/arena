package fr.phoenyx.arena.services;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.BuildDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.BuildMapper;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.repositories.BuildRepository;

@Service
public class BuildService extends CrudService<Build, BuildDTO> {

    @Autowired
    private BuildRepository buildRepository;

    @Override
    protected JpaRepository<Build, Long> getRepository() {
        return buildRepository;
    }

    @Override
    protected Mapper<Build, BuildDTO> getMapper() {
        return new BuildMapper();
    }

    @Override
    protected Class<Build> getConcernedClass() {
        return Build.class;
    }

    @Override
    public BuildDTO create(BuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }

    @Override
    public BuildDTO update(BuildDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        throw new NotImplementedException("Not Yet Implemented");
    }
}
