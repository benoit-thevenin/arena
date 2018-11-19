package fr.phoenyx.arena.builders;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import fr.phoenyx.arena.models.Build;
import fr.phoenyx.arena.models.Player;
import fr.phoenyx.arena.models.guild.GuildMember;
import fr.phoenyx.arena.models.item.Item;

public class PlayerBuilder {

    private Player player;

    public PlayerBuilder() {
        player = new Player();
    }

    public PlayerBuilder id(Long id) {
        player.setId(id);
        return this;
    }

    public PlayerBuilder dateCreation(LocalDateTime dateCreation) {
        player.setDateCreation(dateCreation);
        return this;
    }

    public PlayerBuilder dateModification(LocalDateTime dateModification) {
        player.setDateModification(dateModification);
        return this;
    }

    public PlayerBuilder modifier(Player modifier) {
        player.setModifier(modifier);
        return this;
    }

    public PlayerBuilder username(String username) {
        player.setUsername(username);
        return this;
    }

    public PlayerBuilder hashPassword(String hashPassword) {
        player.setHashPassword(hashPassword);
        return this;
    }

    public PlayerBuilder salt(String salt) {
        player.setSalt(salt);
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

    public PlayerBuilder builds(List<Build> builds) {
        player.setBuilds(builds);
        return this;
    }

    public PlayerBuilder guildMember(GuildMember guildMember) {
        player.setGuildMember(guildMember);
        return this;
    }

    public PlayerBuilder friends(Set<Player> friends) {
        player.setFriends(friends);
        return this;
    }

    public Player build() {
        return player;
    }
}
