package fr.phoenyx.arena.dtos.social;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.social.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends GenericEntityDTO {

    public MessageDTO() {
        super();
    }

    public MessageDTO(Message message) {
        super(message);
    }
}
