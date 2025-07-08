package com.cakequake.cakequakeback.review.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReview is a Querydsl query type for Review
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReview extends EntityPathBase<Review> {

    private static final long serialVersionUID = -1503488365L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReview review = new QReview("review");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final com.cakequake.cakequakeback.cake.item.entities.QCakeItem cakeItem;

    public final QCeoReview ceoReview;

    public final StringPath content = createString("content");

    public final QReviewDeletionRequest deletionRequest;

    public final com.cakequake.cakequakeback.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final com.cakequake.cakequakeback.order.entities.QCakeOrder order;

    public final NumberPath<Integer> rating = createNumber("rating", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Long> reviewId = createNumber("reviewId", Long.class);

    public final StringPath reviewPictureUrl = createString("reviewPictureUrl");

    public final com.cakequake.cakequakeback.shop.entities.QShop shop;

    public final EnumPath<ReviewStatus> status = createEnum("status", ReviewStatus.class);

    public QReview(String variable) {
        this(Review.class, forVariable(variable), INITS);
    }

    public QReview(Path<? extends Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReview(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReview(PathMetadata metadata, PathInits inits) {
        this(Review.class, metadata, inits);
    }

    public QReview(Class<? extends Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cakeItem = inits.isInitialized("cakeItem") ? new com.cakequake.cakequakeback.cake.item.entities.QCakeItem(forProperty("cakeItem"), inits.get("cakeItem")) : null;
        this.ceoReview = inits.isInitialized("ceoReview") ? new QCeoReview(forProperty("ceoReview"), inits.get("ceoReview")) : null;
        this.deletionRequest = inits.isInitialized("deletionRequest") ? new QReviewDeletionRequest(forProperty("deletionRequest"), inits.get("deletionRequest")) : null;
        this.member = inits.isInitialized("member") ? new com.cakequake.cakequakeback.member.entities.QMember(forProperty("member"), inits.get("member")) : null;
        this.order = inits.isInitialized("order") ? new com.cakequake.cakequakeback.order.entities.QCakeOrder(forProperty("order"), inits.get("order")) : null;
        this.shop = inits.isInitialized("shop") ? new com.cakequake.cakequakeback.shop.entities.QShop(forProperty("shop"), inits.get("shop")) : null;
    }

}

