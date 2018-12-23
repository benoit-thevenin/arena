package fr.phoenyx.arena.builders.social;

import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.models.social.Guild;
import fr.phoenyx.arena.models.social.Player;

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

    public GuildBuilder members(Set<Player> members) {
        guild.setMembers(members);
        return this;
    }

    public GuildBuilder applicants(Set<Applicant> applicants) {
        guild.setApplicants(applicants);
        return this;
    }
}
