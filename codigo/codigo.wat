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
(func $insertar
 (local $localsStart i32)
 (local $temp i32)
 i32.const 56
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
;; Inicio asignacion AccArr(lst[pos])
;;exp tipo elem
i32.const 44
get_local $localsStart
i32.add
;;iden
;;AQUI ACCESO ARRAY AccArr(lst[pos])
;;AQUI COMIENZO EXP pos
i32.const 40
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP pos
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.load
i32.add
;;AQUI FIN ARRAY AccArr(lst[pos])
i32.const 1
call $copyn
;; Fin asignacion AccArr(lst[pos])
 call $freeStack
)
(func $buscarElem (result i32)
 (local $localsStart i32)
 (local $temp i32)
 i32.const 64
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
;;Inicio declaracion para
i32.const 44
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion para
;;Inicio declaracion p
i32.const 48
get_local $localsStart
i32.add
i32.const -1
i32.store
;;Fin declaracion p
;;Inicio declaracion i
i32.const 52
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion i
block
loop
i32.const 52
get_local $localsStart
i32.add
i32.load
i32.const 10
i32.lt_s
i32.const 44
get_local $localsStart
i32.add
i32.load
i32.eqz
i32.and
i32.eqz
br_if 1
;;AQUI ACCESO ARRAY AccArr(lst[i])
;;AQUI COMIENZO EXP i
i32.const 52
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 4
i32.mul
i32.const 4
get_local $localsStart
i32.add
i32.load
i32.add
;;AQUI FIN ARRAY AccArr(lst[i])
i32.load
i32.const 0
get_local $localsStart
i32.add
i32.load
i32.eq
if
;; Inicio asignacion p
;;exp tipo i
i32.const 52
get_local $localsStart
i32.add
;;iden
i32.const 48
get_local $localsStart
i32.add
i32.const 1
call $copyn
;; Fin asignacion p
;; Inicio asignacion para
i32.const 44
get_local $localsStart
i32.add
i32.const 1
i32.store
;; Fin asignacion para
end
;; Inicio asignacion i
i32.const 52
get_local $localsStart
i32.add
i32.const 52
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion i
br 0
end
end
i32.const 48
get_local $localsStart
i32.add
i32.load
call $freeStack
return
 call $freeStack
i32.const 0
i32.load
)
(func $principal
 (local $localsStart i32)
 (local $temp i32)
 i32.const 60
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
i32.const 40
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion i
block
loop
i32.const 40
get_local $localsStart
i32.add
i32.load
i32.const 10
i32.lt_s
i32.eqz
br_if 1
;; Inicio asignacion AccArr(listaNumeros[i])
;;exp tipo i
i32.const 40
get_local $localsStart
i32.add
;;iden
;;AQUI ACCESO ARRAY AccArr(listaNumeros[i])
;;AQUI COMIENZO EXP i
i32.const 40
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaNumeros[i])
i32.const 1
call $copyn
;; Fin asignacion AccArr(listaNumeros[i])
;; Inicio asignacion i
i32.const 40
get_local $localsStart
i32.add
i32.const 40
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion i
br 0
end
end
get_global $SP
i32.const 8
i32.add
set_local $temp
;; Copiando argumento: listaNumeros
i32.const 0
get_local $temp
i32.add
i32.const 0
get_local $localsStart
i32.add
i32.store
;; Copiando argumento: 3
i32.const 40
get_local $temp
i32.add
i32.const 3
i32.store
;; Copiando argumento: 100
i32.const 44
get_local $temp
i32.add
i32.const 100
i32.store
call $insertar
get_global $SP
i32.const 8
i32.add
set_local $temp
;; Copiando argumento: listaNumeros
i32.const 0
get_local $temp
i32.add
i32.const 0
get_local $localsStart
i32.add
i32.store
;; Copiando argumento: 4
i32.const 40
get_local $temp
i32.add
i32.const 4
i32.store
;; Copiando argumento: 100
i32.const 44
get_local $temp
i32.add
i32.const 100
i32.store
call $insertar
;;Inicio declaracion i
i32.const 40
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion i
block
loop
i32.const 40
get_local $localsStart
i32.add
i32.load
i32.const 10
i32.lt_s
i32.eqz
br_if 1
;; Inicio imprime AccArr(listaNumeros[i])
;;AQUI ACCESO ARRAY AccArr(listaNumeros[i])
;;AQUI COMIENZO EXP i
i32.const 40
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaNumeros[i])
i32.load
call $print
;; Fin imprime AccArr(listaNumeros[i])
;; Inicio asignacion i
i32.const 40
get_local $localsStart
i32.add
i32.const 40
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion i
br 0
end
end
;;Inicio declaracion pos
i32.const 40
get_local $localsStart
i32.add
get_global $SP
i32.const 8
i32.add
set_local $temp
;; Copiando argumento: 100
i32.const 0
get_local $temp
i32.add
i32.const 100
i32.store
;; Copiando argumento: listaNumeros
i32.const 4
get_local $temp
i32.add
i32.const 0
get_local $localsStart
i32.add
i32.store
call $buscarElem
i32.store
;;Fin declaracion pos
;; Inicio imprime pos
i32.const 40
get_local $localsStart
i32.add
i32.load
call $print
;; Fin imprime pos
;;Inicio declaracion a
i32.const 44
get_local $localsStart
i32.add
i32.const 1
i32.store
;;Fin declaracion a
;; Inicio imprime MENOS(a)
i32.const 0
i32.const 44
get_local $localsStart
i32.add
i32.load
i32.sub
call $print
;; Fin imprime MENOS(a)
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


   get_global $NP
   get_local $size
   i32.sub
   set_global $NP
  


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
