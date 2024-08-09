package org.example.anno;

import java.lang.reflect.Method;

public class PersonPlay {

    //bad code
    public static void main(String[] args)throws Exception {

        Person person = new Person();

        Class clz = person.getClass();

        Method method = clz.getDeclaredMethod("go",null);

        BGM bgm = method.getAnnotation(BGM.class);

        if(bgm != null) {
            String song = bgm.song();
            System.out.println(song);
        }


        method.invoke(person,null);

    }
}