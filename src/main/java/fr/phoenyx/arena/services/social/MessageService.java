package fr.phoenyx.arena.services.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.phoenyx.arena.dtos.social.MessageDTO;
import fr.phoenyx.arena.exceptions.BadRequestException;
import fr.phoenyx.arena.exceptions.EntityNotFoundException;
import fr.phoenyx.arena.mappers.Mapper;
import fr.phoenyx.arena.mappers.social.MessageMapper;
import fr.phoenyx.arena.models.social.Message;
import fr.phoenyx.arena.repositories.social.MessageRepository;
import fr.phoenyx.arena.services.CrudService;

@Service
public class MessageService extends CrudService<Message, MessageDTO> {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    protected JpaRepository<Message, Long> getRepository() {
        return messageRepository;
    }

    @Override
    protected Mapper<Message, MessageDTO> getMapper() {
        return new MessageMapper();
    }

    @Override
    protected Class<Message> getConcernedClass() {
        return Message.class;
    }

    @Override
    public MessageDTO create(MessageDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public MessageDTO update(MessageDTO dto) throws BadRequestException, EntityNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
}
