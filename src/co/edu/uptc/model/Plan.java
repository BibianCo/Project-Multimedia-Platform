package co.edu.uptc.model;

public class Plan {
    private String description;
    private int value;
    private String namePlan;

    public Plan(String description, int value, String namePlan) {
        this.description = description;
        this.value = value;
        this.namePlan = namePlan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getNamePlan() {
        return namePlan;
    }

    public void setNamePlan(String namePlan) {
        this.namePlan = namePlan;
    }

}
