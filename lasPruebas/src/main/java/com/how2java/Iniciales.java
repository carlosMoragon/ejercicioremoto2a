package com.how2java;

public class Iniciales{
	public static void devolverIniciales(String s1){
		if(s1.contains(",")){
			String[] chars = s1.split("");
			String name1 = chars[0];

			if(s1.indexOf(",") > s1.indexOf(" ")){
				//segundo nombre
				String name2 = chars[s1.indexOf(" ")+1];
			}else{
				//No hay segundo nombre
				String apellidos = s1.substring(s1.indexOf(",")+1,chars.length);
				String[] partes = apellidos.split(" ");
				for(int i = 0; i < partes.length; i++){
					if(!partes[i].equals(" ")){
						String apellido = (partes[i].split(""))[0];
					}
				}
			}
		}else System.out.println("Un nombre x favor");

	}
}
