//Hitgreenpig.java
package chpt6.Ex6_5;
abstract class AngryBird { 
  abstract void chirp();
  abstract void shoot();
}

class BlueBird extends AngryBird {
  void chirp() { 
    System.out.println("Blue bird chirp..."); 
  }
  void shoot() { 
    System.out.println("spawn 3 children birds..."); 
  }
}

class WhiteBird extends AngryBird {
	void chirp() { 
		    System.out.println("White Bird chirp"); 
	}
  void shoot() { 
    System.out.println("bomb bomb..."); 
  }
}
class RedBird extends AngryBird{
  void chirp() { 
    System.out.println("Red Bird chirp"); 
  }
  void shoot() { 
    System.out.println("shoot shoot...");
  }
}
public class Hitgreenpig {	  
	  public static void main(String[] args) {
	    AngryBird[] s = new AngryBird[3];
	    s[0] = new BlueBird();
	    s[1] = new WhiteBird();
	    s[2] = new RedBird();
	    
	    for(int i = 0; i < s.length; i++){
	    	s[i].chirp();
	    	s[i].shoot();
	    }
	  }
	} 
/*另一种实现方式
/*public class Hitgreenpig {
  public static void show(AngryBird i) {
    i.chirp();
    i.shoot();
   }
  public static void main(String[] args) {
    AngryBird[] s = new AngryBird[3];
    s[0] = new BlueBird();
    s[1] = new WhiteBird();
    s[2] = new RedBird();
    
    for(int i = 0; i < s.length; i++){
      show(s[i]);
    }
  }
} */


