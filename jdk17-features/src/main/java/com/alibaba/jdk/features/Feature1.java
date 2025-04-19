package com.alibaba.jdk.features;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 *
 */
public class Feature1 {

    public void newRandom() {
        RandomGeneratorFactory<RandomGenerator> l128X256MixRandom = RandomGeneratorFactory.of("L128X256MixRandom");
        RandomGenerator randomGenerator = l128X256MixRandom.create(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int randInt = randomGenerator.nextInt(10);
            System.out.print(randInt + ", ");
        }
    }
}
