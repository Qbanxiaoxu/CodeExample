//SuperStar.java
package chpt6.Ex6_3;
public class SuperStar {
   public static void main(String[] args) {
	RealityShow ourShow = new RealityShow("China Talent");
	
    Singer swift= new Singer("Taylor Swift",25,'f',"change");
    System.out.println(swift);
    //Singer������뵽RealityShow��
    ourShow.joinShow(swift);
       
    System.out.println("***************************************");
    MovieStar chan = new MovieStar("Jackie Chan",62,'m',"policeman story");
    System.out.println(chan);
    //MovieStar������뵽RealityShow��
    ourShow.joinShow(chan);
   }
} 
