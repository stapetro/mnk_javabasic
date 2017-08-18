package com.strategy;

public class Test {

    public static void main(String[] args) {

        //mozemo dodeliti bilo koju strateguju da uradi sortiranje
        int[] var = {1, 2, 3, 4, 5 };
        Context ctx = new Context(new BubbleSort());
        ctx.arrange(var);

        //mozemo promeniti strategiju bez potrebe da menjamo Context klasu
        ctx = new Context(new QuickSort());
        ctx.arrange(var);


    }
}
