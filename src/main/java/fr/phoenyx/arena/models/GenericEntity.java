package fr.phoenyx.arena.models;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_DATE_CREATION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_DATE_MODIFICATION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_MODIFIER;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = COLUMN_ID)
    protected Long id;

    @Column(name = COLUMN_DATE_CREATION, nullable = false)
    protected LocalDateTime dateCreation;

    @Column(name = COLUMN_DATE_MODIFICATION)
    protected LocalDateTime dateModification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_MODIFIER)
    protected Player modifier;

    /**
     * This method should be called whenever a daughter class is calling an update method
     * @param modifier the player in cause of the update
     */
    public void update(Player modifier) {
        this.modifier = modifier;
        dateModification = LocalDateTime.now();
    }
}
