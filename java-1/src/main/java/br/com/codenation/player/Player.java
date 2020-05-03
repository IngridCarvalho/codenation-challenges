package br.com.codenation.player;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {

    private Long id;
    private Long idTeam;
    private String name;
    private LocalDate birthDate;
    private Integer skillLevel;
    private BigDecimal salary;
    private boolean isCaptain;

    public Player(Long id, Long idTeam, String name, LocalDate birthDate, Integer skillLevel, BigDecimal salary) {
        this.id = id;
        this.idTeam = idTeam;
        this.name = name;
        this.birthDate = birthDate;
        this.skillLevel = skillLevel;
        this.salary = salary;
        this.isCaptain = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isCaptain() {
        return isCaptain;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }
}
