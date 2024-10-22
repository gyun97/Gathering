package nbc_final.gathering.domain.gathering.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nbc_final.gathering.common.dto.AuthUser;
import nbc_final.gathering.common.exception.ApiResponse;
import nbc_final.gathering.domain.gathering.dto.request.GatheringRequestDto;
import nbc_final.gathering.domain.gathering.dto.response.GatheringResponseDto;
import nbc_final.gathering.domain.gathering.service.GatheringService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/gatherings")
@RequiredArgsConstructor
public class GatheringController {

  private final GatheringService gatheringService;

  // 반환 데이터 존재 O
  @PostMapping
  public ResponseEntity<ApiResponse<GatheringResponseDto>> createGroup(@AuthenticationPrincipal AuthUser authUser,
                                                          @RequestBody @Valid GatheringRequestDto gatheringRequestDto) {

    GatheringResponseDto res = gatheringService.createGroup(authUser, gatheringRequestDto);
    return ResponseEntity.ok(ApiResponse.createSuccess(res));
  }

  /*
  {
  “status” : 200,
  “message” : “정상 처리 되었습니다.”,
  “data” : {
     “groupId” : 1,
     “title” : “소모임 제목”,
     “description” : “소모임 설명”,
     “groupMaxCount” : “소모임 최대 인원”,
     “groupImage” :  “이미지.png”
    }
  }
  */
/*

  @GetMapping("/{groupId}")
  public ResponseEntity<ApiResponse<GatheringResponseDto>> getGathering(@AuthenticationPrincipal AuthUser authUser,
                                                   @PathVariable Long groupId) {

    GatheringResponseDto res = groupService.getGathering(authUser, groupId)

    return ResponseEntity.ok(ApiResponse.createSuccess(res));
  }
*/




}
