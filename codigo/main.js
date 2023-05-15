const { readFileSync } = require("fs");
const readline = require('readline');

const insrc = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

entrada = [];
i = 0; 

async function readInput(n){
    var line;
//    console.log(line);
    for await (line of insrc) {
//	console.log(line);
	entrada.push(parseInt(line));
	n--;
	if (n==0) return;
    }
    insrc.close();
}

var importObjects = {
    runtime: {
        exceptionHandler : function(code) {
            let errStr;
            if (code == 1) {
                errStr= "Error 1. ";
            } else if (code == 2) {
                errStr= "Error 2. ";
	    } else if (code == 3) {
                errStr= "Not enough memory. ";
	    } else {
		errStr= "Unknown error\n";
            }
            throw new Error(errStr);
        },
	print: function(n) {
	    console.log(n);
        },
	read: function() {
	    let val = entrada[i];
	    i += 1;
	    return val;
        }
    }};

async function start() {
    // await readInput(n); espera a leer n inputs. 
    // DESCOMENTAR LA SIGUIENTE LINEA PARA PROBAR INPUTS
    // await readInput(2);
    var filename = "codigo.wasm"
    if (process.argv.length > 2) {
        filename = process.argv[2];
    }

    const code = readFileSync(filename);
    wasmModule = await WebAssembly.compile(code);
    instance = await WebAssembly.instantiate(wasmModule, importObjects);
//    await instance.exports.init();
    process.exit(0);
}

function run() {
    //await readInput(2);
    start();
}

run();

