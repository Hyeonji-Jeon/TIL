package com.cakequake.cakequakeback.payment.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMerchantPaymentKey is a Querydsl query type for MerchantPaymentKey
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMerchantPaymentKey extends EntityPathBase<MerchantPaymentKey> {

    private static final long serialVersionUID = 1777087874L;

    public static final QMerchantPaymentKey merchantPaymentKey = new QMerchantPaymentKey("merchantPaymentKey");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath encryptedApiKey = createString("encryptedApiKey");

    public final StringPath encryptedSecret = createString("encryptedSecret");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isActive = createBoolean("isActive");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath provider = createString("provider");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Long> shopId = createNumber("shopId", Long.class);

    public QMerchantPaymentKey(String variable) {
        super(MerchantPaymentKey.class, forVariable(variable));
    }

    public QMerchantPaymentKey(Path<? extends MerchantPaymentKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMerchantPaymentKey(PathMetadata metadata) {
        super(MerchantPaymentKey.class, metadata);
    }

}

