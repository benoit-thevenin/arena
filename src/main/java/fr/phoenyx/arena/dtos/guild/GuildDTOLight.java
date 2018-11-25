package fr.phoenyx.arena.dtos.guild;

import fr.phoenyx.arena.dtos.GenericEntityDTO;
import fr.phoenyx.arena.models.guild.Guild;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GuildDTOLight extends GenericEntityDTO {

    protected String name;
    protected String description;

    public GuildDTOLight() {
        super();
    }

    public GuildDTOLight(Guild guild) {
        super(guild);
        name = guild.getName();
        description = guild.getDescription();
    }
}
