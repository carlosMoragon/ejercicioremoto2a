package com.example.pruebadetest;

public class E2G {
    public double a;
    public double b;
    public double c;
    public E2G(double a_, double b_, double c_){
        a=a_;
        b=b_;
        c=c_;
    }
    public double discriminante(){
        return Math.pow(b,2)-(4*a*c);
    }
    public double x1() throws RaicesImaginariasException{
        if (a==0)
            throw new ArithmeticException();
        if (discriminante()>=0)
            return (-b+Math.pow(discriminante(),0.5))/(2*a);
        else
            throw new RaicesImaginariasException(-b/(2*a), Math.pow(-discriminante(),0.5)/(2*a));
    }
    public double x2() throws RaicesImaginariasException{
        if (discriminante()>=0)
            return (-b-Math.pow(discriminante(),0.5))/(2*a);
        else
            throw new RaicesImaginariasException(-b/(2*a), Math.pow(-discriminante(),0.5)/(2*a));
    }
}