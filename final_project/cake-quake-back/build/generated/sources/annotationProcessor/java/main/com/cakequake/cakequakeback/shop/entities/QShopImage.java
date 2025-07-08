package com.cakequake.cakequakeback.shop.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QShopImage is a Querydsl query type for ShopImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QShopImage extends EntityPathBase<ShopImage> {

    private static final long serialVersionUID = -1872388724L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShopImage shopImage = new QShopImage("shopImage");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath createdBy = createString("createdBy");

    public final BooleanPath isThumbnail = createBoolean("isThumbnail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath modifiedBy = createString("modifiedBy");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final QShop shop;

    public final NumberPath<Long> shopImageId = createNumber("shopImageId", Long.class);

    public final StringPath shopImageUrl = createString("shopImageUrl");

    public QShopImage(String variable) {
        this(ShopImage.class, forVariable(variable), INITS);
    }

    public QShopImage(Path<? extends ShopImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShopImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShopImage(PathMetadata metadata, PathInits inits) {
        this(ShopImage.class, metadata, inits);
    }

    public QShopImage(Class<? extends ShopImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

