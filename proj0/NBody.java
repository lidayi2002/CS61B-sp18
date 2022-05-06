public class NBody {

    public static double readRadius(String f) {
        In universe = new In(f);
        int numPlanet = universe.readInt();
        double radius = universe.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String f) {

        In universe = new In(f);
        int numPlanet = universe.readInt();
        Planet[] planets = new Planet[numPlanet];
        double radius = universe.readDouble();
        for (int i = 0; i < numPlanet; i++) {
            double xp = universe.readDouble();
            double yp = universe.readDouble();
            double xv = universe.readDouble();
            double yv = universe.readDouble();
            double mass = universe.readDouble();
            String name = universe.readString();
            planets[i] = new Planet(xp, yp, xv, yv, mass, name);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] planets = NBody.readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for (Planet s : planets) {
            s.draw();
        }

        StdDraw.enableDoubleBuffering();

        double t;
        for (t = 0; t <= T; t += dt) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);                
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet s : planets) {
                s.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);

        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}
