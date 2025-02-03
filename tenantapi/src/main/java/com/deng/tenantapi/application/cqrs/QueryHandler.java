package com.deng.tenantapi.application.cqrs;

public interface QueryHandler<T, E> {
    E handle(T query);
}
