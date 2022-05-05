package com.moragon.inicialesij;

public class DevolverIniciales {
    public static String devolverIniciales(String s1) {
        if (s1.contains(",")) {
            String mensaje = "";
            String names = s1.substring(0, s1.indexOf(","));
            String apellidos = s1.substring(s1.indexOf(",") + 1, s1.split("").length);

            if (!names.replaceAll(" ", "").equals("")) {
                String[] nombre = names.split(" ");
                for(int i = 0; i < nombre.length; i++) {
                    if(!nombre[i].equals("")) {
                        if(mensaje.equals("")){
                            mensaje += nombre[i].split("")[0];
                        }else {
                            mensaje += "." + nombre[i].split("")[0];
                        }
                    }
                }
            } else return "";
            if (!apellidos.replaceAll(" ", "").equals("")) {
                String[] apellido = apellidos.split(" ");
                for(int i = 0; i < apellido.length; i++) {
                    if(!apellido[i].equals("")) {
                        mensaje += "." + apellido[i].split("")[0];
                    }
                }
            }else return "";

            return mensaje.toUpperCase();
        } else{
            return "";
        }
    }
}
