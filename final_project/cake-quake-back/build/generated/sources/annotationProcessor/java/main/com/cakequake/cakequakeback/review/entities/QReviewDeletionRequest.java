package com.cakequake.cakequakeback.review.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewDeletionRequest is a Querydsl query type for ReviewDeletionRequest
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewDeletionRequest extends EntityPathBase<ReviewDeletionRequest> {

    private static final long serialVersionUID = 1711025102L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewDeletionRequest reviewDeletionRequest = new QReviewDeletionRequest("reviewDeletionRequest");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath reason = createString("reason");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Long> requestId = createNumber("requestId", Long.class);

    public final QReview review;

    public final EnumPath<DeletionRequestStatus> status = createEnum("status", DeletionRequestStatus.class);

    public QReviewDeletionRequest(String variable) {
        this(ReviewDeletionRequest.class, forVariable(variable), INITS);
    }

    public QReviewDeletionRequest(Path<? extends ReviewDeletionRequest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewDeletionRequest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewDeletionRequest(PathMetadata metadata, PathInits inits) {
        this(ReviewDeletionRequest.class, metadata, inits);
    }

    public QReviewDeletionRequest(Class<? extends ReviewDeletionRequest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

