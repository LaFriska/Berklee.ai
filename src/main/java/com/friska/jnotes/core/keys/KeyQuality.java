package com.friska.jnotes.core.keys;

import com.friska.jnotes.core.intervals.Interval;
import com.friska.jnotes.debug.MissingJavadoc;
import org.jetbrains.annotations.NotNull;

@MissingJavadoc
public class KeyQuality {

    private int pointer;
    private final String name;
    private final Interval[] intervals;
    public KeyQuality(String name, @NotNull Interval... intervals){
        this.pointer = -1;
        this.name = name;
        this.intervals = intervals;
    }

    public KeyQuality reset(){
        this.pointer = -1;
        return this;
    }

    public Interval getNext(){
        this.pointer++;
        return intervals[pointer];
    }

    public boolean hasNext(){
        return this.pointer + 1 <= intervals.length - 1;
    }

    public Interval get(int i){
        return intervals[i];
    }

    public String getName() {
        return name;
    }

    public int length(){
        return intervals.length;
    }
}
