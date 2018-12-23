package fr.phoenyx.arena.builders.social;

import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.models.social.Player;
import fr.phoenyx.arena.models.social.Team;

public class TeamBuilder extends GenericEntityBuilder<Team> {

    private Team team;

    public TeamBuilder() {
        team = new Team();
    }

    @Override
    protected Team getEntity() {
        return team;
    }

    public TeamBuilder dimension(int dimension) {
        team.setDimension(dimension);
        return this;
    }

    public TeamBuilder leader(Player leader) {
        team.setLeader(leader);
        return this;
    }

    public TeamBuilder members(Set<Applicant> members) {
        team.setMembers(members);
        return this;
    }

    public TeamBuilder applicants(Set<Applicant> applicants) {
        team.setApplicants(applicants);
        return this;
    }
}
