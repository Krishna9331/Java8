/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.in.action.chapter2.weight;

import com.oracle.java8.vo.Apple;

/**
 *
 * @author mishrk3
 */
public class AppleHeavyWeightPredicate implements ApplePredicate {
    
    @Override
    public boolean test(Apple apple){
       return apple.getWeight() > 150;
    }
}
