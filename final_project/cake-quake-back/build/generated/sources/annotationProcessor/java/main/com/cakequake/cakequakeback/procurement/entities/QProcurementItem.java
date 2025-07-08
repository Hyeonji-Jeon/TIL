package com.cakequake.cakequakeback.procurement.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcurementItem is a Querydsl query type for ProcurementItem
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProcurementItem extends EntityPathBase<ProcurementItem> {

    private static final long serialVersionUID = -2031064328L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProcurementItem procurementItem = new QProcurementItem("procurementItem");

    public final QIngredient ingredient;

    public final StringPath ingredientName = createString("ingredientName");

    public final QProcurement procurement;

    public final NumberPath<Long> procurementItemId = createNumber("procurementItemId", Long.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final NumberPath<Integer> unitPrice = createNumber("unitPrice", Integer.class);

    public QProcurementItem(String variable) {
        this(ProcurementItem.class, forVariable(variable), INITS);
    }

    public QProcurementItem(Path<? extends ProcurementItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProcurementItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProcurementItem(PathMetadata metadata, PathInits inits) {
        this(ProcurementItem.class, metadata, inits);
    }

    public QProcurementItem(Class<? extends ProcurementItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingredient = inits.isInitialized("ingredient") ? new QIngredient(forProperty("ingredient")) : null;
        this.procurement = inits.isInitialized("procurement") ? new QProcurement(forProperty("procurement"), inits.get("procurement")) : null;
    }

}

