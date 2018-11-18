package fr.phoenyx.arena.repositories.skill;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.skill.PassiveSkill;

@Repository
public interface PassiveSkillRepository extends CrudRepository<PassiveSkill, Long> {

    List<PassiveSkill> findAll();
}
