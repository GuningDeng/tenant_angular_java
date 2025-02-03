package com.deng.tenantapi.application.cqrs;

public interface CommandHandler<T> {
    void handle(T t);
}
