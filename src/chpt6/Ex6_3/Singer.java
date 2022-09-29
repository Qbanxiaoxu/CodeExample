//Singer.java
package chpt6.Ex6_3;
public class Singer extends Star implements Actions{
	String famousSong;
	public Singer(String nm,int ag,char se,String fmssong) {		
		super(nm,ag,se);
		famousSong=fmssong;		
	}
	public void sing(){
		System.out.println("Singer: Sing a song!");
	}
	public void dance(){
		System.out.println("Singer: I Can Dance...!");
	}
	
	public void perform(){
		System.out.println("Singer: I CanPerform...!");
	}
	public String toString(){
		return (super.toString()+"famous song: "+famousSong);
	}	
}
