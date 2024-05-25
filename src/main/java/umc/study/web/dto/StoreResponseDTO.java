package umc.study.web.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Builder
    public static class CreateReviewResultDTO {

        Long reviewId;
        LocalDateTime createdAt;
    }

    @Builder
    public static class CreateMissionResultDTO {

        Long missionId;
        LocalDateTime createdAt;
    }
}
