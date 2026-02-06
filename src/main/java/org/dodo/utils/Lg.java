package org.dodo.utils;

public class Lg {
    public static void infoClass(String info){
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String callingClassName = "";
        // 通常调用者位于堆栈的第3个元素（索引为2），因为第0个是getStackTrace()调用，第1个是printCallingClassName()调用
        if (stackTraceElements.length > 2) {
            try {
                String pack = stackTraceElements[2].getClassName();
                callingClassName = pack.substring(pack.lastIndexOf(".") + 1);
            } catch (Exception ignored) {
            }
        }

        System.out.println(callingClassName + " : " +info);
    }

    public static void infoItem(String item){
        System.out.print(item);
    }

    public static void infoLine(String item){
        System.out.println(item);
    }

    public static void line(){
        System.out.println(" ");
    }
}
