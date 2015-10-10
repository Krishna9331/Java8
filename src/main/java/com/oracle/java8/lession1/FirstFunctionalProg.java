/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oracle.java8.lession1;

import java.util.List;
import java.util.Optional;

import com.oracle.java8.vo.Student;

/**
 *
 * @author mishrk3
 */
public class FirstFunctionalProg {

    @SuppressWarnings("deprecation")
	public Double highestScoreWithoutFunctionalProg(List<Student> students) {
        Double highestScore = 0.0;
        for (Student s : students) {
            if (2011 == s.getPassingYear().getYear()) {
                if (s.getScore() > highestScore) {
                    highestScore = s.getScore();
                }
            }
        }
        return highestScore;
    }
    
    @SuppressWarnings("deprecation")
    public Double highestScoreWithFunctionalProg(List<Student> students){
//        Optional<Double> highestScore = students.stream().filter(new Predicate<Student>(){
//            public boolean test(Student s){
//                return s.getPassingYear().getYear() == 2011;
//            }
//        }).
//               map(new Mapper<Student,Double>(){
//            public Double extract(Student s){
//                return s.getScore();
//            }
//        }).max();
//          
        
        Optional<Double> highestScore =students.stream().filter(student->student.getPassingYear().getYear() == 2011).
                map(student->student.getScore()).
                reduce(Double::max);
        students.stream().filter(student->student.getPassingYear().getYear() == 2011).
                mapToDouble(student->student.getScore()).max();
                
              
        return highestScore.get();
    }
}
