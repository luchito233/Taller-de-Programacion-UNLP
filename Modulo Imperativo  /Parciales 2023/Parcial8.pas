program Parcial8;
type
	
	sub_meses = 1..12;
	alquiler2 = record
		dni:integer;
		mes:sub_meses;
		anio:integer;
	end;
	
	alquiler = record
		patente:integer;
		info:alquiler2;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:alquiler2;
		sig:lista;
	end;
	
	datoArbol = record
		patente:integer;
		l:lista;
	end;
	
	arbol = ^nodo2;
	nodo2 = record
		dato:datoArbol;
		hi,hd:arbol;
	end;

procedure leerAlquiler(var a:alquiler);
begin
	a.patente:= random(70);
	if(a.patente <> 0)then
	begin
		writeln('patente: ',a.patente);
		a.info.dni:= random(5000) + 1;
		writeln('dni: ',a.info.dni);
		a.info.mes:= random(12) + 1;
		writeln('mes: ',a.info.mes);
		a.info.anio:= random(24) + 2000;
		writeln('anio: ',a.info.anio);
	end;
end;

procedure agregarAdelante(var l:lista; a:alquiler2);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=a;
	aux^.sig:= l;
	l:= aux;
end;

procedure agregar(var a:arbol; alqui:alquiler);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.patente:=alqui.patente;
		a^.dato.l:=nil;
		agregarAdelante(a^.dato.l,alqui.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.patente = alqui.patente)then agregarAdelante(a^.dato.l,alqui.info)
		else
			if(a^.dato.patente > alqui.patente)then agregar(a^.hi,alqui)
			else
				agregar(a^.hd,alqui);
end;

procedure cargarArbol(var a:arbol);
var
	alqui:alquiler;
begin
	leerAlquiler(alqui);
	while (alqui.patente <> 0) do
	begin
		agregar(a,alqui);
		leerAlquiler(alqui);
	end;
end;

procedure recorrerLista(l:lista; dni:integer ; var cant:integer);
begin
	while(l <> nil)do
	begin
		if(l^.dato.dni = dni)then cant:= cant + 1;
		l:=l^.sig;
	end;
end;

procedure buscarDni(a:arbol; dni:integer; var cant:integer);
begin
	if(a <> nil)then
	begin
		buscarDni(a^.hi,dni,cant);
		recorrerLista(a^.dato.l,dni,cant);
		writeln('cantidad: ',cant);
		buscarDni(a^.hd,dni,cant);
	end;
end;

procedure recorrerListaSuma(l:lista; anio:integer; var cant:integer);
begin
	while(l <> nil)do
	begin
		if(l^.dato.anio = anio)then cant:= cant +1;
		l:=l^.sig;
	end
end;

procedure buscarEntre2(a:arbol; min,max,anio:integer; var cant:integer);
begin
	if(a <> nil)then
	begin
		if(a^.dato.patente <= max)then
		begin
			if(a^.dato.patente >= min)then
			begin
				recorrerListaSuma(a^.dato.l,anio,cant);
				buscarEntre2(a^.hi,min,max,anio,cant);
			end
			else
				buscarEntre2(a^.hd,min,max,anio,cant);
		end
		else
			buscarEntre2(a^.hi,min,max,anio,cant);
			buscarEntre2(a^.hd,min,max,anio,cant);
	end;
end;

var
	ABB:arbol;
	D,cant,cantX,X:integer;
	PatenteA,PatenteB:integer;
begin
	randomize;
	ABB:=nil;
	cargarArbol(ABB);
	writeln('ingrese un dni a buscar la cantidad de alquileres realizados: ');
	readln(D);
	cant:= 0;
	buscarDni(ABB,D,cant);
	writeln('la cantidad total de alquileres realizados para el dni: ',D,' es de: ',cant);
	cantX:= 0;
	writeln('ingrese la patente izquierde (minimo): ');
	readln(PatenteA);
	writeln('ingrese la patente derecha (maximo): ');
	readln(PatenteB);
	writeln('ingrese un anio: ');
	readln(X);
	buscarEntre2(ABB,PatenteA,PatenteB,X,cantX);
	writeln('la cantidad de alquileres entre A y B en el anio: ',X,' es de: ',cantX);
end.
