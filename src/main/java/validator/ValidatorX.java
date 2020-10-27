package validator;

import javax.servlet.http.HttpServletRequest;

public class ValidatorX extends Validator
{
    public ValidatorX()
    {
        super();
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidateException
    {
        String string = request.getParameter("X");

        if(string == null)
        {
            throw new ValidateException("X не задан");
        }
        else
        {
            double value;
            string = string.replace(',', '.');

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

            if(!(-5 < cut && cut < 5))
            {
                throw new ValidateException("X не входит в область (-5, 5)");
            }
        }
    }
}
