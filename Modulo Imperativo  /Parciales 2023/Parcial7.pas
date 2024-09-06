program parcial7;
const
	df = 12;
type

	sub_dia = 1..31;
	sub_mes = 1..12;
	
	compra = record
		videojuego:integer;
		cliente:integer;
		dia:sub_dia;
		mes:sub_mes;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:compra;
		hi,hd:arbol;
	end;
	
	vMeses = array[sub_mes]of integer;
	
procedure inicializarVector(var v:vMeses);
var
	i:integer;
begin
	for i:= 1 to df do v[i]:=0;
end;	

procedure leerCompra(var c:compra);
begin
	c.cliente:= random(100);
	if(c.cliente <> 0)then
	begin
		writeln('codigo de cliente: ',c.cliente);
		c.videojuego:= random(20000) + 1;
		writeln('codigo del videojuego: ',c.videojuego);
		c.mes:= random(12) + 1;
		writeln('mes: ',c.mes);
		c.dia:= random(31) + 1;
		writeln('dia: ',c.dia);
	end;
end;

procedure agregar(var a:arbol;var v:vMeses ;c:compra);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato:= c;
		v[a^.dato.mes]:=v[a^.dato.mes] + 1;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.cliente >= c.cliente)then agregar(a^.hi,v,c)
		else
			agregar(a^.hd,v,c);
end;

procedure cargarEstructuras(var a:arbol; var v:vMeses);
var
	c:compra;
begin
	leerCompra(c);
	while(c.cliente <> 0)do
	begin
		agregar(a,v,c);
		leerCompra(c);
	end;
end;

function buscarCliente(a:arbol; c:integer):integer;
begin
	if(a = nil)then buscarCliente:= 0
	else
		if(a^.dato.cliente = c)then buscarCliente:= 1 + buscarCliente(a^.hi,c)
		else
			if(a^.dato.cliente > c)then buscarCliente:= buscarCliente(a^.hi,c)
			else
				buscarCliente:= buscarCliente(a^.hd,c);
end;

procedure ordenarVector(var v:vMeses);
var
	i,j,pos:integer; item:integer;
begin
	for i:= 1 to df-1 do
	begin
		pos:= i;
		for j:= i+1 to df do if(v[j] > v[pos])then pos:=j;
		
		item := v[pos];
		v[pos] := v[i];
		v[i] := item;
	end;
end;

procedure informarVector(v:vMeses);
var
	i:integer;
begin
	for i:= 1 to df do writeln('en la pos: ',i,' cantidad: ',v[i]);
end;

var
	vector: vMeses;
	ABB:arbol;
	cant,codigo:integer;
begin
	randomize;
	ABB:=nil;
	inicializarVector(vector);
	cargarEstructuras(ABB,vector);
	writeln('ingrese el codigo a buscar: ');
	readln(codigo);
	cant:= buscarCliente(ABB,codigo);
	writeln('la cantidad de compras del codigo de cliente: ',codigo,' es: ',cant);
	ordenarVector(vector);
	informarVector(vector);
end.
