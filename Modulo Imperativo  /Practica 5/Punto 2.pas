{
2. Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la
información de los autos en venta. Implementar un programa que:

a) Lea la información de los autos (patente, año de fabricación (2010..2018), marca y
modelo) y los almacene en dos estructuras de datos:

i. Una estructura eficiente para la búsqueda por patente.

ii. Una estructura eficiente para la búsqueda por marca. Para cada marca se deben
almacenar todos juntos los autos pertenecientes a ella.

b) Invoque a un módulo que reciba la estructura generado en a) i y una marca y retorne la
cantidad de autos de dicha marca que posee la agencia.

c) Invoque a un módulo que reciba la estructura generado en a) ii y una marca y retorne
la cantidad de autos de dicha marca que posee la agencia.

d) Invoque a un módulo que reciba el árbol generado en a) i y retorne una estructura con
la información de los autos agrupados por año de fabricación.

e) Invoque a un módulo que reciba el árbol generado en a) i y una patente y devuelva el
modelo del auto con dicha patente.

f) Invoque a un módulo que reciba el árbol generado en a) ii y una patente y devuelva el
modelo del auto con dicha patente.
}


program Punto2;
type
	
	str30 = string[30];
	rango2010 = 2010..2018;
	
	auto2 = record
		anioFabricacion:rango2010;
		patente:str30;
		modelo:str30;
	end;
	
	auto = record
		marca:str30;
		info:auto2;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:auto;
		hi,hd:arbol;
	end;
	
		
	lista = ^nodo2;
	nodo2 = record
		dato:auto2;
		sig:lista;
	end;
		
	autoreg = record
		marca:str30;
		l:lista;
	end;
		
	arbolII = ^nodo3;
	nodo3 = record
		dato:autoreg;
		hi,hd:arbolII;
	end;
	
	listaAnios = ^nodoAnio;
	nodoAnio = record
		dato:auto;
		sig:listaAnios;
	end;

	vAnios = array [rango2010] of listaAnios;

procedure leerAuto(var a:auto);
begin
	writeln('ingrese la marca del auto');
	readln(a.marca);
	if(a.marca <> 'fiat')then
	begin
		writeln('ingrese el año de fabricacion del auto');
		readln(a.info.anioFabricacion);
		writeln('ingrese la patente del auto');
		readln(a.info.patente);
		writeln('ingrese el modelo del auto');
		readln(a.info.modelo);
	end;
end;

procedure agregarI(var a:arbol; x:auto);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:=x;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.info.patente <= x.info.patente)then agregarI(a^.hd,x)
		else
			agregarI(a^.hi,x);
end;

procedure agregarAdelante(var l:lista; a:auto2);
var
	aux:lista;
begin
	new(aux);
	writeln('hola');
	aux^.dato:= a;
	aux^.sig:= l;
	l:= aux;
end;

procedure agregarII(var a:arbolII; x:auto);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.marca:=x.marca;
		a^.dato.l:=nil;
		agregarAdelante(a^.dato.l,x.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.marca = x.marca) then agregarAdelante(a^.dato.l,x.info)
		else
			if(a^.dato.marca < x.marca) then agregarII(a^.hd,x)
			else
				agregarII(a^.hi,x);
end;

procedure cargarArboles(var a:arbol;var a2:arbolII);
var
	x:auto;
begin
	leerAuto(x);
	while(x.marca <> 'fiat')do
	begin
		agregarI(a,x);
		agregarII(a2,x);
		leerAuto(x);
	end;
end;

procedure recorrerArbolI(a:arbol; m:str30; var cant:integer);
begin
	if(a <> nil)then
	begin
		recorrerArbolI(a^.hi,m,cant);
		if(a^.dato.marca = m)then cant:=cant + 1;
		recorrerArbolI(a^.hd,m,cant);
	end;
end;

procedure recorrerLista(l:lista;var cant:integer);
begin
	while(l <> nil)do 
	begin
		writeln('hola');
		cant:=cant+1;
		l:=l^.sig
	end;
end;

procedure recorrerArbolII(a:arbolII; m:str30; var cant:integer);
begin
	if(a = nil)then cant:= 0
	else
		if(a^.dato.marca = m)then recorrerLista(a^.dato.l,cant)
		else
			if(a^.dato.marca < m)then recorrerArbolII(a^.hd,m,cant)
			else
				if(a^.dato.marca > m)then recorrerArbolII(a^.hi,m,cant);
end;

procedure agregarAdelanteII(var l:listaAnios; a:auto);
var
	aux:listaAnios;
begin
	new(aux);
	aux^.dato:=a;
	aux^.sig:= l;
	l:= aux;
end;

procedure recorrerVector(var v:vAnios; a:arbol);
begin
	if(a <> nil)then
	begin
		recorrerVector(v,a^.hi);
		agregarAdelanteII(v[a^.dato.info.anioFabricacion],a^.dato);
		recorrerVector(v,a^.hd);
	end;
end;

procedure buscarPatente(a:arbol; p:str30; var m:str30; var esta:boolean);
begin
	if(a = nil)then esta:=false
	else
		if(a^.dato.info.patente = p)then 
		begin
			m:=a^.dato.info.modelo;
			esta:= true;
		end
		else
			if(a^.dato.info.patente < p)then buscarPatente(a^.hd,p,m,esta)
			else
				buscarPatente(a^.hi,p,m,esta);
end;

function recorrerListaII(l:lista; p:str30): boolean;
begin
	while(l <> nil)do 
	begin
		if(l^.dato.patente = p)then 
		begin
			recorrerListaII:= true;
			
		end;
		l:=l^.sig;
	end;
end;

procedure buscarPatenteII(a:arbolII; p:str30; var m:str30; var esta:boolean);
begin
	if(a <> nil)then
	begin
		esta := recorrerListaII(a^.dato.l,p);
		if(not esta)then
		begin
			buscarPatenteII(a^.hi,p,m,esta);
			buscarPatenteII(a^.hd,p,m,esta);
		end
		else
			m:=a^.dato.l^.dato.modelo;
	end;
end;

var
	ABB:arbol;
	ABB2:arbolII;
	cant,cant2:integer;
	marca:str30;
	vector:vAnios;
	modelo,modelo2,patente,patente2:str30;
	esta:boolean;
begin
	ABB:=nil;
	ABB2:=nil;
	cargarArboles(ABB,ABB2);
	cant:=0;
	writeln('ingrese la marca a buscar en el arbol 1: ');
	readln(marca);
	recorrerArbolI(ABB,marca,cant);
	writeln('la cantidad de autos, ',marca,'en el arbol 1 es de: ',cant);
	writeln('ingrese la marca a buscar en el arbol 2: ');
	readln(marca);
	cant2:=0;
	recorrerArbolII(ABB2,marca,cant2);
	writeln('la cantidad de autos, ',marca,'en el arbol 2 es de: ',cant2);
	recorrerVector(vector,ABB);
	writeln('ingrese la patente a buscar en el primer arbol: ');
	readln(patente);
	modelo:= ' ';
	buscarPatente(ABB,patente,modelo,esta);
	if (esta) then writeln('la patente',patente,' se encuentra y el modelo es: ',modelo)
	else
		writeln('no se encuantra la patente');
	writeln('ingrese la patente a buscar en el segundo arbol: ');
	readln(patente2);
	modelo2:= ' ';
	esta:=false;
	buscarPatenteII(ABB2,patente2,modelo2,esta);
	if (esta) then writeln('la patente',patente2,' se encuentra y el modelo es: ',modelo2)
	else
		writeln('no se encuantra la patente');
end.
