(module
(type $_sig_i32i32i32 (func (param i32 i32 i32) ))
(type $_sig_i32ri32 (func (param i32) (result i32)))
(type $_sig_i32 (func (param i32)))
(type $_sig_ri32 (func (result i32)))
(type $_sig_void (func ))
(import "runtime" "exceptionHandler" (func $exception (type $_sig_i32)))
(import "runtime" "print" (func $print (type $_sig_i32)))
(import "runtime" "read" (func $read (type $_sig_ri32)))
(memory 2000)   ;; TODO: Esto se cambia imagino
(global $SP (mut i32) (i32.const 0)) ;; start of stack
(global $MP (mut i32) (i32.const 0)) ;; mark pointer
(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4
(start $principal)
(func $principal
 (local $localsStart i32)
 (local $temp i32)
 i32.const 120
 call $reserveStack
 set_local $temp
 get_global $MP
 get_local $temp
 i32.store
 get_global $MP
 get_global $SP
 i32.store offset=4
 get_global $MP
 i32.const 8
 i32.add
 set_local $localsStart
;;Inicio declaracion i
i32.const 112
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion i
block
loop
get_local $localsStart
i32.const 112
i32.add
i32.load
i32.const 7
i32.lt_s
i32.eqz
br_if 1
;; Inicio asignacion AccStr(AccArr(listaCitas[i]).mes)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[i]).mes) 0
;;AQUI ACCESO ARRAY AccArr(listaCitas[i])
;;AQUI COMIENZO EXP i
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[i])
i32.const 0
i32.add
get_local $localsStart
i32.const 112
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[i]).mes)
;; Inicio asignacion AccStr(AccArr(listaCitas[i]).anio)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[i]).anio) 4
;;AQUI ACCESO ARRAY AccArr(listaCitas[i])
;;AQUI COMIENZO EXP i
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[i])
i32.const 4
i32.add
i32.const 2023
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[i]).anio)
;; Inicio asignacion i
get_local $localsStart
i32.const 112
i32.add
get_local $localsStart
i32.const 112
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion i
br 0
end
end
;; Inicio asignacion AccStr(AccArr(listaCitas[0]).dia)
;; Inicio asignacion  LunesENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[0]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[0])
;;AQUI COMIENZO EXP 0
i32.const 0
;;AQUI FIN EXP 0
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[0])
i32.const 8
i32.add
i32.const 0
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[0]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[1]).dia)
;; Inicio asignacion  MartesENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[1]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[1])
;;AQUI COMIENZO EXP 1
i32.const 1
;;AQUI FIN EXP 1
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[1])
i32.const 8
i32.add
i32.const 1
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[1]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[2]).dia)
;; Inicio asignacion  MiercolesENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[2]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[2])
;;AQUI COMIENZO EXP 2
i32.const 2
;;AQUI FIN EXP 2
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[2])
i32.const 8
i32.add
i32.const 2
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[2]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[3]).dia)
;; Inicio asignacion  JuevesENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[3]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[3])
;;AQUI COMIENZO EXP 3
i32.const 3
;;AQUI FIN EXP 3
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[3])
i32.const 8
i32.add
i32.const 3
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[3]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[4]).dia)
;; Inicio asignacion  ViernesENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[4]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[4])
;;AQUI COMIENZO EXP 4
i32.const 4
;;AQUI FIN EXP 4
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[4])
i32.const 8
i32.add
i32.const 4
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[4]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[5]).dia)
;; Inicio asignacion  SabadoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[5]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[5])
;;AQUI COMIENZO EXP 5
i32.const 5
;;AQUI FIN EXP 5
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[5])
i32.const 8
i32.add
i32.const 5
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[5]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[6]).dia)
;; Inicio asignacion  DomingoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[6]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[6])
;;AQUI COMIENZO EXP 6
i32.const 6
;;AQUI FIN EXP 6
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[6])
i32.const 8
i32.add
i32.const 6
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[6]).dia)
;; Inicio asignacion AccStr(AccArr(listaCitas[0]).tiempo)
;; Inicio asignacion  LluviosoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[0]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[0])
;;AQUI COMIENZO EXP 0
i32.const 0
;;AQUI FIN EXP 0
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[0])
i32.const 12
i32.add
i32.const 0
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[0]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[1]).tiempo)
;; Inicio asignacion  LluviosoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[1]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[1])
;;AQUI COMIENZO EXP 1
i32.const 1
;;AQUI FIN EXP 1
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[1])
i32.const 12
i32.add
i32.const 0
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[1]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[2]).tiempo)
;; Inicio asignacion  NubladoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[2]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[2])
;;AQUI COMIENZO EXP 2
i32.const 2
;;AQUI FIN EXP 2
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[2])
i32.const 12
i32.add
i32.const 2
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[2]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[3]).tiempo)
;; Inicio asignacion  NubladoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[3]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[3])
;;AQUI COMIENZO EXP 3
i32.const 3
;;AQUI FIN EXP 3
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[3])
i32.const 12
i32.add
i32.const 2
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[3]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[4]).tiempo)
;; Inicio asignacion  SoleadoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[4]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[4])
;;AQUI COMIENZO EXP 4
i32.const 4
;;AQUI FIN EXP 4
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[4])
i32.const 12
i32.add
i32.const 1
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[4]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[5]).tiempo)
;; Inicio asignacion  SoleadoENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[5]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[5])
;;AQUI COMIENZO EXP 5
i32.const 5
;;AQUI FIN EXP 5
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[5])
i32.const 12
i32.add
i32.const 1
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[5]).tiempo)
;; Inicio asignacion AccStr(AccArr(listaCitas[6]).tiempo)
;; Inicio asignacion  NieveENUM
;; Calculando dir relativa de AccStr(AccArr(listaCitas[6]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[6])
;;AQUI COMIENZO EXP 6
i32.const 6
;;AQUI FIN EXP 6
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[6])
i32.const 12
i32.add
i32.const 3
i32.store
;; Fin asignacion AccStr(AccArr(listaCitas[6]).tiempo)
;;Inicio declaracion j
i32.const 112
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion j
block
loop
get_local $localsStart
i32.const 112
i32.add
i32.load
i32.const 7
i32.lt_s
i32.eqz
br_if 1
;; Inicio imprime AccStr(AccArr(listaCitas[j]).dia)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 8
i32.add
i32.load
call $print
;; Fin imprime AccStr(AccArr(listaCitas[j]).dia)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 8
i32.add
i32.load
i32.const 4
i32.eq
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 8
i32.add
i32.load
i32.const 5
i32.eq
i32.or
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).dia) 8
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 8
i32.add
i32.load
i32.const 6
i32.eq
i32.or
if
;; Inicio imprime 1111
i32.const 1111
call $print
;; Fin imprime 1111
else
;; Inicio imprime 2222
i32.const 2222
call $print
;; Fin imprime 2222
end
;; Inicio imprime AccStr(AccArr(listaCitas[j]).mes)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).mes) 0
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 0
i32.add
i32.load
call $print
;; Fin imprime AccStr(AccArr(listaCitas[j]).mes)
;; Inicio imprime AccStr(AccArr(listaCitas[j]).anio)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).anio) 4
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 4
i32.add
i32.load
call $print
;; Fin imprime AccStr(AccArr(listaCitas[j]).anio)
;; Inicio imprime AccStr(AccArr(listaCitas[j]).tiempo)
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 12
i32.add
i32.load
call $print
;; Fin imprime AccStr(AccArr(listaCitas[j]).tiempo)
;;Inicio declaracion t
;; Calculando dir relativa de AccStr(AccArr(listaCitas[j]).tiempo) 12
;;AQUI ACCESO ARRAY AccArr(listaCitas[j])
;;AQUI COMIENZO EXP j
get_local $localsStart
i32.const 112
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 16
i32.mul
get_local $localsStart
i32.const 0
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaCitas[j])
i32.const 12
i32.add
i32.const 116
get_local $localsStart
i32.add
i32.const 4
call $copyn
;;Fin declaracion t
get_local $localsStart
i32.const 116
i32.add
i32.load
i32.const 0
i32.eq
if
;; Inicio imprime 333
i32.const 333
call $print
;; Fin imprime 333
else
get_local $localsStart
i32.const 116
i32.add
i32.load
i32.const 1
i32.eq
if
;; Inicio imprime 444
i32.const 444
call $print
;; Fin imprime 444
else
get_local $localsStart
i32.const 116
i32.add
i32.load
i32.const 2
i32.eq
if
;; Inicio imprime 555
i32.const 555
call $print
;; Fin imprime 555
else
;; Inicio imprime 666
i32.const 666
call $print
;; Fin imprime 666
end
end
end
;; Inicio asignacion j
get_local $localsStart
i32.const 112
i32.add
get_local $localsStart
i32.const 112
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion j
br 0
end
end
 call $freeStack
)
(func $reserveStack (param $size i32)
   (result i32)
   get_global $MP
   get_global $SP
   set_global $MP
   get_global $SP
   get_local $size
   i32.add
   set_global $SP
   get_global $SP
   get_global $NP
   i32.gt_u
   if
   i32.const 3
   call $exception
   end
)
(func $freeStack (type $_sig_void)
   get_global $MP
   i32.load
   i32.load offset=4
   set_global $SP
   get_global $MP
   i32.load
   set_global $MP   
)
(func $reserveHeap (type $_sig_i32)
   (param $size i32)
;; ....
)
(func $copyn (type $_sig_i32i32i32) ;; copy $n i32 slots from $src to $dest
   (param $src i32)
   (param $dest i32)
   (param $n i32)
   block
     loop
       get_local $n
       i32.eqz
       br_if 1
       get_local $n
       i32.const 1
       i32.sub
       set_local $n
       get_local $dest
       get_local $src
       i32.load
       i32.store
       get_local $dest
       i32.const 4
       i32.add
       set_local $dest
       get_local $src
       i32.const 4
       i32.add
       set_local $src
       br 0
     end
   end
)
)