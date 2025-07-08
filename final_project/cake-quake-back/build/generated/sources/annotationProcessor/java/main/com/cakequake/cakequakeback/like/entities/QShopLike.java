package com.cakequake.cakequakeback.like.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopLike is a Querydsl query type for ShopLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopLike extends EntityPathBase<ShopLike> {

    private static final long serialVersionUID = 126304167L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopLike shopLike = new QShopLike("shopLike");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final NumberPath<Long> shopLikeId = createNumber("shopLikeId", Long.class);

    public QShopLike(String variable) {
        this(ShopLike.class, forVariable(variable), INITS);
    }

    public QShopLike(Path<? extends ShopLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopLike(PathMetadata metadata, PathInits inits) {
        this(ShopLike.class, metadata, inits);
    }

    public QShopLike(Class<? extends ShopLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

