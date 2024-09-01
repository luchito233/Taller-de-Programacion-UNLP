program parcial3;
type
	sub_mes = 1..12;
	compra = record
		monto:real;
		cliente:integer;
		mes:sub_mes;
	end;
	
	vMontos = array[sub_mes]of real;
	
	compra2 = record
		cliente:integer;
		montos:vMontos;
	end;
	
	arbol = ^nodo;
	nodo = record
		dato:compra2;
		hi,hd:arbol;
	end;

procedure leerCompra(var c:compra);
begin
	c.cliente:= random(100);
	writeln('codigo de cliente: ',c.cliente);
	if(c.cliente <> 0)then
	begin
		c.monto:= random(1500) + 1;
		writeln('monto: ',c.monto);
		c.mes:= random(12) + 1;
		writeln('mes: ',c.mes);
	end;
end;

procedure inicializarVector(var v:vMontos);
var
	i:integer;
begin
	for i:= 1 to 12 do v[i]:= 0;
end;

procedure agregar(var a:arbol; c:compra);
begin
	if(a = nil)then
	begin
		new(a);
		a^.dato.cliente:=c.cliente;
		inicializarVector(a^.dato.montos);
		a^.dato.montos[c.mes]:=a^.dato.montos[c.mes] + c.monto;
		a^.hi:=nil;
		a^.hd:=nil;
	end
	else
		if(a^.dato.cliente = c.cliente)then a^.dato.montos[c.mes]:=a^.dato.montos[c.mes] + c.monto
		else
			if(a^.dato.cliente < c.cliente)then agregar(a^.hd,c)
			else
				agregar(a^.hi,c);
end;

function buscarNodo(a:arbol;codigo:integer):arbol;
begin
	if(a = nil)then buscarNodo:= nil
	else
		if(a^.dato.cliente = codigo)then buscarNodo:= a
		else
			if(a^.dato.cliente < codigo)then buscarNodo:=buscarNodo(a^.hd,codigo)
			else
				buscarNodo:=buscarNodo(a^.hi,codigo);
end;

procedure cargarArbol(var a:arbol);
var
	c:compra;
begin
	leerCompra(c);
	while(c.cliente <> 0)do
	begin
		agregar(a,c);
		leerCompra(c);
	end;
end;	

procedure calcularMaximo(v:vMontos; var mes:sub_mes);
var
	i:integer;
	max:real;
begin
	max:= -1;
	for i:= 1 to 12 do
	begin
		if(v[i] > max)then
		begin
			max:=v[i];
			mes:=i;
		end;
	end;
end;

procedure recorrerArbol(a:arbol; mes:sub_mes; var cant:integer);
begin
	if(a <> nil)then
	begin
		recorrerArbol(a^.hi,mes,cant);
		if(a^.dato.montos[mes] = 0)then cant:= cant + 1;
		recorrerArbol(a^.hd,mes,cant);
	end;
end;
	
var
	ABB:arbol;
	sub:arbol;
	mes:sub_mes;
	codigo:integer;
	mes2:sub_mes;
	cant:integer;
begin
	randomize;
	cargarArbol(ABB);
	writeln('ingrese el codigo de cliente a buscar en el arbol: ');
	readln(codigo);
	sub:=buscarNodo(ABB,codigo);
	if(sub <> nil)then 
	begin
		calcularMaximo(sub^.dato.montos,mes);
		writeln('el mes con mayor gasta del cliente: ',codigo,' es: ',mes);
	end
	else
		writeln('no se encuentra');
	writeln('ingrese el un mes: ');
	readln(mes2);
	cant:=0;
	recorrerArbol(ABB,mes2,cant);
	writeln('la cantidad de clientes que no gastaron en el mes de: ',mes2,' la cantidad seria de: ',cant);
end.
