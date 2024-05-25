package umc.study.service.MemberService;

import umc.study.domain.Member;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.MemberRequestDTO;

import java.util.List;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
    MemberMission addMemberMission(Long memberId, Long missionId);
    boolean isInRepository(List<Long> idList);
}
