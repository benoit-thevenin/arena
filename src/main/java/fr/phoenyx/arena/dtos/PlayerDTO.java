package fr.phoenyx.arena.dtos;

import java.util.List;
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
    private List<ItemDTO> inventory;
    private List<BuildDTO> builds;
    private GuildDTO guild;
    private List<PlayerDTOLight> friends;

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
                .collect(Collectors.toList());
        if (player.getGuild() != null) {
            guild = new GuildDTO(player.getGuild());
        }
        friends = player.getFriends().stream()
                .map(PlayerDTOLight::new)
                .collect(Collectors.toList());
    }
}
