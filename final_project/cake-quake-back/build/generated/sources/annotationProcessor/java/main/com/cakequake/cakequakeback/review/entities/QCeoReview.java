package com.cakequake.cakequakeback.review.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCeoReview is a Querydsl query type for CeoReview
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCeoReview extends EntityPathBase<CeoReview> {

    private static final long serialVersionUID = 558106858L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCeoReview ceoReview = new QCeoReview("ceoReview");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final NumberPath<Long> ceoReviewId = createNumber("ceoReviewId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath reply = createString("reply");

    public final QReview review;

    public QCeoReview(String variable) {
        this(CeoReview.class, forVariable(variable), INITS);
    }

    public QCeoReview(Path<? extends CeoReview> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCeoReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCeoReview(PathMetadata metadata, PathInits inits) {
        this(CeoReview.class, metadata, inits);
    }

    public QCeoReview(Class<? extends CeoReview> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

