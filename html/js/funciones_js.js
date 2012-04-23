function noEntry(field) {
	mt=field.value;
	if (mt.length<1) {
		alert("El campo debe rellenarse");
		field.focus();
		return true;
	}else { return false; }
}

function fechaOk(field){  
     var Fecha= new String(field.value)   // Crea un string
     // Cadena Año  
     var Ano= new String(Fecha.substring(Fecha.lastIndexOf("/")+1,Fecha.length));
     // Cadena Mes  
     var Mes= new String(Fecha.substring(Fecha.indexOf("/")+1,Fecha.lastIndexOf("/")));
     // Cadena Día  
     var Dia= new String(Fecha.substring(0,Fecha.indexOf("/")));
   
     // Valido el año
     if (Ano=="" || isNaN(Ano) || Ano.length<4 || parseFloat(Ano)<1900){  
         alert('Fecha incorrecta');
         field.focus();
		 field.select();
		 return false;
     }  
     // Valido el Mes  
     if (Mes=="" || isNaN(Mes) || parseFloat(Mes)<1 || parseFloat(Mes)>12){  
         alert('Fecha incorrecta');
         field.focus();
		 field.select();
		 return false;
     }  
     // Valido el Dia  
     if (Dia=="" || isNaN(Dia) || parseInt(Dia, 10)<1 || parseInt(Dia, 10)>31){  
         alert('Fecha incorrecta');
         field.focus();
		 field.select();
		 return false;
     }  
     if (Mes==4 || Mes==6 || Mes==9 || Mes==11 || Mes==2) {  
         if ((Mes==2 && Dia > 28) || Dia>30) {  
             alert('Fecha incorrecta');
    	     field.focus();
			 field.select();
             return false;
         }  
     }
	 return true;
}

//comprueba si la fecha en field1 es menor que la fecha en field2
function compararFechas(field1,field2){
		var fecha1= new String(field1.value);
		var fecha2= new String(field2.value);
     	// Cadena Año  
     	var ano1= new String(fecha1.substring(fecha1.lastIndexOf("/")+1,fecha1.length));
     	var ano2= new String(fecha2.substring(fecha2.lastIndexOf("/")+1,fecha2.length));
     	// Cadena Mes  
     	var mes1= new String(fecha1.substring(fecha1.indexOf("/")+1,fecha1.lastIndexOf("/")));
     	var mes2= new String(fecha2.substring(fecha2.indexOf("/")+1,fecha2.lastIndexOf("/")));
     	// Cadena Día  
     	var dia1= new String(fecha1.substring(0,fecha1.indexOf("/")));
     	var dia2= new String(fecha2.substring(0,fecha2.indexOf("/")));
     	//Creamos las variables Date
		var ini = new Date();
		var fin = new Date();
		ini.setFullYear(ano1,mes1,dia1);
		fin.setFullYear(ano2,mes2,dia2);
		if(ini>fin){
			alert("La fecha de inicio ha de ser anterior a la fecha de fin");
			field1.focus();
			field1.select();
			return false;	
		}
	return true;
}

function validarFechas(){
	if(noEntry(document.frmListado.fechaIni)){return false;}
	if(noEntry(document.frmListado.fechaFin)){return false;}
	if(!fechaOk(document.frmListado.fechaIni)){return false;}
	if(!fechaOk(document.frmListado.fechaFin)){return false;}
	if(!compararFechas(document.frmListado.fechaIni,document.frmListado.fechaFin)){return false;}
	return true;
}

function validarAnulaciones(){
	for(var i=0;i<document.frmAnular.elements.length;i++){
		if(document.frmAnular.elements[i].type=="checkbox"){
			if(document.frmAnular.elements[i].checked==true){
				return true;
			}
		}
	}
	alert("Debes seleccionar alguna reserva");
	return false;
}