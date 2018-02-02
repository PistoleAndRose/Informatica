/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.model;

import java.util.Date;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Marco
 */
public class Auto {

    public float longitudine, latitudine;
    public String name;
    public int[] data=new int[3];
    public int[] ora=new int[3];
    public int[] defaultC = new int[2];
	
	private StringProperty nameProperty;
	private FloatProperty longProperty, latProperty;
	private IntegerProperty[] dataProperty, oraProperty, defaultCProperty;

    public Auto(String name, float longitudine, float latitudine, int[] data, int[] ora) {
        this.name = name;
        this.longitudine=longitudine;
        this.latitudine=latitudine;
        this.data=data;
        this.ora=ora;
		
		this.nameProperty = new SimpleStringProperty(name);
		this.longProperty = new SimpleFloatProperty(longitudine);
		this.latProperty = new SimpleFloatProperty(latitudine);
		this.dataProperty = new SimpleIntegerProperty[3];
		this.oraProperty = new SimpleIntegerProperty[3];
		
		for(int i = 0; i<data.length; i++){
			this.dataProperty[i] = new SimpleIntegerProperty(data[i]);
			this.oraProperty[i] = new SimpleIntegerProperty(ora[i]);
		}
		
    }

    public Auto(String name) {
        this.name = name;
    }

    public float generaLatitudine() {
		latitudine=(float) (45.05 + Math.random() * (45.65 - 45.05));
        return latitudine;
    }
    
    public float generaLongitudine(){
        longitudine =(float) (11.88 + Math.random() * (12.38 - 11.88));
        return latitudine;
    }
    

    public int[] generaData() {
        Date lol = new Date();
        int giorno = lol.getDay();
        int mese = lol.getMonth();
        int anno = lol.getYear() + 1900;
        data[0] =giorno;
        data[1] =mese;
        data[2] =anno;
        return data;
    }
    
    public int[] generaOra() {
        Date lol = new Date();
        int secondo = lol.getSeconds();
        int minuto = lol.getMinutes();
        int hour = lol.getHours();
        ora[0] =secondo;
        ora[1] =minuto;
        ora[2] =hour;
        return ora;
    }

    public void setCoordinates(float latitudine, float longitudine) {
        this.latitudine=latitudine;
        this.longitudine=longitudine;
    }

    public void setData(int[] data) {
        this.data = data;
    }
	
	public StringProperty nameProperty(){
		return nameProperty;
	}
	
	public FloatProperty latProperty(){
		return latProperty;
	}	

	public FloatProperty longProperty(){
		return longProperty;
	}	

	public IntegerProperty[] dataProperty(){
		return dataProperty;
	}		

	public IntegerProperty[] oraProperty(){
		return oraProperty;
	}	
    /*
    public byte[] toByte() {
        this.name = name.concat("~");
        byte[] array1 = this.name.getBytes();
        byte[] array2 = new byte[2];
        this.data = "~".concat(data.toString().concat("~"));
        byte[] array3 = this.data.getBytes();
        array2[0] = (byte) latitudine;
        array2[1] = (byte) longitudine;
        byte[] array1and2 = new byte[array1.length + array2.length + array3.length];
        System.arraycopy(array1, 0, array1and2, 0, array1.length);
        System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
        System.arraycopy(array3, 0, array1and2, array2.length, array3.length);
        return array1and2;
    }

    public static Auto toAuto(byte[] bytes) {
        String[] separated = bytes.toString().split("~");
        Auto mobile = new Auto(separated[0]);
        mobile.latitudine = Integer.valueOf(separated[0]);
        mobile.longitudine = Integer.valueOf(separated[1]);
        double[] coordinatesTemp = new double[2];
        coordinatesTemp[0] = mobile.latitudine;
        coordinatesTemp[1] = mobile.longitudine;
        mobile.setCoordinates(mobile.latitudine, mobile.longitudine);
        mobile.setData(separated[2]);
        return mobile;
    }
    */

    @Override
    public String toString() {
        return "name:" + this.name + " " + "latitudine:" + latitudine + "longitudine:" + longitudine + " date:" + data;
    }
}
