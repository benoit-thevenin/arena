package fr.phoenyx.arena.builders.social;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.models.battle.Build;
import fr.phoenyx.arena.models.social.Applicant;
import fr.phoenyx.arena.models.social.Player;

public class ApplicantBuilder extends GenericEntityBuilder<Applicant> {

    private Applicant applicant;

    public ApplicantBuilder() {
        applicant = new Applicant();
    }

    @Override
    protected Applicant getEntity() {
        return applicant;
    }

    public ApplicantBuilder player(Player player) {
        applicant.setPlayer(player);
        return this;
    }

    public ApplicantBuilder build(Build build) {
        applicant.setBuild(build);
        return this;
    }
}
