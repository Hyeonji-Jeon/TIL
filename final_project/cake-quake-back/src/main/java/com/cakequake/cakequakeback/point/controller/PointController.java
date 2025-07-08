package com.cakequake.cakequakeback.point.controller;


import com.cakequake.cakequakeback.common.dto.InfiniteScrollResponseDTO;
import com.cakequake.cakequakeback.common.dto.PageRequestDTO;
import com.cakequake.cakequakeback.point.dto.PointHistoryResponseDTO;
import com.cakequake.cakequakeback.point.dto.PointRequestDTO;
import com.cakequake.cakequakeback.point.dto.PointResponseDTO;
import com.cakequake.cakequakeback.point.entities.Point;
import com.cakequake.cakequakeback.point.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/points")
@RequiredArgsConstructor
public class PointController {
    private final PointService pointService;

    //현재 잔액 조회
    @GetMapping("/balance")
    public ResponseEntity<PointResponseDTO> getBalance(
            @AuthenticationPrincipal(expression = "member.uid") Long uid) {

        Long balance = pointService.getCurrentBalance(uid);
        return ResponseEntity.ok(new PointResponseDTO(uid, balance));
    }

    //포인트 증감 처리
    @PostMapping("/change")
    public ResponseEntity<PointResponseDTO> changePoint(
            @AuthenticationPrincipal(expression = "member.uid") Long uid,
            @RequestBody PointRequestDTO pointRequestDTO) {

        Long updateBalance = pointService.changePoint(uid, pointRequestDTO.getAmount(), pointRequestDTO.getDescription());
        return ResponseEntity.ok(new PointResponseDTO(uid,updateBalance));
    }

    @GetMapping("/history")
    public ResponseEntity<InfiniteScrollResponseDTO<PointHistoryResponseDTO>> getHistory(
            PageRequestDTO pageRequestDTO,
            @AuthenticationPrincipal(expression = "member.uid") Long uid
    ) {

        InfiniteScrollResponseDTO<PointHistoryResponseDTO> historyList = pointService.getPointHistoryPage(pageRequestDTO,uid);
    return ResponseEntity.ok(historyList);
    }
}
