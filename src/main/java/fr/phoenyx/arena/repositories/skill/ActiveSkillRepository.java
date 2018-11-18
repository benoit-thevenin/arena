package fr.phoenyx.arena.repositories.skill;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.skill.ActiveSkill;

@Repository
public interface ActiveSkillRepository extends CrudRepository<ActiveSkill, Long> {

    List<ActiveSkill> findAll();
}
