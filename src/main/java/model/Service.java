package model;
import javax.ws.rs.GET;


import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("Service")
public class Service {
	
	@GET
    @Path("Annuite/{x}/{y}/{z}")
    public double annuite(@PathParam("x") String x,@PathParam("y") String y,@PathParam("z") String z)
    {
		double capital = Double.parseDouble(z);
		double t = Double.parseDouble(y);
		int duree = Integer.parseInt(x);
		double taux = Math.pow(1 + t, (double) 1 / 12) - 1;;
		return (Math.pow(1 + taux, duree) * taux * capital) / (Math.pow(1 + taux, duree) - 1);
        
    }
	@GET
    @Path("capital/{x}/{y}/{z}")
    public double capital(@PathParam("x") String x,@PathParam("y") String y,@PathParam("z") String z)
    {
		double annuite = Double.parseDouble(z);
		double t = Double.parseDouble(y);
		int duree = Integer.parseInt(x);
		double taux = Math.pow(1 + t, (double) 1 / 12) - 1;;
		return (Math.pow(1 + taux, duree) * annuite - annuite) / (Math.pow(1 + taux, duree) * taux);
        
    }
	@GET
    @Path("duree/{x}/{y}/{z}")
    public int duree(@PathParam("x") String x,@PathParam("y") String y,@PathParam("z") String z)
    {
		double annuite = Double.parseDouble(z);
		double t = Double.parseDouble(y);
		double capital = Double.parseDouble(x);
		double taux = Math.pow(1 + t, (double) 1 / 12) - 1;;
		return (int) ((Math.log(annuite / (annuite - taux * capital)) / Math.log(1 + taux)) + 0.5);
        
    }
	
	
	
}
