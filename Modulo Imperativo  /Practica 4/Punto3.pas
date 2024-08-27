{

3. Una facultad nos ha encargado procesar la información de sus alumnos de la carrera XXX.
Esta carrera tiene 30 materias. Implementar un programa con:

a. Un módulo que lea la información de los finales rendidos por los alumnos y los
almacene en dos estructuras de datos.

i. Una estructura que para cada alumno se almacenen sólo código y nota de las
materias aprobadas (4 a 10). De cada final rendido se lee el código del alumno, el
código de materia y la nota (valor entre 1 y 10). La lectura de los finales finaliza con
nota -1. La estructura debe ser eficiente para buscar por código de alumno.

ii. Otra estructura que almacene para cada materia, su código y todos los finales
rendidos en esa materia (código de alumno y nota).

b. Un módulo que reciba la estructura generada en i. y un código de alumno y retorne los
códigos y promedios de los alumnos cuyos códigos sean mayor al ingresado.

c. Un módulo que reciba la estructura generada en i., dos códigos de alumnos y un valor
entero, y retorne la cantidad de alumnos con cantidad de finales aprobados igual al
valor ingresado para aquellos alumnos cuyos códigos están comprendidos entre los dos
códigos de alumnos ingresados.

}


program punto3;
type
	rango30 = 1..30;
	
	infoAlumno = record
		cod: integer;
		nota: integer;
	end;
	
	finales = record
		alumno: infoAlumno;
		codigoMate:rango30;
	end;
	
	vnotas = array[rango30] of integer; 
	
	alumno = record
		codigo:integer;
		materiasA:vnotas;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato: infoAlumno;
		sig: lista;
	end;
	
	vfinales = array[rango30] of lista;	
	
	arbol = ^nodo;
	nodo = record
		dato:alumno;
		hi,hd:arbol;
	end;

procedure leerFinal(var f:finales);
begin
	writeln('ingrese la nota de 0--10');
	readln(f.Alumno.nota);
	if(f.Alumno.nota <> -1)then
	begin
		writeln('ingrese el codigo de alumno');
		readln(f.Alumno.cod);
		writeln('ingrese el codigo de la materia');
		readln(f.codigoMate);
	end;
end;

procedure inicializarVector(var vector:vnotas);
var
	i:integer;
begin
	for i:=1 to 30 do vector[i]:=0;
end;
	
procedure agregar(var a:arbol; f:finales);
begin
	if(a = nil) then
	begin
		new(a);
		a^.dato.codigo:=f.alumno.cod;
		inicializarVector(a^.dato.materiasA);
		// inicializar vector
		a^.dato.materiasA[f.codigoMate]:= f.Alumno.nota;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codigo = f.alumno.cod )then a^.dato.materiasA[f.codigoMate]:= f.alumno.nota
		else
			if(a^.dato.codigo < f.alumno.cod)then agregar(a^.hd,f)
			else
				agregar(a^.hi,f);			
end;
	
procedure agregarAdelante(var l:lista; infoA:infoAlumno);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:= infoA;
	aux^.sig:= l;
	l:= aux;
end;	
	
procedure cargarArbolyLista(var a:arbol;var l:lista);
var
	f:finales;
begin
	leerFinal(f);
	while(f.alumno.nota <> -1)do
	begin
		agregarAdelante(l,f.alumno);
		if(f.alumno.nota >= 4)and(f.alumno.nota <= 10)then agregar(a,f);
		leerFinal(f);
	end;
end;

function calcularProm(v:vnotas):real;
var
	cant,i,sumaTotal:integer;
begin
	cant:=0;
	sumaTotal:=0;
	for i:= 1 to 30 do
	begin
		if(v[i] <> 0)then 
		begin
			cant:=cant+1;
			sumaTotal:=sumatotal + v[i];
		end;
	end;
	calcularProm:=(sumaTotal/cant);
end;

procedure recorrerArbol(a:arbol;cod:integer);
var
	promedio:real;
begin
	if(a <> nil)then
	begin
		recorrerArbol(a^.hi,cod);
		if(a^.dato.codigo > cod)then 
		begin
			writeln('codigo: ', cod);
			promedio:=calcularProm(a^.dato.materiasA);
			writeln('el promedio: ',promedio);
		end;
		recorrerArbol(a^.hd,cod);
	end;
end;

function cantidadFinales(v:vnotas):integer;
var
	cant,i:integer;
begin
	cant:=0;
	for i:= 1 to 30 do
	begin
		if(v[i] <> 0)then cant:=cant+1;
	end;
	cantidadFinales:=cant;
end;

function recorrerArbolEntre2Valores(a:arbol; c1,c2:integer; valor:integer):integer;
begin
	 if a = nil then
        recorrerArbolEntre2Valores := 0
    else
    begin
        if (a^.dato.codigo >= c1) and (a^.dato.codigo <= c2) then
        begin
            if cantidadFinales(a^.dato.materiasA) = valor then
                recorrerArbolEntre2Valores := 1 + recorrerArbolEntre2Valores(a^.hi, c1, c2, valor) + recorrerArbolEntre2Valores(a^.hd, c1, c2, valor)
            else
                recorrerArbolEntre2Valores := recorrerArbolEntre2Valores(a^.hi, c1, c2, valor) + recorrerArbolEntre2Valores(a^.hd, c1, c2, valor);
        end
        else if a^.dato.codigo < c1 then
            recorrerArbolEntre2Valores := recorrerArbolEntre2Valores(a^.hd, c1, c2, valor)
        else
            recorrerArbolEntre2Valores := recorrerArbolEntre2Valores(a^.hi, c1, c2, valor);
    end;
end;


var
	ABB:arbol;
	Lis:lista;
	codigo:integer;
	cod1,cod2,valor:integer;
	cant:integer;
begin
	ABB:=nil;
	Lis:=nil;
	cargarArbolyLista(ABB,Lis);
	writeln('ingrese el codigo a buscar: ');
	readln(codigo);
	recorrerArbol(ABB,codigo);
	writeln('ingrese el lado izquierdo a buscar: ');
	readln(cod1);
	writeln('ingrese el lado derecho a buscar: ');
	readln(cod2);
	writeln('ingrese el valor');
	readln(valor);
	cant:=recorrerArbolEntre2Valores(ABB,cod1,cod2,valor);
	writeln('la cantidad de alumnos con la cantidad de examenes aprobados igual a ',valor,' es: ',cant);
end.
