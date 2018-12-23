package fr.phoenyx.arena.repositories.social;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.social.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
