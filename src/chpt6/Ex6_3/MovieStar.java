//MovieStar.java
package chpt6.Ex6_3;
class MovieStar extends Star implements Actions{
	String famousMovie;
	
	public MovieStar(String nm,int ag,char se,String fmsmv) {		
		super(nm,ag,se);
		famousMovie=fmsmv;		
	}
    public void dance(){System.out.println("MovieStar:I Can Dance...");}
    public void perform(){System.out.println("MovieStar: I Can perform...");}
    public void sing(){System.out.println("MovieStar:I Can Sing...");}
    public String toString(){
		return (super.toString()+"famous movie: "+famousMovie);
	}
}