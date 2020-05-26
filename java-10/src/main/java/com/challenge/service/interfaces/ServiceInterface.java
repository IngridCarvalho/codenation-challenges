package com.challenge.service.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface ServiceInterface<T> {
    T save(T object);
}
