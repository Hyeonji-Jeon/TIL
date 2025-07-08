package com.cakequake.cakequakeback.qna.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnA is a Querydsl query type for QnA
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnA extends EntityPathBase<QnA> {

    private static final long serialVersionUID = 1766917029L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnA qnA = new QQnA("qnA");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath adminResponse = createString("adminResponse");

    public final StringPath content = createString("content");

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final NumberPath<Long> qnaId = createNumber("qnaId", Long.class);

    public final EnumPath<QnAType> qnAType = createEnum("qnAType", QnAType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final EnumPath<QnAStatus> status = createEnum("status", QnAStatus.class);

    public final StringPath title = createString("title");

    public QQnA(String variable) {
        this(QnA.class, forVariable(variable), INITS);
    }

    public QQnA(Path<? extends QnA> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnA(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnA(PathMetadata metadata, PathInits inits) {
        this(QnA.class, metadata, inits);
    }

    public QQnA(Class<? extends QnA> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
    }

}

