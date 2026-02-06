package org.dodo.utils;

import org.dodo.leetcode.ISolve;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.*;

public class DoScanner {
    public static void doSth(int num) {

        String pack = "org.dodo.leetcode";
//        String pack = "org.dodo.leetcode.t501_600";
        try {
            // 假设我们要扫描 com.example 包下带有 MyAnnotation 注解的类
            List<Class<?>> annotatedClasses = scanPackage(pack, ClassNum.class);
//            Set<Class<?>> annotatedClasses = scanPackage(pack, ClassNum.class);
            Lg.infoClass("Found " + annotatedClasses.size() + " classes with @ClassNum:");
//            Lg.info((Arrays.toString(annotatedClasses.toArray())));
            boolean hasMatch = false;
            for (Class<?> clazz : annotatedClasses) {
                try {
                    Class<?> clazzIn = Class.forName(clazz.getName()); // 获取MyClass的Class对象
                    ClassNum annotation = clazz.getAnnotation(ClassNum.class); // 获取注解实例
                    Constructor<?> constructor = clazz.getDeclaredConstructor(); // 获取无参构造方法
                    Object obj = constructor.newInstance();
                    if(annotation.value() != num){
                        continue;
                    }
                    if(!(obj instanceof ISolve)){
                        continue;
                    }
                    hasMatch = true;
                    Lg.infoClass("<==============下面是结果================>");
                    ((ISolve) obj).doSth();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(!hasMatch){
                Lg.infoClass("没有匹配的类！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 递归扫描指定包路径下的所有类
     * @param packageName 包名
     * @return 扫描到的类列表
     */
    public static List<Class<?>> scanPackage(String packageName, Class<? extends Annotation> annotationClass) {
        List<Class<?>> classes = new ArrayList<>();
        try {
            // 将包名转换为路径格式
            String path = packageName.replace('.', '/');
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.getFile());

                // 递归扫描目录
                scanDirectory(directory, packageName, classes, annotationClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

    /**
     * 递归扫描目录
     * @param directory 目录
     * @param packageName 包名
     * @param classes 类列表
     */
    private static void scanDirectory(File directory, String packageName, List<Class<?>> classes, Class<? extends Annotation> annotationClass) {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                // 递归扫描子目录
                String subPackageName = packageName + "." + file.getName();
                scanDirectory(file, subPackageName, classes, annotationClass);
            } else if (file.getName().endsWith(".class")) {
                // 加载类文件
                String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                try {
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(annotationClass)) {
                        classes.add(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    // 忽略无法加载的类
                }
            }
        }
    }
}

