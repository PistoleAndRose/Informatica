/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivelatore;

import java.util.Arrays;
import java.util.Random;
import java.util.Date;
/**
 *
 * @author stoyan.botusharov
 */
public class Auto {
	public int[] coordinates;
	private int longitudine;
	private int latitudine;
	public String name;
	public int[] defaultC = new int[2];
	public String data;

	public Auto(String name, int[] coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}
	public Auto(String name) {
		this.name = name;
		defaultC[0] = 0;
		defaultC[1] = 0;
		this.coordinates = defaultC;
	}
	Auto car=new Auto("default");
	public void updateCoordinates() {
		int[] coordinatesTemp = new int[2];
		Random random = new Random();
		int d = random.nextInt() * 100;
		coordinates[0] = d;
		d = random.nextInt() * 100;
		coordinates[1] = d;
		this.coordinates = coordinatesTemp;
		this.car.updatedate();
	}
	private void updatedate(){
		Date lol=new Date();
		int giorno=lol.getDay();
		int mese=lol.getMonth();
		int anno=lol.getYear()+1900;
		int secondo=lol.getSeconds();
		int minuto=lol.getMinutes();
		int ora=lol.getHours();
		data=""+giorno+mese+anno+ora+minuto+secondo;
	}

	public void setCoordinates(int[] coordinates) {
		this.coordinates = coordinates;
	}

	public void setData(String data) {
		this.data = data;
	}
	public byte[] toByte() {
		this.name=name.concat("~");
		byte[] array1 = this.name.getBytes();
		byte[] array2 = new byte[2];
		this.data="~".concat(data.concat("~"));
		byte[] array3 = this.data.getBytes();
		array2[0] = (byte) this.coordinates[0];
		array2[1] = (byte) this.coordinates[1];
		byte[] array1and2 = new byte[array1.length + array2.length+array3.length];
		System.arraycopy(array1, 0, array1and2, 0, array1.length);
		System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
		System.arraycopy(array3, 0, array1and2, array2.length, array3.length);
		return array1and2;
	}
	public static Auto toAuto(byte[] bytes){
		String[] separated=bytes.toString().split("~");
		Auto mobile=new Auto(separated[0]);
		mobile.latitudine=Integer.valueOf(separated[0]);
		mobile.longitudine=Integer.valueOf(separated[1]);
		int[] coordinatesTemp=new int[2];
		coordinatesTemp[0]=mobile.latitudine;
		coordinatesTemp[1]=mobile.longitudine;
		mobile.setCoordinates(coordinatesTemp);
		mobile.setData(separated[2]);
		return mobile;
	}
	@Override
	public String toString(){
		return "name:"+this.name+" "+Arrays.toString(coordinates)+" date:"+data;
	}
}
