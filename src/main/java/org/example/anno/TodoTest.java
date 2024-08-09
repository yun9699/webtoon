package org.example.anno;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TodoTest {

    //badcode
    public static void main(String[] args) throws Exception {

        String url = "/user/list";



        String prefix = "D:\\tempy\\webtoon\\src\\main\\java\\";
        String packageFolder = "D:\\tempy\\webtoon\\src\\main\\java\\org\\example\\controller";

        File file = new File(packageFolder);

        String[] classNames = file.list();

        Map<String, Object> webPathMap = new HashMap<String, Object>();

        for (String className : classNames) {
            System.out.println(className);

            String pckageName ="org.example.controller";

            String targetName = pckageName+"."+className.substring(0,className.lastIndexOf('.'));

            Class clazz = Class.forName(targetName);

            System.out.println(clazz);

            Object  object = clazz.getDeclaredConstructors()[0].newInstance();

            Annotation webpatAnno = clazz.getDeclaredAnnotation(WebPath.class);

            if(webpatAnno != null) {

                webPathMap.put( ((WebPath)webpatAnno).value(), object);

            }

        }

        System.out.println(webPathMap);


        String targetPath = url;
        String oper = targetPath.substring(targetPath.lastIndexOf('/'));

        String targetWebPath = targetPath.substring(0,targetPath.lastIndexOf('/'));

        System.out.println(targetWebPath);

        Object controller = webPathMap.get(targetWebPath);

        Class clz = controller.getClass();

        Method[] methods = clz.getDeclaredMethods();

        for (Method method : methods) {

            //System.out.println(method);

            Controller controller1 = method.getAnnotation(Controller.class);

            if(controller1 != null) {
                if(controller1.value().equals(oper)){
                    method.invoke(controller);
                }
            }

        }



    }
}