package dev.cccm5.transposition.math;

public record IntegralPoint(int x, int y, int z) {

    public static final IntegralPoint ZERO = new IntegralPoint(0,0,0);
    public static final IntegralPoint ONE  = new IntegralPoint(1,1,1);

    public IntegralPoint add(IntegralPoint other){
        return new IntegralPoint(this.x+other.x, this.y+other.y, this.z+other.z);
    }

    public IntegralPoint subtract(IntegralPoint other){
        return new IntegralPoint(this.x-other.x, this.y-other.y, this.z-other.z);
    }

    public IntegralPoint negate(){
        return ZERO.subtract(this);
    }


}
