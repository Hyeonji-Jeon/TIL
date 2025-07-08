package com.cakequake.cakequakeback.member.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberDetail is a Querydsl query type for MemberDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberDetail extends EntityPathBase<MemberDetail> {

    private static final long serialVersionUID = -315715512L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberDetail memberDetail = new QMemberDetail("memberDetail");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final DateTimePath<java.time.LocalDateTime> delDate = createDateTime("delDate", java.time.LocalDateTime.class);

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath profileBadge = createString("profileBadge");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Long> uid = createNumber("uid", Long.class);

    public QMemberDetail(String variable) {
        this(MemberDetail.class, forVariable(variable), INITS);
    }

    public QMemberDetail(Path<? extends MemberDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberDetail(PathMetadata metadata, PathInits inits) {
        this(MemberDetail.class, metadata, inits);
    }

    public QMemberDetail(Class<? extends MemberDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member"), inits.get("member")) : null;
    }

}

