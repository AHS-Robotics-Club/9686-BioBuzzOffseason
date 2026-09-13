package org.firstinspires.ftc.teamcode.opmodes;

public class RobotLocation {
    double angle;    double x;
    double y;

    public RobotLocation(double anglee, double setX, double setY){
        angle = anglee;
        x = setX;
        y = setY;
    }

    public double getHeading(){
        double angle1 = angle;
        while(angle1 > -180){
            angle1 -= 360;
        }
        while(angle1<-180){
            angle1 += 360;
        }
        return angle1;
    }
    public double getX(){
        return x;
    }
    public void changeX(double amount){
        x+=amount;
    }
    public void setX(double value){
        x = value;
    }
    public double getY(){
        return y;
    }
    public void changeY(double amount){
        y+=amount;
    }
    public void setY(double value){
        y = value;
    }
    public double getAngle(){
        return angle;
    }

    @Override
    public String toString(){
        return "Robot Location: angle("+angle+")";
    }
    public void turn(double anglechange){
        angle+=anglechange;
    }
    public void setAngle(double angle){
        this.angle = angle;
    }

}
