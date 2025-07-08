package com.cakequake.cakequakeback.order.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeOrderItemOption is a Querydsl query type for CakeOrderItemOption
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeOrderItemOption extends EntityPathBase<CakeOrderItemOption> {

    private static final long serialVersionUID = -44558411L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeOrderItemOption cakeOrderItemOption = new QCakeOrderItemOption("cakeOrderItemOption");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.cake.item.entities.QCakeOptionMapping cakeOptionMapping;

    public final QCakeOrderItem cakeOrderItem;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Integer> optionCnt = createNumber("optionCnt", Integer.class);

    public final NumberPath<Long> orderItemOptionId = createNumber("orderItemOptionId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public QCakeOrderItemOption(String variable) {
        this(CakeOrderItemOption.class, forVariable(variable), INITS);
    }

    public QCakeOrderItemOption(Path<? extends CakeOrderItemOption> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeOrderItemOption(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeOrderItemOption(PathMetadata metadata, PathInits inits) {
        this(CakeOrderItemOption.class, metadata, inits);
    }

    public QCakeOrderItemOption(Class<? extends CakeOrderItemOption> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cakeOptionMapping = inits.isInitialized("cakeOptionMapping") ? new com.cakequake.cakequakeback.cake.item.entities.QCakeOptionMapping(forProperty("cakeOptionMapping"), inits.get("cakeOptionMapping")) : null;
        this.cakeOrderItem = inits.isInitialized("cakeOrderItem") ? new QCakeOrderItem(forProperty("cakeOrderItem"), inits.get("cakeOrderItem")) : null;
    }

}

