package chpt5;

//定义一个抽象类Shape
abstract class Shape
{
    abstract float area();//方法声明
}
//定义一个子类Circle
class Circle extends Shape
{
    public float r; 
    Circle(float r)
    {
          this.r = r;      //this指"这个对象的"
     }
     public float area()//方法实现
     {
         return (float) (3.14*r*r);
      }
}
//定义一个子类Rectangle
class Rectangle extends Shape
{
     public float width,height; 
     Rectangle (float w, float h)
     {
           width = w; 
           height = h;
     }
     public float area()  //方法实现
     {
           return width*height;
     }
}
public class Ex5_5 {
	public static void main(String args[]){
		Circle cir = new Circle(3);
		Rectangle rec = new Rectangle(2,5);
		System.out.println(cir.area());
		System.out.println(rec.area());
	}
}
