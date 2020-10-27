package beans;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.ArrayList;

@Named
@SessionScoped
public class Storage
{
    private ArrayList<Attempt> attempts = new ArrayList<>();

    public Storage()
    {
    }

    public void addAttempt(Attempt attempt)
    {
        attempts.add(attempt);
    }

    public ArrayList<Attempt> getAttempts()
    {
        return attempts;
    }
    public Attempt getLastAttempt()
    {
        if(attempts.size() == 0)
        {
            throw new RuntimeException("Required last attempt, but 0 attempts done");
        }
        else
        {
            return attempts.get(attempts.size() - 1);
        }
    }
}
