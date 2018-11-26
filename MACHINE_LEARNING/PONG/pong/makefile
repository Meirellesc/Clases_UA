COMP=g++
OPTS=-lm -lncurses
OBJECTS=TPaleta.o TPelota.o StdPijo.o TCampo.o TMarcador.o TEtiqueta.o TPartido.o TMenu.o TMensaje.o
EXE=pong

pong: $(OBJECTS) $(EXE).cc
	$(COMP) $(OBJECTS) $(OPTS) $(EXE).cc -o $(EXE) 

StdPijo.o: StdPijo.cc
TEtiqueta.o: TEtiqueta.cc StdPijo.o
TMensaje.o: TMensaje.cc TEtiqueta.o StdPijo.o
TMenu.o: TMenu.cc TEtiqueta.o StdPijo.o
TPaleta.o: TPaleta.cc StdPijo.o
TPelota.o: TPelota.cc StdPijo.o
TMarcador.o: TMarcador.cc TEtiqueta.o StdPijo.o
TCampo.o: TCampo.cc TPelota.o TPaleta.o StdPijo.o
TPartido.o: TPartido.cc TCampo.o TMarcador.o StdPijo.o

clean:
	rm -rf *.o *~

tar:
	tar cvzf ppoo.tgz *.cc *.h makefile readme.txt
