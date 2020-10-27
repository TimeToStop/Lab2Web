import validator.ValidateException;

public class Main
{
    public static void test(String string)
    {
        try
        {
            double value;
            string = string.replace(",", ".");

            try
            {
                value = Double.parseDouble(string);
            }
            catch (NumberFormatException e)
            {
                throw new ValidateException("X не число");
            }

            if(string.length() > 5)
            {
                string = string.substring(0, 5);
                string = string + "1";
            }

            double cut = Double.parseDouble(string);

            if(-5 < cut && cut < 5)
            {
                System.out.println(value);
            }
            else
            {
                throw new ValidateException("X не входит в область (-5, 5)");
            }
        }
        catch (ValidateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String ... args)
    {
        String[] arr = new String[]
        {
                "0",
                "0.0000000000000000000000000000000000000000000000000000000000000000000",
                "1",
                "3,5",
                "8",
                "-5",
                "-1000000000",
                "10000000000000000000000000000000000000000000000000000000000.000000000000000000",
                "4.9999999999999999999999999999999999999999999999999999999999999999999999999999",
                "-4.9999999999999999999999999999999999999999999999999999999999999999999999999",
                "-4.899999999999999999999999999999999999999999999999999999999999999999999999",
                "5.000000000000000000000000000000000000000000000000000000000000000000000000000000",
                "-5,0000000000000000000000000000000000000000000000000000000000000000000000000000000000",

                "aaaa",
                "5.0000000000000000000f",
                "5,8904423423423,432",
                "44,444.444444",

        };

        for(String s : arr)
        {
            System.out.println("Input: ");
            System.out.println(s);
            System.out.println("Output: ");
            test(s);
        }
    }
}
