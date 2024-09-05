program parcial5;
type
	prestamo = record
		numero:integer;
		isbn:integer;
		codSocio:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:prestamo;
		hi,hd:arbol;
	end;
	
	info = record
		codSocio:integer;
		cantTotal:integer;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato:info;
		hi,hd:arbol2;
	end;

procedure agregar(var a:arbol; p:prestamo);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.isbn >= p.isbn)then agregar(a^.hi,p)
		else
			agregar(a^.hd,p);
end;

procedure agregarII(var a:arbol2; cod:integer; cant:integer);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.codSocio:= cod;
		a^.dato.cantTotal:= cant;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codSocio >= cod)then agregarII(a^.hi,cod,cant)
		else
			agregarII(a^.hd,cod,cant);
end;

procedure leerPrestamo(var p:prestamo);
begin
	writeln('ingrese el codigo de socio: ');
	readln(p.codSocio);
	if(p.codSocio <> 0)then
	begin
		writeln('ingrese el ISBN del libro: ');
		readln(p.ISBN);
		writeln('ingrese el numero de prestamo: ');
		readln(p.numero);
	end;
end;

procedure cargarEstructuras(var a:arbol; var a2:arbol2);
var
	pre:prestamo;
	actual:integer;
	cant:integer;
begin
	leerPrestamo(pre);
	while(pre.codSocio <> 0)do
	begin
		cant:=0;
		actual:=pre.codSocio;
		while(pre.codSocio <> 0) and (actual = pre.codSocio)do
		begin
			agregar(a,pre);
			cant:=cant + 1;
			leerPrestamo(pre);
		end;
		agregarII(a2,actual,cant);
	end;
end;

procedure buscarEnArbol(a:arbol2; x:integer; var cant:integer);
begin
	if(a <> nil)then
	begin
		buscarEnArbol(a^.hi,x,cant);
		if(a^.dato.cantTotal > x)then cant:= cant + 1;
		buscarEnArbol(a^.hd,x,cant);
	end;
end;

function contarISBN(a:arbol; isbn:integer):integer;
begin
	if(a = nil)then contarISBN:=0
	else
		if(a^.dato.isbn = isbn)then contarISBN:= 1 + contarISBN(a^.hi,isbn)
        else
			if(a^.dato.isbn > isbn)then 
				contarISBN:=contarISBN(a^.hi,isbn)
			else
				contarISBN:=contarISBN(a^.hd,isbn);
end;

var
	ABB:arbol;
	ABB2:arbol2;
	x,cant,cant2,isbn:integer;
	
begin
	ABB:= nil;
	ABB2:= nil;
	cargarEstructuras(ABB,ABB2);
	writeln('ingrese el isbn a buscar la cantiadad: ');
	read(isbn);
	cant2:=contarISBN(ABB,isbn);
	writeln('la cantidad de prestamos realizados al isbn: ',isbn,' es: ',cant2);
	writeln('ingrese el dato');
	read(x);
	cant:=0;
	buscarEnArbol(ABB2,x,cant);
	writeln('la cantidad de prestamos mayores a x es: ',cant);
end.
