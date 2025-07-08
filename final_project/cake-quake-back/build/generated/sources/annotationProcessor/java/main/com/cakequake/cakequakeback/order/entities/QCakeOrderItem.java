package com.cakequake.cakequakeback.order.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCakeOrderItem is a Querydsl query type for CakeOrderItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeOrderItem extends EntityPathBase<CakeOrderItem> {

    private static final long serialVersionUID = 1470724896L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCakeOrderItem cakeOrderItem = new QCakeOrderItem("cakeOrderItem");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.cake.item.entities.QCakeItem cakeItem;

    public final QCakeOrder cakeOrder;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Long> orderItemId = createNumber("orderItemId", Long.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Integer> subTotalPrice = createNumber("subTotalPrice", Integer.class);

    public final NumberPath<Integer> unitPrice = createNumber("unitPrice", Integer.class);

    public QCakeOrderItem(String variable) {
        this(CakeOrderItem.class, forVariable(variable), INITS);
    }

    public QCakeOrderItem(Path<? extends CakeOrderItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCakeOrderItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCakeOrderItem(PathMetadata metadata, PathInits inits) {
        this(CakeOrderItem.class, metadata, inits);
    }

    public QCakeOrderItem(Class<? extends CakeOrderItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cakeItem = inits.isInitialized("cakeItem") ? new com.cakequake.cakequakeback.cake.item.entities.QCakeItem(forProperty("cakeItem"), inits.get("cakeItem")) : null;
        this.cakeOrder = inits.isInitialized("cakeOrder") ? new QCakeOrder(forProperty("cakeOrder"), inits.get("cakeOrder")) : null;
    }

}

