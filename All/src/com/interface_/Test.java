package com.interface_;

public abstract class Test {
    public static void main(String[] args) {
        //接口的使用1：
        //创建一个接口 用接口的引用指向一个实现了接口的对象
        IPlayGame ip1 = new SmartPhone();
        ip1.playGame();

        IPlayGame ip2 = new Psp();
        ip2.playGame();

        //接口的使用2：
        IPlayGame ip3 = new IPlayGame() {
            //通过匿名内部类的方式使用接口
            public void playGame() {
                //直接在代码里写接口的实现部分
                System.out.println("使用匿名内部类的方式实现接口");
            }
        }; //实现以后这里要有一个分号结束
        ip3.playGame();

        //接口的使用3：
        //直接new接口实现调用方法：
        new IPlayGame() {
            public void playGame() {
                System.out.println("使用匿名内部类的方式实现接口2");
            }
        }.playGame();

        //接口在使用过程当中，还经常与匿名内部类配合使用
        //匿名内部类就是没有名字的内部类，多用于关注实现而不关注实现类的名称
        //语法格式：
        /*Interface i=new Interface() {
            public void method() {
                System.out, println("匿名内部类实现接口的方式");
            }
        }*/





    }
}
