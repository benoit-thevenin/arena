package fr.phoenyx.arena.models;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_PLAYER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_APPLICANTS;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_APPLICANTS)
public class Applicant extends GenericEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_PLAYER)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_BUILD)
    private Build build;
}
