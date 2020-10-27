package validator;

import beans.Attempt;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class AreaCheckRequestValidator
{
    private final ArrayList<Validator> validators = new ArrayList<>();

    public AreaCheckRequestValidator()
    {
        validators.add(new ValidatorX());
        validators.add(new ValidatorY());
        validators.add(new ValidatorR());
    }

    public Attempt parseRequest(HttpServletRequest request) throws ValidateException
    {
        for(Validator v : validators)
        {
            v.validate(request);
        }

        return new Attempt( Double.parseDouble(request.getParameter("X").replace(',', '.')),
                            Double.parseDouble(request.getParameter("Y").replace(',', '.')),
                            Double.parseDouble(request.getParameter("R").replace(',', '.')));
    }
}
