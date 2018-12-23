package fr.phoenyx.arena.models.social;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.*;

import javax.persistence.Entity;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_MESSAGES)
public class Message extends GenericEntity {

    private String object;

    private String body;
}
