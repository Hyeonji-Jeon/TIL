package com.cakequake.cakequakeback.order.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeOrder is a Querydsl query type for CakeOrder
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeOrder extends EntityPathBase<CakeOrder> {

    private static final long serialVersionUID = 1583057517L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeOrder cakeOrder = new QCakeOrder("cakeOrder");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final NumberPath<Integer> discountAmount = createNumber("discountAmount", Integer.class);

    public final NumberPath<Integer> finalPaymentAmount = createNumber("finalPaymentAmount", Integer.class);

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final StringPath orderNote = createString("orderNote");

    public final StringPath orderNumber = createString("orderNumber");

    public final NumberPath<Integer> orderTotalPrice = createNumber("orderTotalPrice", Integer.class);

    public final DatePath<java.time.LocalDate> pickupDate = createDate("pickupDate", java.time.LocalDate.class);

    public final TimePath<java.time.LocalTime> pickupTime = createTime("pickupTime", java.time.LocalTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final EnumPath<OrderStatus> status = createEnum("status", OrderStatus.class);

    public final NumberPath<Integer> totalNumber = createNumber("totalNumber", Integer.class);

    public QCakeOrder(String variable) {
        this(CakeOrder.class, forVariable(variable), INITS);
    }

    public QCakeOrder(Path<? extends CakeOrder> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeOrder(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeOrder(PathMetadata metadata, PathInits inits) {
        this(CakeOrder.class, metadata, inits);
    }

    public QCakeOrder(Class<? extends CakeOrder> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

