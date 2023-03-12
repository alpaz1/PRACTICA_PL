package alex;

%%
%char
%line
%column
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yycolumn+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
parteDecimal = {digito}* {digitoPositivo}
numeroEntero = [\+\-]?{parteEntera}
numeroReal = [\+\-]?{parteEntera}\.{parteDecimal}
inputCharacter = [^\r\n]
separador = [ \t\r\b\n]
comentario = "//"{inputCharacter}*\n?

operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = \/
operadorMod = \%

operadorMayor = \>
operadorMenor = \<
operadorMayorIgual = \>\=
operadorMenorIgual = \<\=
operadorDistinto = \!\=
operadorIgualdad = \=\=

operadorAnd = yy
operadorOr = oo
operadorNegacion = no


igual = \=
coma  = \,
punto = \.
puntoYComa = ;
dosPuntos = :
parentesisApertura = \(
parentesisCierre = \)
corcheteApertura = \[
corcheteCierre = \]
llaveApertura = \{
llaveCierre = \}


int = entero
void = vacio
float = flotante
bool = buleano
enum = enum

true = verdad
false = mentira
new = nuevo

while = mientras
for = paraCada
if = si
else = sino
struct = estructura
switch = selecciona
case = caso
break = \¡para\!
default = porDefecto
return = devuelve
print = imprime
read = lee
main = principal


identificador = {letra}({letra}|{digito}|"_")*



%%
{separador}               {}
{comentario}              {}

{numeroEntero}            {return ops.unidadEnt();}
{numeroReal}              {return ops.unidadReal();}

{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{operadorMod}             {return ops.unidadMod();}

{operadorMayor}           {return ops.unidadMayor();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorMayorIgual}      {return ops.unidadMayorIgual();}
{operadorMenorIgual}      {return ops.unidadMenorIgual();}
{operadorDistinto}        {return ops.unidadDistinto();}
{operadorIgualdad}        {return ops.unidadIgualdad();}

{operadorAnd}              {return ops.unidadAnd();}
{operadorOr}              {return ops.unidadOr();}
{operadorNegacion}        {return ops.unidadNegacion();}

{igual}                   {return ops.unidadIgual();} 
{coma}                    {return ops.unidadComa();}
{puntoYComa}              {return ops.unidadPuntoYComa();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();}
{corcheteApertura}        {return ops.unidadCAp();}
{corcheteCierre}          {return ops.unidadCCierre();} 
{llaveApertura}           {return ops.unidadLLAp();}
{llaveCierre}             {return ops.unidadLLCierre();}  

{int}		                  {return ops.unidadTipoInt();}
{bool}                    {return ops.unidadTipoBool();}
{float}                   {return ops.unidadTipoFloat();}
{void}                    {return ops.unidadTipoVoid();} 
{enum}                    {return ops.unidadTipoEnum();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}

{new}                     {return ops.unidadNew();}
{while}                   {return ops.unidadWhile();}
{for}                     {return ops.unidadFor();}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{struct}                  {return ops.unidadStruct();}
{switch}                  {return ops.unidadSwitch();}
{case}                    {return ops.unidadCase();}
{break}                   {return ops.unidadBreak();}
{default}                 {return ops.unidadDefault();}
{return}                  {return ops.unidadReturn();}
{print}                   {return ops.unidadPrint();}
{read}                    {return ops.unidadRead();}
{main}                    {return ops.unidadMain();}

{identificador}           {return ops.unidadId();}
[^]                       {ops.error();}  
