package chpt5;

class Point
{
   int x, y;  //����
   public Point(int x, int y) //����
   {
	   this.x = x; 
	   this.y = y;
   }
}
class Line
{
   Point  p1,p2;     
   Line(Point a, Point b)   //���췽��
   {  
	   p1 = new Point(a.x,a.y);
       p2 = new Point(b.x,b.y);
    }
}
public class Ex5_7{
    public static void main(String[] args){
    	Point one = new Point(4,2);
    	Point two = new Point(6,3);
    	Line lineone = new Line(one, two);
    	System.out.println("��A��"+one.x+","+one.y);
    	System.out.println("��B��"+two.x+","+two.y);
    }
}


 /*
  *���������·�ʽʵ��
  */
/*class Line
{
	Point p1, p2;
	Line(int x1,int y1, int x2,int y2){
	   p1 = new Point(x1,y1);
	   p2 = new Point(x2,y2);
	}
}
public class Ex5_7{
	public static void main(String[] args){   	
    	Line lineone = new Line(4,2,6,3);
	}
}*/