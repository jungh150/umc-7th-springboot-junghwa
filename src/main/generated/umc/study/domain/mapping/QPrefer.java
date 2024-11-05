package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPrefer is a Querydsl query type for Prefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPrefer extends EntityPathBase<Prefer> {

    private static final long serialVersionUID = 625040562L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPrefer prefer = new QPrefer("prefer");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QPrefer(String variable) {
        this(Prefer.class, forVariable(variable), INITS);
    }

    public QPrefer(Path<? extends Prefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPrefer(PathMetadata metadata, PathInits inits) {
        this(Prefer.class, metadata, inits);
    }

    public QPrefer(Class<? extends Prefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new umc.study.domain.QFood(forProperty("food")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user")) : null;
    }

}

