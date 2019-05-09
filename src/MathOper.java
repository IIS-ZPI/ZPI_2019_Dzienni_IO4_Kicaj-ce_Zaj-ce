public class MathOper implements IArithemicsAdd, IArithmeticsDiff, IArithmeticsDiv  {
    @Override
    public double Addition(double A, double B) {
        return A + B;
    }

    @Override
    public double Devision(double A, double B) {
        return A / B;
    }

    @Override
    public double Difference(double A, double B) {
        return A - B;
    }
}
