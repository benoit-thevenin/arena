package fr.phoenyx.arena.services.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.social.AttachmentDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.AttachmentMapper;
import fr.phoenyx.arena.models.social.Attachment;
import fr.phoenyx.arena.repositories.social.AttachmentRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class AttachmentService extends CrudService<Attachment, AttachmentDTO> {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    protected JpaRepository<Attachment, Long> getRepository() {
        return attachmentRepository;
    }

    @Override
    protected Mapper<Attachment, AttachmentDTO> getMapper() {
        return new AttachmentMapper();
    }

    @Override
    protected Class<Attachment> getConcernedClass() {
        return Attachment.class;
    }

    @Override
    public AttachmentDTO create(AttachmentDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AttachmentDTO update(AttachmentDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
