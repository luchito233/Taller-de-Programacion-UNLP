program Punto5;
const
	df = 10;
type
	vector = array[1..df] of integer;



procedure cargarVector(var v:vector; i:integer);
var
	NUM:integer;
begin
	if( i <= df) then
	begin
		num:= random(100);
		v[i]:= num;
		i:=i+1;
		cargarVector(v,i);
	end;
end;

procedure imprimir(v:vector);
var
  i:integer;
begin
	for i:=1 to df do writeln('numero ',i,': ',v[i]);
end;

procedure OrdenarVector(var v:vector);
var
	i,j,aux:integer;
begin
	for i:=1 to df-1 do
	begin
		for j:= i+1 to df do
		begin
			if(v[j] < v[i]) then
			begin
				aux:=v[i];
				v[i]:=v[j];
				v[j]:=aux;
			end;
		end;
	end;
	imprimir(v);
end;

Procedure BusquedaDicotomica (v: vector; ini,fin,dato:integer; var pos: integer);
var
  medio:integer;
begin
  if(ini >= fin)then pos:= -1
  else
  begin
	medio:=(ini+fin) div 2;
	if v[medio] = dato then pos:=medio
	else
	   if(v[medio] < dato) then BusquedaDicotomica(v,medio+1,fin,dato,pos)
	   else
		 BusquedaDicotomica(v,ini,medio-1,dato,pos);
  end;
end;

var	
	vec:vector;
	i:integer;
	dato,pos:integer;
begin
	randomize;
	i:=1;
	cargarVector(vec,i);
	OrdenarVector(vec);
	readln(dato);
	BusquedaDicotomica(vec,1,df,dato,pos);
	if (pos <> - 1) then writeln('el numero: ',dato,' se encontro')
	else
	  writeln('el numero: ',dato,'no se encontro');
end.
