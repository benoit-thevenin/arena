package fr.phoenyx.arena.builders.social;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import fr.phoenyx.arena.builders.GenericEntityBuilder;
import fr.phoenyx.arena.enums.social.GuildRole;
import fr.phoenyx.arena.models.battle.Build;
import fr.phoenyx.arena.models.item.Item;
import fr.phoenyx.arena.models.social.Guild;
import fr.phoenyx.arena.models.social.Player;

public class PlayerBuilder extends GenericEntityBuilder<Player> {

    private Player player;

    public PlayerBuilder() {
        player = new Player();
    }

    @Override
    protected Player getEntity() {
        return player;
    }

    public PlayerBuilder username(String username) {
        player.setUsername(username);
        return this;
    }

    public PlayerBuilder email(String email) {
        player.setEmail(email);
        return this;
    }

    public PlayerBuilder lastConnection(LocalDateTime lastConnection) {
        player.setLastConnection(lastConnection);
        return this;
    }

    public PlayerBuilder gold(int gold) {
        player.setGold(gold);
        return this;
    }

    public PlayerBuilder level(int level) {
        player.setLevel(level);
        return this;
    }

    public PlayerBuilder experience(long experience) {
        player.setExperience(experience);
        return this;
    }

    public PlayerBuilder inventory(List<Item> inventory) {
        player.setInventory(inventory);
        return this;
    }

    public PlayerBuilder builds(Set<Build> builds) {
        player.setBuilds(builds);
        return this;
    }

    public PlayerBuilder guild(Guild guild) {
        player.setGuild(guild);
        return this;
    }

    public PlayerBuilder guildRole(GuildRole guildRole) {
        player.setGuildRole(guildRole);
        return this;
    }

    public PlayerBuilder friends(Set<Player> friends) {
        player.setFriends(friends);
        return this;
    }
}
