//SuperStar.java
package chpt6.Ex6_2;
public class SuperStar {
   public static void main(String[] args) {
    Singer swift= new Singer("Taylor Swift",25,'f',"change");
    System.out.println(swift);
    swift.show();  //����Star�е�show()
    swift.sing();  //���� Singer�е�sing()
    swift.dance(); //����Singer��ʵ�ֵ�dance
    swift.perform(); //����Singer��ʵ�ֵ�perform
    swift.putonTvShow(); //����Singer��ʵ�ֵ�TvShow
    System.out.println("***************************************");
    MovieStar chan = new MovieStar("Jackie Chan",62,'m',"policeman story");
    System.out.println(chan);
    chan.show();     //����Star�е�show()
    chan.perform();  //����MovieStar��ʵ�ֵ�perform()
    chan.sing();     //����MovieStar��ʵ�ֵ�sing()
    chan.dance();    //����MovieStar��ʵ�ֵ�dance()
    chan.putonTvShow(); //����MovieStar��ʵ�ֵ�TvShow
   }
} 
