import java.math.*;
public class Planet {
    public double xxPos; /*x position*/
    public double yyPos; /*y position*/
    public double xxVel; /*velocity in x direction*/
    public double yyVel; /*velocity in y direction*/
    public double mass;  /*mass*/
    public String imgFileName; /*name of the image*/
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
	xxPos=xP;
	yyPos=yP;
	xxVel=xV;
	yyVel=yV;
	mass=m;
	imgFileName=img;
    };
    public Planet(Planet p){
	this.xxPos=p.xxPos;
	this.yyPos=p.yyPos;
	this.xxVel=p.xxVel;      
	this.yyVel=p.yyVel;
	this.mass=p.mass;
	this.imgFileName=p.imgFileName;
    };
    public double calcDistance(Planet p){/**Returns the sqrt of the distance between planets r=sqrt(dx^2+dy^2)*/  
	double dx = 0;
	double dy = 0;
	double distance=0;              
	dx=this.xxPos-p.xxPos;
	dy=this.yyPos-p.yyPos;
	distance=(double)Math.sqrt(dx*dx+dy*dy);
	return distance;
    };
    public double calcForceExertedBy(Planet p){/** Returns the pairwise force exerted by this planet on the passed arg planet 'F'*/
	double G=6.67E-11;
	double distance=this.calcDistance(p);
	double pairwise_force=0;
	pairwise_force=(G*this.mass*p.mass)/(distance*distance);
	return pairwise_force;
    };
    public double calcForceExertedByX(Planet p){/**force exerted along x axis */
	double pairwise_force=this.calcForceExertedBy(p);
	double dx=p.xxPos-this.xxPos;
	double r=this.calcDistance(p);
	double force_exerted_byx=(pairwise_force*dx)/r;
	return force_exerted_byx;
    };
    public double calcForceExertedByY(Planet p){/**force exerted along y axis */
	double pairwise_force=this.calcForceExertedBy(p);
	double dy=p.yyPos-this.yyPos;
	double r=this.calcDistance(p);
	double force_exerted_byy=(pairwise_force*dy)/r;
	return force_exerted_byy;
    };
    public double calcNetForceExertedByX(Planet[] allPlanets){
	double netforceExertedbyx=0;
	for (Planet planet:allPlanets){
	    if (this.equals(planet)==false){
		netforceExertedbyx+=this.calcForceExertedByX(planet);
	    }
	}
	return netforceExertedbyx;
    };
     public double calcNetForceExertedByY(Planet[] allPlanets){
	double netforceExertedbyy=0;
	for (Planet planet:allPlanets){
	    if (this.equals(planet)==false){
		netforceExertedbyy+=this.calcForceExertedByY(planet);
	    }
	}
	return netforceExertedbyy;
    };
    public void update(double dt,double fX,double fY){
	double acceleration_x=(double)fX/this.mass;
	double acceleration_y=(double)fY/this.mass;
	this.xxVel=this.xxVel+dt*acceleration_x;
	this.yyVel=this.yyVel+dt*acceleration_y;
	this.xxPos=this.xxPos+dt*this.xxVel;
	this.yyPos=this.yyPos+dt*this.yyVel; 
    };
    public void draw(){
	String file_path="images/"+this.imgFileName;
	StdDraw.picture(this.xxPos,this.yyPos,file_path);
	
    };
}
