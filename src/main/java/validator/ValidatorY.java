package validator;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class ValidatorY extends Validator
{
    private static final ArrayList<String> valid_values = new ArrayList<>();

    static
    {
        for(int i = -5; i <= 4; i++)
        {
            valid_values.add(String.valueOf(i));
        }
    }

    public ValidatorY()
    {
        super();
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidateException
    {
        String string = request.getParameter("Y");

        if (string == null)
        {
            throw new ValidateException("Y не задан");
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
                throw new ValidateException("Y не число");
            }

            if(!valid_values.contains(string))
            {
                throw new ValidateException("Y не находится во множестве {-5, -4, -3, -2, -1, 0, 1, 2, 3}");
            }
        }
    }
}
