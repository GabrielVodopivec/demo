package com.example.demo.services;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}