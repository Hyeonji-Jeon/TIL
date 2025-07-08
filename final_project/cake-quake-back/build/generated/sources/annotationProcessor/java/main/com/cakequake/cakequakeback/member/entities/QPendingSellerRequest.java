package com.cakequake.cakequakeback.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPendingSellerRequest is a Querydsl query type for PendingSellerRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPendingSellerRequest extends EntityPathBase<PendingSellerRequest> {

    private static final long serialVersionUID = 282370422L;

    public static final QPendingSellerRequest pendingSellerRequest = new QPendingSellerRequest("pendingSellerRequest");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath bossName = createString("bossName");

    public final StringPath businessCertificateUrl = createString("businessCertificateUrl");

    public final StringPath businessNumber = createString("businessNumber");

    public final TimePath<java.time.LocalTime> closeTime = createTime("closeTime", java.time.LocalTime.class);

    public final StringPath mainProductDescription = createString("mainProductDescription");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath openingDate = createString("openingDate");

    public final TimePath<java.time.LocalTime> openTime = createTime("openTime", java.time.LocalTime.class);

    public final StringPath password = createString("password");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final BooleanPath publicInfo = createBoolean("publicInfo");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath sanitationCertificateUrl = createString("sanitationCertificateUrl");

    public final StringPath shopImageUrl = createString("shopImageUrl");

    public final StringPath shopName = createString("shopName");

    public final StringPath shopPhoneNumber = createString("shopPhoneNumber");

    public final EnumPath<SocialType> socialType = createEnum("socialType", SocialType.class);

    public final EnumPath<SellerRequestStatus> status = createEnum("status", SellerRequestStatus.class);

    public final NumberPath<Long> tempSellerId = createNumber("tempSellerId", Long.class);

    public final StringPath uname = createString("uname");

    public final StringPath userId = createString("userId");

    public QPendingSellerRequest(String variable) {
        super(PendingSellerRequest.class, forVariable(variable));
    }

    public QPendingSellerRequest(Path<? extends PendingSellerRequest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPendingSellerRequest(PathMetadata metadata) {
        super(PendingSellerRequest.class, metadata);
    }

}

