package validator;


import javax.servlet.http.HttpServletRequest;

public class ValidatorHit extends Validator
{
    public ValidatorHit()
    {
        super();
    }

    @Override
    public void validate(HttpServletRequest request) throws ValidateException
    {
        String s = request.getParameter("PIC");

        if(s == null)
        {
            throw new ValidateException("PIC does not set");
        }
        else
        {
            s = s.toLowerCase();

            if (!s.equals("true") && !s.equals("false"))
            {
                throw new ValidateException("PIC is not a true or false");
            }
        }
    }
}
