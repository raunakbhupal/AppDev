package com.example.finalapp;

import java.util.Random;

import static java.lang.StrictMath.abs;

public class QuestionLibraryEasy {

    //Easy Range[5,10]
    final int r1 = new Random().nextInt(3) + 2;
    final int r2 = new Random().nextInt(3) + 5;
    final int r3 = new Random().nextInt(3) + 8;
    final int r4 = new Random().nextInt(3) + 11;

    //Medium Range[10,15]
    final int r5 = new Random().nextInt(3) + 14;



    private String mQuestions [] = {
            //Easy questions
            r1 + " * " + r1 +" =\n",
            r2 + " * " + r2 +" =\n",
            r3 + " * " + r3 +" =\n",
            r2 + " * " + r4 +" =\n",
            r1 + " * " + r3 +" =\n",
            r1 + " * " + r2 +" =\n",
            r3 + " * " + r2 +" =\n",
            r4 + " * " + r1 +" =\n",
            r4 + " + " + r5 +" =\n",
            r4 + " * " + r3 +" =\n",

            //Medium questions
            "(" + r5 + " + " + r1 +")"+ " * " +"(" +  r2 + " + " + r4 + ")"+" =\n",
            "(" + r2 +" + " + r3 +")"+ " / " + "(" + r1 + " + " + r5 + ")"+" =\n(Round upto 2 decimal points)",
            "|"+"(" + r4 +" + "+r1+")"+ " - " + "(" + r3 + " + " + r2 +")"+ "| =\n",
            "(" +r4+ " * "+ r1+")"+ " + "+ "(" + r2+ " * " +r2+ ")"+" =\n",
            "(" +r4+ " * " +  r3+")" + " / " +  "(" + r2 + " * " + r2 + ")"+" =\n(Round upto 2 decimal points)",
            "(" +r2 + " * " + r1 +")"+ " - " + "(" + r4 + " * " + r5 +")"+ " =\n" ,
            "(" +r2+ " / "+ r4 +")"+ " * "+"(" +  r3+ " / "+ r2+")"+ " =\n(Round upto 2 decimal points)",

            //Formula based
            "(" + r5 + " + " + r1+ ")" + "^ 2 =\n(Formula based)",
            "(" + r4 + " - " + r2+ ")" + "^ 2 =\n(Formula based)",
            "(" + r3 + "^2 " + " - " + r2+ "^2" + ")" +" =\n(Formula based)"
    };
    //Easy question answers
    int a1 = r1 * r1;
    int a2 = r2 * r2;
    int a3 = r3 * r3;
    int a4 = r2 * r4;
    int a5 = r1 * r3;
    int a6 = r1 * r2;
    int a7 = r3 * r2;
    int a8 = r4 * r1;
    int a9 = r4 + r5;
    int a10 = r4 * r3;

    //Medium question answers
    int a11 =  (r5 + r1) * (r2 + r4) ;
    double a12 =  ((double)r2 + (double)r3) / ((double)r1 + (double)r5) ;
    String a112 = String.format("%.2f",a12);
    int a13 =  abs((r4 + r1) - (r3 + r2)) ;
    int a14 =  (r4 * r1) + (r2 * r2) ;
    double a15 =  ((double)r4 * (double)r3) / ((double)r2 * (double)r2) ;
    String a115 = String.format("%.2f",a15);
    int a16 =  (r2 * r1) - (r4 * r5) ;
    double a17 =  ((double)r2 / (double)r4) * ((double)r3 / (double)r2) ;
    String a117 = String.format("%.2f",a17);
    int a18 = (r5 + r1) * (r5 + r1);
    int a19 = (r4 - r2) * (r4 - r2);
    int a20 = (r3 * r3) - (r2 * r2);


    private String mCorrectAnsweres[] = {a1+"",a2+"",a3+"",a4+"",a5+"",a6+"",a7+"",a8+"",a9+"",a10+"",a11+"",a112+"",a13+"",a14+"",a115+"",a16+""
            ,a117+"",a18+"",a19+"",a20+""};

    public int getQuestioncount(){
        return mQuestions.length;
    }

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }
    public  String getCorrectAnswer(int a){
        String answer = mCorrectAnsweres[a];
        return answer;
    }
}
