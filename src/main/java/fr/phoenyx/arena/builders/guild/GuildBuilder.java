package fr.phoenyx.arena.builders.guild;

import java.util.List;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.Guild;

public class GuildBuilder extends GenericEntityBuilder<Guild> {

    private Guild guild;

    public GuildBuilder() {
        guild = new Guild();
    }

    @Override
    protected Guild getEntity() {
        return guild;
    }

    public GuildBuilder name(String name) {
        guild.setName(name);
        return this;
    }

    public GuildBuilder description(String description) {
        guild.setDescription(description);
        return this;
    }

    public GuildBuilder members(List<Player> members) {
        guild.setMembers(members);
        return this;
    }

    public GuildBuilder applicants(List<Applicant> applicants) {
        guild.setApplicants(applicants);
        return this;
    }
}
