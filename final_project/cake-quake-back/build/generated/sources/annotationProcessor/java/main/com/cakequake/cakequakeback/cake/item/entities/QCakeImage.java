package com.cakequake.cakequakeback.cake.item.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeImage is a Querydsl query type for CakeImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeImage extends EntityPathBase<CakeImage> {

    private static final long serialVersionUID = -115262241L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeImage cakeImage = new QCakeImage("cakeImage");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final QCakeItem cakeItem;

    public final com.cakequake.cakequakeback.member.entities.QMember createdBy;

    public final NumberPath<Long> imageId = createNumber("imageId", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final BooleanPath isThumbnail = createBoolean("isThumbnail");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.member.entities.QMember modifiedBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QCakeImage(String variable) {
        this(CakeImage.class, forVariable(variable), INITS);
    }

    public QCakeImage(Path<? extends CakeImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeImage(PathMetadata metadata, PathInits inits) {
        this(CakeImage.class, metadata, inits);
    }

    public QCakeImage(Class<? extends CakeImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cakeItem = inits.isInitialized("cakeItem") ? new QCakeItem(forProperty("cakeItem"), inits.get("cakeItem")) : null;
        this.createdBy = inits.isInitialized("createdBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.modifiedBy = inits.isInitialized("modifiedBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("modifiedBy"), inits.get("modifiedBy")) : null;
    }

}

