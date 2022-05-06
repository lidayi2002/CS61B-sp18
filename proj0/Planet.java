public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;
    /** Instance variables above. */
    public Planet(double xP, double yP, double xV,
        double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double distance;
        double xdis = this.xxPos - p.xxPos;
        double ydis = this.yyPos - p.yyPos;
        distance = Math.sqrt(xdis * xdis + ydis * ydis);
        return distance;

    }

    public double calcForceExertedBy(Planet p) {
        
        double dis2 = this.calcDistance(p) * this.calcDistance(p);
        return Planet.G * this.mass * p.mass / (dis2);

    }

    public double calcForceExertedByX(Planet p) {
        return (p.xxPos - this.xxPos) / this.calcDistance(p) * this.calcForceExertedBy(p);
    }

    public double calcForceExertedByY(Planet p) {
        return (p.yyPos - this.yyPos) / this.calcDistance(p) * this.calcForceExertedBy(p);
    }
    
    public double calcNetForceExertedByX(Planet[] p) {
        double NetForce = 0;
        for (Planet s : p) {
            if (this.equals(s)) {
                NetForce += 0;
            } else {
                NetForce += this.calcForceExertedByX(s);
            }
        }
        return NetForce;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double NetForce = 0;
        for (Planet s : p) {
            if (this.equals(s)) {
                NetForce += 0;
            } else {
                NetForce += this.calcForceExertedByY(s);
            }
        }
        return NetForce;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += aX * dt;
        this.yyVel += aY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;

    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}