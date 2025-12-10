package br.com.alura.screenmatch.service;

public interface DataConvertion {
    <T> T getDatas(String json, Class<T> typeClass);
}