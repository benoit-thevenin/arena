package fr.phoenyx.arena.repositories.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.skill.PassiveSkill;

@Repository
public interface PassiveSkillRepository extends JpaRepository<PassiveSkill, Long> {

}
