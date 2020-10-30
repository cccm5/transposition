package dev.cccm5.transposition.util.voxel;

import dev.cccm5.transposition.math.IntegralPoint;

public interface VoxelMask {
    boolean contains(IntegralPoint point);

    boolean intersects(VoxelMask other);
    boolean excludes(VoxelMask other);
    boolean isSubset(VoxelMask other);
    boolean isSuperset(VoxelMask other);
    boolean isEmpty();

    VoxelMask subtract(VoxelMask other);
    VoxelMask add(VoxelMask other);
    default VoxelMask union(VoxelMask other){  return add(other); }
    VoxelMask intersection(VoxelMask other);
    VoxelMask symmetricDifference(VoxelMask other);
    VoxelMask boundingMask();
}
