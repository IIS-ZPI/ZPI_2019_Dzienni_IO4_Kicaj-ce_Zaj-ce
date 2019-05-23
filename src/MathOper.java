public class MathOper implements IArithemicsAdd, IArithmeticsDiff, IArithmeticsMult, IArithmeticsDiv {
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

    @Override
    public double Multiplication(double A, double B) {
        return A * B;
    }
}
