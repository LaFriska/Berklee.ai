package com.friska.jnotes.core;

public interface ComparableElement<T extends ComparableElement<T>> {
    boolean equals(T object);

    boolean equalsEnharmonically(T object);

}
