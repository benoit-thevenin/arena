package fr.phoenyx.arena.repositories.guild;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.guild.GuildMember;

@Repository
public interface GuildMemberRepository extends CrudRepository<GuildMember, Long> {

    List<GuildMember> findAll();
}
