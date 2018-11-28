package fr.phoenyx.arena.repositories.guild;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.guild.GuildMember;

@Repository
public interface GuildMemberRepository extends JpaRepository<GuildMember, Long> {

}
