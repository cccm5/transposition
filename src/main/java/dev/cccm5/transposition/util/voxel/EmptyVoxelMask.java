package dev.cccm5.transposition.util.voxel;

import dev.cccm5.transposition.math.IntegralPoint;
import org.jetbrains.annotations.NotNull;

public class EmptyVoxelMask implements VoxelMask{
    private EmptyVoxelMask(){}

    public static final EmptyVoxelMask EMPTY_MASK = new EmptyVoxelMask();

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
        return true;
    }

    @Override
    public boolean isSuperset(@NotNull VoxelMask other) {
        return other.isEmpty();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public @NotNull VoxelMask subtract(@NotNull VoxelMask other) {
        return this;
    }

    @Override
    public @NotNull VoxelMask add(@NotNull VoxelMask other) {
        return other;
    }

    @Override
    public @NotNull VoxelMask intersection(@NotNull VoxelMask other) {
        return other;
    }

    @Override
    public @NotNull VoxelMask symmetricDifference(@NotNull VoxelMask other) {
        return other;
    }

    @Override
    public @NotNull VoxelMask boundingMask() {
        return this;
    }
}
