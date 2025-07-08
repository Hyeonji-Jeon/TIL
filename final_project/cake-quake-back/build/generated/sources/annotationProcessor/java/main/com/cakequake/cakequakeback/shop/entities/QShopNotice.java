package com.cakequake.cakequakeback.shop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopNotice is a Querydsl query type for ShopNotice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopNotice extends EntityPathBase<ShopNotice> {

    private static final long serialVersionUID = -2063914809L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopNotice shopNotice = new QShopNotice("shopNotice");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final QShop shop;

    public final NumberPath<Long> shopNoticeId = createNumber("shopNoticeId", Long.class);

    public final StringPath title = createString("title");

    public QShopNotice(String variable) {
        this(ShopNotice.class, forVariable(variable), INITS);
    }

    public QShopNotice(Path<? extends ShopNotice> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopNotice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopNotice(PathMetadata metadata, PathInits inits) {
        this(ShopNotice.class, metadata, inits);
    }

    public QShopNotice(Class<? extends ShopNotice> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

