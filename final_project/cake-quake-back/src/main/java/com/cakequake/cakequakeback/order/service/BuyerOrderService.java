package com.cakequake.cakequakeback.order.service;

import com.cakequake.cakequakeback.order.dto.buyer.CreateOrder;
import com.cakequake.cakequakeback.order.dto.buyer.OrderDetail;
import com.cakequake.cakequakeback.order.dto.buyer.OrderList;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List; // ⭐ List 임포트 추가 ⭐


@Service
@Transactional
public interface BuyerOrderService {

    //주문 생성
    CreateOrder.Response createOrder(String userId, CreateOrder.Request request);

    //주문 목록 조회
    OrderList.Response getOrderList(String userId, Pageable pageable);

    //주문 상세 조회
    OrderDetail.Response getOrderDetail(String userId, Long orderId);

    //주문 취소
    void cancelOrder(String userId, Long orderId);

    //특정 구매자(userId)의 최신 주문 N개 조회
    List<OrderList.OrderListItem> getLatestBuyerOrders(String userId);
}
