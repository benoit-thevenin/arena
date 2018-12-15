package fr.phoenyx.arena.models.item;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ID_ITEM;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_ITEM_TYPE;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_LEVEL;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_NAME;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_POWER;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_QUANTITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_RARITY;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_ITEMS;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.item.ItemType;
import fr.phoenyx.arena.enums.item.Power;
import fr.phoenyx.arena.enums.item.Rarity;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_ITEMS)
public class Item extends GenericEntity {

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_LEVEL, nullable = false)
    private int level;

    @Column(name = COLUMN_QUANTITY, nullable = false)
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_ITEM_TYPE, nullable = false)
    private ItemType itemType;

    @Enumerated(EnumType.STRING)
    @Column(name = COLUMN_RARITY, nullable = false)
    private Rarity rarity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = COLUMN_ID_ITEM)
    private Set<Bonus> bonuses = new HashSet<>();

    @Enumerated
    @Column(name = COLUMN_POWER)
    private Power power;
}
