program Parcial9;
type
	
	str30 = string[30];
	
	pedido2 = record
		fecha:integer;
		monto:real;
	end;
	
	pedido = record
		dni:integer;
		nombre:str30;
		info:pedido2;
	end;
	
	lista = ^nodo;
	nodo = record
		dato:pedido2;
		sig:lista;
	end;
	
	datoArbol = record
		dni:integer;
		nombre:str30;
		l:lista;
	end;
	
	arbol = ^nodo2;
	nodo2 = record
		dato:datoArbol;
		hi,hd:arbol;
	end;

procedure leerPedido(var p:pedido);
begin
	p.info.monto:= random(700);
	if(p.info.monto <> 0)then
	begin
		writeln('monto: ',p.info.monto);
		p.info.fecha:= random(30)+1;
		writeln('fecha: ',p.info.fecha);
		p.dni:= random(2000)+1;
		writeln('dni: ',p.dni);
		p.nombre:= 'zzz';
		writeln('nombre: ',p.nombre);
	end;
end;

procedure agregarAdelante(var l:lista; p:pedido2);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=p;
	aux^.sig:=l;
	l:= aux;
end;

procedure agregar(var a:arbol; p:pedido);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.dni:=p.dni;
		a^.dato.nombre:=p.nombre;
		a^.dato.l:=nil;
		agregarAdelante(a^.dato.l,p.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.dni = p.dni)then agregarAdelante(a^.dato.l,p.info)
		else
			if(a^.dato.dni > p.dni)then agregar(a^.hi,p)
			else
				agregar(a^.hd,p);
end;

procedure cargarArbol(var a:arbol);
var
	p:pedido;
begin
	leerPedido(p);
	while(p.info.monto <> 0)do
	begin
		agregar(a,p);
		leerPedido(p);
	end;
end;

procedure recorrerListaSuma(l:lista; f:integer; var cant:integer);
begin
	while(l <> nil)do
	begin
		if(l^.dato.fecha = f)then cant:=cant+1;
		l:=l^.sig;
	end;
end;

procedure buscarFecha(a:arbol; f:integer; var cant:integer);
begin
	if(a <> nil)then
	begin
		buscarFecha(a^.hi,f,cant);
		recorrerListaSuma(a^.dato.l,f,cant);
		buscarFecha(a^.hd,f,cant);
	end;
end;	

procedure recorrerLista(l:lista; var cant:integer; var total:real);
begin
	while(l <> nil)do
	begin
		cant:= cant + 1;
		total:= total + l^.dato.monto;
		l:=l^.sig;
	end
end;

procedure buscarDni(a:arbol; dni:integer; var cantP:integer; var total:real);
begin
	if(a = nil)then
	begin
		cantP:=0;
		total:=0;
	end
	else
		if(a^.dato.dni = dni)then recorrerLista(a^.dato.l,cantP,total)
		else
			if(a^.dato.dni > dni)then buscarDni(a^.hi,dni,cantP,total)
			else
				buscarDni(a^.hd,dni,cantP,total);
end;

var
	ABB:arbol;
	fecha,cant,dni,cantPedidos:integer;
	montoTotal:real;
begin
	randomize;
	ABB:=nil;
	cargarArbol(ABB);
	writeln('ingrese una fecha a buscar en el arbol del (1..31): ');
	readln(fecha);
	cant:=0;
	buscarFecha(ABB,fecha,cant);
	writeln('la cantidad de clientes que realizaron pedidos en la fecha: ',fecha,' es de: ',cant);
	cantPedidos:=0;
	montoTotal:=0;
	writeln('ingrese un dni a buscar su monto total e cantidad de pedidos: ');
	readln(dni);
	buscarDni(ABB,dni,cantPedidos,montoTotal);
	writeln('para el dni: ',dni,' monto total: ',montoTotal,' cantidad de pedidos: ',cantPedidos);
end.
