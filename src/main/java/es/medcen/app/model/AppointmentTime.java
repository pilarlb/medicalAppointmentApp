package es.medcen.app.model;

import java.util.ArrayList;
import java.util.List;

public enum AppointmentTime {
	/**
	 * 
	 */
	
	A9a("9:00"), A9b("9:15"),A9c("9:30"),A9d("9:45")
	,A10a("10:00"), A10b("10:15"),A10c("10:30"),A10d("10:45")
	,A11a("11:00"), A11b("11:15"),A11c("11:30"),A11d("11:45")
	,A12a("12:00"), A12b("12:15"),A12c("12:30"),A12d("12:45")
	,A13a("13:00"), A13b("13:15"),A13c("13:30"),A13d("13:45")
	,A14a("14:00"), A14b("14:15"),A14c("14:30"),A14d("14:45")
	,B15a("15:00"), B15b("15:15"),B15c("15:30"),B15d("15:45")
	,B16a("16:00"), B16b("16:15"),B16c("16:30"),B16d("16:45")
	,B17a("17:00"), B17b("17:15"),B17c("17:30"),B17d("17:45")
	,B18a("18:00"), B18b("18:15"),B18c("18:30"),B18d("18:45")
	,B19a("19:00"), B19b("19:15"),B19c("19:30"),B19d("19:45")
	,B20a("20:00"), B20b("20:15"),B20c("20:30"),B20d("20:45")
	;
	
	public final String hour;

    private AppointmentTime(String hour) {
		this.hour= hour;
	}
    
    //Metodo para buscar por el inicio del valor interior
    public static List<AppointmentTime> hoursStartWith (String hour) {
        List<AppointmentTime> lista = new ArrayList<>();
    	for (AppointmentTime a : values()) {
            if (a.hour.startsWith(hour)) {
            	lista.add(a);
               
            }
        }
    	
    	if(lista.size()!= 0) {
    		return lista;
    	}else {
    		return null;
    	}
        
    }
}
