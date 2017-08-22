import java.lang.*;
public class NBody {
     public static double readRadius(String file){
	In in_file=new In(file);
	int n_of_planets=in_file.readInt();
	double radius=in_file.readDouble();    
	return radius;
    };
    public static Planet[] readPlanets(String file){
	In in = new In(file);
	int size_of_arr=in.readInt();
	double r=in.readDouble();
	Planet[] p_arr=new Planet[size_of_arr];
	for (int i=0; i<size_of_arr;i++){
	    Planet p=new Planet(0.0,0.0,0.0,0.0,0.0,null);
	    p.xxPos=in.readDouble();
	    p.yyPos=in.readDouble();
	    p.xxVel=in.readDouble();
	    p.yyVel=in.readDouble();
	    p.mass=in.readDouble();
	    p.imgFileName=in.readString();
	    p_arr[i]=p;
	}
	return p_arr;
    }
    public static void main(String[] args){
	StdAudio.play("audio/2001.mid");
	int no_of_p=0;
	if (args.length!=0){
	    double T=Double.parseDouble(args[0]);
	    double dt=Double.parseDouble(args[1]);
	    String bckgrd_img="images/starfield.jpg";
	    String filename=args[2];
	    double radius_of_universe=NBody.readRadius(filename);
	    Planet[] p_arr=NBody.readPlanets(filename);
	    StdDraw.clear();
	    StdDraw.setCanvasSize(512,512);
	    StdDraw.setXscale(-radius_of_universe,radius_of_universe);
	    StdDraw.setYscale(-radius_of_universe,radius_of_universe);
	    StdDraw.picture(0,0,bckgrd_img); 
	    for (Planet p : NBody.readPlanets(filename)){
		p.draw();
		no_of_p+=1;
	    }
	    
	    StdDraw.show(10);
	    Planet[] p_array=NBody.readPlanets(filename);
	    for(double time_var=0;time_var<=T;){
		double[] xForces=new double[no_of_p];
		double[] yForces=new double[no_of_p];
		int i=0;
		for (Planet each_planet:p_array){
		    xForces[i]=each_planet.calcNetForceExertedByX(p_array);
		    yForces[i]=each_planet.calcNetForceExertedByY(p_array);
		    each_planet.update(dt,xForces[i],yForces[i]);
		    i+=1;
		}
		StdDraw.clear();
		StdDraw.picture(0,0,bckgrd_img);
		for (Planet p : p_array){
		p.draw();
		}
		StdDraw.show(10);
		time_var+=dt;
		
	    }
	    
	}
	

    }
    
}
