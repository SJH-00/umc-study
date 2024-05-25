package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.validation.annotation.ExistMember;
import umc.study.validation.annotation.ExistStore;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> addReview(@RequestBody @Valid StoreRequestDTO.ReviewDTO request,
                                                                         @RequestParam(name = "memberId") @ExistMember Long memberId,
                                                                         @PathVariable(name = "storeId") @ExistStore Long storeId) {

        Review review = storeCommandService.createReview(request, memberId, storeId);
        return ApiResponse.onSuccess(StoreConverter.toCreateReviewResultDTO(review));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> addMission(@RequestBody @Valid StoreRequestDTO.MissionDTO request,
                                                                           @PathVariable(name = "storeId") @ExistStore Long storeId) {

        Mission mission = storeCommandService.createMission(request, storeId);
        return ApiResponse.onSuccess(StoreConverter.toCreateMissionResultDTO(mission));
    }
}
