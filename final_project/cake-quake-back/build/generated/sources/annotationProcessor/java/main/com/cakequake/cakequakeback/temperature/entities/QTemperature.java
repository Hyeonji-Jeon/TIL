package com.cakequake.cakequakeback.temperature.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTemperature is a Querydsl query type for Temperature
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTemperature extends EntityPathBase<Temperature> {

    private static final long serialVersionUID = 1093912773L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTemperature temperature1 = new QTemperature("temperature1");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final NumberPath<Float> changeAmount = createNumber("changeAmount", Float.class);

    public final EnumPath<Grade> grade = createEnum("grade", Grade.class);

    public final ListPath<TemperatureHistory, QTemperatureHistory> historyList = this.<TemperatureHistory, QTemperatureHistory>createList("historyList", TemperatureHistory.class, QTemperatureHistory.class, PathInits.DIRECT2);

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final EnumPath<ChangeReason> reason = createEnum("reason", ChangeReason.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath relatedObjectId = createString("relatedObjectId");

    public final EnumPath<RelatedObjectType> relatedObjectType = createEnum("relatedObjectType", RelatedObjectType.class);

    public final NumberPath<Double> temperature = createNumber("temperature", Double.class);

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    public QTemperature(String variable) {
        this(Temperature.class, forVariable(variable), INITS);
    }

    public QTemperature(Path<? extends Temperature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTemperature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTemperature(PathMetadata metadata, PathInits inits) {
        this(Temperature.class, metadata, inits);
    }

    public QTemperature(Class<? extends Temperature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

