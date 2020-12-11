package model;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class RestEasy extends Application {

    private Set < Object > singletons = new HashSet < Object > ();

    public RestEasy() {
        singletons.add(new Service());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}