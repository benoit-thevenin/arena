package fr.phoenyx.arena.repositories.guild;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.phoenyx.arena.models.guild.Guild;

@Repository
public interface GuildRepository extends CrudRepository<Guild, Long> {

    List<Guild> findAll();
}
