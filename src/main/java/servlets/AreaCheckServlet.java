package servlets;

import beans.Storage;
import validator.AreaCheckRequestValidator;
import validator.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AreaCheckServlet extends HttpServlet
{
    public static final AreaCheckRequestValidator validator = new AreaCheckRequestValidator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {
            Storage storage = (Storage)request.getSession().getAttribute("storage");
            storage.addAttempt(validator.parseRequest(request));
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
        catch (ValidateException e)
        {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
