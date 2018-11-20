package fr.phoenyx.arena.models.battle;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_AGILITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_CURRENT_HEALTH;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_CURRENT_MANA;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_EFFECT;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_SHEET;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_INIT_HEALTH;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_INIT_MANA;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_INTELLIGENCE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_STRENGTH;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_SHEETS;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_SHEETS_EFFECTS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.Effect;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_SHEETS)
public class Sheet extends GenericEntity {

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "sheet")
    private Hero hero;

    @Column(name = COLUMN_INIT_HEALTH, nullable = false)
    private int initHealth;

    @Column(name = COLUMN_INIT_MANA, nullable = false)
    private int initMana;

    @Column(name = COLUMN_STRENGTH, nullable = false)
    private int strength;

    @Column(name = COLUMN_AGILITY, nullable = false)
    private int agility;

    @Column(name = COLUMN_INTELLIGENCE, nullable = false)
    private int intelligence;

    @Column(name = COLUMN_CURRENT_HEALTH, nullable = false)
    private int currentHealth;

    @Column(name = COLUMN_CURRENT_MANA, nullable = false)
    private int currentMana;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Effect.class)
    @JoinTable(name = TABLE_SHEETS_EFFECTS, joinColumns = @JoinColumn(name = COLUMN_ID_SHEET))
    @Column(name = COLUMN_EFFECT, nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Effect> effects = new ArrayList<>();
}
