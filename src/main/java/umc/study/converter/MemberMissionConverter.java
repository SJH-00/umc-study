package umc.study.converter;

import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberResponseDTO.AddMemberMissionResultDTO toAddMemberMissionResultDTO(MemberMission memberMission) {
        return MemberResponseDTO.AddMemberMissionResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}

