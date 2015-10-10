/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;

import com.oracle.java8.vo.Apple;

/**
 *
 * @author mishrk3
 */
public class AppleBuilder {

    private Apple apple;

    public AppleBuilder() {
        apple = new Apple();
    }

    public AppleBuilder withColor(String color) {
        apple.setColor(color);
        return this;
    }

    public AppleBuilder withOrigin(String origin) {
        apple.setOrigin(origin);
        return this;
    }

    public AppleBuilder withWeight(double weight) {
        apple.setWeight(weight);
        return this;
    }

    public Apple build() {
        return apple;
    }
    
    public static List<Apple> createApples() {
        List<Apple> apples = new ArrayList<>();
        Apple paleApple = new AppleBuilder().withColor("pale").withWeight(180).withOrigin("india").build();
        Apple whiteApple = new AppleBuilder().withColor("white").withWeight(90).withOrigin("india").build();
        Apple redApple = new AppleBuilder().withColor("red").withWeight(120).withOrigin("india").build();
        Apple redHeavyApple = new AppleBuilder().withColor("red").withWeight(170).withOrigin("india").build();
        Apple redForiegnApple = new AppleBuilder().withColor("red").withWeight(110).withOrigin("US").build();
        Apple redForiegnHeavyApple = new AppleBuilder().withColor("red").withWeight(170).withOrigin("China").build();
        Apple greenApple = new AppleBuilder().withColor("green").withWeight(140).withOrigin("Japan").build();
        Apple greenHeavyApple = new AppleBuilder().withColor("green").withWeight(190).withOrigin("india").build();
        apples.add(paleApple);
        apples.add(whiteApple);
        apples.add(redApple);
        apples.add(redHeavyApple);
        apples.add(redForiegnApple);
        apples.add(redForiegnHeavyApple);
        apples.add(greenApple);
        apples.add(greenHeavyApple);
        return apples;
    }

}
