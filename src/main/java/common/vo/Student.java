/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.vo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mishrk3
 */
public abstract class Student {

    private Date passingYear;
    private String name;
    private Double score;
    
    public Date getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(Date passingYear) {
        this.passingYear = passingYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.passingYear);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.score);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Student{" + "passingYear=" + passingYear + ", name=" + name + ", score=" + score + '}';
    }

}
