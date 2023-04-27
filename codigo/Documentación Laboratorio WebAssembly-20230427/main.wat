(module
(import "runtime" "print" (func $print (param i32)))
(import "runtime" "read" (func $read (result i32)))
(memory 2000)
(start $init)
(func $init
   (local $in1 i32)
   (local $in2 i32)
   (local $out i32)
   call $read
   set_local $in1
   call $read
   set_local $in2
   get_local $in1
   get_local $in2
   i32.add
   set_local $out
   get_local $out
   call $print
)
(export "init" (func $init))
)