program Parcial6;
type

	
	pasaje2 = record
		vuelo:integer;
		cliente:integer;
		monto:real
	end;
	
	pasaje = record
		destino:integer;
		info:pasaje2;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:pasaje2;
		sig:lista;
	end;
	
	datoArbol = record
		destino:integer;
		l:lista;
	end;
	
	arbol = ^nodo2;
	nodo2 = record
		dato:datoArbol;
		hi,hd:arbol;
	end;

procedure leerPasaje(var p:pasaje);
begin
	p.info.monto:= random(99)/(random(10) +1);
	if(p.info.monto <> 0)then
	begin
		writeln('monto: ',p.info.monto);
		p.info.vuelo:= random(700);
		writeln('codigo de vuelo: ',p.info.vuelo);
		p.info.cliente:= random(100) + 1;
		writeln('codigo de cliente: ',p.info.cliente);
		p.destino:= random(500) + 1;
		writeln('codigo de vuelo: ',p.destino);
	end;
end;

procedure agregarAdelante(var l:lista; p:pasaje2);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=p;
	aux^.sig:=l;
	l:= aux;
end;

procedure agregar(var a:arbol; p:pasaje);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.destino:= p.destino;
		a^.dato.l:= nil;
		agregarAdelante(a^.dato.l,p.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.destino = p.destino)then agregarAdelante(a^.dato.l,p.info)
		else
			if(a^.dato.destino > p.destino)then agregar(a^.hi,p)
			else
				agregar(a^.hd,p);
end;

procedure cargarArbol(var a:arbol);
var
	pj:pasaje;
begin
	leerPasaje(pj);
	while(pj.info.monto <> 0)do
	begin
		agregar(a,pj);
		leerPasaje(pj);
	end;
end;

function recorrerLista(l:lista):integer;
var
	cant:integer;
begin
	cant:=0;
	while(l <> nil)do
	begin
		cant:=cant + 1;
		l:=l^.sig;
	end;
	recorrerLista:=cant;
end;

function buscarDestino(a:arbol; dest:integer):integer;
begin
	if(a = nil)then buscarDestino:=0
	else
		if(a^.dato.destino = dest)then buscarDestino:= recorrerLista(a^.dato.l)
		else
			if(a^.dato.destino > dest)then buscarDestino:= buscarDestino(a^.hi,dest)
			else
				buscarDestino:= buscarDestino(a^.hd,dest);
end;


procedure imprimirLista(l:lista);
begin
	while(l <> nil)do
	begin
		writeln('monto: ',l^.dato.monto);
		writeln('codigo de cliente: ',l^.dato.cliente);
		writeln('codigo de vuelo: ',l^.dato.vuelo);
		l:=l^.sig;
	end;
end;


procedure informarArbol(a:arbol);
begin
	if(a <> nil)then
	begin
		informarArbol(a^.hi);
		writeln('------codigo de viaje: ',a^.dato.destino);
		imprimirLista(a^.dato.l);
		informarArbol(a^.hd);
	end;
end;

procedure calcularMaximo(var maxV:integer;cantV,destinoActual:integer; var maxdest:integer);
begin
	if(cantV > maxV)then
	begin
		maxV:=cantV;
		maxdest:=destinoActual;
	end;
end;

procedure recorrerArbol(a:arbol;var maxVia,Dest:integer);
var
	cantViajes:integer;
begin
	if(a <> nil)then
	begin
		recorrerArbol(a^.hi,maxVia,dest);
		cantViajes:= recorrerLista(a^.dato.l);
		writeln('cantidad de viajes: ',cantViajes);
		calcularMaximo(maxVia,cantViajes,a^.dato.destino,dest);
		recorrerArbol(a^.hd,maxVia,dest);
	end;
end;

var
	ABB:arbol;
	cant,destino:integer;
	maxDestino:integer;
	maxViajes:integer;
begin

	randomize;
	ABB:=nil;
	cargarArbol(ABB);
	informarArbol(ABB);
	writeln('ingrese un codigo de destino a buscar la cantidad de viajes realizados: ');
	readln(destino);
	cant:=buscarDestino(ABB,destino);
	writeln('la cantidad de viajes del destino: ',destino,' es: ',cant);
	maxViajes:= -1;
	recorrerArbol(ABB,maxViajes,maxDestino);
	writeln('el codigo de destino con mas viajes realizados es: ',maxDestino,' con la cantidad de: ',maxViajes);
end.
