package dev.cccm5.transposition.math;

import org.jetbrains.annotations.NotNull;

public record IntegralPoint(int x, int y, int z) {

    public static final IntegralPoint ZERO = new IntegralPoint(0,0,0);
    public static final IntegralPoint ONE  = new IntegralPoint(1,1,1);

    @NotNull
    public IntegralPoint add(@NotNull IntegralPoint other){
        return new IntegralPoint(this.x+other.x, this.y+other.y, this.z+other.z);
    }

    @NotNull
    public IntegralPoint subtract(@NotNull IntegralPoint other){
        return new IntegralPoint(this.x-other.x, this.y-other.y, this.z-other.z);
    }

    @NotNull
    public IntegralPoint negate(){
        return ZERO.subtract(this);
    }


}
