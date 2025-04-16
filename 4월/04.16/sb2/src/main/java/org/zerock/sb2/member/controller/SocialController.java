package org.zerock.sb2.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.sb2.member.service.MemberService;
import org.zerock.sb2.util.JWTUtil;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor
public class SocialController {

    private final MemberService memberService;

    private final JWTUtil jwtUtil;

    @PostMapping("/api/v1/member/login")
    public ResponseEntity<String[]> login(@RequestParam("mid") String mid, @RequestParam("mpw") String mpw) {

        log.info("login----------------------");
        log.info(mid + " " + mpw);

        String accessToken = jwtUtil.createToken(Map.of("mid", mid), 5);

        String refreshToken = jwtUtil.createToken(Map.of("mid", mid), 10);

        String[] result = new String[]{accessToken, refreshToken};

        return ResponseEntity.ok(result);
    }

    @RequestMapping("/api/v1/member/kakao")
    public ResponseEntity<String[]> getKakao( @RequestParam("accessToken") String accessToken) {

        log.info("getKakao: " + accessToken);

        String kakaoEmail = memberService.getKakaoEmail(accessToken);

        log.info("KakaoEmail: " + kakaoEmail);

        String[] result = new String[]{"access.........", "refresh............."};

        return ResponseEntity.ok(result);

    }

    @RequestMapping("/api/v1/member/refresh")
    public ResponseEntity<String[]> refresh (
            @RequestHeader("Authorization") String accessTokenStr,
            @RequestParam("refreshToken") String refreshToken) {

        String accessToken = accessTokenStr.substring(7);
        String uid = "user00";

        String newAccessToken = jwtUtil.createToken(Map.of("uid",uid), 5);
        String newRefreshToken = jwtUtil.createToken(Map.of("uid",uid), 10); //60*24*7

        String[] result = new String[]{newAccessToken, newRefreshToken};

        return ResponseEntity.ok(result);
    }

}