package com.cakequake.cakequakeback.procurement.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcurement is a Querydsl query type for Procurement
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProcurement extends EntityPathBase<Procurement> {

    private static final long serialVersionUID = -846977467L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProcurement procurement = new QProcurement("procurement");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath cancelReason = createString("cancelReason");

    public final DatePath<java.time.LocalDate> estimatedArrivalDate = createDate("estimatedArrivalDate", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath note = createString("note");

    public final NumberPath<Long> procurementId = createNumber("procurementId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final EnumPath<ProcurementStatus> status = createEnum("status", ProcurementStatus.class);

    public QProcurement(String variable) {
        this(Procurement.class, forVariable(variable), INITS);
    }

    public QProcurement(Path<? extends Procurement> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProcurement(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProcurement(PathMetadata metadata, PathInits inits) {
        this(Procurement.class, metadata, inits);
    }

    public QProcurement(Class<? extends Procurement> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

