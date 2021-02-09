package dev.cccm5.transposition.configuration;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleProperties {
    private final Map<String, Object> backing = new HashMap<>();

    private <T> @NotNull T getProperty(@NotNull String key, @NotNull Class<T> clazz){
        if(!backing.containsKey(key)){
            throw new IllegalArgumentException(key + " is not a valid property");
        }
        if(!clazz.isInstance(backing.get(key))){
            throw new IllegalArgumentException(key + " is not an instance of " + clazz.getName() + "." );
        }
        return clazz.cast(key);
    }
}
