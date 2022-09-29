package chpt5;

//����һ��������Shape
abstract class Shape
{
    abstract float area();//��������
}
//����һ������Circle
class Circle extends Shape
{
    public float r; 
    Circle(float r)
    {
          this.r = r;      //thisָ"��������"
     }
     public float area()//����ʵ��
     {
         return (float) (3.14*r*r);
      }
}
//����һ������Rectangle
class Rectangle extends Shape
{
     public float width,height; 
     Rectangle (float w, float h)
     {
           width = w; 
           height = h;
     }
     public float area()  //����ʵ��
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
