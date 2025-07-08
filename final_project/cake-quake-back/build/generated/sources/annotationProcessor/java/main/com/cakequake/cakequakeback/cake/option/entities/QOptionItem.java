package com.cakequake.cakequakeback.cake.option.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOptionItem is a Querydsl query type for OptionItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOptionItem extends EntityPathBase<OptionItem> {

    private static final long serialVersionUID = 1757684142L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOptionItem optionItem = new QOptionItem("optionItem");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.member.entities.QMember createdBy;

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.member.entities.QMember modifiedBy;

    public final NumberPath<Long> optionItemId = createNumber("optionItemId", Long.class);

    public final StringPath optionName = createString("optionName");

    public final QOptionType optionType;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QOptionItem(String variable) {
        this(OptionItem.class, forVariable(variable), INITS);
    }

    public QOptionItem(Path<? extends OptionItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOptionItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOptionItem(PathMetadata metadata, PathInits inits) {
        this(OptionItem.class, metadata, inits);
    }

    public QOptionItem(Class<? extends OptionItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.modifiedBy = inits.isInitialized("modifiedBy") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("modifiedBy"), inits.get("modifiedBy")) : null;
        this.optionType = inits.isInitialized("optionType") ? new QOptionType(forProperty("optionType"), inits.get("optionType")) : null;
    }

}

