{2. Una biblioteca nos ha encargado procesar la información de los préstamos realizados
durante el año 2021. De cada préstamo se conoce el ISBN del libro, el número de socio, día
y mes del préstamo y cantidad de días prestados. Implementar un programa con:


a. Un módulo que lea préstamos y retorne 2 estructuras de datos con la información de
los préstamos. La lectura de los préstamos finaliza con ISBN -1. Las estructuras deben
ser eficientes para buscar por ISBN.
i. En una estructura cada préstamo debe estar en un nodo.

ii. En otra estructura, cada nodo debe contener todos los préstamos realizados al ISBN.

(prestar atención sobre los datos que se almacenan).

b. Un módulo recursivo que reciba la estructura generada en i. y retorne el ISBN más
grande.

c. Un módulo recursivo que reciba la estructura generada en ii. y retorne el ISBN más
pequeño.

d. Un módulo recursivo que reciba la estructura generada en i. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.

e. Un módulo recursivo que reciba la estructura generada en ii. y un número de socio. El
módulo debe retornar la cantidad de préstamos realizados a dicho socio.

f. Un módulo que reciba la estructura generada en i. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.

g. Un módulo que reciba la estructura generada en ii. y retorne una nueva estructura
ordenada ISBN, donde cada ISBN aparezca una vez junto a la cantidad total de veces
que se prestó.

h. Un módulo recursivo que reciba la estructura generada en h. y muestre su contenido.

i. Un módulo recursivo que reciba la estructura generada en i. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).

j. Un módulo recursivo que reciba la estructura generada en ii. y dos valores de ISBN. El
módulo debe retornar la cantidad total de préstamos realizados a los ISBN
comprendidos entre los dos valores recibidos (incluidos).}


program punto2;
type

	rangoDia = 1..31;
	rangoMes = 1..12;

	prestamo = record
		ISBN:integer;
		numSocio:integer;
		dia:rangoDia;
		mes:rangoMes;
		diasPrestamo:integer;
	end;
	
	prestamo2 = record
		numSocio:integer;
		dia:rangoDia;
		mes:rangoMes;
		diasPrestamo:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:prestamo;
		hi:arbol;
		hd:arbol;
	end;
	
	lista = ^nodo3;
	nodo3 = record
		dato:prestamo2;
		sig:lista;
	end;
	
	regPrestamo = record
		ISBN:integer;
		l:lista;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato:regPrestamo;
		hi:arbol2;
		hd:arbol2;
	end;
	
	cantISBN = record
		ISBN:integer;
		cant:integer;
	end;
	
	arbolISBN = ^nodo4;
	nodo4 = record
		dato:cantISBN;
		hi,hd:arbolISBN;
	end;
	

procedure leerPrestamo(var p:prestamo);
begin
	writeln('ingrese el ISBN del libro');
	readln(p.ISBN);
	if(p.ISBN <> -1)then
	begin
		writeln('ingrese el numero del socio');
		readln(p.numSocio);
		writeln('ingrese el dia');
		readln(p.dia);
		writeln('ingrese el mes');
		readln(p.mes);
		writeln('ingrese los dias a prestar');
		readln(p.diasPrestamo);
	end;
end;

procedure agregar(var a:arbol; p:prestamo);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:= p;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(a^.dato.ISBN <= p.ISBN) then agregar(a^.hd,p)
		else
			agregar(a^.hi,p);
end;

procedure agregarAdelante(var l:lista;p:prestamo);
var
	aux:lista;
begin
	new(aux);
	aux^.dato.numSocio:= p.numSocio;
	aux^.dato.dia:= p.dia;
	aux^.dato.mes:= p.mes;
	aux^.dato.diasPrestamo:= p.diasPrestamo;
	aux^.sig:=l;
	l:=aux;
end;

procedure agregarII(var a:arbol2; p:prestamo);
begin
	if(a = nil)then 
	begin
		new(a);
		a^.dato.ISBN:= p.ISBN;
		if(a^.dato.ISBN = p.ISBN)then agregarAdelante(a^.dato.l,p);
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.ISBN <= p.ISBN)then agregarII(a^.hd,p)
		else
			agregarII(a^.hi,p);
end;
	
procedure cargarArboles(var a:arbol; var a2:arbol2);
var
	p:prestamo;
