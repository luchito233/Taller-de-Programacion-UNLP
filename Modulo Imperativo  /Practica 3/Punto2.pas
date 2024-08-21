{2. Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de
producto 0. Un producto puede estar en más de una venta. Se pide:

i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto.

ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendida.
Nota: El módulo debe retornar los dos árboles.

b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.

c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.}

program punto2;
type
    str30 = string[30];
	venta = record
		codProducto:integer;
		fecha:str30;
		cantUniVendidas:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:venta;
		hI:arbol;
		hD:arbol;
	end;
	
	datoABB = record
		codProducto:integer;
		cantUniVendidas:integer;
	end;
	
	arbol2 = ^nodo2;
	nodo2 = record
		dato:datoABB;
		hI:arbol2;
		hD:arbol2;
	end;

procedure leerVenta(var v:venta);
var
	a:integer;
begin
	writeln('ingrese el codigo del producto');
	readln(v.codProducto);
	if(v.codProducto <> 0)then 
	begin
		writeln('ingrese la fecha');
		readln(v.fecha);
		writeln('cantida vendida');
		a:= random(11);
		writeln(a);
		v.cantUniVendidas:= a;
	end;
end;

procedure agregar(var a:arbol;v:venta);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:=v;
		a^.hI:=nil;
		a^.hD:=nil;
	end
	else
		if(a^.dato.codProducto <= v.codProducto) then agregar(a^.hD,v)
		else
			agregar(a^.hI,v);
end;

procedure cargarArbol(var a:arbol);
var
	v:venta;
begin
	leerVenta(v);
	while(v.codProducto <> 0) do
	begin
		agregar(a,v);
		leerVenta(v);
	end;
end;

procedure agregar2(var a:arbol2; codP:integer; cantVentas:integer);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.codProducto:=codP;
		a^.dato.cantUniVendidas:=cantVentas;
		a^.hI:=nil;
		a^.hD:=nil;
	end
	else
		if(a^.dato.codProducto = codP) then a^.dato.cantUniVendidas:=a^.dato.cantUniVendidas + cantVentas
		else
			if(a^.dato.codProducto <= codP) then agregar2(a^.hD,codP,cantVentas)
			else
				agregar2(a^.hI,codP,cantVentas);
end;

procedure recorrerArbol(a:arbol;var a2:arbol2);
begin
	if(a <> nil)then
	begin
		recorrerArbol(a^.hI,a2);
		agregar2(a2,a^.dato.codProducto,a^.dato.cantUniVendidas);
		recorrerArbol(a^.hD,a2);
	end;
end;


procedure cargarArboles(var a:arbol;var a2:arbol2);
begin
	a:=nil;
	a2:=nil;
	cargarArbol(a);
	if(a <> nil)then recorrerArbol(a,a2);
end;

procedure informarArbol(a:arbol2);
begin
	if(a <> nil)then
	begin
		informarArbol(a^.hI);
		writeln(a^.dato.codProducto);
		informarArbol(a^.hD);
	end;
end;

procedure cantProductos1(a:arbol;c:integer;var total:integer);
begin
	if(a <> nil) then
	begin
		cantProductos1(a^.hI,c,total);
		if(a^.dato.codProducto = c)then total:= total + a^.dato.cantUniVendidas;
		cantProductos1(a^.hD,c,total);
	end;
end;

function cantProductos2(a: arbol2; c: integer): integer;
begin
	if (a = nil) then
		cantProductos2 := 0  
	else
	begin
		if (a^.dato.codProducto = c) then
			cantProductos2 := a^.dato.cantUniVendidas + cantProductos2(a^.hI, c) + cantProductos2(a^.hD, c)
		else
			cantProductos2 := cantProductos2(a^.hI, c) + cantProductos2(a^.hD, c);
	end;
end;


var
	ABB:arbol;
	ABB2:arbol2;
	codigo:integer;
	sumaTotal:integer;
begin
	randomize;
	sumaTotal:=0;
	cargarArboles(ABB,ABB2);
	informarArbol(ABB2);
	writeln('ingrese el codigo a buscar en el primer arbol');
	readln(codigo);
	cantProductos1(ABB,codigo,sumaTotal);
	writeln('el total vendido del codigo en el primer arbol es: , ',codigo,' es: ',sumaTotal);
	writeln('ingrese el codgio a buscar en el segundo arbol');
	readln(codigo);
	sumaTotal:=cantProductos2(ABB2,codigo);
	writeln('el total vendido del codigo en el segundo arbol es: , ',codigo, 'es: ',sumaTotal);
	
end.
