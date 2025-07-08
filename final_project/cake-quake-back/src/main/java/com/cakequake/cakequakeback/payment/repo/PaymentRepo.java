package com.cakequake.cakequakeback.payment.repo;

import com.cakequake.cakequakeback.payment.dto.PaymentResponseDTO;
import com.cakequake.cakequakeback.payment.entities.Payment;
import com.cakequake.cakequakeback.payment.entities.PaymentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentRepo extends JpaRepository<Payment,Long> {

    //본인 결제 목록 전체 조회 -> DTO리스트로 바로 변환
    @Query("""
    SELECT new com.cakequake.cakequakeback.payment.dto.PaymentResponseDTO(
    p.paymentId,
    p.provider,
    p.status,
    p.amount,
    p.transactionId,
    p.regDate,
    p.completedAt,
    p.cancelReason,
    p.refundAt,
    p.refundReason,
    p.redirectUrl,
    p.paymentUrl,
    p.order.shop.shopName,
    p.order.orderNumber
    )
    FROM Payment p
    WHERE p.member.uid = :uid
    ORDER BY p.regDate DESC
""")
    List<PaymentResponseDTO> selectPaymentListDTO(
            @Param("uid") Long uid
    );

    //본인 결제 단건 조회 -> DTO 바로 반환
    @Query("""
    SELECT new com.cakequake.cakequakeback.payment.dto.PaymentResponseDTO(
              p.paymentId,
              p.provider,
              p.status,
              p.amount,
              p.transactionId,
              p.regDate,
              p.completedAt,
              p.cancelReason,
              p.refundAt,
              p.refundReason,
              p.redirectUrl,
              p.paymentUrl,
              p.order.shop.shopName,
              p.order.orderNumber
    )
    From Payment p
    WHERE p.paymentId = :paymentId
    And p.member.uid =:uid
""")
    PaymentResponseDTO selectPaymentDTO(
            @Param("paymentId") Long paymentId,
            @Param("uid") Long uid
    );
// 특정 주문에 달린 결제들만 DTO로 바로 조회
@Query("""
      SELECT new com.cakequake.cakequakeback.payment.dto.PaymentResponseDTO(
          p.paymentId,
          p.provider,
          p.status,
          p.amount,
          p.transactionId,
          p.regDate,
          p.completedAt,
          p.cancelReason,
          p.refundAt,
          p.refundReason,
          p.redirectUrl,
          p.paymentUrl,
          p.order.shop.shopName,
          p.order.orderNumber
      )
      FROM Payment p
      WHERE p.order.orderId = :orderId
        AND p.member.uid   = :uid
      ORDER BY p.regDate DESC
    """)
List<PaymentResponseDTO> selectByOrderAndMember(
        @Param("orderId") Long orderId,
        @Param("uid")     Long uid
);

    // ① ready 단계(=PaymentStatus.READY)로 생성된 레코드를 찾기 위해
    Optional<Payment> findByOrder_OrderIdAndStatus(Long orderId, PaymentStatus status);

    // 본인 결제 엔티티 단건 조회 (payment_id, member.userId 조건)
    Optional<Payment> findByPaymentIdAndMemberUid(Long paymentId, Long userId);

    // 본인 결제 엔티티 페이징 조회 (member.userId 조건)
    Page<Payment> findAllByMemberUid(Long memberId, Pageable pageable);

    // 한 주문에 대한 결제 조회 (order.orderId 조건)
    Optional<Payment> findByOrderOrderId(Long orderId);

    // PG사 거래 식별자(transactionId)으로 조회
    Optional<Payment> findByTransactionId( String transactionId);

    Optional<Payment> findOneByOrderOrderIdAndMemberUidAndStatus(Long orderId, Long uid, PaymentStatus status);



}
