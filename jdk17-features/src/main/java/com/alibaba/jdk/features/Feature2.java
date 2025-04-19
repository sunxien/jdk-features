package com.alibaba.jdk.features;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 *
 */
public class Feature2 {

    Object[] array = new Object[]{1, 2L, 3.0D, "Hello", null};

    public void enhanceSwitch() {
        RandomGeneratorFactory<RandomGenerator> l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom");
        RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
        for (int j = 0; j < 10; j++) {
            Object o = array[randomGenerator.nextInt(array.length)];
            String result = switch (o) {
                case null -> ("Oops....");
                case Integer i -> String.format("int %d", i);
                case Long l -> String.format("long %d", l);
                case Double d -> String.format("double %f", d);
                case String s -> String.format("String %s", s);
                default -> o.toString();
            };
            System.out.print(result + ", ");
        }
    }
}
