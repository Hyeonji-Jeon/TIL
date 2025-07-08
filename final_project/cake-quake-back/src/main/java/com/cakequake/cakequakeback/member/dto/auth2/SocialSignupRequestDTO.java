package com.cakequake.cakequakeback.member.dto.auth2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 소셜 로그인 후 db 등록을 위해 간단한 가입 정보를 받을 때 사용
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialSignupRequestDTO {

    @NotBlank(message = "아이디는 필수 입력값입니다.")
    private String userId; // socialId와 동일

    @NotBlank(message = "이름은 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[가-힣a-zA-Z])([가-힣a-zA-Z0-9]{1,20})$", message = "이름은 한글 또는 영어가 최소 1개 이상 포함되고, 한글, 영어, 숫자 조합으로 20자 이내로 입력해야합니다.")
    private String uname;

    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    @Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", message = "전화번호 양식은 XXX-XXX(X)-XXXX로 입력해야합니다.")
    private String phoneNumber;

    @NotBlank(message = "정보 공개 여부는 필수 입력값입니다.")
    private Boolean publicInfo;

    @NotNull(message = "알람 설정 값은 필수입니다.")
    private Boolean alarm;

    @NotBlank
    @Pattern(regexp = "^(kakao|google)$", message = "가입 유형은 kakao 또는 google만 허용됩니다.")
    private String joinType;


    @Override
    public String toString() {
        return String.format("SocialSignupRequestDTO{userId='%s', uname='%s', phoneNumber='%s', publicInfo='%s', alarm=%s, joinType='%s'}",
                userId, uname, mask(phoneNumber), publicInfo, alarm, joinType);
    }

    private String mask(String input) {
        if (input == null || input.length() < 4) return "***";
        return input.substring(0, 2) + "***" + input.substring(input.length() - 2);
    }

    public void changeUname( String uname) {
        this.uname = uname;
    }
}
