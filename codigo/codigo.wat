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
 i32.const 32
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
i32.const 80
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion i
block
loop
i32.const 80
get_local $localsStart
i32.add
i32.load
i32.const 20
i32.lt_s
i32.eqz
br_if 1
;;Inicio declaracion aux
i32.const 84
get_local $localsStart
i32.add
i32.const 80
get_local $localsStart
i32.add
i32.load
i32.const 2
i32.rem_s
i32.const 0
i32.eq
i32.store
;;Fin declaracion aux
i32.const 84
get_local $localsStart
i32.add
i32.load
set_local $temp
block $break
block ;; un caso
block ;; caso default
end
get_local $temp
i32.const 1
get_local $temp
i32.eq
i32.eqz
br_if 0
;; Inicio asignacion AccArr(l[i])
;;AQUI ACCESO ARRAY AccArr(l[i])
;;AQUI COMIENZO EXP i
i32.const 80
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
;;AQUI FIN ARRAY AccArr(l[i])
i32.const 1
i32.store
;; Fin asignacion AccArr(l[i])
br $break
set_local $temp
end
get_local $temp
;; Inicio asignacion AccArr(l[i])
;;AQUI ACCESO ARRAY AccArr(l[i])
;;AQUI COMIENZO EXP i
i32.const 80
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
;;AQUI FIN ARRAY AccArr(l[i])
i32.const -1
i32.store
;; Fin asignacion AccArr(l[i])
br $break
set_local $temp
end ;; para salir del switch con break
;; Inicio imprime AccArr(l[i])
;;AQUI ACCESO ARRAY AccArr(l[i])
;;AQUI COMIENZO EXP i
i32.const 80
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
;;AQUI FIN ARRAY AccArr(l[i])
i32.load
call $print
;; Fin imprime AccArr(l[i])
;; Inicio asignacion i
i32.const 80
get_local $localsStart
i32.add
i32.const 80
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
;;Inicio declaracion numPositivos
i32.const 84
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion numPositivos
;;Inicio declaracion numNegativos
i32.const 88
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion numNegativos
;; Inicio asignacion AccArr(l[11])
;;AQUI ACCESO ARRAY AccArr(l[11])
;;AQUI COMIENZO EXP 11
i32.const 11
;;AQUI FIN EXP 11
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(l[11])
i32.const 0
i32.store
;; Fin asignacion AccArr(l[11])
;;Inicio declaracion sigue
i32.const 92
get_local $localsStart
i32.add
i32.const 1
i32.store
;;Fin declaracion sigue
;;Inicio declaracion j
i32.const 96
get_local $localsStart
i32.add
i32.const 0
i32.store
;;Fin declaracion j
block
loop
i32.const 96
get_local $localsStart
i32.add
i32.load
i32.const 20
i32.lt_s
i32.const 92
get_local $localsStart
i32.add
i32.load
i32.and
i32.eqz
br_if 1
;;Inicio declaracion aux
i32.const 100
get_local $localsStart
i32.add
;;AQUI ACCESO ARRAY AccArr(l[j])
;;AQUI COMIENZO EXP j
i32.const 96
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(l[j])
i32.load
i32.const 0
i32.gt_s
i32.store
;;Fin declaracion aux
i32.const 100
get_local $localsStart
i32.add
i32.load
set_local $temp
block $break
block ;; un caso
block ;; un caso
end
get_local $temp
i32.const 1
get_local $temp
i32.eq
i32.eqz
br_if 0
;; Inicio asignacion numPositivos
i32.const 84
get_local $localsStart
i32.add
i32.const 84
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion numPositivos
;; Inicio imprime AccArr(l[j])
;;AQUI ACCESO ARRAY AccArr(l[j])
;;AQUI COMIENZO EXP j
i32.const 96
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(l[j])
i32.load
call $print
;; Fin imprime AccArr(l[j])
br $break
set_local $temp
end
get_local $temp
i32.const 0
get_local $temp
i32.eq
i32.eqz
br_if 0
;;AQUI ACCESO ARRAY AccArr(l[j])
;;AQUI COMIENZO EXP j
i32.const 96
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(l[j])
i32.load
i32.const 0
i32.eq
if
;; Inicio asignacion sigue
i32.const 92
get_local $localsStart
i32.add
i32.const 0
i32.store
;; Fin asignacion sigue
else
;; Inicio imprime AccArr(l[j])
;;AQUI ACCESO ARRAY AccArr(l[j])
;;AQUI COMIENZO EXP j
i32.const 96
get_local $localsStart
i32.add
i32.load
;;AQUI FIN EXP j
i32.const 4
i32.mul
i32.const 0
get_local $localsStart
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(l[j])
i32.load
call $print
;; Fin imprime AccArr(l[j])
;; Inicio asignacion numNegativos
i32.const 88
get_local $localsStart
i32.add
i32.const 88
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion numNegativos
end
br $break
set_local $temp
end ;; para salir del switch con break
;; Inicio asignacion j
i32.const 96
get_local $localsStart
i32.add
i32.const 96
get_local $localsStart
i32.add
i32.load
i32.const 1
i32.add
i32.store
;; Fin asignacion j
br 0
end
end
;; Inicio imprime numPositivos
i32.const 84
get_local $localsStart
i32.add
i32.load
call $print
;; Fin imprime numPositivos
;; Inicio imprime numNegativos
i32.const 88
get_local $localsStart
i32.add
i32.load
call $print
;; Fin imprime numNegativos
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
