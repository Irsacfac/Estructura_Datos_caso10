package modelo;

import java.util.Random;

import otros.IConstants;

public class Sensor implements Comparable<Sensor>, IConstants{
	private String ID;
	private String canton;
	private String distrito;
	private String barrio;
	private int color;
	private final int cm3Base;
	private int cm3Actual;
	
	public Sensor(String pID, String pCanton, int pCm3Base){
		ID = pID;
		canton = pCanton;
		distrito = "";
		barrio = "";
		cm3Base = pCm3Base;
		cm3Actual = pCm3Base;
		color = 0;
	}
	/*public Sensor(String pID, String pCanton, String pDistrito ){
		ID = pID;
		canton = pCanton;
		distrito = pDistrito;
		barrio = "";
	}
	public Sensor(String pID, String pCanton, String pDistrito, String pBarrio ){
		ID = pID;
		canton = pCanton;
		distrito = pDistrito;
		barrio = pBarrio;
	}*/

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

	/*public void setCm3Base(int pCm3Base) {
		this.cm3Base += pCm3Base;
	}*/

	public int getCm3Actual() {
		return cm3Actual;
	}

	public void setCm3Actual(int pCm3Actual) {
		this.cm3Actual += pCm3Actual;
	}

	public String getID() {
		return ID;
	}

	public String getCanton() {
		return canton;
	}

	public String getPath() {
		return String.format("%1$s/%2$s/%3$s", getCanton(), getDistrito(), getBarrio());
	}
	
	public void actualizar() {
		Random random = new Random();
		int porcentaje = (random.nextInt(21))-8;
		int variacion = (this.getCm3Actual()*porcentaje)/MAX_PERCENTAGE;
		setCm3Actual(variacion);

	}

	@Override
	public String toString() {
		String string = ID+", ";
		if (!this.canton.equals("")){
			string += canton;
		}
		if (!this.distrito.equals("")){
			string += "/"+distrito;
		}
		if (!this.barrio.equals("")){
			string += "/"+barrio;
		}

		string += "|"+cm3Actual+"|";

		if (color == 1){
			string += " (Alerta)";
		}

		return string;
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
