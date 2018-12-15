package fr.phoenyx.arena.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import fr.phoenyx.arena.dtos.guild.GuildDTO;
import fr.phoenyx.arena.dtos.item.ItemDTO;
import fr.phoenyx.arena.models.Player;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PlayerDTO extends PlayerDTOLight {

    private String email;
    private int gold;
    private long experience;
    private List<ItemDTO> inventory = new ArrayList<>();
    private Set<BuildDTO> builds = new HashSet<>();
    private GuildDTO guild;
    private Set<PlayerDTOLight> friends = new HashSet<>();

    public PlayerDTO() {
        super();
    }

    public PlayerDTO(Player player) {
        super(player);
        email = player.getEmail();
        gold = player.getGold();
        experience = player.getExperience();
        inventory = player.getInventory().stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
        builds = player.getBuilds().stream()
                .map(BuildDTO::new)
                .collect(Collectors.toSet());
        if (player.getGuild() != null) {
            guild = new GuildDTO(player.getGuild());
        }
        friends = player.getFriends().stream()
                .map(PlayerDTOLight::new)
                .collect(Collectors.toSet());
    }
}
