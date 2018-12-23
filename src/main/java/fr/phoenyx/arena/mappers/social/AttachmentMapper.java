package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.AttachmentDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Attachment;

public class AttachmentMapper implements Mapper<Attachment, AttachmentDTO> {

    @Override
    public AttachmentDTO entityToDto(Attachment entity) {
        return new AttachmentDTO(entity);
    }
}
