#include "TPartido.h"
#include <cmath>

//#define MACHINE_LEARNING
#define MAQ0   4
#define MAQ1   5

typedef enum {
   s_jugadorVY = 0,
   s_enemigoYRel,
   s_enemigoVY,
   s_pelotaXRel,
   s_pelotaYRel,
   s_pelotaVX, 
   s_pelotaVY,
   s_teclaArriba,
   s_teclaAbajo,
   s_N_EstadosJuego
} SEstadoJuego;

double vEstadoJuego[s_N_EstadosJuego];

///////////////////////////////////////////////////////////
// Constructor:                                          //
// * Saben aquel que diu que... xDD.                     //
///////////////////////////////////////////////////////////
TPartido::TPartido ()
{
   // El partido por defecto es una demo maquina - maquina en el campo 0
   ctrlIzq = ctrlDcha = false;
   PonCampo (0); nivel = 0;
   maxtiempo = -1; maxgoles = -1;
   FPS = 35;
}

///////////////////////////////////////////////////////////
// Destructor:                                           //
// * Neverending stooOoooOoryyy...                       //
///////////////////////////////////////////////////////////
TPartido::~TPartido () { /* ...nanana nanana nanana... */ }

///////////////////////////////////////////////////////////
// PonControles:                                         //
// * Tu, humano, yo, maquina, nosotros amigos xDDD       //
///////////////////////////////////////////////////////////
void
TPartido::PonControles (bool pctrlIzq, bool pctrlDcha)
{ ctrlIzq = pctrlIzq; ctrlDcha = pctrlDcha; }

