package fr.phoenyx.arena.dtos.social;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.social.Attachment;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttachmentDTO extends GenericEntityDTO {

    public AttachmentDTO() {
        super();
    }

    public AttachmentDTO(Attachment attachment) {
        super(attachment);
    }
}
