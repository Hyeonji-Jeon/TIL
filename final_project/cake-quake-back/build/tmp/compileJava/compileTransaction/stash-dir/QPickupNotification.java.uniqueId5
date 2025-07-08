package com.cakequake.cakequakeback.notification.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPickupNotification is a Querydsl query type for PickupNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPickupNotification extends EntityPathBase<PickupNotification> {

    private static final long serialVersionUID = -1139492779L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPickupNotification pickupNotification = new QPickupNotification("pickupNotification");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.order.entities.QCakeOrder order;

    public final NumberPath<Long> pickupNotiId = createNumber("pickupNotiId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final DateTimePath<java.time.LocalDateTime> scheduledSendTime = createDateTime("scheduledSendTime", java.time.LocalDateTime.class);

    public final EnumPath<PickupNotification.NotificationStatus> status = createEnum("status", PickupNotification.NotificationStatus.class);

    public QPickupNotification(String variable) {
        this(PickupNotification.class, forVariable(variable), INITS);
    }

    public QPickupNotification(Path<? extends PickupNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPickupNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPickupNotification(PathMetadata metadata, PathInits inits) {
        this(PickupNotification.class, metadata, inits);
    }

    public QPickupNotification(Class<? extends PickupNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
        this.order = inits.isInitialized("order") ? new com.cakequake.cakequakeback.order.entities.QCakeOrder(forProperty("order"), inits.get("order")) : null;
    }

}

