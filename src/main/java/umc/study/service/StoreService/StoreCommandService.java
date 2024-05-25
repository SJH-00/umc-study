package umc.study.service.StoreService;

import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    Review createReview(StoreRequestDTO.ReviewDTO request, Long memberId, Long storeId);
    Mission createMission(StoreRequestDTO.MissionDTO request, Long storeId);
}
