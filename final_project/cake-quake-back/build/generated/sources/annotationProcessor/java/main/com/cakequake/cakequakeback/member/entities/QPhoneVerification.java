package com.cakequake.cakequakeback.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPhoneVerification is a Querydsl query type for PhoneVerification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhoneVerification extends EntityPathBase<PhoneVerification> {

    private static final long serialVersionUID = -1786362868L;

    public static final QPhoneVerification phoneVerification = new QPhoneVerification("phoneVerification");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath code = createString("code");

    public final DateTimePath<java.time.LocalDateTime> expiresAt = createDateTime("expiresAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath phoneNumber = createString("phoneNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final EnumPath<VerificationType> type = createEnum("type", VerificationType.class);

    public final BooleanPath verified = createBoolean("verified");

    public QPhoneVerification(String variable) {
        super(PhoneVerification.class, forVariable(variable));
    }

    public QPhoneVerification(Path<? extends PhoneVerification> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPhoneVerification(PathMetadata metadata) {
        super(PhoneVerification.class, metadata);
    }

}

