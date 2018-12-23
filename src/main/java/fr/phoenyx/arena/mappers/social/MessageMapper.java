package fr.phoenyx.arena.mappers.social;

import fr.phoenyx.arena.dtos.social.MessageDTO;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.models.social.Message;

public class MessageMapper implements Mapper<Message, MessageDTO> {

    @Override
    public MessageDTO entityToDto(Message entity) {
        return new MessageDTO(entity);
    }
}
