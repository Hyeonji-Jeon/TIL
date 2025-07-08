package com.cakequake.cakequakeback.cake.option.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOptionType is a Querydsl query type for OptionType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptionType extends EntityPathBase<OptionType> {

    private static final long serialVersionUID = 1758016981L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOptionType optionType1 = new QOptionType("optionType1");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.member.entities.QMember createdBy;

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final BooleanPath isRequired = createBoolean("isRequired");

    public final BooleanPath isUsed = createBoolean("isUsed");

    public final NumberPath<Integer> maxSelection = createNumber("maxSelection", Integer.class);

    public final NumberPath<Integer> minSelection = createNumber("minSelection", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.member.entities.QMember modifiedBy;

    public final StringPath optionType = createString("optionType");

    public final NumberPath<Long> optionTypeId = createNumber("optionTypeId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public QOptionType(String variable) {
        this(OptionType.class, forVariable(variable), INITS);
    }

    public QOptionType(Path<? extends OptionType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOptionType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOptionType(PathMetadata metadata, PathInits inits) {
        this(OptionType.class, metadata, inits);
    }

    public QOptionType(Class<? extends OptionType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.modifiedBy = inits.isInitialized("modifiedBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("modifiedBy"), inits.get("modifiedBy")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

