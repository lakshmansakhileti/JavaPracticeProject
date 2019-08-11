package com.java;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCloneExample implements Cloneable {
    String name = "lakshman";
    int age = 32;
    List<String> address = new ArrayList();

    /**
     * Way of taking deep copy of cloning, i.e If you didn't override the clone method, java always gives you
     * shallow copy. It means that  for instance address is reference in this example, so in shallow copy both
     * cloned object, original object have same reference to address. so when ever you change any one of the object then
     * it will effect the both the objects. That is why in clone method we have created separate object for address so both
     * objects have its own copies.
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        EmployeeCloneExample cloneExample = (EmployeeCloneExample) super.clone();
        cloneExample.address = new ArrayList<>(cloneExample.address);
        return cloneExample;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        EmployeeCloneExample ec = new EmployeeCloneExample();

        ec.address.add("Satyavaram");
        ec.address.add("Hyd");
        System.out.println("name ="+ ec.name);
        System.out.println("age="+ec.age);
        System.out.println("address ="+ ec.address.toString());

        EmployeeCloneExample clone = (EmployeeCloneExample)ec.clone();

        System.out.println("name ="+ clone.name);
        System.out.println("address ="+ clone.address.toString());
        clone.name  = "ram";
        ec.address.add("chandra palem");
        clone.address.add("Panjagutta");
        System.out.println("name ="+ clone.name);
        System.out.println("name ="+ ec.name);

        System.out.println("address ="+ clone.address.toString());

        System.out.println("address ="+ ec.address.toString());




    }

}
