program parcialI;
type

	compra2 = record
		numFac:integer;
		cantProd:integer;
		monto:real;
	end;

	compra = record
		codCli:integer;
		info:compra2;
	end;
	
	lista = ^nodo2;
	nodo2 = record
		dato:compra2;
		sig:lista;
	end;
	
	info = record
		codCli:integer;
		l:lista;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:info;
		hi,hd:arbol;
	end;

procedure agregarAdelante(var l:lista; c:compra2);
var
	aux:lista;
begin
	new(aux);
	aux^.dato:=c;
	aux^.sig:= l;
	l:=aux;
end;

procedure agregar(var a:arbol; c:compra);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.codCli:=c.codCli;
		a^.dato.l:=nil;
		agregarAdelante(a^.dato.l,c.info);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codCli = c.codCli)then agregarAdelante(a^.dato.l,c.info)
		else
			if(a^.dato.codCli > c.codCli)then agregar(a^.hi,c)
			else
				agregar(a^.hd,c);
end;

procedure leerCompra(var c:compra);
begin
	c.codCli:=random(100);
	writeln('codigo cliente: ', c.codCli);
	if(c.codCli <> 0)then
	begin
		c.info.numFac:= random(10000)+1;
		writeln('numero de la factura', c.info.numFac);
		c.info.cantProd:= random(20) + 1;
		writeln('cantidad de productos: ', c.info.cantProd);
		c.info.monto:= random(2000)/(random(10)+1);
		writeln('el monto: ',c.info.monto);
	end;
end;
	
procedure cargarArbol(var a:arbol);
var
	c:compra;
begin
	leerCompra(c);
	while(c.codCli <> 0)do
	begin
		agregar(a,c);
		leerCompra(c);
	end;
end;

procedure informarLista(l: lista);
begin
    while l <> nil do
    begin
        writeln('numero de la factura: ', l^.dato.numFac, ' cantidad de productos: ', l^.dato.cantProd, ' monto: ', l^.dato.monto:0:2);
        l := l^.sig;
    end;
end;

procedure imprimirCliente(dato:info);
begin
	writeln('compra: ',dato.codCli);
	informarLista(dato.l);
end;

procedure informarArbol(a:arbol);
begin
	if(a <> nil)then
	begin
		informarArbol(a^.hi);
		imprimirCliente(a^.dato);
		informarArbol(a^.hd);
	end;
end;

procedure recorrerListaSuma(l:lista; var cant:integer; var montos:real);
begin
	while(l <> nil)do
	begin
		cant:=cant + 1;
		montos:=montos + l^.dato.monto;
		l:=l^.sig
	end;
end;

procedure buscarCodigo(a:arbol; c:integer; var cant:integer; var montos:real); 
begin
	if(a <> nil)then 
	begin
		if(a^.dato.codCli = c) then recorrerListaSuma(a^.dato.l,cant,montos)
		else
			if(a^.dato.codCli > c)then buscarCodigo(a^.hi,c,cant,montos)
			else
				buscarCodigo(a^.hd,c,cant,montos);
	end;
end;


procedure recorrerLista(l: lista; x, y: integer; var lnueva:lista);
begin
    while(l <> nil)then
    begin
		
		if(l^.dato.numFac >= x) and (l^.dato.numFac <= y)then
			agregarAdelante(lnueva,l^.dato);
		l:=l^.sig;
    end;
end;

procedure buscarEntre2(a: arbol; var l: lista; x, y: integer);
begin
    if a <> nil then
    begin
        buscarEntre2(a^.hi, l, x, y);
        recorrerLista(a^.dato.l, x, y, l);
        buscarEntre2(a^.hd, l, x, y);
    end;
end;



var
	ABB:arbol;
	lisXY:lista;
	X,Y,codigo:integer;
	cantCompras:integer;
	montoTotal:real;
begin
	ABB:=nil;
	randomize;
	cargarArbol(ABB);
	informarArbol(ABB);
	writeln('ingrese un codigo: ');
	readln(codigo);
	cantCompras:=0;
	montoTotal:=0;
	buscarCodigo(ABB,codigo,cantCompras,montoTotal);
	writeln('para el codigo, ',codigo,' tuvo cantidad de compras de: ',cantCompras, ' y un monto total de: ',montoTotal);
	writeln('----------------------------------');
	writeln('ingrese el valor izquierdo (x): ');
	read(X);
	writeln('ingrese el valor derecho (y): ');
	read(Y);
	lisXY:=nil;
	buscarEntre2(ABB,lisXY,X,y);
	if(lisXY = nil)then writeln('hola');
	informarLista(lisXY);
end.
