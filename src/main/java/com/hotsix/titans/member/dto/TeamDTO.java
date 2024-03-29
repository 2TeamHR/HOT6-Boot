package com.hotsix.titans.member.dto;

import com.hotsix.titans.member.entity.TeamRole;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamDTO {

    private int teamCode;
    private String teamName;

    private String memberCode;
    private List<TeamRole> teamRole;

}
