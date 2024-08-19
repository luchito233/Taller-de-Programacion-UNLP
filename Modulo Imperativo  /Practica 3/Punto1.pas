{1. Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
con el número de socio 0 y el árbol debe quedar ordenado por número de socio.
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como
parámetro y que :

i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.

ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo
recursivo que retorne dicho socio.

iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.

iv. Aumente en 1 la edad de todos los socios.

v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a
un módulo recursivo que reciba el valor leído y retorne verdadero o falso.

vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a
un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.

vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha
cantidad.

viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del inciso.

vii. e invocar a un módulo recursivo que retorne la suma de las edades de los socios.

ix. Informe, a partir de dos valores que se leen, la cantidad de socios en el árbol cuyo
número de socio se encuentra entre los dos valores ingresados. Debe invocar a un módulo
recursivo que reciba los dos valores leídos y retorne dicha cantidad.

x. Informe los números de socio en orden creciente.

xi. Informe los números de socio pares en orden decreciente.}

program Punto1;
type

  str30 = string[30];
  socio = record
	numSocio:integer;
	nombre:str30;
	edad:integer;
  end;
  
  arbol = ^nodo;
  nodo = record
    dato:socio;
    hI:arbol;
    hD:arbol;
  end;

procedure agregar(var a:arbol;s:socio);
begin
	if(a = nil) then
	begin
	    new(a);
		a^.hI:= nil;
		a^.hD:= nil;
		a^.dato:= s;
	end
	else
	begin
		if(s.numSocio <= a^.dato.numSocio) then agregar(a^.hI,s)
		else
			agregar(a^.hD,s);
	end; 
end;

procedure leerSocio(var s:socio);
begin
	writeln('ingrese el numero de socio');
	readln(s.numSocio);
	if(s.numSocio <> 0)then
	begin
		writeln('ingrese el nombre');
		readln(s.nombre);
		writeln('ingrese la edad');
		readln(s.edad);
	end;
end;

procedure cargarArbol(var a:arbol);
var
	s:socio;
begin
	leerSocio(s);
	while (s.numSocio <> 0) do
	begin
		agregar(a,s);
		leerSocio(s);
	end;
end;

function maximo(a:arbol):integer;
begin
	if(a^.hD <> nil)then maximo:= maximo(a^.hD)
	else
		maximo:=a^.dato.numSocio;
end;

procedure buscarMinimo(var a:arbol;var s:socio);
begin
	if(a^.hI <> nil) then buscarMinimo(a^.hI,s)
	else
		s:=a^.dato;
end; 
 
procedure informarSocio(var s:socio);
begin
	writeln('numero de socio: ',s.numSocio);
	writeln('nombre del socio: ',s.nombre);
	writeln('edad del socio: ',s.edad);
end; 

function maximo2(a:arbol):integer;
begin
	if(a^.hD <> nil) then maximo2:= maximo2(a^.hD)
	else
		maximo2:= a^.dato.edad;
end;

procedure aumentar1Anio(a:arbol);
begin
	if(a <> nil)then
	begin
		aumentar1Anio(a^.hI);
		a^.dato.edad:= a^.dato.edad + 1;
		aumentar1Anio(a^.hD);
	end;
end;

function buscarSocio(a:arbol;x:integer):boolean;
begin
	if(a = nil) then buscarSocio:= false
	else 
		if (a^.dato.numSocio = x)then buscarSocio:= true
		else 
			if(x > a^.dato.numSocio) then buscarSocio:=buscarSocio(a^.hD,x)
			else
				 buscarSocio:=buscarSocio(a^.hI,x);
end;

procedure contar(a:arbol;var cant:integer);
begin
	if(a <> nil) then
	begin
		contar(a^.hI,cant);
		contar(a^.hD,cant);
		cant:=cant +1;
	end;
end;

function buscarNombre(a:arbol;nombre:str30):boolean;
begin
	if(a = nil) then buscarNombre:= false
	else
		if(nombre = a^.dato.nombre) then buscarNombre:=true
		else
			if(nombre > a^.dato.nombre) then buscarNombre(a^.hD,nombre)
			else
				buscarNombre(a^.hI,nombre);
end;

procedure sumaEdades(a:arbol;var sumaTotal:integer);
begin
	if(a <> nil) then
	begin
		sumaTotal:=sumaTotal + a^.dato.edad;
		sumaEdades(a^.hI,sumaTotal);
		sumaEdades(a^.hD,sumaTotal);
	end;
end;

procedure busquedaEntre2Num(a:arbol;var cant:integer;n1,n2:integer);
begin
	if(a <> nil)then
	begin
		if(a^.dato.numSocio >= n1) and (a^.dato.numSocio <= n2)then cant:=cant +1;
		if(a^.dato.numSocio > n1) then busquedaEntre2Num(a^.hI,cant,n1,n2);
		if(a^.dato.numSocio < n2) then busquedaEntre2Num(a^.hD,cant,n1,n2);
	end;
end;

procedure informarEnOrden(a: arbol);
begin
  if (a <> nil) then
  begin
    informarEnOrden(a^.hI);
    writeln(a^.dato.numSocio);
    informarEnOrden(a^.hD);  
  end;
end;

procedure informarEnOrdenPares(a: arbol);
begin
  if (a <> nil) then
  begin
    informarEnOrdenPares(a^.hI);
    if(a^.dato.numSocio mod 2 = 0)then writeln(a^.dato.numSocio);
    informarEnOrdenPares(a^.hD);  
  end;
end;


  
var
	ABB:arbol;
	maxCodigo,maxEdad,x:integer;
	min:socio;
	cantSocios:integer;
	esta,esta2:boolean;
	nombre:str30;
	sumaTotal:integer;
	num1,num2:integer;
	cantSociosEntre:integer;
begin
	cargarArbol(ABB);
	if(ABB <> nil) then 
	begin
	  maxCodigo:=maximo(ABB);
	  writeln('el codigo maximo es: ',maxCodigo);
	  buscarMinimo(ABB,min);
	  informarSocio(min);
	  maxEdad:=maximo2(ABB);
	  writeln('la edad maxima es: ',maxEdad);
	  aumentar1Anio(ABB);
	  writeln('ingrese un numero a buscar');
	  readln(x);
	  esta:=buscarSocio(ABB,x);
	  writeln('el numero se encuenta? ',esta);	  
	  contar(ABB,cantSocios);
	  writeln('la cantidad de socios es: ',cantSocios);
	  writeln('ingrese el nombre a buscar');
	  readln(nombre);
	  esta2:=buscarNombre(ABB,nombre);
	  writeln('el nombre se encuenta? ',esta2);
	  sumaEdades(ABB,sumaTotal);
	  writeln('el promedio de edad es: ',(sumaTotal/cantSocios));
	  cantSociosEntre:=0;
	  writeln('ingrese el primer numero');
	  readln(num1);
	  writeln('ingrese el segundo numero');
	  readln(num2);
	  busquedaEntre2Num(ABB,cantSociosEntre,num1,num2);
	  writeln('los socios entre: ',num1,'y',num2,'son: ',cantSociosEntre);
	  informarEnOrden(ABB);
	  writeln('--------------');
	  informarEnOrdenPares(ABB); 
	end;
end.
