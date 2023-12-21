package Finding_area;
/**
 * Java program to calculate area for different dimensions of different shapes
 */
import java.lang.Math; //to calculate square root in dimension3 class
import java.util.ArrayList;
public class Area{

    public static void main(String []args){
        ArrayList<Double> array = new ArrayList<>();//initialize array list
        //Creating objects for child classes
        dimension2 d2 = new dimension2();
        dimension3 d3 = new dimension3();
//pushing objects to array list
        array.add(d2.triangle_area(44,76));
        array.add(d2.rectangle_area(56,66));
        array.add(d3.cone_area(3,4));
        array.add(d3.box_area(22,45,12));
        System.out.println("Areas of triangle, rectangle, cone, box are: ");
        // Displaying result using arraylist
        try{//loop inside a try block to handle exception
         for(Double element:array){
                System.out.println(element);
            }
        }
        catch(Exception e){//catch the exception and display it
            System.out.println("Error has occured");
        }
        finally{
            System.out.println("End of the code");
        }
    }
}
//creating a child class which calculates 2 dimensional shapes
class dimension2 extends Area{
    dimension2(){System.out.println("Constructor for circle class is created");}//Constructor for circle class
        //Calculate area of triangle
        public double triangle_area(float length,float height){
        return 0.5f*length*height;
    }
        //Calculate area of rectangle
        public double rectangle_area(float length,float height){
        return length*height;
    }
}
//creating a child class which calculates 3 dimensional shapes
class dimension3 extends Area{
    dimension3(){System.out.println("Constructor for box class is created");}//Constructor for box class
    //Calculate area of cone
    public double cone_area(float radius,float height){//calculate area of cone
        double area =3.14f*radius*radius+3.14f*radius*(Math.sqrt(radius*radius+height*height));
        return area;
    }
    //Calculate area of box
    public double box_area(float length,float breadth, float height){
        return 2*(length*breadth+breadth*height+height*length);
    }
}
