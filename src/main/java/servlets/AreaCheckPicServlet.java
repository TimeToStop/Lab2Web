package servlets;

import validator.AreaCheckPicRequestValidator;
import validator.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AreaCheckPicServlet extends HttpServlet
{
    private static final AreaCheckPicRequestValidator validator = new AreaCheckPicRequestValidator();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            response.getWriter().println("{ \"hit\" : " + (validator.parseRequest(request) ? "true" : "false") + " }");
        }
        catch (ValidateException e)
        {
            response.getWriter().println("{ \"error\": \"Invalid request\"}");
        }
    }
}
