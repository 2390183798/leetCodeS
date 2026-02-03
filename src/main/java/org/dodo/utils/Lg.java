package org.dodo.utils;

public class Lg {
    public static void info(String info){
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

//    static String getClassName01(){
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        String callingClassName = "";
//        // 通常调用者位于堆栈的第3个元素（索引为2），因为第0个是getStackTrace()调用，第1个是printCallingClassName()调用
//        if (stackTraceElements.length > 2) {
//            try {
//                String pack = stackTraceElements[2].getClassName();
//                callingClassName = pack.substring(pack.lastIndexOf(".") + 1);
//            } catch (Exception ignored) {
//            }
//        }
//        return callingClassName;
//    }
//    static String getClassName02(){
//        try {
//            // 使用Throwable而非手动捕获异常以避免额外的异常处理开销
//            return new Throwable().getStackTrace()[1].getClassName();
//        } catch (Exception e) {
//            return "";
//        }
//    }
}
