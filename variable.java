// A variable is the name of memory location that can store data
/*
 there are three types of variables
 local variable->
 1. they are always declared within a method,constructors or blocks.
 2. scope is always inside the method,constructor or block.
 3. when variable get allocated when constructor method or block get executed variable allocates in memory
 when get exits variable get deleted
 4. local variable stored in stack memory
 5. default values - value should be provided before use
 7. access specifier(public,private,protected) can't be used with local variables

 static variable->
 *** Static variable is get shared with every object ***
 1. declaration within a class but using static keyword but outside a method or constructor or block
 2. scope similar to instance variable inside all methods constructor or blocks
 3. when we run program .class file is loaded then static variable loaded
 4. when .class file unloaded variable get releases
 5. they are stored in static memory
 6. default value similar to instance variable
 7. access specifier can be used
 8. access it directly call by using class name
 9.by using object reference just like instance variable.


 instance variable->
 1. declaration inside the class but outside methods or constructors or blocks
 2. scope inside all methods block and constructor within a class
 3. variable allocate memory when object is created
 4. when object deleted destroyed variable releases memory
 5. they are stored in heap memory
 6. default values like int as 0 bool as false if object then none
 7. access specifiers can be used
 8. how to access it can be called directly if its a simple method
 9. If its a static method then you need to create an object of class and call variable with it



 */
public class variable
{
    int a = 10; //instance variable
    static int b = 20; //static variable
    void add()
    {
        int c = 30;//local variable
        int d = a+b+c;
        System.out.println(d);

    }
    public static void main(String args[])
    {
        variable v = new variable();
        System.out.println(v.a);
        System.out.println(v.b);
        v.a = 1000;//instance variable will have separate memory for each object
        v.b = 2000;// static variable will share common memory with v and v1 object both 
         System.out.println(v.a);
        System.out.println(v.b);
        variable v1 = new variable();
         System.out.println(v1.a);
        System.out.println(v1.b);


       // System.out.println(v.a*b*c);// error because c is a local variable of method add they can't be used outside add method
        //v.add();

    }
}
