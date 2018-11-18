package fr.phoenyx.arena.models.battle;

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
import javax.persistence.Table;

import fr.phoenyx.arena.enums.skill.Effect;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "SHEET")
public class Sheet extends GenericEntity {

    //FIXME one sheet per round?
    @Column(name = "INIT_HEALTH")
    private int initHealth;

    @Column(name = "INIT_MANA")
    private int initMana;

    @Column(name = "STRENGTH")
    private int strength;

    @Column(name = "AGILITY")
    private int agility;

    @Column(name = "INTELLIGENCE")
    private int intelligence;

    @Column(name = "CURRENT_HEALTH")
    private int currentHealth;

    @Column(name = "CURRENT_MANA")
    private int currentMana;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = Effect.class)
    @JoinTable(name = "SHEET_EFFECT", joinColumns = @JoinColumn(name = "ID_SHEET"))
    @Column(name = "EFFECT")
    @Enumerated(EnumType.STRING)
    private List<Effect> effects = new ArrayList<>();
}
