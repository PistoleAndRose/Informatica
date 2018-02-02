/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserverudp;

import java.util.Arrays;
import java.util.Random;
import java.util.Date;

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

    public Auto(String name, float longitudine, float latitudine, int[] data, int[] ora) {
        this.name = name;
        this.longitudine=longitudine;
        this.latitudine=latitudine;
        this.data=data;
        this.ora=ora;
    }

    public Auto(String name) {
        this.name = name;
    }
	
	public Auto(){
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
	public byte[] toByte(){
		String id=this.name.concat("~");
		String lat=String.valueOf(latitudine).concat("~");
		String lon=String.valueOf(longitudine).concat("~");
		String day=String.valueOf(data[0]).concat("~");
		String month=String.valueOf(data[1]).concat("~");
		String year=String.valueOf(data[2]).concat("~");
		String second=String.valueOf(ora[0]).concat("~");
		String minute=String.valueOf(ora[1]).concat("~");
		String hours=String.valueOf(ora[2]).concat("~");
		String out=""+id+lat+lon+day+month+year+hours+minute+second;
		return out.getBytes();
	}
	public Auto toAuto(byte[] dati){
		Auto out=new Auto();
		String d=Arrays.toString(dati);
		String[] s=d.split("~");
		out.name=s[0];
		out.latitudine=Float.parseFloat(s[1]);
		out.longitudine=Float.parseFloat(s[2]);
		out.data[0]=Integer.parseInt(s[3]);
		out.data[1]=Integer.parseInt(s[4]);
		out.data[2]=Integer.parseInt(s[5]);
		out.ora[0]=Integer.parseInt(s[6]);
		out.ora[1]=Integer.parseInt(s[7]);
		out.ora[2]=Integer.parseInt(s[8]);
		return out;
	}
}
