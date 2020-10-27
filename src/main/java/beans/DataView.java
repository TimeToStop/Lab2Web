package beans;

import adapters.HtmlAdapter;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@SessionScoped
public class DataView
{
    public static String getAsHtmlTable(Attempt attempt)
    {
        return HtmlAdapter.toTable(attempt);
    }

    public static String getAsHtmlTable(ArrayList<Attempt> attempts)
    {
        return HtmlAdapter.toTable(attempts);
    }
}
