package modelo;

public class Sensor implements Comparable<Sensor>{
	private int ID;
	private String canton;
	private String distrito;
	private String barrio;
	private int color;
	private int cm3Base;
	private int cm3Actual;
	
	public Sensor(int pID, String pCanton){
		ID = pID;
		canton = pCanton;
		distrito = "";
		barrio = "";
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String pDistrito) {
		this.distrito = pDistrito;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String pBarrio) {
		this.barrio = pBarrio;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int pColor) {
		this.color = pColor;
	}

	public int getCm3Base() {
		return cm3Base;
	}

	public void setCm3Base(int pCm3Base) {
		this.cm3Base = pCm3Base;
	}

	public int getCm3Actual() {
		return cm3Actual;
	}

	public void setCm3Actual(int pCm3Actual) {
		this.cm3Actual = pCm3Actual;
	}

	public int getID() {
		return ID;
	}

	public String getCanton() {
		return canton;
	}
	
	public String getPath() {
		return String.format("%1$s/%2$s/%3$s", this.getCanton(), getDistrito(), getBarrio());
	}

	@Override
	public int compareTo(Sensor pSensor) {
		// TODO Auto-generated method stub
		int result = this.canton.compareTo(pSensor.getCanton());
		if(distrito == "" && barrio == "" || result != 0) {
			return result;
		}else {
			if(distrito == "" ){
				result = this.barrio.compareTo(pSensor.getBarrio());
				return result;
			}else {
				result = this.distrito.compareTo(pSensor.getDistrito());
				if(barrio == "") {
					return result;
				}
				else {
					result = this.barrio.compareTo(pSensor.getBarrio());
					return result;
				}
			}
		}
	}
	
}
