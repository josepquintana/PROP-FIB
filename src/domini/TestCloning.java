//package domini;

/*
Creates and returns a copy of this object. The precise meaning of "copy" may depend on the class of the object.
The general intent is that, for any object x, the expression:
1) x.clone() != x will be true
2) x.clone().getClass() == x.getClass() will be true, but these are not absolute requirements.
3) x.clone().equals(x) will be true, this is not an absolute requirement.
*/

//public class TestCloning {
//
//    public static void main(String[] args) throws CloneNotSupportedException
//    {
//        Department dept = new Department(1, "Human Resource");
//        Employee original = new Employee(1, "Admin", dept);
//
//        //Lets create a clone of original object
//        Employee cloned = (Employee) original.clone();
//
//        //Let verify using employee id, if cloning actually workded
//        System.out.println(cloned.getEmpoyeeId());
//
//        //Verify JDK's rules
//
//        //Must be true and objects must have different memory addresses
//        System.out.println(original != cloned);
//
//        //As we are returning same class; so it should be true
//        System.out.println(original.getClass() == cloned.getClass());
//
//        //Default equals method checks for references so it should be false. If we want to make it true,
//        //then we need to override equals method in Employee class.
//        System.out.println(original.equals(cloned));
//    }
//
//}