begin
	leerPrestamo(p);
	while(p.ISBN <> -1)do
	begin
		agregar(a,p);
		agregarII(a2,p);
		leerPrestamo(p);
	end;
end;
	
function maximoISBN(a:arbol):integer;
begin
	if(a^.hd <> nil)then maximoISBN:=maximoISBN(a)
	else
		maximoISBN:=a^.dato.ISBN;
end;	
	
function minimoISBN(a:arbol2):integer;
begin
	if(a^.hi <> nil)then minimoISBN:=minimoISBN(a)
	else
		minimoISBN:=a^.dato.ISBN;
end;

procedure cantPrestamos(a:arbol; var cant:integer; num:integer);
begin
	cantPrestamos(a^.hi,cant,num);
	if(a^.dato.numSocio = num) then cant:=cant + 1;
	cantPrestamos(a^.hd,cant,num);
end;

procedure cantPrestamos2(a:arbol2 ;var cant:integer; num:integer);
var
	aux:lista;
begin
	if(a <> nil)then
	begin
		cantPrestamos2(a^.hi,cant,num);
		aux:=a^.dato.l;
		while(aux <> nil)do
		begin
			if(aux^.dato.numSocio = num)then cant:=cant + 1;
			aux:=aux^.sig;
		end;
		cantPrestamos2(a^.hd,cant,num);
	end;
end;	

procedure agregarArbol(isbn:integer; var a:arbolISBN);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.ISBN:=isbn;
		a^.hi:= nil;
		a^.hd:= nil;
	end
	else
		if(isbn = a^.dato.ISBN)then a^.dato.cant:= a^.dato.cant + 1
		else
			if(isbn < a^.dato.ISBN)then agregarArbol(isbn,a^.hi)
			else
				agregarArbol(isbn,a^.hd);
end;    	
	
procedure cargararbolI(a:arbol;var aISBN:arbolISBN);
begin
	if(a <> nil)then
	begin
		cargarArbolI(a^.hi,aISBN);
		agregarArbol(a^.dato.ISBN,aISBN);
		cargarArbolI(a^.hd,aISBN);
	end;
end;

function recorrerLista(l:lista):integer;
var
	cant:integer;
begin
	cant:= 0;
	while(l <> nil)do 
	begin
		cant:= cant + 1;
		l:=l^.sig;
	end;
	recorrerLista:= cant;
end;

procedure agregarII(reg:regPrestamo;var a:arbolISBN);
var
	cant:integer;
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.ISBN:=reg.ISBN;
		cant:=recorrerLista(reg.l);
		a^.dato.cant:=cant;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.ISBN <= reg.ISBN)then agregarII(reg,a^.hd)
		else
			agregarII(reg,a^.hi);
end;

procedure cargararbolII(a:arbol2; var aISBN:arbolISBN);
begin
	if(a <> nil)then
	begin
		cargararbolII(a^.hi,aISBN);
		agregarII(a^.dato,aISBN);
		cargararbolII(a^.hd,aISBN);
	end;
end;

procedure imprimirA1(a:arbol);
begin
	if(a <> nil)then
	begin
		imprimirA1(a^.hi);
		writeln('ISBN: ',a^.dato.ISBN);
		writeln('numero de socio: ',a^.dato.numSocio);
		writeln('dia: ',a^.dato.dia);
		writeln('mes: ',a^.dato.mes);
		writeln('dias prestados: ',a^.dato.diasPrestamo);
		imprimirA1(a^.hd);
	end;
end;

procedure recorrerListaA2(l:lista);
begin
	while(l <> nil)do
	begin
		writeln('numero de socio: ',l^.dato.numSocio);
		writeln('dia: ',l^.dato.dia);
		writeln('mes: ',l^.dato.mes);
		writeln('dias prestado: ',l^.dato.diasPrestamo);
		l:=l^.sig;
	end;
end;

procedure imprimirA2(a:arbol2);
begin
	if(a <> nil)then
	begin
		imprimirA2(a^.hi);
		writeln('el isbn del libro', a^.dato.ISBN);
		writeln('sus prestamos ');
		recorrerListaA2(a^.dato.l);
		imprimirA2(a^.hd);
	end;
end;
	
