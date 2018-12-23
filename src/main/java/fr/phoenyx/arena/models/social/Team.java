package fr.phoenyx.arena.models.social;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_DIMENSION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_LEADER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_TEAM;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_TEAMS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_TEAMS)
public class Team extends GenericEntity {

    @Column(name = COLUMN_DIMENSION)
    private int dimension;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_LEADER)
    private Player leader;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_TEAM)
    private Set<Applicant> members = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_ID_TEAM)
    private Set<Applicant> applicants = new HashSet<>();
}
