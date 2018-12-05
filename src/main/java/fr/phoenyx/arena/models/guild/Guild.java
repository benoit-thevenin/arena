package fr.phoenyx.arena.models.guild;

import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_DESCRIPTION;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.COLUMN_NAME;
import static fr.phoenyx.arena.constants.DatabaseSchemaConstants.TABLE_GUILDS;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.phoenyx.arena.models.GenericEntity;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_GUILDS)
public class Guild extends GenericEntity {

    @Column(name = COLUMN_NAME, nullable = false)
    private String name;

    @Column(name = COLUMN_DESCRIPTION)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guild")
    private List<Player> members = new ArrayList<>();

    //TODO other fields like raid boss stage ?
}
