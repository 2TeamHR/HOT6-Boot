package com.hotsix.titans.member.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "TBL_TEAM")
public class Team {

    @Id
    @Column(name = "TEAM_CODE")
    private int teamCode;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @OneToMany
    @JoinColumn(name = "TEAM_CODE")
    private List<TeamRole> teamRole;

    @Override
    public String toString() {
        return "Team{" +
                "teamCode=" + teamCode +
                ", teamName='" + teamName + '\'' +
                ", teamRole=" + teamRole +
                '}';
    }
}
