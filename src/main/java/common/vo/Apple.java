/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.vo;

/**
 * @author mishrk3
 */
public class Apple {

    private Double weight;
    private String color;
    private String origin;

    public Apple() {
    }

    public Apple(Double weight) {
        this.weight = weight;
    }

    public Apple(Double weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Double weight, String color, String origin) {
        this.weight = weight;
        this.color = color;
        this.origin = origin;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
