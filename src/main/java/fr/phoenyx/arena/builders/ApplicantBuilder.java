package fr.phoenyx.arena.builders;

import fr.phoenyx.arena.models.Applicant;
import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;

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
