import java.io.*;
import java.text.*;

public class Main
{
    static InputStreamReader isr;
    static BufferedReader br;
    static int getNum()
{
    int number = 0;
    boolean flag = false;
    try  {
    String line = br.readLine();
    number = Integer.parseInt(line);
    flag = true;
}
    catch (NumberFormatException e)
{
    System.out.println("Не целое число");
}
    catch (IOException e)
{
    System.out.println("Ошибка чтения с клавиатуры");
}
    if (flag) return number;

    return getNum();
}
static double getNumD()
{
    double number = 0;
    boolean flag = false;
    try
    {
        String line = br.readLine();
        number = Double.parseDouble(line);
        flag = true;
    }
    catch (NumberFormatException e)
    {
        System.out.println("Не целое число");
    }
    catch (IOException e)
    {
        System.out.println("Ошибка чтения с клавиатуры");
    }
    if (flag) return number;

    return getNum();
}

    public static void main(String[] args)
    {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        double x = getNumD();
        int k = getNum();
        Calculation_class obj = new Calculation_class(x, k);
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(k);
        System.out.println("Приближенное " + formatter.format(obj.getTailor()));
        System.out.println("Стандартное  " + formatter.format(1.0/Math.sqrt(1+x)));
    }

}