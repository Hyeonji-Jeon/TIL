package com.cakequake.cakequakeback.badge.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberBadge is a Querydsl query type for MemberBadge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberBadge extends EntityPathBase<MemberBadge> {

    private static final long serialVersionUID = 853482667L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberBadge memberBadge = new QMemberBadge("memberBadge");

    public final DateTimePath<java.time.LocalDateTime> acquiredDate = createDateTime("acquiredDate", java.time.LocalDateTime.class);

    public final QBadge badge;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isRepresentative = createBoolean("isRepresentative");

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    public QMemberBadge(String variable) {
        this(MemberBadge.class, forVariable(variable), INITS);
    }

    public QMemberBadge(Path<? extends MemberBadge> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberBadge(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberBadge(PathMetadata metadata, PathInits inits) {
        this(MemberBadge.class, metadata, inits);
    }

    public QMemberBadge(Class<? extends MemberBadge> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.badge = inits.isInitialized("badge") ? new QBadge(forProperty("badge")) : null;
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

