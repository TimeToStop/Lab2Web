package adapters;

import beans.Attempt;
import java.util.ArrayList;

public class HtmlAdapter
{
    public static String toTable(Attempt attempt)
    {
        ArrayList<Attempt> attempts = new ArrayList<>();
        attempts.add(attempt);
        return toTable(attempts);
    }

    public static String toTable(ArrayList<Attempt> attempts)
    {
        StringBuilder b = new StringBuilder();

        b.append("<table><tr>")
                .append("<td>X</td>")
                .append("<td>Y</td>")
                .append("<td>R</td>")
                .append("<td>Результат</td>")
                .append("<td>Время</td>")
                .append("<td>Время работы скрипта</td>")
                .append("</tr>");

        for(Attempt attempt : attempts)
        {
            b.append(HtmlAdapter.toRow(attempt));
        }

        b.append("</table>");
        return b.toString();
    }

    public static String toRow(Attempt attempt)
    {
        StringBuilder b = new StringBuilder();

        b.append("<tr>")
                .append("<td>").append(attempt.getX()).append("</td>")
                .append("<td>").append(attempt.getY()).append("</td>")
                .append("<td>").append(attempt.getR()).append("</td>")
                .append("<td>").append(attempt.getResult()).append("</td>")
                .append("<td>").append(attempt.getTime()).append("</td>")
                .append("<td>").append(attempt.getTimeExecuted()).append("</td>")
                .append("</tr>");

        return b.toString();
    }
}
