/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author jians
 */
public class JobRequirement {
    private String skillName;
    private String proficiencyLevel;

    public JobRequirement(String skillName, String proficiencyLevel) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    @Override
    public String toString() {
        return skillName + " (" + proficiencyLevel + ")";
    }
}
