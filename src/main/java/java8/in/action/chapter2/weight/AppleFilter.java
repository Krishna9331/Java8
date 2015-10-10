/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.in.action.chapter2.weight;

import java.util.ArrayList;
import java.util.List;

import com.oracle.java8.vo.Apple;

/**
 *
 * @author mishrk3
 */
public class AppleFilter {

    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
