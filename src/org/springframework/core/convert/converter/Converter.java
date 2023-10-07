package org.springframework.core.convert.converter;

public interface Converter<S, T> {

    /**
     * 类型转换
     */
    T convert(S source);
}