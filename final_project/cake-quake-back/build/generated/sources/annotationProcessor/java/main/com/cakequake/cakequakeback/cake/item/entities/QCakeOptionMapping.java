package com.cakequake.cakequakeback.cake.item.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeOptionMapping is a Querydsl query type for CakeOptionMapping
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeOptionMapping extends EntityPathBase<CakeOptionMapping> {

    private static final long serialVersionUID = 537360925L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeOptionMapping cakeOptionMapping = new QCakeOptionMapping("cakeOptionMapping");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final QCakeItem cakeItem;

    public final BooleanPath isUsed = createBoolean("isUsed");

    public final NumberPath<Long> mappingId = createNumber("mappingId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.cake.option.entities.QOptionItem optionItem;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QCakeOptionMapping(String variable) {
        this(CakeOptionMapping.class, forVariable(variable), INITS);
    }

    public QCakeOptionMapping(Path<? extends CakeOptionMapping> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeOptionMapping(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeOptionMapping(PathMetadata metadata, PathInits inits) {
        this(CakeOptionMapping.class, metadata, inits);
    }

    public QCakeOptionMapping(Class<? extends CakeOptionMapping> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cakeItem = inits.isInitialized("cakeItem") ? new QCakeItem(forProperty("cakeItem"), inits.get("cakeItem")) : null;
        this.optionItem = inits.isInitialized("optionItem") ? new com.cakequake.cakequakeback.cake.option.entities.QOptionItem(forProperty("optionItem"), inits.get("optionItem")) : null;
    }

}

