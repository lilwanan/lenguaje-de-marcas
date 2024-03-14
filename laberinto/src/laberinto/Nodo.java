package laberinto;

public class Nodo {
	public int cordX;
	public int cordY;
	public int costeG;
	public Nodo padre;

	public Nodo(int cordX, int cordY, Nodo padre){
		this.cordX = cordX;
		this.cordY = cordY;
		this.padre = padre;
	}


	public boolean mismaPos(Nodo n)
	{
		return (n.cordX == this.cordX && n.cordY == this.cordY);
	}
}
