package com.cakequake.cakequakeback.temperature.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTemperatureHistory is a Querydsl query type for TemperatureHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTemperatureHistory extends EntityPathBase<TemperatureHistory> {

    private static final long serialVersionUID = 87768079L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTemperatureHistory temperatureHistory = new QTemperatureHistory("temperatureHistory");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final NumberPath<Double> afterTemperature = createNumber("afterTemperature", Double.class);

    public final NumberPath<Float> changeAmount = createNumber("changeAmount", Float.class);

    public final NumberPath<Long> historyId = createNumber("historyId", Long.class);

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final EnumPath<ChangeReason> reason = createEnum("reason", ChangeReason.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath relatedObjectId = createString("relatedObjectId");

    public final EnumPath<RelatedObjectType> relatedObjectType = createEnum("relatedObjectType", RelatedObjectType.class);

    public final QTemperature temperature;

    public QTemperatureHistory(String variable) {
        this(TemperatureHistory.class, forVariable(variable), INITS);
    }

    public QTemperatureHistory(Path<? extends TemperatureHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTemperatureHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTemperatureHistory(PathMetadata metadata, PathInits inits) {
        this(TemperatureHistory.class, metadata, inits);
    }

    public QTemperatureHistory(Class<? extends TemperatureHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
        this.temperature = inits.isInitialized("temperature") ? new QTemperature(forProperty("temperature"), inits.get("temperature")) : null;
    }

}

