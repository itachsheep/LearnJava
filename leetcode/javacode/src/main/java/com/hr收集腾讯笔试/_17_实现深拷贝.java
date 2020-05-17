package com.hr收集腾讯笔试;

public class _17_实现深拷贝 {
    public static void main(String[] args) {
        // 原始对象
        Student stud = new Student("陶蔚", "Itach");
        System.out.println("原始对象: " + stud.getStuName() + " - "
                + stud.getRefObject().getObjName());

        // 拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println("拷贝对象: " + clonedStud.getStuName() + " - "
                + clonedStud.getRefObject().getObjName());

        // 原始对象和拷贝对象是否一样：
        System.out.println("原始对象和拷贝对象是否一样: " + (stud == clonedStud));

        // 原始对象和拷贝对象的name属性是否一样
        System.out.println("原始对象和拷贝对象的name属性是否一样: "
                + (stud.getStuName() == clonedStud.getStuName()));

        // 原始对象和拷贝对象的subj属性是否一样
        System.out.println("原始对象和拷贝对象的subj属性是否一样: "
                + (stud.getRefObject() == clonedStud.getRefObject()));




    }

}
/**
 * https://juejin.im/post/5c988a7ef265da6116246d11
 *
 * 深拷贝 和 浅拷贝区别
 */
class RefObject {
    private String objName;

    public RefObject(String objName) {
        this.objName = objName;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    @Override
    public String toString() {
        return "RefObject{" +
                "objName='" + objName + '\'' +
                '}';
    }
}

class Student implements Cloneable{
    private String stuName;
    private RefObject refObject;

    public Student(String sName,String objName) {
        stuName = sName;
        refObject = new RefObject(objName);
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public RefObject getRefObject() {
        return refObject;
    }

    public void setRefObject(RefObject refObject) {
        this.refObject = refObject;
    }

    @Override
    protected Object clone() {
        Student s = new Student(stuName,refObject.getObjName());
        return s;
    }
}
