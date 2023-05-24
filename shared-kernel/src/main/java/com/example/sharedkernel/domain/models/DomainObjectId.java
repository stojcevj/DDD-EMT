package com.example.sharedkernel.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Embeddable
@Getter
public class DomainObjectId implements Serializable {
    private String id;

    public DomainObjectId() {
    }
    @JsonCreator
    protected DomainObjectId(@NonNull String uuid){
        this.id = Objects.requireNonNull(uuid, "uuid must not be null");
    }

    @NonNull
    public static <ID extends DomainObjectId> ID randomId(@NonNull Class<ID> idClass){
        Objects.requireNonNull(idClass, "idClass must not be null");
        try{
            return idClass.getConstructor(String.class).newInstance(UUID.randomUUID().toString());
        }catch (Exception e){
            throw new RuntimeException("randomId could not be created");
        }
    }

}