///////////////////////////////////////////////////////////
// PonCampo:                                             //
// * Nou Camp, El Sardinero... xDDD                      //
///////////////////////////////////////////////////////////
void
TPartido::PonCampo (int pnumCampo)
{
   int mx = STDP::TamX();
   int my = STDP::TamY();

   switch (pnumCampo)
   {
      case 0:
      {
         marcador.PonMarco     (0, 0, mx-1, 2);
         marcador.PonAtributos (' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_CIAN);
         marcador.PonPosEtiq   (0, (mx - 15)/2, 1);
         marcador.PonAtrEtiq   (0, STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_CIAN);
         marcador.PonPosEtiq   (1, 5, 1);
         marcador.PonAtrEtiq   (1, STDP_A_NEGRITA,STDP_C_AZUL,STDP_C_CIAN);
         marcador.PonPosEtiq   (2, mx - (5 + 10), 1);
         marcador.PonAtrEtiq   (2, STDP_A_NORMAL,STDP_C_AMARILLO,STDP_C_CIAN);

         campo.PonLimites      (0, 3, mx-1, my-1);
         campo.TipoCampo       (' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_VERDE);
         campo.TipoPelota      ('@',STDP_A_NORMAL,STDP_C_MAGENTA,STDP_C_VERDE);
         campo.TipoPaletas     (' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AZUL,
                                ' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AMARILLO);
         campo.LargoPaletas    (4, 4);
         break;
      }
      case 1:
      {
         marcador.PonMarco    (3, my-4, mx-3, my-4);
         marcador.PonAtributos('-',STDP_A_NORMAL,STDP_C_CIAN,STDP_C_BLANCO);
         marcador.PonPosEtiq  (0, (mx - 20) / 2, 0);
         marcador.PonAtrEtiq  (0,STDP_A_NEGRITA,STDP_C_NEGRO,STDP_C_BLANCO);
         marcador.PonPosEtiq  (1, 3, 0);
         marcador.PonAtrEtiq  (1,STDP_A_NEGRITA,STDP_C_ROJO,STDP_C_BLANCO);
         marcador.PonPosEtiq  (2, (mx - 16), 0);
         marcador.PonAtrEtiq  (2,STDP_A_NEGRITA,STDP_C_AZUL,STDP_C_BLANCO);

         campo.PonLimites (5, 5, mx-5, my-5);
         campo.TipoCampo  ('*',STDP_A_NEGRITA,STDP_C_NEGRO,STDP_C_VERDE);
         campo.TipoPelota ('@',STDP_A_NEGRITA,STDP_C_AMARILLO,STDP_C_VERDE);
         campo.TipoPaletas(' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_ROJO,
                           ' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AZUL);
         campo.LargoPaletas(2 , 2);
         break;
      }
      case 2:
      {
         marcador.PonMarco    (mx-21, 5, mx-6, my-6);
         marcador.PonAtributos(' ',STDP_A_NORMAL,STDP_C_CIAN,STDP_C_VERDE);
         marcador.PonPosEtiq  (0, 1,7);
         marcador.PonAtrEtiq  (0,STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_VERDE);
         marcador.PonPosEtiq  (1,3,2);
         marcador.PonAtrEtiq  (1,STDP_A_NEGRITA,STDP_C_ROJO,STDP_C_VERDE);
         marcador.PonPosEtiq  (2,3,12);
         marcador.PonAtrEtiq  (2,STDP_A_NEGRITA,STDP_C_AZUL,STDP_C_VERDE);
         campo.PonLimites (5, 4, mx-23, my-5);
         campo.TipoCampo  (' ',STDP_A_NEGRITA,STDP_C_NEGRO,STDP_C_CIAN);
         campo.TipoPelota ('O',STDP_A_NEGRITA,STDP_C_AMARILLO,STDP_C_CIAN);
         campo.TipoPaletas(' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_ROJO,
                           ' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AZUL);
         campo.LargoPaletas(5 , 5);

         break;
      }
      case 3:
      {
         marcador.PonMarco    (2, my-5, mx-3, my-3);
         marcador.PonAtributos(' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AMARILLO);
         marcador.PonPosEtiq  (0,(mx-20)/2,1);
         marcador.PonAtrEtiq  (0,STDP_A_NORMAL,STDP_C_AZUL,STDP_C_AMARILLO);
         marcador.PonPosEtiq  (1,3,1);
         marcador.PonAtrEtiq  (1,STDP_A_NEGRITA,STDP_C_ROJO,STDP_C_AMARILLO);
         marcador.PonPosEtiq  (2,mx-15,1);
         marcador.PonAtrEtiq  (2,STDP_A_NEGRITA,STDP_C_VERDE,STDP_C_AMARILLO);
         campo.PonLimites (1, 3, mx-2, my-7);
         campo.TipoCampo  ('=',STDP_A_NEGRITA,STDP_C_NEGRO,STDP_C_AZUL);
         campo.TipoPelota ('0',STDP_A_NEGRITA,STDP_C_AMARILLO,STDP_C_AZUL);
         campo.TipoPaletas(' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_ROJO,
                           ' ',STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_VERDE);
         campo.LargoPaletas(3 , 3);

         break;
      }
      default:
      {
         pnumCampo = numCampo;
         break;
      }
   }

   numCampo = pnumCampo;
}

///////////////////////////////////////////////////////////
// PonNivel:                                             //
// * Nivel de inteligencia de la maquina.                //
///////////////////////////////////////////////////////////
void
TPartido::PonNivel (int pnivel)
{ if (pnivel < _MAX_NIVEL_) nivel = pnivel; }

///////////////////////////////////////////////////////////
// PonMaxTiempo:                                         //
// * Tiempo maximo de juego (pa jugar partidos a time).  //
//   Un tiempo negativo indica tiempo ilimitado.         //
///////////////////////////////////////////////////////////
void
TPartido::PonMaxTiempo (int pmaxtiempo) { maxtiempo = pmaxtiempo; }

///////////////////////////////////////////////////////////
// PonMaxGoles:                                          //
// * Numero de goles a los que se acaba el partido.      //
//   Un numero negativo indica goles ilimitados.         //
///////////////////////////////////////////////////////////
void
TPartido::PonMaxGoles (int pmaxgoles) { maxgoles = pmaxgoles; }

///////////////////////////////////////////////////////////
// PonFPS:                                               //
// * Dise acuantos fotogramas por segundo mostraremos.   //
///////////////////////////////////////////////////////////
void
TPartido::PonFPS (double pFPS) { if (pFPS>0) FPS = pFPS; }

#include <fstream>

///////////////////////////////////////////////////////////
// Jugar:                                                //
// * Desarrollo del encuentro. Devuelve el numero del    //
// jugador ganador (1,2) o 0 en caso de empate.          //
// * FPS = Fotogramas por segundo (velocidad).           //
///////////////////////////////////////////////////////////
int
TPartido::Jugar ()
{
   const double inc = 1.0/FPS * CLOCKS_PER_SEC;
   double       t, aum1, aum2;
   bool         Fin = false;
   int          gol;
   char         cad[30];
   TMensaje     mensaje;

   // Bucle principal
   mensaje.PonSombra ();
   campo.Inicializar();
   marcador.Inicializar();
   std::ofstream file("datos.csv", std::ofstream::out | std::ios_base::app); 
   
   // A ver quien saca
   if (rand() % 2) Saque (PORTERIA_IZQ);
              else Saque (PORTERIA_DCHA);
   do
   {
      // Tomamos tiempo
      t = clock() + inc;

      // Dibujamos
      STDP::BorraPantalla();
      campo.Dibujar();
      marcador.Dibujar();
      STDP::Refrescar();

      // Calcular estado del juego
      vEstadoJuego[s_jugadorVY]   = campo.PaletaIzqVel();
      vEstadoJuego[s_enemigoYRel] = campo.PaletaDchaY() - campo.PaletaIzqY();
      vEstadoJuego[s_enemigoVY]   = campo.PaletaDchaVel();
      vEstadoJuego[s_pelotaXRel]  = campo.PelotaX() - campo.PaletaIzqX();
      vEstadoJuego[s_pelotaYRel]  = campo.PelotaY() - campo.PaletaIzqY();
      vEstadoJuego[s_pelotaVX]    = campo.PelotaVX();
      vEstadoJuego[s_pelotaVY]    = campo.PelotaVY();
      vEstadoJuego[s_teclaArriba] = 0;
      vEstadoJuego[s_teclaAbajo]  = 0;
     
      // Comprobamos teclado
      switch (STDP::ObtenTecla())
      {
         case 'A':
         case 'a':
         {
            vEstadoJuego[s_teclaArriba] = 1;
            aum1 = -0.2;
            break;
         }
         case 'Z':
         case 'z':
         {
            vEstadoJuego[s_teclaAbajo] = 1;
            aum1 = 0.2;
            break;
         }
         case STDP_T_CURSOR_ARRIBA:
         case 'L':
         case 'l':
         {
            vEstadoJuego[s_teclaArriba] = 1;
            aum2 = -0.2;
            break;
         }
         case STDP_T_CURSOR_ABAJO:
         case '.':
         case ':':
         {
            vEstadoJuego[s_teclaAbajo] = 1;
            aum2 = 0.2;
            break;
         }
         case STDP_T_ESCAPE:
         {
            mensaje.PonTitulo ("Juego en pausa");
            mensaje.PonTexto  ("Desea finalizar el partido?");
            mensaje.PonTipo   (TMENSAJE_T_SINO);
            marcador.PararTiempo();
            if (mensaje.Ejecutar() == TMENSAJE_R_SI) Fin = true;
            marcador.ContarTiempo();
            break;
         }
         default:
         {
            aum1 = aum2 = 0.0;
            break;
         }
      }

      // Escribimos a fichero
      file << vEstadoJuego[0];
      for(unsigned ki=1; ki < s_N_EstadosJuego; ki++)
         file << ";" << vEstadoJuego[ki];
      file << "\n";

      // Realizamos calculos de inteligencia (jiji)
      if  (!ctrlIzq) aum1=Inteligencia (1);
      if (!ctrlDcha) aum2=Inteligencia (2);

      // Realizamos movimientos
      switch (campo.Mover (aum1, aum2))
      {
         case -1:
         {
            EfectoGol (PORTERIA_IZQ);
            if (marcador.IncPuntos2() == maxgoles) Fin = true;
            else Saque(PORTERIA_IZQ);
            break;
         }
         case 1:
         {
            EfectoGol (PORTERIA_DCHA);
            if (marcador.IncPuntos1() == maxgoles) Fin = true;
            else Saque(PORTERIA_DCHA);
            break;
         }
      }
      // Comprobamos el tiempo de juego
      if (maxtiempo > 0 && marcador.Tiempo() >= maxtiempo) Fin = true;

      // Esperamos a que toque el siguiente frame
      while (t > clock());
   } while (!Fin);

   file.close();

   // A ver quien gana...
   if (marcador.Puntos1() > marcador.Puntos2()) gol = 1;
   else if (marcador.Puntos2() > marcador.Puntos1()) gol = 2;
   else gol = 0;

   // Preparamos y mostramos el mensaje
   mensaje.PonAncho  (26);
   mensaje.PonTitulo ("Fin del partido");
   if (gol != 0) sprintf (cad, "Gana el jugador %i", gol);
            else sprintf (cad, "Empate!");
   mensaje.PonTexto  (cad);
   mensaje.PonTipo   (TMENSAJE_T_OK);
   mensaje.PonMarco  (' ', STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_AMARILLO);
   mensaje.PonFondo  (' ', STDP_A_NORMAL,STDP_C_NEGRO,STDP_C_NEGRO);
   campo.Dibujar();
   marcador.Dibujar();
   mensaje.Ejecutar ();

   return gol;
}

///////////////////////////////////////////////////////////
// HumanoIzq:                                            //
// * Dise si el que ta a la izquierda es o no humano.    //
// (jue, como suena eso... xDDD)                         //
///////////////////////////////////////////////////////////
bool
TPartido::HumanoIzq () const { return ctrlIzq; }

///////////////////////////////////////////////////////////
// HumanoDcha:                                           //
// * I know this love's for ever...larlara NoMatterWhat..//
///////////////////////////////////////////////////////////
bool
TPartido::HumanoDcha () const { return ctrlDcha; }

///////////////////////////////////////////////////////////
// Campo:                                                //
// * Devuerve el numero del campo en que se esta jugando.//
///////////////////////////////////////////////////////////
int
TPartido::Campo () const { return numCampo; }

///////////////////////////////////////////////////////////
// Nivel:                                                //
// * Devuerve el nivel de la maquina.                    //
///////////////////////////////////////////////////////////
int
TPartido::Nivel () const { return nivel; }

///////////////////////////////////////////////////////////
// EfectoGol:                                            //
// * Efecto grafico para cuando se mete un gol.          //
///////////////////////////////////////////////////////////
void
TPartido::EfectoGol (int lado)
{
   char cad[30];
   if (lado == PORTERIA_IZQ) lado = 2; else lado = 1;
   sprintf(cad, "Gol Del Jugador %i!!!", lado);
   int TX = STDP::TamX();
   int TY = STDP::TamY();
   int lon = strlen (cad);
   int x = campo.CentroX() - lon/2;
   int y = campo.CentroY();
   float posx[lon], posy[lon], vx[lon], vy[lon];
   int i,j,k;
   double t;

   // Paramos el tiempo
   marcador.PararTiempo ();

   // Calculamos posiciones y velocidades
   for (i=0; i<lon; i++)
   {
      int fx, fy, l;
      l = rand() % 4;
      fx = (rand() % (2*TX-1)) - (TX-1);
      fy = (rand() % (2*TY-1)) - (TY-1);
      switch (l)
      {
         case 0: { fx = 0; break; }
         case 1: { fy = TY; break; }
         case 2: { fx = TX; break; }
         case 3: { fy = 0; break; }
      }
      posx[i] = (float)(x + i); posy[i] = (float)y;
      vx[i] = (fx-posx[i])/(FPS/2);
      vy[i] = (fy-posy[i])/(FPS/2);
   }

   // Aparece el letrero de GOL y parpadea en colores
   for (k = 0; k < FPS/8; k++)
   {
      for (i = STDP_C_NEGRO; i < STDP_C_BLANCO; i++)
      {
         // Tomamos el tiempo
         t = clock() + 1.0/FPS * CLOCKS_PER_SEC;

         // Primero dibujamos el campo y el marcador
         STDP::BorraPantalla();
         campo.Dibujar();
         marcador.Dibujar();

         // Y ahora el efecto del gol
         STDP::PonCursor (x,y);
         for(j=0; j<strlen(cad); j++)
         {
            STDP::CambiaColor (STDP_A_NEGRITA,(j+i+1)%8, i%8);
            STDP::EscribeCh   (cad[j]);
         }

         // Refrescamos la pantalla y esperamos
         STDP::Refrescar();
         while (t > clock());
      }
   }

   // El letrero se dispersa y aumenta el marcador
   int AtrMrc = marcador.AtributoEtiq (lado);
   int CTMrc = marcador.ColorTextoEtiq (lado);
   int CFMrc = marcador.ColorFondoEtiq (lado);
   for (k=0; k<FPS; k++)
   {
      // Tomamos el tiempo
      t = clock() + 1.0/FPS * CLOCKS_PER_SEC;

      // Dibujamos campo y marcador
      STDP::BorraPantalla ();
      campo.Dibujar();
      marcador.Dibujar();

      // Dibujamos las letras
      for (i=0; i<lon; i++)
      {
         int px, py;

         // Recalculamos las posiciones
         posx[i] += vx[i];
         posy[i] += vy[i];
         px = (int)(posx[i] + 0.5);
         py = (int)(posy[i] + 0.5);

         // Pintamos (si debemos)
         if (px >= 0 && px < TX && py >= 0 && py < TY )
         {
            STDP::CambiaColor (STDP_A_NEGRITA, px%8, py%8);
            STDP::PonCursor   (px, py);
            STDP::EscribeCh   (cad[i]);
         }
      }

      // Repintamos el marcador
      marcador.PonAtrEtiq (lado, STDP_A_NEGRITA, k%8, ((int)t)%8);

      // Refrescamos y esperamos
      STDP::Refrescar ();
      while (t > clock());
   }

   // Restauramos los atributos de la etiqueta del marcador
   marcador.PonAtrEtiq (lado, AtrMrc, CTMrc, CFMrc);

   // Volvemos a poner en marcha el crono
   marcador.ContarTiempo();
}

///////////////////////////////////////////////////////////
// Saque:                                                //
// * Realiza el saque de centro en la direccion indicada.//
///////////////////////////////////////////////////////////
void
TPartido::Saque (int Dir)
{
   TEtiqueta sac;
   char cad[29];
   int x = campo.CentroX();
   int frames = campo.LimiteMaxY() - campo.CentroY() + 1;
   double t;

   // Paramos el tiempo
   marcador.PararTiempo ();

   sprintf(cad, "Saca el jugador %i", (Dir==PORTERIA_IZQ) ? 1 : 2);
   sac.PonCadena    (cad);
   sac.PonAtributos (STDP_A_PARPADEO,STDP_C_BLANCO,STDP_C_NEGRO);
   sac.Posicionar   ((x - strlen(cad)/2), campo.CentroY() - 2);

   for (int y=campo.LimiteMaxY(); y>=campo.CentroY(); y--)
   {
      // Tomamos el tiempo
      t = clock() + 1.0/frames * CLOCKS_PER_SEC;

      // Ponemos la pelota
      campo.PosPelota (x, y);

      // Dibujamos todo
      STDP::BorraPantalla();
      campo.Dibujar();
      marcador.Dibujar();
      sac.Dibujar();
      STDP::Refrescar();

      // Esperamos
      while (t>clock());
   }

   // Hacemos 1 ultima espera de preparacion
   t = clock() + 0.5 * CLOCKS_PER_SEC;
   while (t > clock());

   // Restauramos el tiempo, paramos las paletas y sacamos
   marcador.ContarTiempo ();
   campo.Sacar (Dir);
   campo.VelPaletas (0.0, 0.0);
}

///////////////////////////////////////////////////////////
// Inteligencia:                                         //
// * Controla las paletas de la maquina.                 //
///////////////////////////////////////////////////////////
const unsigned s_kinputs = s_N_EstadosJuego-1;
double s_w[24][s_kinputs] = {
     { 644.2, -166.251, 12.0085, -27.3286, 99.5423, -74.4238, -1198.33, -128 }
   , { -2.6, 51.8678, 1.00819, -30.6251, 85.5748, -9.01556, 2.74653, -1 }
   , { 199.8,  0, 0, -8.7441, -43.5157, -135.701, -451.175 }
   , { -123.6, 0, 0, -5.82508, 19.2405, -143.82, 119.563, -68 }
   , { 199.8, -31.2072, -17.6677, -8.7441, -43.5157, -135.701, -451.175 }
   , { -123.6, 1.29211, 38.0328, -5.82508, 19.2405, -143.82, 119.563, -68 }
   , { -2319, 58.0342, 82.4193, -4.17163, -13.4985, -119.845, 345.776, -248 }
   , { 2216.8, -48.9395, -50.1821, -5.03074, 18.7431, -489.705, -414.061, -390 }
   , {  -69.4,       0,       0, -55.5974, -36.7335, -95.7131, -176.882, 185 }
   , {  -92.2,       0,       0, -62.3415,  18.6742, -59.3649,  317.805, 174 }
   , {    566, 2.55401, 13.3497, -31.5007, -59.0554,   13.818, -255.623, 114 }
   , { -785.2, 109.145, 148.471, -33.0644, -45.5554, -243.011,  1010.17, 251 }
};

unsigned h(unsigned wn, const double* st) {
   double hval = 0;

   for(unsigned i=0; i < s_kinputs-1; i++)
      hval += st[i] * s_w[wn][i];

   return (hval + s_w[wn][s_kinputs-1] > 0) ? 1 : 0;
}

double
TPartido::Inteligencia (int jugador)
{
   double aum;

   // Calculos necesarios para todos los niveles
   float CentroPala, VelPala;
   float PosYBola = campo.PelotaY();
   float MaxDist  = (float)(campo.LimiteMaxY() - campo.LimiteMinY() + 1);
   int   prob = rand() % 100 + 1;

   if (jugador == 1)
   {
      CentroPala = campo.PaletaIzqY()
                   + ((float)(campo.PaletaIzqLargo()))/2;
      VelPala = campo.PaletaIzqVel();
   }
   else
   {
      CentroPala = campo.PaletaDchaY()
                   + ((float)(campo.PaletaDchaLargo()))/2;
      VelPala = campo.PaletaDchaVel();
   }

#ifndef MACHINE_LEARNING
   // Devolvemos movimiento segun el nivel
   switch (nivel)
   {
      // Nivel 4: Una pared no lo hace mejor
      // Nivel 3: Soy un hacha
      case 4:
      case 3:
      {
         int primero = (nivel == 3) ? 30 : 60;
         int segundo = (nivel == 3) ? 98 : 101;

         // % de veces que sigue con precision
         if (prob < primero)
         {
            float dist = fabs(CentroPala - PosYBola);

            if      (CentroPala > PosYBola) aum = -(dist/MaxDist) - VelPala;
            else if (CentroPala < PosYBola) aum = dist/MaxDist - VelPala;
                                       else aum = 0.0;
         }
         // % de veces que sigue sin precision
         else if (prob < segundo)
         {
            if      (CentroPala > PosYBola) aum = -0.15;
            else if (CentroPala < PosYBola) aum = 0.15;
                                       else aum = (prob > 40) ? 0.0 : 0.15;
         }
         else
            aum = ((float)((rand() % 20) - 10))/10.0;

         break;
      }
      // Nivel Me he entrenado en el pasillo
      // Nivel Juego como mi abuela
      case 2:
      case 1:
      {
         //  % de las veces sigue a la bola
         if (prob < (80 + nivel*6))
         {
             if      (CentroPala > PosYBola) aum = -0.2;
             else if (CentroPala < PosYBola) aum = 0.2;
                                       else aum = 0.0;
         }
         else
            aum = ((float)((rand() % 20) - 10))/10.0;

         break;
      }

      // Nivel Soy un colador
      case 0:
      default:
      {
         aum = ((float)((rand() % 20) - 10))/10.0;
         break;
      }
   }
#else
   unsigned b0 = h(MAQ0, vEstadoJuego);
   unsigned b1 = h(MAQ1, vEstadoJuego);

   if      ( b0 && !b1) aum = -0.2;      
   else if (!b0 &&  b1) aum = +0.2;
#endif

   return aum;
}

