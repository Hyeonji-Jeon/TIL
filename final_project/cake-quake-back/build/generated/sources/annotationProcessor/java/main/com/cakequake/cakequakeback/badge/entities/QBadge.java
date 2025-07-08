package com.cakequake.cakequakeback.badge.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBadge is a Querydsl query type for Badge
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBadge extends EntityPathBase<Badge> {

    private static final long serialVersionUID = 836980901L;

    public static final QBadge badge = new QBadge("badge");

    public final NumberPath<Long> badgeId = createNumber("badgeId", Long.class);

    public final StringPath description = createString("description");

    public final StringPath icon = createString("icon");

    public final StringPath name = createString("name");

    public QBadge(String variable) {
        super(Badge.class, forVariable(variable));
    }

    public QBadge(Path<? extends Badge> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBadge(PathMetadata metadata) {
        super(Badge.class, metadata);
    }

}

