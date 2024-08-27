{
1. El administrador de un edificio de oficinas, cuenta en papel, con la información del pago
de las expensas de dichas oficinas. Implementar un programa con:

a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.

b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.

c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo, debe
retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0.
Luego el programa debe informar el DNI del propietario o un cartel indicando que no
se encontró la oficina.

d) Un módulo recursivo que retorne el monto total de las expensas.
}

program punto1;
const
	df = 300;
type
	
	rango300 = 1..df;
		
	oficina = record
		codigo:integer;
		dni:integer;
		valorExpensas:real;
	end;
	
	vOficinas = array[rango300]of oficina;


procedure leerOficina(var o:oficina);
begin
	writeln('ingrese el codigo de indentificacion: ');
	readln(o.codigo);
	if(o.codigo <> -1)then
	begin
		writeln('ingrese el dni del propietario: ');
		readln(o.dni);
		writeln('ingrese el valor de la expensa: ');
		readln(o.valorExpensas);
	end;
end;

procedure cargarVector(var v:vOficinas; var dl:integer);
var
	o:oficina;
begin
	leerOficina(o);
	while(o.codigo <> -1)do
	begin
		dl:=dl +1;
		v[dl]:= o;
		leerOficina(o);
	end;
end;

procedure ordenarVector(var v:vOficinas; dl:integer);
var
	i,j,pos:integer;
	item:oficina;
begin
	for i:= 1 to dl-1 do
	begin
		pos:=i;
		for j:= i+1 to dl do 
			if v[j].codigo < v[pos].codigo then pos:=j;
	end;
	item:= v[pos];
	v[pos] := v[i];
	v[i]:= item;
end;

procedure busquedaDicotomica(v:vOficinas; code:integer ;var dni,pos:integer;fin,ini:integer);
var
	medio:integer;
begin
	if(ini > fin)then pos:= 0
	else
		medio:= (fin + ini) div 2;
		if(v[medio].codigo = code)then 
		begin
			pos:=medio;
			dni:=v[medio].dni;
		end
		else
			if(v[medio].codigo > code)then busquedaDicotomica(v,code,dni,pos,medio-1,ini)
			else
				busquedaDicotomica(v,code,dni,pos,medio+1,fin);
end;

function calcularMonto(v:vOficinas;dl:integer):real;
begin
	if(dl <> 0)then calcularMonto:= v[dl].valorExpensas + calcularMonto(v,dl-1);
end;

var
	vector:vOficinas;
	dl,ini:integer;
	pos,dni:integer;
	code:integer;
	montoTotal:real;
begin
	dl:=0;
	cargarVector(vector,dl);
	ordenarVector(vector,dl);
	writeln('ingrese el codigo a buscar en el vector de manera dicotomica: ');
	read(code);
	ini:=1;
	busquedaDicotomica(vector,code,dni,pos,dl,ini);
	if(pos <> 0)then writeln('el codigo: ',pos,'se encuentra en el vector y el dni del propietario es: ',dni)
	else
		writeln('no se encontro la pos en el vector');
	montoTotal:=calcularMonto(vector,dl);
	writeln('el monto total entre todas las oficinas es: ',montoTotal);
end.
