package validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ValidatorR extends Validator
{
    private static final ArrayList<String> valid_values = new ArrayList<>();

    static
    {
        valid_values.add("1");
        valid_values.add("1.5");
        valid_values.add("2");
        valid_values.add("2.5");
        valid_values.add("3");
    }

    public ValidatorR()
    {
        super();
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidateException
    {
        String string = request.getParameter("R");

        if (string == null)
        {
            throw new ValidateException("R не задан");
        }
        else
        {
            string = string.replace(',', '.');

            try
            {
                Double.parseDouble(string);
            }
            catch (NumberFormatException e)
            {
                throw new ValidateException("R не число");
            }

            if(!valid_values.contains(string))
            {
                throw new ValidateException("R не находится во множестве {1, 1.5, 2, 2.5, 3}");
            }
        }
    }
}
