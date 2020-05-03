package br.com.codenation.team;

import java.time.LocalDate;

public class Team {

    private Long id;
    private String name;
    private LocalDate createDate;
    private String mainUniformColor;
    private String secondaryUniformColor;

    public Team(Long id, String name, LocalDate createDate, String mainUniformColor, String secondaryUniformColor) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.mainUniformColor = mainUniformColor;
        this.secondaryUniformColor = secondaryUniformColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getMainUniformColor() {
        return mainUniformColor;
    }

    public void setMainUniformColor(String mainUniformColor) {
        this.mainUniformColor = mainUniformColor;
    }

    public String getSecondaryUniformColor() {
        return secondaryUniformColor;
    }

    public void setSecondaryUniformColor(String secondaryUniformColor) {
        this.secondaryUniformColor = secondaryUniformColor;
    }
}
