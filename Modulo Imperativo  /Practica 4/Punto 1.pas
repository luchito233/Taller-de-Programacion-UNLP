{1. Implementar un programa modularizado para una librería que:

a. Almacene los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados la cantidad total de
unidades vendidas y el monto total. De cada venta se lee código de venta, código del
producto vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las
ventas finaliza cuando se lee el código de venta -1.

b. Imprima el contenido del árbol ordenado por código de producto.

c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.
 
d. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.

e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).}

program punto1;
type
	
	
	venta = record
		codigoV:integer;
		codProducto:integer;
		cantUniVendidas:integer;
		precioUnidad:real;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:venta;
		hi:arbol;
		hd:arbol;
	end;

procedure leerVenta(var v:venta);
begin
	writeln('ingres el codigo de la venta');
	readln(v.codigoV);
	if(v.codigoV <> -1)then
	begin
		writeln('ingrese el codigo del producto vendido');
		readln(v.codProducto);
		writeln('ingrese la cantidad de unidades vendidas');
		readln(v.cantUniVendidas);
		writeln('ingrese el precio por unidad');
		readln(v.precioUnidad);
	end;
end;	

procedure agregar(var a:arbol;v:venta);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:=v;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codProducto <= v.codProducto)then agregar(a^.hi,v)
		else
			agregar(a^.hd,v);
end;
	
procedure cargarArbol(var a:arbol);
var
	v:venta;
begin
	leerVenta(v);
	while(v.codigoV<> -1)do
	begin
		agregar(a,v);
		leerVenta(v);
	end;
end;	

procedure informarArbol(a:arbol);
begin
	if(a <> nil)then
	begin
		informarArbol(a^.hi);
		writeln('codigo de venta: ',a^.dato.codigoV);
		writeln('codigo de producto: ',a^.dato.codProducto);
		writeln('cantidad de unidades vendidas: ',a^.dato.cantUniVendidas);
		writeln('precio por unidad: ',a^.dato.precioUnidad);
		informarArbol(a^.hd);
	end;
end;

procedure mayorcantventas(a:arbol;var maxV,maxC:integer);
begin
	if(a <> nil) then
	begin
		mayorcantventas(a^.hi,maxV,maxC);
		if(maxV < a^.dato.cantUniVendidas)then
		begin
			maxV:=a^.dato.cantUniVendidas;
			maxC:=a^.dato.codProducto;
		end;
		mayorcantventas(a^.hd,maxV,maxC);
	end;
end;

procedure recorrerArbol(a:arbol; c:integer; var cant:integer);
begin
	if(a <> nil) then
	begin
		recorrerArbol(a^.hi,c,cant);
		if(a^.dato.codProducto < c)then cant:=cant + 1; 
		recorrerArbol(a^.hd,c,cant);
	end;
end;
	
procedure recorrerArbolEntre(a:arbol;var suma:real;min,max:integer);	
begin
	if(a <> nil)then
	begin
		if(a^.dato.codProducto > min) and (a^.dato.codProducto < max) then suma:=suma + (a^.dato.cantUniVendidas * a^.dato.precioUnidad);
		if(a^.dato.codProducto > min)then recorrerArbolEntre(a^.hi,suma,min,max);
		if(a^.dato.codProducto < max)then recorrerArbolEntre(a^.hd,suma,min,max);
	end;
end;

var
	ABB:arbol;
	maxVentas:integer;
	maxCod:integer;
	cantCod,cod:integer;
	min,max:integer;
	sumaTotal:real;
begin
	cargarArbol(ABB);
	if(ABB <> nil)then
	begin
		informarArbol(ABB);
		maxVentas:=-1;
		mayorcantventas(ABB,maxVentas,maxCod);
		writeln('el codigo de producto con mayor cantidad de unidades vendidas es ',maxCod);
		writeln('ingrese el codigo a eleccion');
		readln(cod);
		recorrerArbol(ABB,cod,cantCod);
		writeln('la cantidad de codigos menores a: ',cod,' son: ',cantCod);
		sumaTotal:= 0;
		writeln('ingrese el lado derecho ');
		readln(min);
		writeln('ingrese el lado izquierdo ');
		readln(max);
		recorrerArbolEntre(ABB,sumaTotal,min,max);
		writeln('la suma total de precios entre los numeros ingresados es: ',sumaTotal);
	end;
end.
