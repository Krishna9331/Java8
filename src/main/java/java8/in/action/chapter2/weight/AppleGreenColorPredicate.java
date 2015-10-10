/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8.in.action.chapter2.weight;

import common.vo.Apple;

/**
 *
 * @author mishrk3
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    
    @Override
    public boolean test(Apple apple){
      return "green".equalsIgnoreCase(apple.getColor());
    }
}
