package com.cakequake.cakequakeback.cakeAI.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCakeAI is a Querydsl query type for CakeAI
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCakeAI extends EntityPathBase<CakeAI> {

    private static final long serialVersionUID = 715866275L;

    public static final QCakeAI cakeAI = new QCakeAI("cakeAI");

    public final com.cakequake.cakequakeback.common.entities.QBaseEntity _super = new com.cakequake.cakequakeback.common.entities.QBaseEntity(this);

    public final StringPath answer = createString("answer");

    public final StringPath category = createString("category");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath question = createString("question");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final StringPath sessionId = createString("sessionId");

    public QCakeAI(String variable) {
        super(CakeAI.class, forVariable(variable));
    }

    public QCakeAI(Path<? extends CakeAI> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCakeAI(PathMetadata metadata) {
        super(CakeAI.class, metadata);
    }

}

