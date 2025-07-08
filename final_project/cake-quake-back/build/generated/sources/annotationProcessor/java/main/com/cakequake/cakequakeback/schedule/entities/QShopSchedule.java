package com.cakequake.cakequakeback.schedule.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopSchedule is a Querydsl query type for ShopSchedule
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopSchedule extends EntityPathBase<ShopSchedule> {

    private static final long serialVersionUID = -253416537L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopSchedule shopSchedule = new QShopSchedule("shopSchedule");

    public final NumberPath<Integer> availableSlots = createNumber("availableSlots", Integer.class);

    public final NumberPath<Integer> maxSlots = createNumber("maxSlots", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> scheduleDateTime = createDateTime("scheduleDateTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> scheduleId = createNumber("scheduleId", Long.class);

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final EnumPath<ReservationStatus> status = createEnum("status", ReservationStatus.class);

    public QShopSchedule(String variable) {
        this(ShopSchedule.class, forVariable(variable), INITS);
    }

    public QShopSchedule(Path<? extends ShopSchedule> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopSchedule(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopSchedule(PathMetadata metadata, PathInits inits) {
        this(ShopSchedule.class, metadata, inits);
    }

    public QShopSchedule(Class<? extends ShopSchedule> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

