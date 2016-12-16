package com.jiaxy.giants.javassit;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;

/**
 * Description: <br/>
 * <p/>
 * <br/>
 * @Date: 2016/12/15 18:11
 */
public class Guide {




    public static void createClass() throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.getCtClass("com.jiaxy.giants.javassit.Guide");
        ctClass = pool.makeClass("com.jiaxy.giants.Test");
        ctClass.debugWriteFile("d://");
    }

    /**
     * writeFile(), toClass(), or toBytecode() will frozen ctclass
     */
   public static void frozen() throws NotFoundException, IOException, CannotCompileException {
       ClassPool pool = ClassPool.getDefault();
       CtClass ctClass = pool.makeClass("com.jiaxy.giants.TestFrozen");
       byte[] bytes = ctClass.toBytecode();
       ctClass.setSuperclass(pool.get(Guide.class.getCanonicalName()));
       ctClass.debugWriteFile("d://");
   }

   public static void defrost() throws IOException, CannotCompileException, NotFoundException {
       ClassPool pool = ClassPool.getDefault();
       CtClass ctClass = pool.makeClass("com.jiaxy.giants.TestFrozen");
       byte[] bytes = ctClass.toBytecode();
       ctClass.defrost();
       ctClass.setSuperclass(pool.get(Guide.class.getCanonicalName()));
       ctClass.debugWriteFile("d://");
   }


   public static void changeName(String name){
       ClassPool pool = ClassPool.getDefault();
       CtClass ctClass = pool.makeClass("com.jiaxy.giants.Test");
       ctClass.setName(name);
       ctClass.debugWriteFile("d://");
   }


   public static void copyClass() throws NotFoundException, IOException, CannotCompileException {
       ClassPool pool = ClassPool.getDefault();
       CtClass ctClass = pool.get("com.jiaxy.giants.javassit.Guide");
       ctClass.toBytecode();
       ctClass = pool.getAndRename("com.jiaxy.giants.javassit.Guide","com.jiaxy.giants.TestCopied");
       ctClass.debugWriteFile("d://");
   }

   public static void javassitLoad(){

   }

}
