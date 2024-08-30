{
4. Una oficina requiere el procesamiento de los reclamos de las personas. De cada reclamo
se lee código, DNI de la persona, año y tipo de reclamo. La lectura finaliza con el código de
igual a -1. Se pide:

a) Un módulo que retorne estructura adecuada para la búsqueda por DNI. Para cada DNI
se deben tener almacenados cada reclamo y la cantidad total de reclamos que realizó.

b) Un módulo que reciba la estructura generada en a) y un DNI y retorne la cantidad de
reclamos efectuados por ese DNI.

c) Un módulo que reciba la estructura generada en a) y dos DNI y retorne la cantidad de
reclamos efectuados por todos los DNI comprendidos entre los dos DNI recibidos.

d) Un módulo que reciba la estructura generada en a) y un año y retorne los códigos de
los reclamos realizados en el año recibido.
}

program Punto4;
type

	str30 = string[30];

	reclamo = record
		codigo:integer;
		anio:integer;
		tipoReclamo:str30;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato:reclamo;
		sig:lista;
	end;
	
	info = record
		dni:integer;
		cantReclamos:integer;
		l:lista;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:info;
		hi,hd:arbol;
	end;

procedure leerReclamo(var r:reclamo; var dni:integer);
begin
	writeln('ingrese el codigo: ');
	readln(r.codigo);
	if(r.codigo <> -1)then
	begin
		writeln('ingrese el dni de la persona: ');
		readln(dni);
		writeln('ingrese el anio del reclamo: ');
		readln(r.anio);
		writeln('ingrese el tipo de reclamo: ');
		readln(r.tipoReclamo);
	end;
end;

procedure agregarAdelante(var l:lista; r:reclamo);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=r;
	aux^.sig:=l;
	l:=aux;
end;

procedure agregar(var a:arbol; r:reclamo; dni:integer);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.dni:= dni;
		a^.dato.l:=nil;
		a^.dato.cantReclamos := 0;
		agregarAdelante(a^.dato.l,r);
		a^.dato.cantReclamos:= a^.dato.cantReclamos + 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.dni = dni)then agregarAdelante(a^.dato.l,r)
		else
			if(a^.dato.dni < dni)then agregar(a^.hd,r,dni)
			else
				agregar(a^.hi,r,dni);		
end;

procedure cargarArbol(var a:arbol);
var
	recla:reclamo;
	dni:integer;
begin
	leerReclamo(recla,dni);
	while(recla.codigo <> -1)do
	begin
		agregar(a,recla,dni);
		leerReclamo(recla,dni);
	end;
end;

function buscarDni(a:arbol; dni:integer):integer;
begin
	if(a = nil)then buscarDni:=0
	else
		if(a^.dato.dni = dni)then buscarDni:= a^.dato.cantReclamos
		else
			if(a^.dato.dni < dni)then buscarDni:= buscarDni(a^.hd,dni)
			else
				buscarDni:= buscarDni(a^.hi,dni);
end;

function buscarEntre(a:arbol; min,max:integer):integer;
begin
	if(a = nil)then buscarEntre:= 0
	else
		if(a^.dato.dni < min)then buscarEntre:=buscarEntre(a^.hd,min,max)
		else
			if(a^.dato.dni > max)then buscarEntre:=buscarEntre(a^.hi,min,max)
			else
				buscarEntre:= a^.dato.cantReclamos + buscarEntre(a^.hd,min,max) + buscarEntre(a^.hi,min,max)
end;

procedure recorrerLista(l:lista; anio:integer);
begin
	while(l <> nil)do
	begin
		if(l^.dato.anio = anio)then writeln('codigo: ',l^.dato.codigo);
		l:=l^.sig;
	end;
end;

procedure recorrerArbol(a:arbol; anio:integer);
begin
	if(a <> nil)then
	begin
		recorrerArbol(a^.hi,anio);
		recorrerLista(a^.dato.l,anio);
		recorrerArbol(a^.hd,anio)
	end;
end;

var
	ABB:arbol;
	dni:integer;
	cant,cantTotal:integer;
	dniMin,dniMax:integer;
	anio:integer;

begin
	cargarArbol(ABB);
	if(ABB <> nil)then
	begin
		writeln('ingrese el dni a buscar en el arbol');
		readln(dni);
		cant:=buscarDni(ABB,dni);
		writeln('para el dni: ',dni,' tuvo una cantidad de: ',cant,' reclamos');
		writeln('---------------------');
		writeln('ingrese el codigo izquirdo');
		readln(dniMin);
		writeln('ingrese el codigo derecho');
		readln(dniMax);
		cantTotal:= buscarEntre(ABB,dniMin,dniMax);
		writeln('---------------------');
		writeln('la cantidad total de reclamos entre, ',dniMin,' y ',dniMax,' es de: ',cantTotal);
		writeln('ingrese el anio a buscar: ');
		read(anio);
		recorrerArbol(ABB,anio);
	end;
end.
