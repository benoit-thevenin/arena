package fr.phoenyx.arena.constants;

public class MessagesConstants {

    private MessagesConstants() {}

    public static final String NOT_FOUND = "not found :";

    public static final String EXPECTED_ID_FOR_PUT = "Expected id for PUT request<br/>";
    public static final String UNEXPECTED_ID_FOR_POST = "Unexpected id for POST request<br/>";

    public static final String APPLICANT_PLAYER_EXPECTED = "A not null Player is expected<br/>";

    public static final String BUILD_NEGATIVE_VITALITY = "Vitality should not be negative<br/>";
    public static final String BUILD_NEGATIVE_STRENGTH = "Strength should not be negative<br/>";
    public static final String BUILD_NEGATIVE_INTELLIGENCE = "Intelligence should not be negative<br/>";
    public static final String BUILD_NEGATIVE_AGILITY = "Agility should not be negative<br/>";
    public static final String BUILD_ZERO_ACTIVE_SKILL = "At least one active skill must be selected<br/>";
    public static final String BUILD_ILLEGAL_ACTIVE_SKILLS = String.join(" ", "No more than", Integer.toString(GlobalConstants.MAX_ACTIVE_SKILLS), "active skills can be selected<br/>");
    public static final String BUILD_ILLEGAL_PASSIVE_SKILLS = String.join(" ", "No more than", Integer.toString(GlobalConstants.MAX_PASSIVE_SKILLS), "passive skills can be selected<br/>");
    public static final String BUILD_ILLEGAL_STUFF = "An item slot can be used only once per build<br/>";
}
