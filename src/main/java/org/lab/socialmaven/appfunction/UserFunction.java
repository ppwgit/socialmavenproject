package org.lab.socialmaven.appfunction;

@FunctionalInterface
public interface UserFunction<T, R> {
    R Action(T obj);
}