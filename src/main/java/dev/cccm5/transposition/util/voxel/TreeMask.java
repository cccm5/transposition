package dev.cccm5.transposition.util.voxel;

import dev.cccm5.transposition.math.IntegralPoint;
import dev.cccm5.transposition.util.OctreeNode;
import org.apache.commons.lang.NotImplementedException;
import org.jetbrains.annotations.NotNull;

public class TreeMask implements VoxelMask{
    private OctreeNode<Object> backing = new OctreeNode<>();
    private int depth;
    private IntegralPoint b1, b2;

    public TreeMask(){
        depth = 0;
        b1 = IntegralPoint.ZERO;
        b2 = IntegralPoint.ONE;
    }

    @Override
    public boolean contains(@NotNull IntegralPoint point) {
        return false;
    }

    @Override
    public boolean intersects(@NotNull VoxelMask other) {
        return false;
    }

    @Override
    public boolean excludes(@NotNull VoxelMask other) {
        return false;
    }

    @Override
    public boolean isSubset(@NotNull VoxelMask other) {
        return false;
    }

    @Override
    public boolean isSuperset(@NotNull VoxelMask other) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public @NotNull VoxelMask subtract(@NotNull VoxelMask other) {
        return null;
    }

    @Override
    public @NotNull VoxelMask add(@NotNull VoxelMask other) {
        return null;
    }

    @Override
    public @NotNull VoxelMask intersection(@NotNull VoxelMask other) {
        return null;
    }

    @Override
    public @NotNull VoxelMask symmetricDifference(@NotNull VoxelMask other) {
        return null;
    }

    @Override
    public @NotNull VoxelMask boundingMask() {
        return null;
    }

    private boolean inBounds(@NotNull IntegralPoint point){
        return b2.x() <= point.x() && b2.y() <= point.y() && b2.z() <= point.z() &&
                b1.x() >= point.x() && b1.y() >= point.y() && b1.z() >= point.z();
    }

    private void resize(@NotNull IntegralPoint point){
        while(!inBounds(point)){
            var parent = new OctreeNode<>();
            parent.setChild(depth % 2 * 7, backing);
            backing = parent;
            var scale = b2.subtract(b1).x();
            if(depth % 2 == 1){
                b1 = b1.subtract(new IntegralPoint(scale,scale,scale));
            } else {
                b2 = b2.add(new IntegralPoint(scale,scale,scale));
            }
            depth++;
        }
    }
}
