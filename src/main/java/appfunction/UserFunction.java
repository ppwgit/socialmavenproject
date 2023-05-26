package appfunction;

import java.util.function.*;


public interface UserFunction<T, R> {
    R Action(T obj);
}