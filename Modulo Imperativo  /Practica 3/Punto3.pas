{3. Implementar un programa que contenga:

a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
de las materias finaliza con el código de materia -1.

b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.

c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.

d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.

e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.

e. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del
alumno con mayor promedio.

f. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}

program punto3;
type
	
	
	
	finales = record
		codigo:integer;
		nota:integer;
	end;
	
	lista = ^nodo;
	nodo = record
		dato: finales;
		sig:lista;
	end;
	
	alumno = record
		legajo:integer;
		DNI:integer;
		ingreso:integer;
		notas:lista;
	end;

	arbol = ^nodoArbol;
	nodoArbol = record
		dato:alumno;
		hi:arbol;
		hd:arbol;
	end;

procedure leerNotas(var n:finales);
var
	i:integer;
begin
	i:=random(12) - 1;
	n.codigo:= i;
	writeln('el codigo de la materia es: ',i);
	if(n.codigo <> -1)then
	begin
		i:= random(11);
		n.nota:= i;
		writeln('la nota es: ',i);
	end;
end;

procedure agregarAdelante(var l:lista;n:finales);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:= n;
	aux^.sig:= l;
	l:= aux;
end;

procedure leerAlumno(var a:alumno);
var
	n:finales;
begin
	writeln('ingrese el legajo');
	readln(a.legajo);
	if(a.legajo <> 0) then
	begin
		writeln('ingrese el DNI');
		readln(a.DNI);
		writeln('ingrese el anio de ingreso');
		readln(a.ingreso);
		a.notas:=nil;
		leerNotas(n);
		while(n.codigo <> -1)do
		begin
			agregarAdelante(a.notas,n);
			leerNotas(n);
		end;
	end;
end;

procedure agregar(var a:arbol;alu:alumno);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:=alu;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.legajo <= alu.legajo)then agregar(a^.hd,alu)
		else
			agregar(a^.hi,alu);
end;

procedure cargarArbol(var a:arbol);
var
	alu:alumno;
begin
	leerAlumno(alu);
	while(alu.legajo <> 0)do
	begin
		agregar(a,alu);
		leerAlumno(alu);
	end;
end;

procedure recorrerArbol(a:arbol;legajo:integer);
begin
	if(a <> nil) then
	begin
		recorrerArbol(a^.hi,legajo);
		if(a^.dato.legajo < legajo) then 
		begin
			writeln('dni: ',a^.dato.DNI);
			writeln('ingreso: ',a^.dato.ingreso);
		end;
		recorrerArbol(a^.hd,legajo);
	end;
end;

function calcularMaximoLegajo(a:arbol):integer;
begin
	if(a^.hd <> nil)then calcularMaximoLegajo:=calcularMaximoLegajo(a^.hd)
	else
		calcularMaximoLegajo:=a^.dato.legajo;
end;

function calcularMaximoDni(a:arbol):integer;
begin
	if(a^.hd <> nil)then calcularMaximoDni:=calcularMaximoDni(a^.hd)
	else
		calcularMaximoDni:=a^.dato.DNI;
end;

procedure calcularLegImpares(a:arbol;var cant:integer);
begin
	if(a <> nil)then
	begin
		calcularLegImpares(a^.hi,cant);
		if(a^.dato.legajo mod 2 <> 0) then cant:=cant + 1;
		calcularLegImpares(a^.hd,cant);
	end;
end;

function calcularProm(l:lista):real;
var
	suma:real;
	cantAlum:integer;
begin
	suma:=0;
	cantAlum:=0;
	while(l <> nil)do
	begin
		suma:= suma + l^.dato.nota;
		cantAlum:= cantAlum + 1;
		l:=l^.sig;
	end;
	calcularProm:=(suma/cantAlum);
end;

procedure maximoPromedio(a:arbol; var promedio:real; var legajo:integer );
var
	x:real;
begin
	if(a <> nil)then 
	begin
		maximoPromedio(a^.hi,promedio,legajo);
		x:= calcularProm(a^.dato.notas);
		if(promedio > x) then
		begin
			promedio:=x;
			legajo:=a^.dato.legajo;
		end;
		maximoPromedio(a^.hd,promedio,legajo);
	end;
end;

procedure calcularPromedios(a:arbol; num:real);
var
	x:real;
begin
	if(a <> nil)then 
	begin
		calcularPromedios(a^.hi,num);
		x:= calcularProm(a^.dato.notas);
		if(num > x) then
		begin
			writeln('legajo',a^.dato.legajo);
			writeln('promedio',x);
		end;
		calcularPromedios(a^.hd,num);
	end;
end;


var
	ABB:arbol;
	x,num:integer;
	maxLeg,maxDNI,cantidad:integer;
	legajo:integer;
	prom:real;
begin
	randomize;
	cargarArbol(ABB);
	if(ABB <> nil)then
	begin
		writeln('ingrese el legajo a eleccion');
		readln(x);
		recorrerArbol(ABB,x);
		maxLeg:=calcularMaximoLegajo(ABB);
		writeln('el legajo maximo es: ',maxLeg);
		maxDNI:=calcularMaximoDni(ABB);
		writeln('el dni maximo es: ',maxDNI);
		cantidad:=0;
		calcularLegImpares(ABB,cantidad);
		writeln('la cantidad de legajos impares es: ',cantidad);
		prom:=-1;
		legajo:=0;
		maximoPromedio(ABB,prom,legajo);
		writeln('el legajo con mejor promedio es: ',legajo);
		writeln('ingrese un numero');
		readln(num);
		calcularPromedios(ABB,num);
	end;
end.
