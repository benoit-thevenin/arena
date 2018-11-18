package fr.phoenyx.arena.enums;

public enum GuildRole {
    GUILD_LEADER("Guild leader"),
    OFFICER("Officer"),
    MEMBER("Member");

    private String description;

    GuildRole(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
