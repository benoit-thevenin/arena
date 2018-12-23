package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_MESSAGES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.MessageDTO;
import fr.phoenyx.arena.models.social.Message;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.MessageService;

@RestController
@RequestMapping(ROOT_MESSAGES)
public class MessageController extends CrudController<Message, MessageDTO> {

    @Autowired
    private MessageService messageService;

    @Override
    protected CrudService<Message, MessageDTO> getService() {
        return messageService;
    }
}
