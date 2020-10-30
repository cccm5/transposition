package dev.cccm5.transposition.util.voxel;

import dev.cccm5.transposition.math.IntegralPoint;

public class EmptyVoxelMask implements VoxelMask{
    private EmptyVoxelMask(){}

    public static final EmptyVoxelMask EMPTY_MASK = new EmptyVoxelMask();

    @Override
    public boolean contains(IntegralPoint point) {
        return false;
    }

    @Override
    public boolean intersects(VoxelMask other) {
        return false;
    }

    @Override
    public boolean excludes(VoxelMask other) {
        return false;
    }

    @Override
    public boolean isSubset(VoxelMask other) {
        return true;
    }

    @Override
    public boolean isSuperset(VoxelMask other) {
        return other.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public VoxelMask subtract(VoxelMask other) {
        return this;
    }

    @Override
    public VoxelMask add(VoxelMask other) {
        return other;
    }

    @Override
    public VoxelMask intersection(VoxelMask other) {
        return other;
    }

    @Override
    public VoxelMask symmetricDifference(VoxelMask other) {
        return other;
    }

    @Override
    public VoxelMask boundingMask() {
        return this;
    }
}
