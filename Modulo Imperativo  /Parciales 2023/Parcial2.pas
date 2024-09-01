program clinica;
const
	df = 15;
type
	sub_mes = 0..12;
	sub_diagnostico = 1..15;
	atencion = record
		dni:integer;
		mes:sub_mes;
		diagnostico:sub_diagnostico;
	end;
	
	cliente = record
		dni:integer;
		cantAtenciones:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:cliente;
		hi,hd:arbol;
	end;
	
	vDiagnosticos = array[sub_diagnostico] of integer;

procedure inicializarVector(var v:vDiagnosticos);
var
	i:integer;
begin
	for i:= 1 to 15 do v[i]:= 0;
end;

procedure leerAtencion(var a:atencion);
begin
	a.mes:=random(13);
	writeln('mes: ',a.mes);
	if(a.mes <> 0)then
	begin
		a.dni:=random(1000)+1;
		writeln('dni: ',a.dni);
		a.diagnostico:=random(15)+1;
		writeln('diagnostico: ', a.diagnostico);
	end;
end;

procedure agregar(var a:arbol; dni:integer);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.dni:=dni;
		a^.dato.cantAtenciones:=1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.dni = dni)then a^.dato.cantAtenciones:=a^.dato.cantAtenciones + 1
		else
			if(a^.dato.dni < dni)then agregar(a^.hd,dni)
			else
				agregar(a^.hi,dni);
end;

procedure cargarArbol(var a: arbol; var v:vDiagnosticos);
var
	aten:atencion;
begin
	leerAtencion(aten);
	while(aten.mes <> 0)do
	begin
		agregar(a,aten.dni);
		v[aten.diagnostico]:=v[aten.diagnostico] + 1;
		leerAtencion(aten);
	end;
end;

function calcular(cant:integer; x:integer):integer;
begin
	if(cant > x)then calcular:= 1
	else
		calcular:= 0;
end;

function recorrerEntre2(a:arbol; min,max,x:integer):integer;
begin
	if(a = nil)then recorrerEntre2:= 0
	else
		if(a^.dato.dni < min)then recorrerEntre2:=recorrerEntre2(a^.hd,min,max,x)
		else
			if(a^.dato.dni > max)then recorrerEntre2:=recorrerEntre2(a^.hi,min,max,x)
			else
				recorrerEntre2:= calcular(a^.dato.cantAtenciones,x) + recorrerEntre2(a^.hi,min,max,x) + recorrerEntre2(a^.hd,min,max,x)
end;

function recorrerVector(v:vDiagnosticos; dl:integer):integer;
begin
	if(dl < df)then
	begin
		dl:=dl + 1;
		if(v[dl] = 0)then recorrerVector:= 1 + recorrerVector(v,dl)
		else
			recorrerVector:= recorrerVector(v,dl);
	end;
end;

var
	vector:vDiagnosticos;
	ABB:arbol;
	minDni,maxDni,x,cant,atenIgualesAcero:integer;
	i:integer;
begin
	randomize;
	ABB:=nil;
	inicializarVector(vector);
	cargarArbol(ABB,vector);
	if(ABB <> nil)then
	begin
		writeln('ingrese el dni izquierdo');
		readln(minDni);
		writeln('ingrese el dni derecho');
		readln(maxDni);
		writeln('ingrese un valor');
		readln(x);
		cant:=recorrerEntre2(ABB,minDni,maxDni,x);
		writeln('la cantidad de pacientes con mas de ',x,' es de: ',cant);
		i:=0;
		atenIgualesAcero:= recorrerVector(vector,i);
		writeln('la cantidad de diagnosticos para los cuales la cantidad de atenciones fue cera es de: ',atenIgualesAcero);
	end;
end.
