package com.cakequake.cakequakeback.cake.item.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeItem is a Querydsl query type for CakeItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeItem extends EntityPathBase<CakeItem> {

    private static final long serialVersionUID = -2081921265L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeItem cakeItem = new QCakeItem("cakeItem");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final NumberPath<Long> cakeId = createNumber("cakeId", Long.class);

    public final EnumPath<CakeCategory> category = createEnum("category", CakeCategory.class);

    public final StringPath cname = createString("cname");

    public final com.cakequake.cakequakeback.member.entities.QMember createdBy;

    public final StringPath description = createString("description");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final BooleanPath isOnsale = createBoolean("isOnsale");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.member.entities.QMember modifiedBy;

    public final NumberPath<Integer> orderCount = createNumber("orderCount", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final StringPath thumbnailImageUrl = createString("thumbnailImageUrl");

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public QCakeItem(String variable) {
        this(CakeItem.class, forVariable(variable), INITS);
    }

    public QCakeItem(Path<? extends CakeItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeItem(PathMetadata metadata, PathInits inits) {
        this(CakeItem.class, metadata, inits);
    }

    public QCakeItem(Class<? extends CakeItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.modifiedBy = inits.isInitialized("modifiedBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("modifiedBy"), inits.get("modifiedBy")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

