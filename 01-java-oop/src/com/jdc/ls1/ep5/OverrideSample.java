package com.jdc.ls1.ep5;

public class OverrideSample {
    
    static class Super {
        void doGreet() {
            System.out.println("Hello from Super");
        }
    }
    
    static class Sub extends Super {
        @Override
        void doGreet() {
            System.out.println("Hello from Sub");
        }
    }

    public static void main(String[] args) {
        Super sup = new Super();
        Super sub = new Sub();
        
        sup.doGreet();
        sub.doGreet();
    }
}
