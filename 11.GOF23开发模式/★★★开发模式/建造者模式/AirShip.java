

/**
 * …–—ßÃ√≈∆”Ó÷Ê∑…¥¨
 */
public class AirShip {
	
	private OrbitalModule orbitalModule;  //πÏµ¿≤’
	private Engine engine; //∑¢∂Øª˙
	private EscapeTower escapeTower;  //Ã”“›À˛
	
	
	public void launch(){
		System.out.println("∑¢…‰£°");
	}
	
	
	
	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}
	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public EscapeTower getEscapeTower() {
		return escapeTower;
	}
	public void setEscapeTower(EscapeTower escapeTower) {
		this.escapeTower = escapeTower;
	}
	
	
	
}

class OrbitalModule{
	private String name;

	public OrbitalModule(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

class Engine {
	private String name;

	public Engine(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class EscapeTower{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EscapeTower(String name) {
		super();
		this.name = name;
	}
	
}


