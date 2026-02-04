package org.dodo.utils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

public class DoScanner {
    public static void doSth(int num) {

//        String pack = "org.dodo.leetcode";
        String pack = "org.dodo.leetcode.t501_600";
        try {
            // 假设我们要扫描 com.example 包下带有 MyAnnotation 注解的类
//            List<Class<?>> annotatedClasses = scanForAnnotations(pack, ClassNum.class);
            Set<Class<?>> annotatedClasses = scanPackage(pack, ClassNum.class);
            System.out.println("Found " + annotatedClasses.size() + " classes with @ClassNum:");
            for (Class<?> clazz : annotatedClasses) {
                System.out.println(clazz.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Set<Class<?>> annotatedClasses = scanPackage(pack);
//        for (Class<?> clazz : annotatedClasses) {
//            System.out.println("Found class with annotation: " + clazz.getName());
//        }
    }


    private static List<Class<?>> scanForAnnotations(String packageName, Class<? extends Annotation> annotationClass)
            throws IOException, URISyntaxException, ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Enumeration<URL> resources = classLoader.getResources(path);

        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File directory = new File(resource.getFile());

            // 遍历目录中的所有文件
            for (File file : directory.listFiles()) {
                if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                    Class<?> clazz = Class.forName(className);

                    // 检查类上是否有指定的注解
                    if (clazz.isAnnotationPresent(annotationClass)) {
                        classes.add(clazz);
                    }
                }
            }
        }
        return classes;
    }


    private static Set<Class<?>> scanPackage(String packageName, Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classes = new HashSet<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            String path = packageName.replace('.', '/');
            Enumeration<URL> resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.getFile());
                if (directory.exists()) {
                    for (File file : directory.listFiles()) {
                        if (file.getName().endsWith(".class")) {
                            String className = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                            try {
                                Class<?> clazz = Class.forName(className);
                                if (clazz.isAnnotationPresent(annotationClass)) {
                                    classes.add(clazz);
                                }
                            } catch (ClassNotFoundException e) {
//                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return classes;
    }
}

