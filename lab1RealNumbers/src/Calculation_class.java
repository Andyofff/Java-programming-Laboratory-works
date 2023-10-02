public class Calculation_class
{
    private double x;
    private int k;
    public Calculation_class(double x, int k)
    {
        this.x = x;
        this.k = k;
    }
    private double getNext(double last, double x, int n)
    {
        last *= -1.0; last *= x; last /= n; last *= (n-1);
        return last;
    }
    public double getTailor()
    {
        double last = 1;
        double sum = 1;
        double eps = Math.pow(10, -k - 2);
        int n = 2;

        while (Math.abs(last) > eps)
        {
            last = getNext(last, x, n);
            sum += last;
            n += 2;
        }

        return sum;
    }
}