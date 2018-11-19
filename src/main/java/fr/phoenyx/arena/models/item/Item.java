package fr.phoenyx.arena.models.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.enums.item.Power;
import fr.phoenyx.arena.enums.item.Rarity;
import fr.phoenyx.arena.models.GenericEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ITEM")
public class Item extends GenericEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "LEVEL")
    private int level;

    @Column(name = "QUANTITY")
    private int quantity;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ITEM")
    private List<Bonus> bonuses = new ArrayList<>();

    private Power power;
}
