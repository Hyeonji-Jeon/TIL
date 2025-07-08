package com.cakequake.cakequakeback.member.validator;

import com.cakequake.cakequakeback.common.exception.BusinessException;
import com.cakequake.cakequakeback.common.exception.ErrorCode;
import com.cakequake.cakequakeback.member.dto.auth2.SocialSignupRequestDTO;
import com.cakequake.cakequakeback.member.dto.buyer.BuyerSignupRequestDTO;
import com.cakequake.cakequakeback.member.dto.seller.SellerSignupStep1RequestDTO;
import com.cakequake.cakequakeback.member.dto.seller.SellerSignupStep2RequestDTO;
import com.cakequake.cakequakeback.member.entities.Member;
import com.cakequake.cakequakeback.member.entities.SocialType;
import com.cakequake.cakequakeback.member.entities.VerificationType;
import com.cakequake.cakequakeback.member.repo.MemberRepository;
import com.cakequake.cakequakeback.member.repo.PhoneVerificationRepository;
import com.cakequake.cakequakeback.shop.repo.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class MemberValidator {

    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;

    public MemberValidator(MemberRepository memberRepository, ShopRepository shopRepository) {
        this.memberRepository = memberRepository;
        this.shopRepository = shopRepository;
    }

    public void validateSignupRequest(BuyerSignupRequestDTO dto) {

        String userId = dto.getUserId();

        // 형식 검사
        if (!isValidUserId(dto.getUserId())) {
            throw new BusinessException(ErrorCode.INVALID_USER_ID); // 601
        }
        if (!isValidPassword(dto.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD); // 602
        }
        if (!isValidName(dto.getUname())) {
            throw new BusinessException(ErrorCode.INVALID_NAME_SHORT); // 603
        }
        if (!isValidPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.INVALID_PHONE); // 604
        }
        if (!isValidJoinType(dto.getJoinType())) {
            throw new BusinessException(ErrorCode.INVALID_SIGNUP_TYPE); // 606
        }

        // ID 중복 검사
        if (memberRepository.existsByUserId(userId)) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_USER_ID); // 701
        }

        // 전화번호 중복 검사
        if (memberRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_PHONE); // 702
        }
    }

    // 소셜 회원가입 형식 검사
    public void validateSocialSignupRequest(SocialSignupRequestDTO dto) {

        // 형식 검사
        if (!isValidName(dto.getUname())) {
            throw new BusinessException(ErrorCode.INVALID_NAME_SHORT); // 603
        }
        if (!isValidPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.INVALID_PHONE); // 604
        }
        if (!isValidJoinType(dto.getJoinType())) {
            throw new BusinessException(ErrorCode.INVALID_SIGNUP_TYPE); // 606
        }

        // ID 중복 검사
        if (memberRepository.existsByUserId(dto.getUserId())) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_USER_ID); // 701
        }

        // 전화번호 중복 검사
        if (memberRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_PHONE); // 702
        }
    }

    public void validateSellerSignup(SellerSignupStep1RequestDTO dto) {

        String userId = dto.getUserId();

        /* 형식 검사 */
        if (!isValidUserId(dto.getUserId())) {
            throw new BusinessException(ErrorCode.INVALID_USER_ID); // 601
        }
        if (!isValidPassword(dto.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD); // 602
        }
        if (!isValidName(dto.getUname())) {
            throw new BusinessException(ErrorCode.INVALID_NAME_SHORT); // 603
        }
        if (!isValidPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.INVALID_PHONE); // 604
        }
        if (!isValidJoinType(dto.getJoinType())) {
            throw new BusinessException(ErrorCode.INVALID_SIGNUP_TYPE); // 606
        }
        // 사업자 등록 번호, 대표자 성명, 개업 일자, 매장명
        if (!isValidBusinessNumber(dto.getBusinessNumber())) {
            throw new BusinessException(ErrorCode.INVALID_BUSINESS_NUMBER); // 607
        }
        if (!isValidBossName(dto.getBossName())) {
            throw new BusinessException(ErrorCode.INVALID_OWNER_NAME); // 609
        }
        if (!isValidOpeningDate(dto.getOpeningDate())) {
            throw new BusinessException(ErrorCode.INVALID_DATETIME_FORMAT); // 642
        }
        if (!isValidShopName(dto.getShopName())) {
            throw new BusinessException(ErrorCode.INVALID_COMPANY_NAME); // 608
        }

        // ID 중복 검사
        if (memberRepository.existsByUserId(userId)) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_USER_ID); // 701
        }

        // 전화번호 중복 검사
        if (memberRepository.existsByPhoneNumber(dto.getPhoneNumber())) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_PHONE); // 702
        }
    }

    public void validateSellerSignup2(SellerSignupStep2RequestDTO dto) {

        if (dto.getTempSellerId() == null) {
            throw new BusinessException(ErrorCode.MISSING_TEMP_SELLER_ID); // 611
        }

        if (dto.getShopAddress() == null || dto.getShopAddress().isBlank()) {
            throw new BusinessException(ErrorCode.INVALID_SHOP_ADDRESS); // 613
        }

        // 매장 전화번호가 공백으로 넘어왔을 때
        if (dto.getShopPhoneNumber() != null && dto.getShopPhoneNumber().isBlank()) {
            dto.setShopPhoneNumber(null);
        }

        if (dto.getShopPhoneNumber() != null && !dto.getShopPhoneNumber().matches("^\\d{2,4}-\\d{3,4}-\\d{4}$")) {
            throw new BusinessException(ErrorCode.INVALID_PHONE); // 604
        }

        if (dto.getOpenTime() == null || dto.getCloseTime() == null) {
            throw new BusinessException(ErrorCode.INVALID_BUSINESS_HOURS); // 616
        }

        if (dto.getMainProductDescription() == null || dto.getMainProductDescription().isBlank()) {
            throw new BusinessException(ErrorCode.MISSING_SHORT_DESCRIPTION); // 633
        }

        int length = dto.getMainProductDescription().length();
        if (length < 10 || length > 200) {
            throw new BusinessException(ErrorCode.MISSING_SHORT_DESCRIPTION); // 633
        }

        if (shopRepository.existsByPhone(dto.getShopPhoneNumber())) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_PHONE); // 702
        }

    }

    public void validateUserId(String userId) {
        if (!isValidUserId(userId)) {
            throw new BusinessException(ErrorCode.INVALID_USER_ID);
        }
        if (memberRepository.existsByUserId(userId)) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_USER_ID);
        }
    }

    public void validatePassword(String password) {
        if (!isValidPassword(password)) {
            throw new BusinessException(ErrorCode.INVALID_PASSWORD);
        }
    }

    public void validateName(String uname) {
        if (!isValidName(uname)) {
            throw new BusinessException(ErrorCode.INVALID_NAME_SHORT);
        }
    }

    // 전화번호 형식 + 중복 검사
    public void validatePhoneNumber(String phoneNumber) {
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new BusinessException(ErrorCode.INVALID_PHONE);
        }
        if (memberRepository.existsByPhoneNumber(phoneNumber)) {
            throw new BusinessException(ErrorCode.ALREADY_EXIST_PHONE);
        }
    }

    public void validateJoinType(String joinType) {
        if (!isValidJoinType(joinType)) {
            throw new BusinessException(ErrorCode.INVALID_SIGNUP_TYPE);
        }
    }

    // member 유효성 검사
    public Member validateMemberByUid(Long uid) {
        return memberRepository.findById(uid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }


    // 검증용 정규식
    private boolean isValidUserId(String id) {
        return id != null && id.matches("^[a-zA-Z0-9]{4,20}$");
    }

    private boolean isValidPassword(String pw) {
        return pw != null && pw.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-]).{8,20}$");
    }

    private boolean isValidName(String name) {
        return name != null && name.matches("^(?=.*[가-힣a-zA-Z])([가-힣a-zA-Z0-9]{1,20})$");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\d{3}-\\d{4}-\\d{4}$");
    }

    private boolean isValidBusinessNumber(String businessNumber) {
        return businessNumber != null && businessNumber.matches("^\\d{10}$");
    }

    private boolean isValidBossName(String bossName) {
        return bossName != null && bossName.matches("^[가-힣a-zA-Z]+$");
    }

    private boolean isValidOpeningDate(String openingDate) {
        return openingDate != null && openingDate.matches("^\\d{8}$");
    }

    private boolean isValidShopName(String shopName) {
        return shopName != null && shopName.length() >= 1 && shopName.length() <= 50;
    }

    // "KAKAO", "GOOGLE", "BASIC" 외 값은 예외 발생
    private boolean isValidJoinType(String joinType) {
        try {
            SocialType.from(joinType); // enum 내부에서 toUpperCase 처리
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}
