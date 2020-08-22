public class Body {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static double G = 6.67 * Math.pow(10, -11);

    public Body(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b){
        double distance = Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
        return distance;
    }

    public double calcForceExertedBy(Body b){
        double force = G*this.mass*b.mass/Math.pow(this.calcDistance(b), 2);
        return force;
    }

    public double calcForceExertedByX(Body b) {
        double forceX = this.calcForceExertedBy(b)/this.calcDistance(b)*(b.xxPos - this.xxPos);
        return forceX;
    }

    public double calcForceExertedByY(Body b) {
        double forceY = this.calcForceExertedBy(b)/this.calcDistance(b)*(b.yyPos - this.yyPos);
        return forceY;
    }

    public double calcNetForceExertedByX(Body[] allbodys){
        double netforceX = 0;
        for(Body b : allbodys){
            if (!this.equals(b)){
                netforceX += this.calcForceExertedByX(b);
            }
        }
        return netforceX;
    }

    public double calcNetForceExertedByY(Body[] allbodys){
        double netforceY = 0;
        for(Body b : allbodys){
            if (!this.equals(b)){
                netforceY += this.calcForceExertedByY(b);
            }
        }
        return netforceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt*aX;
        this.yyVel += dt*aY;
        this.xxPos += dt*xxVel;
        this.yyPos += dt*yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}