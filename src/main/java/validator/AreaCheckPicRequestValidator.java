package validator;

import beans.HitManager;

import javax.servlet.http.HttpServletRequest;

public class AreaCheckPicRequestValidator
{
    private final ValidatorHit validator = new ValidatorHit();

    public AreaCheckPicRequestValidator()
    {
    }

    public boolean parseRequest(HttpServletRequest request) throws ValidateException
    {
        validator.validate(request);

        try
        {
            Double.parseDouble(request.getParameter("X"));
            Double.parseDouble(request.getParameter("Y"));
            Double.parseDouble(request.getParameter("R"));
        }
        catch (NumberFormatException e)
        {
            throw new ValidateException("Invalid input");
        }

        return HitManager.isHit( Double.parseDouble(request.getParameter("X").replace(',', '.')),
                Double.parseDouble(request.getParameter("Y").replace(',', '.')),
                Double.parseDouble(request.getParameter("R").replace(',', '.')));
    }
}
