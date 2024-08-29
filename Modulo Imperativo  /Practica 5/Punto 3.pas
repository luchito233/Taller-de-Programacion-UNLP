{
3. Un supermercado requiere el procesamiento de sus productos. De cada producto se
conoce código, rubro (1..10), stock y precio unitario. Se pide:

a) Generar una estructura adecuada que permita agrupar los productos por rubro. A su
vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo
más eficiente posible. La lectura finaliza con el código de producto igual a -1.

b) Implementar un módulo que reciba la estructura generada en a), un rubro y un código
de producto y retorne si dicho código existe o no para ese rubro.

c) Implementar un módulo que reciba la estructura generada en a), y retorne, para cada
rubro, el código y stock del producto con mayor código.

d) Implementar un módulo que reciba la estructura generada en a), dos códigos y
retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores
ingresados.
}

program Punto3;
const
	df = 10;
type
	
	rango10 = 1..df;
	
	producto = record
		codigo:integer;
		rubro:rango10;
		stock:integer;
		precioUnidad:real;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:producto;
		hi,hd:arbol;
	end;
	
	vRubro = array[rango10] of arbol;

procedure inicializarVector(var v:vRubro);
var
	i:integer;
begin
	for i:= 1 to df do v[i]:=nil;
end;

procedure leerProducto(var p:producto);
begin
	writeln('ingrese el codigo de producto: ');
	read(p.codigo);
	if(p.codigo <> -1)then
	begin
		writeln('ingrese el rubro: ');
		read(p.rubro);
		writeln('ingrese el stock del producto: ');
		read(p.stock);
		writeln('ingrese el precio unitario: ');
		read(p.precioUnidad);
	end;
end;

procedure agregar(var a:arbol; p:producto);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:=p;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.codigo <= p.codigo)then agregar(a^.hd,p)
		else
			agregar(a^.hi,p);
end;

procedure cargarVector(var v:vRubro);
var
	produ:producto;
begin
	leerProducto(produ);
	while(produ.codigo <> -1)do
	begin
		agregar(v[produ.rubro],produ);
		leerProducto(produ);
	end;
end;
	
function buscarCodigo(a:arbol; cod:integer):boolean	;
begin
	if(a = nil)then buscarCodigo:=false
	else
		if(a^.dato.codigo = cod)then buscarCodigo:=true
		else
			if(a^.dato.codigo < cod)then buscarCodigo:=buscarCodigo(a^.hd,cod)
			else
				buscarCodigo:=buscarCodigo(a^.hi,cod);
end;

procedure calcularMaximo(a:arbol; var maxC,maxR:integer);
begin
	if(a^.hd <> nil)then calcularMaximo(a^.hd,maxC,maxR)
	else
	begin
		maxC:=a^.dato.codigo;
		maxR:=a^.dato.stock; 
	end;
end;

function contarEntre2Codigos(a:arbol; min,max:integer):integer;
begin
	if(a = nil)then contarEntre2Codigos:=0
	else
		if(a^.dato.codigo < min)then contarEntre2Codigos:=contarEntre2Codigos(a^.hd,min,max)
		else
			if(a^.dato.codigo > max)then contarEntre2Codigos:=contarEntre2Codigos(a^.hi,min,max)
			else
				contarEntre2Codigos:= 1 + contarEntre2Codigos(a^.hd,min,max) + contarEntre2Codigos(a^.hi,min,max);
end;


procedure recorrerRubros(v:vRubro);
var
	i:integer;
	maxCod,maxStock:integer;
	min,max:integer;
	cantCodigos:integer;
begin
	writeln('ingrese el primer codigo (lado derecho): ');
	read(min);
	writeln('ingrese el segundo codigo (lado izquierdo): ');
	read(max);
	for i:=1 to df do
	begin
		if(v[i] <> nil)then
		begin
			cantCodigos:=0;
			maxCod:=-1;
			maxStock:=-1;
			calcularMaximo(v[i],maxCod,maxStock);
			writeln('el codigo mayor en el rubro, ',i,' codigo: ',maxCod,', stock: ',maxStock);
			cantCodigos:=contarEntre2Codigos(v[i],min,max);
			writeln('la cantidad de codigos entre,',min,' y ',max,'en el rubro: ',i,' es de: ',cantCodigos);
		end;
	end;
end;

	
var
	vector:vRubro;
	rubro:rango10;
	codigo:integer;
	esta:boolean;
begin
	inicializarVector(vector);
	cargarVector(vector);
	writeln('--------------------');
	writeln('ingrese un rubro: ');
	read(rubro);
	writeln('ingrese el codigo a buscar en el rubro: ');
	read(codigo);
	esta:= buscarCodigo(vector[rubro],codigo);
	if(esta)then writeln('el codigo se encuentra en el arbol')
	else
		writeln('el codigo no se encontro');
	recorrerRubros(vector);
end.
