package dev.cccm5.transposition.util;

import dev.cccm5.transposition.math.IntegralPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OctreeNode<V> {
    @SuppressWarnings("rawtypes")
    private final @Nullable OctreeNode @NotNull[] children;
    @Nullable private V value;


    public OctreeNode(){
        this.value = null;
        children = new OctreeNode[8];
    }

    public OctreeNode(@Nullable V value){
        this.value = value;
        children = new OctreeNode[8];
    }

    @Nullable
    @SuppressWarnings("unchecked")
    public OctreeNode<V> getChild(int index){
        if(index < 0 || index > 7){
            throw new IndexOutOfBoundsException("non octal value");
        }
        return children[index];
    }

    @Nullable
    public OctreeNode<V> setChild(int index, @Nullable OctreeNode<V> child){
        if(index < 0 || index > 7){
            throw new IndexOutOfBoundsException("non octal value");
        }
        children[index] = child;
        return child;
    }

    @Nullable
    public V getValue(){
        return value;
    }

    public void setValue(@Nullable V value){
        this.value = value;
    }

    public boolean isLeaf(){
        return children[0] == null &&
                children[1] == null &&
                children[2] == null &&
                children[3] == null &&
                children[4] == null &&
                children[5] == null &&
                children[6] == null &&
                children[7] == null;
    }
}