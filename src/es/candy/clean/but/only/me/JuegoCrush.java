package es.candy.clean.but.only.me;

public class JuegoCrush {
	private int size;
	Color black = new Color(0);
	Color red = new Color(1);
	Color green = new Color(2);
	Color yellow = new Color(3);
	Color blue = new Color(4);
	Color purple = new Color(5);
	Color cyan = new Color(6);
	Color white = new Color(7);
	
	public JuegoCrush() {
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getSize() {
		return this.size;
	}
	//method that tests the Color class functionality
	public void colorTest() {
		Tablero tablero = new Tablero();
		Color[][] tableroo1 = new Color[tablero.getSize()][tablero.getSize()];
		if(tablero.getSize()>0) {
			tableroo1[0][0] = red;
			if (getSize()>1) {
				tableroo1[0][1] = green;
				if (getSize()>2) {
					tableroo1[0][2] = yellow;
					if (getSize()>3) {
						tableroo1[0][3] = blue;
						if (getSize()>4) {
							tableroo1[0][4] = purple;
							if (getSize()>5) {
								tableroo1[0][5] = cyan;
								if (getSize()>6) {
									tableroo1[0][6] = white;
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println("Got size: "+getSize());
		for (int i=0; i<(getSize()); i++) {
			if (getSize()<=6) {		//if getsize() is greater than 6, it throws null
			System.out.println(tableroo1[0][i]);
			}
		}
	}

}
