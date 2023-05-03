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
;;INICIO DECLARACIONl
i32.const 0
get_local $localsStart
i32.add
i32.const 0
i32.add
i32.const 1
i32.store
;;FIN DECLARACIONl
;;INICIO DECLARACIONl
i32.const 0
get_local $localsStart
i32.add
i32.const 4
i32.add
i32.const 2
i32.store
;;FIN DECLARACIONl
;;INICIO DECLARACIONl
i32.const 0
get_local $localsStart
i32.add
i32.const 8
i32.add
i32.const 3
i32.store
;;FIN DECLARACIONl
;;INICIO DECLARACIONl
i32.const 0
get_local $localsStart
i32.add
i32.const 12
i32.add
i32.const 4
i32.store
;;FIN DECLARACIONl
;;INICIO DECLARACIONi
i32.const 16
get_local $localsStart
i32.add
i32.const 0
i32.store
;;FIN DECLARACIONi
block
loop
get_local $localsStart
i32.const 16
i32.add
i32.load
i32.const 2
i32.lt_s
i32.eqz
br_if 1
;;INICIO DECLARACIONj
i32.const 20
get_local $localsStart
i32.add
i32.const 0
i32.store
;;FIN DECLARACIONj
block
loop
get_local $localsStart
i32.const 20
i32.add
i32.load
i32.const 2
i32.lt_s
i32.eqz
br_if 1
;;INICIO ASIGNACIONj
get_local $localsStart
i32.const 20
i32.add
get_local $localsStart
i32.const 20
i32.add
i32.load
i32.const 1
i32.add
i32.store
;;FIN ASIGNACIONj
br 0
end
end
;;INICIO ASIGNACIONi
get_local $localsStart
i32.const 16
i32.add
get_local $localsStart
i32.const 16
i32.add
i32.load
i32.const 1
i32.add
i32.store
;;FIN ASIGNACIONi
br 0
end
end
;;INICIO ASIGNACIONAccStr(t.hora)
get_local $localsStart
i32.const 16
i32.add
i32.const 0
i32.add
i32.const 1
i32.store
;;FIN ASIGNACIONAccStr(t.hora)
;;INICIO ASIGNACIONAccStr(t.minuto)
get_local $localsStart
i32.const 16
i32.add
i32.const 4
i32.add
i32.const 2
i32.store
;;FIN ASIGNACIONAccStr(t.minuto)
;;INICIO ASIGNACIONAccStr(t.segundo)
get_local $localsStart
i32.const 16
i32.add
i32.const 8
i32.add
i32.const 3
i32.store
;;FIN ASIGNACIONAccStr(t.segundo)
;;INICIO DECLARACIONlistaTiempos
i32.const 28
get_local $localsStart
i32.add
i32.const 0
i32.add
get_local $localsStart
i32.const 16
i32.add
i32.load
i32.store
;;FIN DECLARACIONlistaTiempos
;;INICIO DECLARACIONi
i32.const 52
get_local $localsStart
i32.add
i32.const 0
i32.store
;;FIN DECLARACIONi
block
loop
get_local $localsStart
i32.const 52
i32.add
i32.load
i32.const 2
i32.lt_s
i32.eqz
br_if 1
;;AQUI ACCESO ARRAY AccArr(listaTiempos[i])
;;AQUI COMIENZO EXP i
get_local $localsStart
i32.const 52
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 12
i32.mul
get_local $localsStart
i32.const 28
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaTiempos[i])
i32.const 0
i32.add
i32.load
call $print
;;AQUI ACCESO ARRAY AccArr(listaTiempos[i])
;;AQUI COMIENZO EXP i
get_local $localsStart
i32.const 52
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 12
i32.mul
get_local $localsStart
i32.const 28
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaTiempos[i])
i32.const 4
i32.add
i32.load
call $print
;;AQUI ACCESO ARRAY AccArr(listaTiempos[i])
;;AQUI COMIENZO EXP i
get_local $localsStart
i32.const 52
i32.add
i32.load
;;AQUI FIN EXP i
i32.const 12
i32.mul
get_local $localsStart
i32.const 28
i32.add
i32.add
;;AQUI FIN ARRAY AccArr(listaTiempos[i])
i32.const 8
i32.add
i32.load
call $print
;;INICIO ASIGNACIONi
get_local $localsStart
i32.const 52
i32.add
get_local $localsStart
i32.const 52
i32.add
i32.load
i32.const 1
i32.add
i32.store
;;FIN ASIGNACIONi
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