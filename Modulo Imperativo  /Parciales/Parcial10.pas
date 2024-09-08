program Parcial0;
type	
	rangoDias = 1..31;
	registro2 = record
		dia:rangoDias;
		cantCombos:integer;
		monto:real;
	end;

	registro = record
		numCliente:integer;
		info:registro2;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:registro2;
		sig:lista;
	end;
	
	datoArbol = record
		numCliente:integer;
		l:lista;
	end;
	
	arbol = ^nodo2;
	nodo2 = record
		dato:datoArbol;
		hi,hd:arbol;
	end;

procedure leerRegistro(var r:registro);
begin
	r.numCliente:= random(76);
	if(r.numCliente <> 0)then
	begin
		writeln('codigo de cliente: ',r.numCliente);
		r.info.dia:= random(32);
		writeln('dia: ',r.info.dia);
		r.info.monto:= 100 + random(3000);
		writeln('monto: ',r.info.monto);
		r.info.cantCombos:= 1 + random(20);
		writeln('cantidad de combos: ',r.info.cantCombos);
	end;
end;

procedure agregarAdelante(var l:lista; r:registro2);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=r;
	aux^.sig:= l;
	l:= aux;
end;

procedure agregar(var a:arbol; r:registro);
begin
	if(a = nil)then 
	begin
		new(a);
		a^.dato.numCliente:= r.numCliente;
		a^.dato.l:= nil;
		agregarAdelante(a^.dato.l,r.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.numCliente = r.numCliente)then agregarAdelante(a^.dato.l,r.info)
		else
			if(a^.dato.numcliente > r.numCliente)then agregar(a^.hi,r)
			else
				agregar(a^.hd,r);
end;

procedure cargarArbol(var a:arbol);
var
	reg:registro;
begin
	leerRegistro(reg);
	while(reg.numCliente <> 0)do
	begin
		agregar(a,reg);
		leerRegistro(reg);
	end;
end;

procedure buscarCliente(a:arbol; c:integer; var l:lista);
begin
	if(a <> nil)then
	begin
		if(a^.dato.numCliente = c)then l:= a^.dato.l
		else
			if(a^.dato.numCliente > c)then buscarCliente(a^.hi,c,l)
			else
				buscarCliente(a^.hd,c,l);
	end;
end;

procedure informarLista(l:lista);
begin
	while(l <> nil)do
	begin
		writeln('dia: ',l^.dato.dia,' cantidad de combos: ',l^.dato.cantCombos,' monto: ',l^.dato.monto);
		l:=l^.sig;
	end;
end;

function recorrerLista(l:lista):real;
begin
	if(l = nil)then recorrerLista:= 0
	else
		recorrerLista:= l^.dato.monto + recorrerLista(l^.sig);
end;

var
	ABB:arbol;
	lisCliente:lista;
	cliente:integer;
	montoTotal:real;
begin
	randomize;
	ABB:=nil;
	lisCliente:=nil;
	cargarArbol(ABB);
	writeln('ingrese un numero de cliente a buscar sus pedidos: ');
	readln(cliente);
	buscarCliente(ABB,cliente,lisCliente);
	informarLista(lisCliente);
	montoTotal:= recorrerLista(lisCliente);
	writeln('el monto total del cliente: ',cliente,' es de: ',montoTotal:0:2);
end.
