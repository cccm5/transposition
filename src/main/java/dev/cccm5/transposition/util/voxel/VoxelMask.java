package dev.cccm5.transposition.util.voxel;

import dev.cccm5.transposition.math.IntegralPoint;
import org.jetbrains.annotations.NotNull;

public interface VoxelMask {
    boolean contains(@NotNull IntegralPoint point);

    boolean intersects(@NotNull VoxelMask other);
    boolean excludes(@NotNull VoxelMask other);
    boolean isSubset(@NotNull VoxelMask other);
    boolean isSuperset(@NotNull VoxelMask other);
    boolean isEmpty();

    @NotNull VoxelMask subtract(@NotNull VoxelMask other);
    @NotNull VoxelMask add(@NotNull VoxelMask other);
    default VoxelMask union(@NotNull VoxelMask other){  return add(other); }
    @NotNull VoxelMask intersection(@NotNull VoxelMask other);
    @NotNull VoxelMask symmetricDifference(@NotNull VoxelMask other);
    @NotNull VoxelMask boundingMask();
}
