package validator;

import javax.servlet.http.HttpServletRequest;

public abstract class Validator
{
    public Validator()
    {
    }

    public abstract void validate(HttpServletRequest request) throws ValidateException;
}
