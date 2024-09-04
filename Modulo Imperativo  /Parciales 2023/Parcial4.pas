program parcial4;
type
	rangoDias = 1..31;
	
	registro2 = record
		dia:rangoDias;
		cantProductos:integer;
		monto:real;
	end;
	
	registro = record
		codCliente:integer;
		info:registro2;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:registro2;
		sig:lista;
	end;
	
	datoArbol = record
		codCliente:integer;
		l:lista;
	end;
		
	arbol = ^nodo2;
	nodo2 = record
		dato:datoArbol;
		hi,hd:arbol;
	end;

procedure leerRegistro(var r:registro);
begin
	r.info.cantProductos:= random(30);
	if(r.info.cantProductos <> 0)then
	begin
		writeln('cantidad de productos: ',r.info.cantProductos);
		r.codCliente:= 1 + random(99);
		writeln('codigo del cliente: ',r.codCliente);
		r.info.monto:= 150 + random(8000);
		writeln('monto: ',r.info.monto);
		r.info.dia:= 1 + random(31);
		writeln('dia: ',r.info.dia);
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
		a^.dato.codCliente:= r.codCliente;
		a^.dato.l:= nil;
		agregarAdelante(a^.dato.l,r.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codCliente = r.codCliente)then agregarAdelante(a^.dato.l,r.info)
		else
			if(a^.dato.codCliente > r.codCliente)then agregar(a^.hi,r)
			else
				agregar(a^.hd,r);
end;

procedure cargarArbol(var a:arbol);
var
	reg:registro;
begin
	leerRegistro(reg);
	while(reg.info.cantProductos <> 0)do
	begin
		agregar(a,reg);
		leerRegistro(reg);
	end;
end;

procedure cargarLista(a:arbol; var l:lista; c:integer);
begin
	if(a <> nil)then
	begin
		if(a^.dato.codCliente = c)then l:=a^.dato.l
		else
			if(a^.dato.codCliente > c)then cargarLista(a^.hi,l,c)
			else
				cargarLista(a^.hd,l,c);
			
	end;
end;

procedure calcularMaximo(l:lista; max:integer; var maxMonto:real);
begin
	while(l <> nil)do
	begin
		if(l^.dato.cantProductos > max)then
		begin
			max:=l^.dato.cantProductos;
			maxMonto:=l^.dato.monto;
		end;
		l:=l^.sig;
	end;
end;

procedure informarLista(l:lista);
begin
	while(l <> nil)do
	begin
		writeln('monto: ',l^.dato.monto,' cantidad Productos: ',l^.dato.cantProductos,' dia: ',l^.dato.dia);
		l:=l^.sig;
	end;
end;

var
	ABB:arbol;
	lis:lista;
	codigo:integer;
	max:integer;
	maxMonto:real;
begin
	randomize;
	ABB:=nil;
	lis:=nil;
	cargarArbol(ABB);
	writeln('ingrese un codigo; ');
	read(codigo);
	cargarLista(ABB,lis,codigo);
	informarLista(lis);
	max:=-1;
	calcularMaximo(lis,max,maxMonto);
	writeln('el monto de la compra con mayor cantidad de productos es: ',maxMonto);
end.
