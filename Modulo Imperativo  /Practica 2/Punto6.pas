{6.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).
Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.}

program Punto6;

procedure ArmarCadena(var cadena:string; n:integer);
begin
	if(n <> 0) then
	begin
	  if(n mod 2)= 0 then
		cadena:= '0' + cadena
	  else
	    cadena:= '1' + cadena;
	  ArmarCadena(cadena,n div 2);
	end;
end;


var
  n:integer;
  cadena:string;
begin
  cadena:= ' ';
  writeln('ingrese un numero');
  read(n);
  ArmarCadena(cadena,n);
  writeln('su representacion es: ',cadena);
end.
