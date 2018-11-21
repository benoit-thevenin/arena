package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_HERO_BUILD;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_SHEET;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LEVEL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_HEROES;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_HEROES)
public class Hero extends GenericEntity {

    @Column(name = COLUMN_LEVEL, nullable = false)
    private int level;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = COLUMN_ID_HERO_BUILD)
    private HeroBuild heroBuild;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = COLUMN_ID_SHEET)
    private Sheet sheet;
}