procedure imprimirA3yA4(a:arbolISBN);
begin
	if(a <> nil)then
	begin
		imprimirA3yA4(a^.hi);
		writeln('ISBN: ',a^.dato.ISBN);
		writeln('cantidad de veces prestado: ',a^.dato.cant);
		imprimirA3yA4(a^.hd);
	end;
end;
	
	
procedure ImprimirArboles(a1:arbol;a2:arbol2;a3,a4:arbolISBN);
begin
	imprimirA1(a1);
	writeln('-----------------');
	imprimirA2(a2);
	writeln('-----------------');
	writeln('arbol 3');
	imprimirA3yA4(a3);
	writeln('-----------------');
	writeln('arbol 4');
	imprimirA3yA4(a4);
end;	
function ArbolEntre2I(a: arbol; min, max: integer): integer;
begin
    if (a = nil) then
        ArbolEntre2I := 0
    else if (a^.dato.ISBN < min) then
        ArbolEntre2I := ArbolEntre2I(a^.hd, min, max)
    else if (a^.dato.ISBN > max) then
        ArbolEntre2I := ArbolEntre2I(a^.hi, min, max)
    else
        ArbolEntre2I := 1 + ArbolEntre2I(a^.hd, min, max) + ArbolEntre2I(a^.hi, min, max);
end;

procedure recorrerArbolEntre2I(a: arbol);
var
    cantTotal: integer;
    min, max: integer;
begin
    writeln('Ingrese el ISBN izquierdo');
    readln(min);
    writeln('Ingrese el ISBN derecho');
    readln(max);
    cantTotal := ArbolEntre2I(a, min, max);
    writeln('La cantidad total de préstamos realizados entre esos dos ISBN es: ', cantTotal);
end;

function ArbolEntre2II(a: arbol2; min, max: integer): integer;
begin
    if (a = nil) then
        ArbolEntre2II := 0
    else if (a^.dato.ISBN < min) then
        ArbolEntre2II := ArbolEntre2II(a^.hd, min, max)
    else if (a^.dato.ISBN > max) then
        ArbolEntre2II := ArbolEntre2II(a^.hi, min, max)
    else
        ArbolEntre2II := recorrerLista(a^.dato.l) + ArbolEntre2II(a^.hd, min, max) + ArbolEntre2II(a^.hi, min, max);
end;

procedure recorrerArbolEntre2II(a2: arbol2);
var
    cantTotal: integer;
    min, max: integer;
begin
    writeln('Ingrese el ISBN izquierdo');
    readln(min);
    writeln('Ingrese el ISBN derecho');
    readln(max);
    cantTotal := ArbolEntre2II(a2, min, max);
    writeln('La cantidad total de préstamos realizados entre esos dos ISBN es: ', cantTotal);
end;
	
	
var
	ABB:arbol;
	ABB2:arbol2;
	max:integer;
    min:integer;
    cant,cant2:integer;
    numSocio:integer;
    arbolI,arbolII:arbolISBN;
begin
	arbolI:= nil;
	arbolII:= nil;
    ABB := nil;
    ABB2 := nil;
	cargarArboles(ABB,ABB2);
	if(ABB <> nil) or (ABB2 <> nil)then
	begin
		max:=maximoISBN(ABB);
		writeln('-----------------');
		writeln('el ISBN mas grande del arbol 1 es: ',max);
		min:=minimoISBN(ABB2);
		writeln('-----------------');
		writeln('el ISBN mas chico del arbol 2 es: ',min);
		cant:=0;
		writeln('-----------------');
		writeln('ingrese el numero de socio par buscar los prestamos en el primer arbol: ');
		readln(numSocio);
		cantPrestamos(ABB,cant,numSocio);
		writeln('-----------------');
		writeln('la cantidad de prestamos del numero de socio , ',numSocio,' en el arbol 1 es: ',cant);
		cant2:=0;
		writeln('-----------------');
		writeln('ingrese el numero de socio par buscar los prestamos en el primer arbol: ');
		readln(numSocio);
		cantPrestamos2(ABB2,cant2,numSocio);
		cargarArbolI(ABB,arbolI);
		cargarArbolII(ABB2,arbolII);
		ImprimirArboles(ABB,ABB2,arbolI,arbolII);
		writeln('-----------------');
		recorrerArbolEntre2I(ABB);
		recorrerArbolEntre2II(ABB2);
	end;
end.
