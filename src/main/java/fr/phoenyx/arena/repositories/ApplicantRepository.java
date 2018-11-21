package fr.phoenyx.arena.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

    List<Applicant> findAll();
}
