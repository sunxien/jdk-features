package com.alibaba.jdk.features;

/**
 *
 */
public class Feature1 {

    // -XX:+ShowCodeDetailsInExceptionMessages
    public void enhanceNPE(){
        Parent p = new Parent();
        p.name = "jack";
        System.out.println(p.toString());
    }

    public static class Parent {
        public String name;
        public Child child;

        @Override
        public String toString() {
            return "Parent{" +
                    "child=" + child.toString() +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class Child {
        public String name;
    }
}
