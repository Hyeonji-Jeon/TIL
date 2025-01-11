package org.example;

public class SubjectTest {

    public static void main(String[] args) {

        SubjectScore s1 = new SubjectScore();
        s1.subject = "국어";
        s1.score = 30;

        SubjectScore s2 = new SubjectScore();
        s2.subject = "영어";
        s2.score = 40;

        SubjectScore s3 = new SubjectScore();
        s3.subject = "수학";
        s3.score = 20;

        SubjectScore [] arr = {s1, s2, s3};


    }
}
