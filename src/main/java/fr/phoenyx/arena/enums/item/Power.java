package fr.phoenyx.arena.enums.item;

public enum Power {

    BURN("Burn",20,"toto");

    private String name;
    private int value;
    private String description;

    Power(String name, int value, String description){
        this.name=name;
        this.value=value;
        this.description=description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
