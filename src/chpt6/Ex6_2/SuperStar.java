//SuperStar.java
package chpt6.Ex6_2;
public class SuperStar {
   public static void main(String[] args) {
    Singer swift= new Singer("Taylor Swift",25,'f',"change");
    System.out.println(swift);
    swift.show();  //调用Star中的show()
    swift.sing();  //调用 Singer中的sing()
    swift.dance(); //调用Singer中实现的dance
    swift.perform(); //调用Singer中实现的perform
    swift.putonTvShow(); //调用Singer中实现的TvShow
    System.out.println("***************************************");
    MovieStar chan = new MovieStar("Jackie Chan",62,'m',"policeman story");
    System.out.println(chan);
    chan.show();     //调用Star中的show()
    chan.perform();  //调用MovieStar中实现的perform()
    chan.sing();     //调用MovieStar中实现的sing()
    chan.dance();    //调用MovieStar中实现的dance()
    chan.putonTvShow(); //调用MovieStar中实现的TvShow
   }
} 
