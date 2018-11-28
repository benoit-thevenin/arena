package fr.phoenyx.arena.repositories.guild;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.guild.Guild;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {

}
