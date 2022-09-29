//Singer.java
package chpt6.Ex6_2;
public class Singer extends Star implements TvShow,CanPerform{
	String famousSong;
	public Singer(String nm,int ag,char se,String fmssong) {		
		super(nm,ag,se);
		famousSong=fmssong;		
	}
	void sing(){
		System.out.println("Singer: Sing a song!");
	}
	public void dance(){
		System.out.println("Singer: I Can Dance...!");
	}
	public void putonTvShow(){
		System.out.println("Singer: I am on Tv Show...!");
	}
	public void perform(){
		System.out.println("Singer: I CanPerform...!");
	}
	public String toString(){
		return (super.toString()+"famous song: "+famousSong);
	}	
}
