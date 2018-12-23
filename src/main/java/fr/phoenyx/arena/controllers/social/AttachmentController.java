package fr.phoenyx.arena.controllers.social;

import static fr.phoenyx.arena.constants.RestConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.phoenyx.arena.controllers.CrudController;
import fr.phoenyx.arena.dtos.social.AttachmentDTO;
import fr.phoenyx.arena.models.social.Attachment;
import fr.phoenyx.arena.services.CrudService;
import fr.phoenyx.arena.services.social.AttachmentService;

@RestController
@RequestMapping(ROOT_ATTACHMENTS)
public class AttachmentController extends CrudController<Attachment, AttachmentDTO> {

    @Autowired
    private AttachmentService attachmentService;

    @Override
    protected CrudService<Attachment, AttachmentDTO> getService() {
        return attachmentService;
    }
}
